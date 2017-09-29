var app = angular.module("dashboard", ['ngRoute']);

app.config(function($routeProvider) {

	$routeProvider
		.when('/evento/cadastro', {
			templateUrl : 'EventoAction.cadastro.mtw',
			controller  : 'cadastroEventoController'
		})
		.when('/evento/lista', {
			templateUrl : 'EventoAction.listar.mtw',
			controller  : 'listaEventoController'
		});
});

app.controller('cadastroEventoController', function($scope, $http, $filter) {
	$scope.titulo = 'Novo Evento';
	$scope.estados = [];
	$scope.cidades = [];
	
	$http.get('EnderecoAction.listarEstados.mtw')
		.then(function(response) {
			$scope.estados = response.data.estados;
		}
	);
	
	$scope.carregarCidades = function(estado){
		 $http({
		        method : "GET",
		        url : "EnderecoAction.listarCidades.mtw",
		        params: {
		        	'estadoId' : estado.id
		        }
		    }).then(function mySuccess(response) {
		    	$scope.cidades = response.data.cidades;
		    }, function myError(response) {
		    	console.log(response);
		    });
		
	};
	
	$scope.salvarEvento = function(evento){
		$http({
	        method : "POST",
	        url : "EventoAction.salvar.mtw",
	        params: evento
	    }).then(function mySuccess(response) {
	    	console.log(response);
	    }, function myError(response) {
	    	console.log(response);
	    });
	}
});

app.controller('listaEventoController', function($scope, $http, $filter) {
	$scope.eventos = [];
	
	$http({
	    url: "EventoAction.listar.mtw", 
	    method: "GET",
	    params: {isAjax: true}
	 }).then(function(response) {
		$scope.eventos = response.data.eventos;
	});
});

app.controller("menuController", function ($scope, $filter, $compile) {
	
	//TODO: Buscar do servidor
	$scope.itens = [
		{	
			id: 1,
			nome: "Eventos", 
			link: "/", 
			icone:"glyphicon-briefcase",
			subItem:[{	
				nome: "Cadastro", 
				link: "#/evento/cadastro", 
			},{	
				nome: "Listar", 
				link: "#/evento/lista", 
			}]
		},
		{
			id: 2,
			nome: "Pages", 
			link: "/", 
			icone:"glyphicon-duplicate", 
			subItem:[{	
				nome: "Page 1", 
				link: "#", 
			},{	
				nome: "Page 2", 
				link: "#", 
			},{	
				nome: "Page 2", 
				link: "#", 
			}]
		},
		{	
			id: 3,
			nome: "Portifolio", 
			link: "#", 
			icone:"glyphicon-link"
		}
	];
});





