(function() {
	var app = angular.module('app', ['ui.router', 'navController', 'ngAnimate', 'ui.bootstrap', 'ngResource', 'app.services', 'item.controllers', 'pauta.controllers', 'reuniao.controllers', 'ata.controllers', 'deliberacao.controllers', 'categoria.controllers', 'participante.controllers', 'usuario.controllers','reuniaoParticipantes.controllers'])

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
		    }).state('viewPauta',{
		       url:'/pautas/:id/view',
		       templateUrl: 'views/pautas/pautas-view.html',
		       controller:'PautaController'
		    }).state('newPauta',{
		        url:'/pautas/new',
		        templateUrl: 'views/pautas/pautas-create.html',
		        controller:'PautaController'
		    }).state('editPauta',{
		        url:'/pautas/:id/edit',
		        templateUrl: 'views/pautas/pautas-edit.html',
		        controller:'PautaController'
		    })
		    
		    
		    .state('reuniaoparticipantes',{
		        url:'/reuniaoparticipantes',
		        templateUrl: 'views/reunioes-participantes/reunioes-participantes.html',
		        controller:'ReuniaoParticipantesController'
		    }).state('viewReuniaoParticipantes',{
		       url:'/reuniaoparticipantes/:id/view',
		       templateUrl: 'views/reunioes-participantes/reunioes-participantes-view.html',
		       controller:'ReuniaoParticipantesController'
		    }).state('newReuniaoParticipantes',{
		        url:'/reuniaoparticipantes/:id/new',
		        templateUrl: 'views/reunioes-participantes/reunioes-participantes-create.html',
		        controller:'ReuniaoParticipantesController'
		    }).state('editReuniaoParticipantes',{
		        url:'/reuniaoparticipantes/:id/edit',
		        templateUrl: 'views/reunioes-participantes/reunioes-participantes-edit.html',
		        controller:'ReuniaoParticipantesController'
		    }).state('editListaReuniaoParticipantes',{
		        url:'/reuniaoparticipantes/:id',
		        templateUrl: 'views/reunioes-participantes/reunioes-participantes.html',
		        controller:'ReuniaoParticipantesController'
		    })
		    
		    

			.state('reunioes',{
				url:'/reunioes',
				templateUrl: 'views/reunioes/reunioes.html',
				controller:'ReuniaoController'
			}).state('viewReuniao',{
				 url:'/reunioes/:id/view',
				 templateUrl: 'views/reunioes/reunioes-view.html',
				 controller:'ReuniaoController'
			}).state('newReuniao',{
					url:'/reunioes/new',
					templateUrl: 'views/reunioes/reunioes-create.html',
					controller:'ReuniaoController'
			}).state('editReuniao',{
					url:'/reunioes/:id/edit',
					templateUrl: 'views/reunioes/reunioes-edit.html',
					controller:'ReuniaoController'
			}).state('editReuniaoPDF',{
					url:'/reunioes-pdf/:id/pdf',
					templateUrl: 'views/reunioes/reunioes-pdf.html',
					controller:'ReuniaoController'
			})

			.state('deliberacoes',{
				url:'/deliberacoes',
				templateUrl: 'views/deliberacoes/deliberacoes.html',
				controller:'DeliberacaoController'
			}).state('viewDeliberacao',{
				 url:'/deliberacoes/:id/view',
				 templateUrl: 'views/deliberacoes/deliberacoes-view.html',
				 controller:'DeliberacaoController'
			}).state('newDeliberacao',{
					url:'/deliberacoes/new',
					templateUrl: 'views/deliberacoes/deliberacoes-create.html',
					controller:'DeliberacaoController'
			}).state('editDeliberacao',{
					url:'/deliberacoes/:id/edit',
					templateUrl: 'views/deliberacoes/deliberacoes-edit.html',
					controller:'DeliberacaoController'
			}).state('editDeliberacaoPDF',{
					url:'/deliberacoes/:id/pdf',
					templateUrl: 'views/deliberacoes/deliberacoes-pdf.html',
					controller:'DeliberacaoController'
			})

			.state('atas',{
				url:'/atas',
				templateUrl: 'views/atas/atas.html',
				controller:'AtaController'
			}).state('viewAta',{
				 url:'/atas/:id/view',
				 templateUrl: 'views/atas/atas-view.html',
				 controller:'AtaController'
			}).state('newAta',{
					url:'/atas/new',
					templateUrl: 'views/atas/atas-create.html',
					controller:'AtaController'
			}).state('editAta',{
					url:'/atas/:id/edit',
					templateUrl: 'views/atas/atas-edit.html',
					controller:'AtaController'
			})

			.state('itens',{
				url:'/itens',
				templateUrl: 'views/itens/itens.html',
				controller:'ItemController'
			}).state('viewItem',{
				url:'/itens/:id/view',
				templateUrl: 'views/itens/itens-view.html',
				controller:'ItemController'
			}).state('newItem',{
				url:'/itens/:id/new',
				templateUrl: 'views/itens/itens-create.html',
				controller:'ItemController'
			}).state('editItem',{
					url:'/itens/:id/edit',
					templateUrl: 'views/itens/itens-edit.html',
					controller:'ItemController'
			})

			.state('categorias',{
				url:'/categorias',
				templateUrl: 'views/categorias/categorias.html',
				controller:'CategoriaController'
			}).state('viewCategoria',{
				 url:'/categorias/:id/view',
				 templateUrl: 'views/categorias/categorias-view.html',
				 controller:'CategoriaController'
			}).state('newCategoria',{
					url:'/categorias/new',
					templateUrl: 'views/categorias/categorias-create.html',
					controller:'CategoriaController'
			}).state('editCategoria',{
					url:'/categorias/:id/edit',
					templateUrl: 'views/categorias/categorias-edit.html',
					controller:'CategoriaController'
			})

			.state('participantes',{
				url:'/participantes',
				templateUrl: 'views/participantes/participantes.html',
				controller:'ParticipanteController'
			}).state('viewParticipante',{
				 url:'/participantes/:id/view',
				 templateUrl: 'views/participantes/participantes-view.html',
				 controller:'ParticipanteController'
			}).state('newParticipante',{
					url:'/participantes/new',
					templateUrl: 'views/participantes/participantes-create.html',
					controller:'ParticipanteController'
			}).state('editParticipante',{
					url:'/participantes/:id/edit',
					templateUrl: 'views/participantes/participantes-edit.html',
					controller:'ParticipanteController'
			})

			
			.state('usuarios',{
				url:'/usuarios',
				templateUrl: 'views/usuarios/usuarios.html',
				controller:'UsuarioController'
			}).state('viewUsuario',{
				 url:'/usuario/:id/view',
				 templateUrl: 'views/usuarios/usuarios-view.html',
				 controller:'UsuarioController'
			}).state('newUsuario',{
					url:'/usuarios/new',
					templateUrl: 'views/usuarios/usuarios-create.html',
					controller:'UsuarioController'
			}).state('editUsuario',{
					url:'/usuario/:id/edit',
					templateUrl: 'views/usuarios/usuarios-edit.html',
					controller:'UsuarioController'
			})
			
			
			// .state('arquivos',{
			// 	url:'/arquivos',
			// 	templateUrl: 'views/arquivos/arquivos.html',
			// 	controller:'ShipwreckListController'
			// })
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
