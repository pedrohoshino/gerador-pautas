// app = angular.module('MySimpleEditor', ['textAngular']);
//
// app.controller('MyController', ['$scope', function($scope){
//     $scope.sample = 'Shout out from the javascript!';
//     $scope.htmlContent = '<h2>Testing Content</h2>'
// }]);


angular.module('pauta.controllers', ['textAngular']).controller('PautaController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.getPautas = function () {
    $http.get("pauta/v1/pautas").success(function (data) {
      $scope.pautas = data;
    });
  };

  $scope.addPauta = function() {

    console.log($scope.pauta);

    $http.post('pauta/v1/pautas', $scope.pauta).success(function() {
      $state.go('pautas');
    });
  };

  $scope.getPauta = function() {
    $http.get("pauta/v1/pautas/" + $stateParams.id).success(function (data) {
      $scope.pauta = data;
      $scope.htmlContent = $scope.pauta.arquivo;
    })
  }

  $scope.deletePauta = function(pauta) { // Delete a Shipwreck. Issues a DELETE to /api/v1/shipwrecks/:id
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("pauta/v1/pautas/" + pauta.id).success(function(){
        $state.reload();
      });
    }
  }

  $scope.editPauta = function() { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
    $http.put('pauta/v1/pautas/' + $scope.pauta.id, $scope.pauta).success(function() {
      $state.go('pautas');
    });
  };

});
