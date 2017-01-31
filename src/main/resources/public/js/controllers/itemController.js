angular.module('item.controllers', []).controller('ItemController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.getItens = function () {
    $http.get("item/v1/itens").success(function (data) {
      $scope.itens = data;
    });
  };

  $scope.addItem = function(item) {
    $http.get("reuniao/v1/reunioes/" + $stateParams.id).success(function (data) {
      $scope.reuniao = data;
      item.reuniao = $scope.reuniao;
      $http.post('item/v1/itens', item).success(function() {
        $window.location.href = "index.html#/pautas/" + $stateParams.id + "/edit";
      });
    })
  };

  $scope.getItem = function() {
    $http.get("item/v1/itens/" + $stateParams.id).success(function (data) {
      $scope.item = data;
      console.log($scope.item);
    })
  }

  $scope.deleteItem = function(item) {
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("item/v1/itens/" + item.id).success(function(){
        $state.reload();
      });
    }
  }

  $scope.editItem = function(item) {
    $http.put('item/v1/itens/' + item.id, item).success(function() {
      $window.location.href = "index.html#/pautas/" + item.reuniao.id + "/edit";
    });
  };


  $scope.getCategorias = function () {
    $http.get("categoria/v1/categorias").success(function (data) {
      $scope.categorias = data;
    });
  };

});
