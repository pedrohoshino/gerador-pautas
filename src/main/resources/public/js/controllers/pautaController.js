angular.module('pauta.controllers', ['textAngular']).controller('PautaController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.getPautas = function () {
    $http.get("pauta/v1/pautas").success(function (data) {
      $scope.pautas = data;
    });
  };

  $scope.addPauta = function() {
    $http.post('pauta/v1/pautas', $scope.pauta).success(function() {
      $state.go('pautas');
    });
  };

  $scope.getPauta = function() {
    $http.get("pauta/v1/pautas/" + $stateParams.id).success(function (data) {
      $scope.pauta = data;
    })
  }

  $scope.deletePauta = function(pauta) {
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("pauta/v1/pautas/" + pauta.id).success(function(){
        $state.reload();
      });
    }
  }

  $scope.gerarPDF = function(pauta) {
    $http.get("pauta/v1/pautas/" + pauta.id).success(function (data) {
      $scope.pauta = data;
      var doc = new jsPDF();
      doc.fromHTML($scope.pauta.arquivo, 15, 15,{'width': 170});
      doc.save($scope.pauta.titulo + '.pdf');
    });
  }

  $scope.editPauta = function() {
    console.log($scope.pauta.arquivo)
    $http.put('pauta/v1/pautas/' + $scope.pauta.id, $scope.pauta).success(function() {
      $state.go('pautas');
    });
  };

});
