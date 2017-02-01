angular.module('deliberacao.controllers', ['textAngular']).controller('DeliberacaoController', function($scope, $state, $stateParams, popupService, $window, $http) {

  $scope.selected = false;

  $scope.getDeliberacoes = function () {
    $http.get("item/v1/itens").success(function (data) {
      $scope.itens = [];
      for(var i=0; i<data.length; i++){
        if(data[i].assuntoDeliberacao != null){
          $scope.itens.push(data[i]);
        }
      }
    });
  };

  $scope.addDeliberacao = function() {
    $http.put('item/v1/itens/' + $scope.item.id, $scope.item).success(function() {
      $state.go('deliberacoes');
    });
  };

  $scope.getDeliberacao = function() {
    $http.get("item/v1/itens/" + $stateParams.id).success(function (data) {
      $scope.item = data;
    });
  }

  $scope.deleteDeliberacao = function(item) {
    if (popupService.showPopup('Quer realmente deletar?')) {
      $http.get("item/v1/itens/" + item.id).success(function (data) {
        $scope.item = data;
        $scope.item.assuntoDeliberacao = null;
        $scope.item.arquivoDeliberacao = null;
        $http.put('item/v1/itens/' + $scope.item.id, $scope.item).success(function() {
          $state.reload();
        });
      });
    }
  }

  $scope.gerarTexto = function(){
    $http.get("item/v1/itens/" + $stateParams.id).success(function (data) {
      $scope.item = data;
      $http.get("reuniao/v1/reunioes/" + $scope.item.reuniao.id).success(function (data) {
        $scope.reuniao = data;
        $scope.item.arquivoDeliberacao = "";
        $scope.item.arquivoDeliberacao += '<h4 style="text-align: center;"><b>'+ $scope.reuniao.titulo +' DA CONGREGAÇÃO DO INSTITUTO DE COMPUTAÇÃO,</b></h4><h4 style="text-align: center;"><b> REALIZADA EM ' + $scope.item.dataDeliberacao + '</b><br/></h4>';
        $scope.item.arquivoDeliberacao += '<h4 style="text-align: center;"><b style="color: inherit;"><br/></b></h4><h4 style="text-align: center;"><b style="color: inherit;">DELIBERAÇÃO  Nº.</b><br/></h4>';
        $scope.item.arquivoDeliberacao += '<div><b style="color: inherit;"><br/></b></div><div><b style="color: inherit;"><br/></b></div><h5><b style="color: inherit;"><br/></b></h5><title></title><h4><b>Assunto:</b> ' + $scope.item.assuntoDeliberacao + '<br/></h4>';
        $scope.item.arquivoDeliberacao += '<p><br/></p><p><br/></p><h4>A Congregação do Instituto de Computação, reunida em ' + $scope.item.dataDeliberacao + ',<b>aprovou o ' + $scope.item.descricao + '</b></h4>';
        // $scope.item.arquivoDeliberacao += '<p><br/></p><p><br/></p><h4>Campinas, ' + $scope.item.dataDeliberacao + '.<br/></h4>';
        $scope.item.arquivoDeliberacao += '<p><br/></p><p><br/></p><p><br/></p><p><br/></p><h4 style="text-align: center;"><b>Presidente da Congregação</b><br/></h4>';
      });
    });
  }

  $scope.gerarPDF = function(item) {
    // $http.get("deliberacao/v1/deliberacoes/" + deliberacao.id).success(function (data) {
    //   $scope.deliberacao = data;
    // console.log($scope.item.arquivoDeliberacao);
      var doc = new jsPDF();
      doc.fromHTML($scope.item.arquivoDeliberacao, 15, 15,{'width': 170});
      doc.save($scope.item.titulo + '.pdf');
    // });
  }

  $scope.editDeliberacao = function() {
    $http.put('item/v1/itens/' + $stateParams.id, $scope.item).success(function() {
      $state.go('deliberacoes');
    });
  };

  $scope.selecionar = function() {
    $scope.selected = true;
    $scope.itens = [];
    for(var i=0; i<$scope.itens2.length; i++){
      if($scope.itens2[i].reuniao.id == $scope.item.reuniao.id){
        $scope.itens.push($scope.itens2[i]);
        $scope.itens.assuntoDeliberacao = $scope.itens.descricao;
      }
    }
  }

  $scope.getItens = function () {
    $http.get("item/v1/itens").success(function (data) {
        $scope.itens2 = data;
    });
  };

  $scope.getItem = function() {
    $http.get("item/v1/itens/" + $stateParams.id).success(function (data) {
      $scope.item = data;
    })
  }

  $scope.getReunioes = function () {
    $http.get("reuniao/v1/reunioes").success(function (data) {
      $scope.reunioes = data;
    });
  };

});
