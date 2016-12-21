angular.module('ata.controllers', ['textAngular']).controller('AtaController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.getAtas = function () {
    $http.get("ata/v1/atas").success(function (data) {
      $scope.atas = data;
    });
  };

  $scope.addAta = function() {
    $http.post('ata/v1/atas', $scope.ata).success(function() {
      $state.go('atas');
    });
  };

  $scope.getAta = function() {
    $http.get("ata/v1/atas/" + $stateParams.id).success(function (data) {
      $scope.ata = data;
    })
  }

  $scope.deleteAta = function(ata) {
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("ata/v1/atas/" + ata.id).success(function(){
        $state.reload();
      });
    }
  }

  $scope.gerarPDF = function(ata) {
    $http.get("ata/v1/atas/" + ata.id).success(function (data) {
      $scope.ata = data;
      var doc = new jsPDF();
      doc.fromHTML($scope.ata.arquivo, 15, 15,{'width': 170});
      doc.save($scope.ata.titulo + '.pdf');
    });
  }

  $scope.editAta = function() {
    console.log($scope.ata.arquivo)
    $http.put('ata/v1/atas/' + $scope.ata.id, $scope.ata).success(function() {
      $state.go('atas');
    });
  };

});
