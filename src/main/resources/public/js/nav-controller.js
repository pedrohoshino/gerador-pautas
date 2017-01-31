angular.module('navController', [])
	.controller('nav', function($scope, $state) {
		$scope.title = 'Gerenciador de Pautas';

		// returns true if the current router url matches the passed in url
		// so views can set 'active' on links easily
		$scope.isUrl = function(url) {
			if (url === '#') return false;
			return ('#' + $state.$current.url.source + '/').indexOf(url + '/') === 0;
		};

		$scope.pages = [
			{
				name: 'Home',
				url: '#/'
			},
			{
				name: 'Reunioes',
				url: '#/reunioes'
			},
			{
				name: 'Deliberações',
				url: '#/deliberacoes'
			},
			{
				name: 'Atas',
				url: '#/atas'
			},

			{
				name: 'Itens',
				url: '#/itens'
			},
			{
				name: 'Categorias',
				url: '#/categorias'
			},
			{
				name: 'Participantes',
				url: '#/participantes'
			},
			{
				name: 'Usuarios',
				url: '#/usuarios'
			}//,
			// {
			// 	name: 'Arquivos',
			// 	url: '#/arquivos'
			// }
		]
	});
