angular.module('deliberacao.controllers', ['textAngular']).controller('DeliberacaoController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.getDeliberacoes = function () {
    $http.get("deliberacao/v1/deliberacoes").success(function (data) {
      $scope.deliberacoes = data;
    });
  };

  $scope.addDeliberacao = function() {
    $http.post('deliberacao/v1/deliberacoes', $scope.deliberacao).success(function() {
      $state.go('deliberacoes');
    });
  };

  $scope.getDeliberacao = function() {
    $http.get("deliberacao/v1/deliberacoes/" + $stateParams.id).success(function (data) {
      $scope.deliberacao = data;
    })
  }

  $scope.deleteDeliberacao = function(deliberacao) {
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("deliberacao/v1/deliberacoes/" + deliberacao.id).success(function(){
        $state.reload();
      });
    }
  }

  $scope.gerarPDF = function(deliberacao) {
    $http.get("deliberacao/v1/deliberacoes/" + deliberacao.id).success(function (data) {
      $scope.deliberacao = data;
      var doc = new jsPDF();
      doc.fromHTML($scope.deliberacao.arquivo, 15, 15,{'width': 170});
      doc.save($scope.deliberacao.titulo + '.pdf');
    });
  }

  $scope.editDeliberacao = function() {
    console.log($scope.deliberacao.arquivo)
    $http.put('deliberacao/v1/deliberacoes/' + $scope.deliberacao.id, $scope.deliberacao).success(function() {
      $state.go('deliberacoes');
    });
  };

});
