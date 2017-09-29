
angular.module("index", []);

angular.module("index").controller("indexCtrl", function ($scope, $filter) {
	$scope.app = "Eventos Acadêmicos";
	
	//TODO: buscar do servidor
	$scope.eventos = [
		{nome: "I Semana do Administrador", tema: "Chaves do Conhecimento: transformando ideias em realizações", imagem: "http://eventos.faesf.com.br/images/img_large_2.jpg"},
		{nome: "Dia do Nutricionista e Educador Físico", tema: "Saúde a hora é agora", imagem: "http://eventos.faesf.com.br/images/img_large_1.jpg"}
	];
	
	$scope.orndenarPor = function(campo){
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};
});