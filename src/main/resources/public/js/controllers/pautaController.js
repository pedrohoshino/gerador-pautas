angular.module('pauta.controllers', ['textAngular']).controller('PautaController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.itens = [];

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
    $http.put('pauta/v1/pautas/' + $scope.pauta.id, $scope.pauta).success(function() {
      $state.go('pautas');
    });
  };




  $scope.getReuniao = function() {
    $http.get("reuniao/v1/reunioes/" + $stateParams.id).success(function (data) {
      $scope.reuniao = data;
    })
  };


  $scope.getItens = function () {
    $http.get("item/v1/itens").success(function (data) {
      for(var i=0; i<data.length; i++){
        if(data[i].reuniao.id == $stateParams.id)
          $scope.itens.push(data[i]);
      }
    });
  };

  $scope.back = function(item) {
      $state.go('reunioes');
  };

  $scope.getItem = function() {
    $http.get("item/v1/itens/" + $stateParams.id).success(function (data) {
      $scope.item = data;
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
      $state.go('itens');
    });
  };
});
