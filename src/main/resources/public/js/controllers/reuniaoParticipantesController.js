angular.module('reuniaoParticipantes.controllers', []).controller('ReuniaoParticipantesController', function($scope, $state, $stateParams, popupService, $window, $http) {

 

  $scope.getReuniaoParticipantes = function () {
	    $http.get("reuniaoparticipantes/v1/reunioes/" + $stateParams.id).success(function (data) {
	      $scope.reuniaoParticipantes = data;
	    });
	  };  

	  
  $scope.addReuniaoParticipante = function(reuniaoParticipante) {
	  $http.get("reuniao/v1/reunioes/" + $stateParams.id).success(function (data) {
		  $scope.reuniao = data;
		  reuniaoParticipante.reuniao = $scope.reuniao;
		  $http.post('reuniaoparticipantes/v1/reuniaoparticipantes', reuniaoParticipante).success(function() {
		      $window.location.href = "index.html#/reuniaoparticipantes/" + reuniaoParticipante.reuniao.id;
		      //$state.go('reunioes');
    
		  });
	});
  };
	  
  $scope.getReuniaoParticipante = function() {
	    $http.get("reuniaoparticipantes/v1/reuniaoparticipantes/" + $stateParams.id).success(function (data) {
		  $scope.reuniaoParticipante = data;
		  console.log($scope.reuniaoParticipante);
	    })
	  };	  
	 

  $scope.deleteReuniaoParticipante = function(reuniaoParticipante) {
	    if (popupService.showPopup('Quer realmente deletar?')) {
	        $http.delete("reuniaoparticipantes/v1/reuniaoparticipantes/" + reuniaoParticipante.id).success(function(){
	        $state.reload();
	      });
	    }
	  }

  
  $scope.editReuniaoParticipante = function(reuniaoParticipante) {
	    $http.put('reuniaoparticipantes/v1/reuniaoparticipantes/' + $scope.reuniaoParticipante.id, $scope.reuniaoParticipante).success(function() {
	      $window.location.href = "index.html#/reuniaoparticipantes/" + reuniaoParticipante.reuniao.id;
	     //   $state.go('reuniaoparticipantes/2');
	    });
	  };	 
		
	  
  $scope.getReuniao = function() {
	    $http.get("reuniao/v1/reunioes/" + $stateParams.id).success(function (data) {
	      $scope.reuniao = data;
	    })
	  };
	  
  $scope.back = function() {
      $state.go('reunioes');
  };  
	  
 $scope.getParticipantes = function () {
	   $http.get("participante/v1/participantes").success(function (data) {
	      $scope.participantes = data;
	   });
	 };
 });
