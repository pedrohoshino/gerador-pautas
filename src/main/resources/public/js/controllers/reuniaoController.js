angular.module('reuniao.controllers', ['textAngular']).controller('ReuniaoController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.getReunioes = function () {
    $http.get("reuniao/v1/reunioes").success(function (data) {
      $scope.reunioes = data;
    });
  };

  $scope.criaHeader = function(){
    $scope.reuniao.header ="<blockquote><blockquote><h6><b>DE ORDEM, CONVOCAMOS OS MEMBROS DA CONGREGAÇÃO DO INSTITUTO DE COMPUTAÇÃO PARA A " + $scope.reuniao.titulo.toUpperCase() + " DA CONGREGAÇÃO, A REALIZAR-SE DIA " + $scope.reuniao.data + ", ÀS " + $scope.reuniao.hora + ",NA SALA " + $scope.reuniao.local + " DO INSTITUTO DE COMPUTAÇÃO.</b></h6></blockquote></blockquote>";
  }

  $scope.addReuniao = function() {
    $scope.criaHeader();
    $scope.reuniao.arquivo = $scope.reuniao.header;
    $http.post('reuniao/v1/reunioes', $scope.reuniao).success(function() {
      $state.go('reunioes');
    });
  };

  $scope.previewReuniao = function() {
    $scope.criaHeader();
    $scope.reuniao.vizualizar = $scope.reuniao.header;
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
    $scope.criaHeader();
    $scope.reuniao.arquivo = $scope.reuniao.header;
    $http.put('reuniao/v1/reunioes/' + $scope.reuniao.id, $scope.reuniao).success(function() {
      $state.go('reunioes');
    });
  };

});
