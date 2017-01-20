angular.module('reuniao.controllers', ['textAngular']).controller('ReuniaoController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.presidentes = [];
  $scope.convidados = [];
  $scope.docentes = [];
  $scope.dicentes = [];
  $scope.funcionarios = [];

  $scope.reuniaoPresidente = [];
  $scope.reuniaoDocente = [];
  $scope.reuniaoDicente = [];
  $scope.reuniaoFuncionario = [];
  $scope.reuniaoConvidado = [];

  $scope.getReunioes = function () {
    $http.get("reuniao/v1/reunioes").success(function (data) {
      $scope.reunioes = data;
    });
  };

  $scope.criaHeader = function(){
    $scope.reuniao.header ="<blockquote><blockquote><h6><b>DE ORDEM, CONVOCAMOS OS MEMBROS DA CONGREGAÇÃO DO INSTITUTO DE COMPUTAÇÃO PARA A " + $scope.reuniao.titulo.toUpperCase() + " DA CONGREGAÇÃO, A REALIZAR-SE DIA " + $scope.reuniao.data + ", ÀS " + $scope.reuniao.hora + ", NA SALA " + $scope.reuniao.local + " DO INSTITUTO DE COMPUTAÇÃO.</b></h6></blockquote></blockquote>";
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
    $scope.criaHeader();
    $scope.reuniao.arquivo = $scope.reuniao.header;
    $http.put('reuniao/v1/reunioes/' + $scope.reuniao.id, $scope.reuniao).success(function() {
      $state.go('reunioes');
    });
  };

  $scope.cleanReuniao = function() {
    if (popupService.showPopup('Quer realmente limpar os campos?')) {
      $scope.presidentes = [];
      $scope.convidados = [];
      $scope.docentes = [];
      $scope.dicentes = [];
      $scope.funcionarios = [];

      $scope.reuniaoPresidente = [];
      $scope.reuniaoDocente = [];
      $scope.reuniaoDicente = [];
      $scope.reuniaoFuncionario = [];
      $scope.reuniaoConvidado = [];
      $state.reload();
    }
  }

  $scope.getParticipantes = function () {
    $http.get("participante/v1/participantes").success(function (data) {
      $scope.rParticipantes = data;
    });
  };

  $scope.addNewPresidente = function() {
    var newItemNo = $scope.presidentes.length+1;
    $scope.presidentes.push({'id': newItemNo});
  };

  $scope.removePresidente = function() {
    var lastItem = $scope.presidentes.length-1;
    $scope.presidentes.splice(lastItem);
    $scope.reuniaoPresidente.splice(lastItem)
  };

  $scope.addNewDocente = function() {
    var newItemNo = $scope.docentes.length+1;
    $scope.docentes.push({'id': newItemNo});
  };

  $scope.removeDocente = function() {
    var lastItem = $scope.docentes.length-1;
    $scope.docentes.splice(lastItem);
    $scope.reuniaoDocente.splice(lastItem)
  };

  $scope.addNewDicente = function() {
    var newItemNo = $scope.dicentes.length+1;
    $scope.dicentes.push({'id': newItemNo});
  };

  $scope.removeDicente = function() {
    var lastItem = $scope.dicentes.length-1;
    $scope.dicentes.splice(lastItem);
    $scope.reuniaoDicente.splice(lastItem)
  };

  $scope.addNewFuncionario = function() {
    var newItemNo = $scope.funcionarios.length+1;
    $scope.funcionarios.push({'id': newItemNo});
  };

  $scope.removeFuncionario = function() {
    var lastItem = $scope.funcionarios.length-1;
    $scope.funcionarios.splice(lastItem);
    $scope.reuniaoFuncionario.splice(lastItem)
  };

  $scope.addNewConvidado = function() {
    var newItemNo = $scope.convidados.length+1;
    $scope.convidados.push({'id': newItemNo});
  };

  $scope.removeConvidado = function() {
    var lastItem = $scope.convidados.length-1;
    $scope.convidados.splice(lastItem);
    $scope.reuniaoConvidado.splice(lastItem)
  };

});
