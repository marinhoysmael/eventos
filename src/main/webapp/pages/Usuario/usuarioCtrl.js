angular.module("usuario").controller("cadastroController", function ($scope, $filter, usuarioAPI) {

	$scope.app = "Formulário de Cadastro";
	
	$scope.cadastrarUsuario = function(provedor, usuario, confirmarSenha){
		
		if(provedor == "EMAIL"){
			if(usuario.senha == confirmarSenha){
				var usuario = usuarioAPI.create(usuario, provedor);
				
				$scope.salvarUsuario(usuario);
			}else{
				//TODO: Mostrar mensagem de erro
			}
		}else{
			var provider = usuarioAPI.getProvider(provedor);
			
			firebase.auth().signInWithPopup(provider).then(function(result) {
				
				var usuario = usuarioAPI.create(result.user, provedor);
				
				$scope.salvarUsuario(usuario);
			}).catch(function(error) {
				//TODO: Mostrar mensagem de erro
				console.log(error);
			});
		}
		
	}

	$scope.salvarUsuario = function(usuario){
		usuarioAPI.save(usuario)
		.then(function mySuccess(response) {
			console.log(response);
//			window.location.href = 'UsuarioAction.dashboard.mtw';
		}, function myError(response) {
			//TODO: Mostrar mensagem de erro
			console.log(response);
		});
	}
	
});


angular.module("usuario").controller("dashboardController", function ($scope, $filter, $http) {
	$scope.app = "Dashboard do Usuário";
});
