angular.module('usuario.controllers', []).controller('UsuarioController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.getUsuarios = function () {
    $http.get("usuario/v1/usuarios").success(function (data) {
      $scope.usuarios = data;
    });
  };

  $scope.addUsuario = function() {
    $http.post('usuario/v1/usuarios', $scope.usuario).success(function() {
      $state.go('usuarios');
    });
  };

  $scope.getUsuario = function() {
    $http.get("usuario/v1/usuarios/" + $stateParams.id).success(function (data) {
      $scope.usuario = data;
    })
  }

  $scope.deleteUsuario = function(usuario) {
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("usuario/v1/usuarios/" + usuario.id).success(function(){
        $state.reload();
      });
    }
  }


  $scope.editUsuario = function() {
    $http.put('usuario/v1/usuarios/' + $scope.usuario.id, $scope.usuario).success(function() {
      $state.go('usuarios');
    });
  };

});
