angular.module('categoria.controllers', []).controller('CategoriaController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.getCategorias = function () {
    $http.get("categoria/v1/categorias").success(function (data) {
      $scope.categorias = data;
    });
  };

  $scope.addCategoria = function() {
    $http.post('categoria/v1/categorias', $scope.categoria).success(function() {
      $state.go('categorias');
    });
  };

  $scope.getCategoria = function() {
    $http.get("categoria/v1/categorias/" + $stateParams.id).success(function (data) {
      $scope.categoria = data;
    })
  }

  $scope.deleteCategoria = function(categoria) {
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("categoria/v1/categorias/" + categoria.id).success(function(){
        $state.reload();
      });
    }
  }


  $scope.editCategoria = function() {
    $http.put('categoria/v1/categorias/' + $scope.categoria.id, $scope.categoria).success(function() {
      $state.go('categorias');
    });
  };

});
