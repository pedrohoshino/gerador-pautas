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

  $scope.itens = [];

  $scope.getReunioes = function () {
    $http.get("reuniao/v1/reunioes").success(function (data) {
      $scope.reunioes = data;
    });
  };

  $scope.criaHeader = function() {
    $scope.header ="<blockquote><blockquote><h6><b>DE ORDEM, CONVOCAMOS OS MEMBROS DA CONGREGAÇÃO DO INSTITUTO DE COMPUTAÇÃO PARA A " + $scope.reuniao.titulo.toUpperCase() + " DA CONGREGAÇÃO, A REALIZAR-SE DIA " + $scope.reuniao.data + ", ÀS " + $scope.reuniao.hora + ", NA SALA " + $scope.reuniao.local + " DO INSTITUTO DE COMPUTAÇÃO.</b></h6></blockquote></blockquote><br>";
  };

  $scope.createText = function() {
    $http.get("reuniao/v1/reunioes/" + $stateParams.id).success(function (data) {
      $scope.reuniao = data;
      $http.get("categoria/v1/categorias").success(function (data) {
        $scope.categorias = data;
        $scope.criaHeader();
        $http.get("item/v1/itens").success(function (data) {
          for(var i=0; i<data.length; i++){
            if(data[i].reuniao.id == $stateParams.id)
              $scope.itens.push(data[i]);
          }
          $scope.criaBody();
          $scope.reuniao.textoReuniao = $scope.header+$scope.body;
        });
      });
    });
  };

  $scope.criaBody = function() {
      $scope.body = "";
      for(var i=0; i<$scope.categorias.length; i++){
        $scope.categorias[i].tamanho = 0;
      }
      for(var i=0; i<$scope.itens.length; i++){
        for(var v=0; v<$scope.categorias.length; v++){
          if($scope.itens[i].categoria.titulo == $scope.categorias[v].titulo){
            $scope.categorias[v].tamanho += 1;
          }
        }
      }
      for(var i=0; i<$scope.categorias.length; i++){
        if($scope.categorias[i].tamanho > 0){
            $scope.body += "<h3><b>" + $scope.categorias[i].titulo + "</b></h3>";
        }
        for(var v=0; v<$scope.itens.length; v++){
          if($scope.itens[v].categoria.titulo == $scope.categorias[i].titulo){
            $scope.body += "<div>" + $scope.itens[v].ordem + ". " + $scope.itens[v].descricao + "</div>";
          }
        }
        $scope.body += "<div></div>"
      }
  };

  $scope.addReuniao = function() {
    $scope.criaHeader();
    $scope.reuniao.textoReuniao = $scope.header;
    $http.post('reuniao/v1/reunioes', $scope.reuniao).success(function() {
      $state.go('reunioes');
    });
  };

  $scope.getReuniao = function() {
    $http.get("reuniao/v1/reunioes/" + $stateParams.id).success(function (data) {
      $scope.reuniao = data;
    })
  };

  $scope.getReuniaoParticipantes = function() {
    $http.get("reuniaoparticipantes/v1/reuniaoparticipantes").success(function (data) {
      $scope.reuniaoParticipantes=data;
    })
  };

  $scope.deleteReuniao = function(reuniao) {
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("reuniao/v1/reunioes/" + reuniao.id).success(function(){
        $state.reload();
      });
    }
  }

  $scope.gerarPDF = function(reuniao) {
      // console.log($scope.reuniao.textoReuniao)
      var doc = new jsPDF();
      doc.fromHTML($scope.reuniao.textoReuniao, 15, 15,{'width': 170});
      doc.save($scope.reuniao.titulo + '.pdf');
  }

  $scope.editReuniao = function() {
    $scope.criaHeader();
    $scope.reuniao.textoReuniao = $scope.header;
    for(var i=0; i<$scope.reuniaoPresidente.length; i++){
        var presidente = {reuniao:$scope.reuniao, tipo_participacao:"Presidente", participantes:$scope.reuniaoPresidente[i]};

        $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', presidente);
    }
    for(var i=0; i<$scope.reuniaoDocente.length; i++){
        var docente = [$scope.reuniao.id, $scope.reuniaoDocente[i].id, "docente"];
        $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', docente);
    }
    for(var i=0; i<$scope.reuniaoDicente.length; i++){
        var dicente = [$scope.reuniao.id, $scope.reuniaoDicente[i].id, "dicente"];
        $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', dicente);
    }
    for(var i=0; i<$scope.reuniaoFuncionario.length; i++){
        var funcionario = [$scope.reuniao.id, $scope.reuniaoFuncionario[i].id, "funcionario"];
        $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', funcionario);
    }
    for(var i=0; i<$scope.reuniaoConvidado.length; i++){
        var convidado = [$scope.reuniao.id, $scope.reuniaoConvidado[i].id, "convidado"];
        $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', convidado);
    }
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








/*angular.module('reuniao.controllers', ['textAngular']).controller('ReuniaoController', function($scope, $state, $stateParams, popupService, $window, $http) {

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

 
  
  $scope.itens = [];

  $scope.getReunioes = function () {
    $http.get("reuniao/v1/reunioes").success(function (data) {
      $scope.reunioes = data;
    });
  };

  $scope.criaHeader = function() {
    $scope.header ="<blockquote><blockquote><h6><b>DE ORDEM, CONVOCAMOS OS MEMBROS DA CONGREGAÇÃO DO INSTITUTO DE COMPUTAÇÃO PARA A " + $scope.reuniao.titulo.toUpperCase() + " DA CONGREGAÇÃO, A REALIZAR-SE DIA " + $scope.reuniao.data + ", ÀS " + $scope.reuniao.hora + ", NA SALA " + $scope.reuniao.local + " DO INSTITUTO DE COMPUTAÇÃO.</b></h6></blockquote></blockquote><br>";
  };

  $scope.createText = function() {
    $http.get("reuniao/v1/reunioes/" + $stateParams.id).success(function (data) {
      $scope.reuniao = data;
      $http.get("categoria/v1/categorias").success(function (data) {
        $scope.categorias = data;
        $scope.criaHeader();
        $http.get("item/v1/itens").success(function (data) {
          for(var i=0; i<data.length; i++){
            if(data[i].reuniao.id == $stateParams.id)
              $scope.itens.push(data[i]);
          }
          $scope.criaBody();
          $scope.reuniao.textoReuniao = $scope.header+$scope.body;
        });
      });
    });
  };

  $scope.criaBody = function() {
      $scope.body = "";
      for(var i=0; i<$scope.categorias.length; i++){
        $scope.categorias[i].tamanho = 0;
      }
      for(var i=0; i<$scope.itens.length; i++){
        for(var v=0; v<$scope.categorias.length; v++){
          if($scope.itens[i].categoria.titulo == $scope.categorias[v].titulo){
            $scope.categorias[v].tamanho += 1;
          }
        }
      }
      for(var i=0; i<$scope.categorias.length; i++){
        if($scope.categorias[i].tamanho > 0){
            $scope.body += "<h3><b>" + $scope.categorias[i].titulo + "</b></h3>";
        }
        for(var v=0; v<$scope.itens.length; v++){
          if($scope.itens[v].categoria.titulo == $scope.categorias[i].titulo){
            $scope.body += "<div>" + $scope.itens[v].ordem + ". " + $scope.itens[v].descricao + "</div>";
          }
        }
        $scope.body += "<div></div>"
      }
  };

  $scope.addReuniao = function() {
    $scope.criaHeader();
    $scope.reuniao.textoReuniao = $scope.header;
    $http.post('reuniao/v1/reunioes', $scope.reuniao).success(function() {
      $state.go('reunioes');
    });
  };

  $scope.getReuniao = function() {
    $http.get("reuniao/v1/reunioes/" + $stateParams.id).success(function (data) {
      $scope.reuniao = data;
    })
  };	  

  
  $scope.deleteReuniao = function(reuniao) {
    if (popupService.showPopup('Quer realmente deletar?')) {
        $http.delete("reuniao/v1/reunioes/" + reuniao.id).success(function(){
        $state.reload();
      });
    }
  }

  $scope.gerarPDF = function(reuniao) {
      // console.log($scope.reuniao.textoReuniao)
      var doc = new jsPDF();
      doc.fromHTML($scope.reuniao.textoReuniao, 15, 15,{'width': 170});
      doc.save($scope.reuniao.titulo + '.pdf');
  }

  $scope.editReuniao = function() {
    $scope.criaHeader();
    $scope.reuniao.textoReuniao = $scope.header;
    for(var i=0; i<$scope.reuniaoPresidente.length; i++){
        var presidente = {reuniao:$scope.reuniao, tipo_participacao:"Presidente", participantes:$scope.reuniaoPresidente[i]};

        $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', presidente);
    }
    for(var i=0; i<$scope.reuniaoDocente.length; i++){
        var docente = [$scope.reuniao.id, $scope.reuniaoDocente[i].id, "docente"];
        $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', docente);
    }
    for(var i=0; i<$scope.reuniaoDicente.length; i++){
        var dicente = [$scope.reuniao.id, $scope.reuniaoDicente[i].id, "dicente"];
        $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', dicente);
    }
    for(var i=0; i<$scope.reuniaoFuncionario.length; i++){
        var funcionario = [$scope.reuniao.id, $scope.reuniaoFuncionario[i].id, "funcionario"];
        $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', funcionario);
    }
    for(var i=0; i<$scope.reuniaoConvidado.length; i++){
        var convidado = [$scope.reuniao.id, $scope.reuniaoConvidado[i].id, "convidado"];
        $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', convidado);
    }
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
*/