// app = angular.module('MySimpleEditor', ['textAngular']);
//
// app.controller('MyController', ['$scope', function($scope){
//     $scope.sample = 'Shout out from the javascript!';
//     $scope.htmlContent = '<h2>Testing Content</h2>'
// }]);


angular.module('pauta.controllers', ['textAngular']).controller('PautaController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.sample = 'Shout out from the javascript!';
  $scope.htmlContent = '<h2>Testing Content</h2>'

  $scope.addPauta =function (htmlContent){
    // $state.go('pautas');
    console.log($scope.htmlContent+"\n"+$scope.pauta.descricao+"\n"+$scope.pauta.titulo);
    console.log(typeof($scope.htmlContent));

  };

  // $scope.getItens = function () {
  //   $http.get("item/v1/itens").success(function (data) {
  //     $scope.itens = data;
  //   });
  // };
  //
  // $scope.addItem = function(item) {
  //   $http.post('item/v1/itens', item).success(function() {
  //     $state.go('itens');
  //   });
  // };
  //
  // $scope.getItem = function() {
  //   $http.get("item/v1/itens/" + $stateParams.id).success(function (data) {
  //     $scope.item = data;
  //   })
  // }
  //
  // $scope.deleteItem = function(item) { // Delete a Shipwreck. Issues a DELETE to /api/v1/shipwrecks/:id
  //   if (popupService.showPopup('Quer realmente deletar?')) {
  //       $http.delete("item/v1/itens/" + item.id).success(function(){
  //       $state.reload();
  //     });
  //   }
  // }

  // $scope.editItem = function(item) { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
  //   $http.put('item/v1/itens/' + item.id, item).success(function() {
  //     $state.go('itens');
  //   });
  // };

});
