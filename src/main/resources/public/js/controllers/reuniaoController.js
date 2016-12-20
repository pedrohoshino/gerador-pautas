angular.module('reuniao.controllers', ['textAngular']).controller('ReuniaoController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.getReunioes = function () {
    $http.get("reuniao/v1/reunioes").success(function (data) {
      $scope.reunioes = data;
    });
  };

  $scope.addReuniao = function() {
    $http.post('reuniao/v1/reunioes', $scope.reuniao).success(function() {
      $state.go('reunioes');
    });
  };

  $scope.getReuniao = function() {
    $http.get("reuniao/v1/reunioes/" + $stateParams.id).success(function (data) {
      $scope.reuniao = data;
    })
  }

  $scope.deleteReuniao = function(reuniao) {
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("reuniao/v1/reunioes/" + reuniao.id).success(function(){
        $state.reload();
      });
    }
  }

  $scope.gerarPDF = function(reuniao) {
    $http.get("reuniao/v1/reunioes/" + reuniao.id).success(function (data) {
      $scope.reuniao = data;
      var doc = new jsPDF();
      doc.fromHTML($scope.reuniao.arquivo, 15, 15,{'width': 170});
      doc.save($scope.reuniao.titulo + '.pdf');
    });
  }

  $scope.editReuniao = function() {
    console.log($scope.reuniao.arquivo)
    $http.put('reuniao/v1/reunioes/' + $scope.reuniao.id, $scope.reuniao).success(function() {
      $state.go('reunioes');
    });
  };

});
