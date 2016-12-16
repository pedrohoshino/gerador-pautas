(function() {
	var app = angular.module('app', ['ui.router', 'navController', 'ngAnimate', 'ui.bootstrap', 'ngResource', 'app.controllers', 'app.services', 'item.controllers', 'pauta.controllers'])

	// define for requirejs loaded modules
	define('app', [], function() { return app; });

	// function for dynamic load with requirejs of a javascript module for use with a view
	// in the state definition call add property `resolve: req('/views/ui.js')`
	// or `resolve: req(['/views/ui.js'])`
	// or `resolve: req('views/ui')`
	function req(deps) {
		if (typeof deps === 'string') deps = [deps];
		return {
			deps: function ($q, $rootScope) {
				var deferred = $q.defer();
				require(deps, function() {
					$rootScope.$apply(function () {
						deferred.resolve();
					});
					deferred.resolve();
				});
				return deferred.promise;
			}
		}
	}

	app.config(function($stateProvider, $urlRouterProvider, $controllerProvider){
		var origController = app.controller
		app.controller = function (name, constructor){
			$controllerProvider.register(name, constructor);
			return origController.apply(this, arguments);
		}

		// For any unmatched url, send to /
		$urlRouterProvider.otherwise("/")

		$stateProvider
			// you can set this to no template if you just want to use the html in the page
			.state('home', {
				url: "/",
				templateUrl: "views/home.html",
				data: {
					pageTitle: 'Home'
				}
			})
			.state('pautas',{
		        url:'/pautas',
		        templateUrl: 'views/pautas/pautas.html',
		        controller:'PautaController'
		    }).state('viewShipwreck',{
		       url:'/shipwrecks/:id/view',
		       templateUrl: 'views/shipwreck-view.html',
		       controller:'ShipwreckViewController'
		    }).state('newPauta',{
		        url:'/pautas/new',
		        templateUrl: 'views/pautas/pautas-create.html',
		        controller:'PautaController'
		    }).state('editShipwreck',{
		        url:'/shipwrecks/:id/edit',
		        templateUrl: 'views/shipwreck-edit.html',
		        controller:'ShipwreckEditController'
		    })

			.state('reunioes',{
				url:'/reunioes',
				templateUrl: 'views/reunioes/reunioes.html',
				controller:'ShipwreckListController'
			})

			.state('atas',{
				url:'/atas',
				templateUrl: 'views/atas/atas.html',
				controller:'ShipwreckListController'
			})

			.state('itens',{
				url:'/itens',
				templateUrl: 'views/itens/itens.html',
				controller:'ItemController'
			}).state('newItem',{
        url:'/itens/new',
        templateUrl: 'views/itens/itens-create.html',
        controller:'ItemController'
			}).state('viewItem',{
        url:'/itens/:id/view',
        templateUrl: 'views/itens/itens-view.html',
        controller:'ItemController'
			}).state('editItem',{
				url:'/itens/:id/edit',
				templateUrl: 'views/itens/itens-edit.html',
				controller:'ItemController'
			})

			.state('participantes',{
				url:'/participantes',
				templateUrl: 'views/participantes/participantes.html',
				controller:'ShipwreckListController'
			})

			.state('arquivos',{
				url:'/arquivos',
				templateUrl: 'views/arquivos/arquivos.html',
				controller:'ShipwreckListController'
			})
	})
	.directive('updateTitle', ['$rootScope', '$timeout',
		function($rootScope, $timeout) {
			return {
				link: function(scope, element) {
					var listener = function(event, toState) {
						var title = 'Project Name';
						if (toState.data && toState.data.pageTitle) title = toState.data.pageTitle + ' - ' + title;
						$timeout(function() {
							element.text(title);
						}, 0, false);
					};

					$rootScope.$on('$stateChangeSuccess', listener);
				}
			};
		}
	]);
}());
