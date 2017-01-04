angular.module('participante.controllers', []).controller('ParticipanteController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.tipos = [{
    id: 1,
    nome: 'Docente'
  }, {
    id: 2,
    nome: 'Dicente'
  }, {
    id: 3,
    nome: 'Funcionario'
  }, {
    id: 4,
    nome: 'Convidado'
  }];

  $scope.getParticipantes = function () {
    $http.get("participante/v1/participantes").success(function (data) {
      $scope.participantes = data;
    });
  };

  $scope.addParticipante = function() {
    $scope.participante.tipo = $scope.participante.tipo.nome;
    $http.post('participante/v1/participantes', $scope.participante).success(function() {
      $state.go('participantes');
    });
  };

  $scope.getParticipante = function() {
    $http.get("participante/v1/participantes/" + $stateParams.id).success(function (data) {
      $scope.participante = data;
    })
  }

  $scope.deleteParticipante = function(participante) {
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("participante/v1/participantes/" + participante.id).success(function(){
        $state.reload();
      });
    }
  }


  $scope.editParticipante = function() {
    $http.put('participante/v1/participantes/' + $scope.participante.id, $scope.participante).success(function() {
      $state.go('participantes');
    });
  };

});
