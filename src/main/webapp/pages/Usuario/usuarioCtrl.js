angular.module("usuario").controller("cadastroController", function ($scope, $filter, usuarioAPI) {

	$scope.app = "Formulário de Cadastro";
	$scope.errorMessage = "";
	$scope.hasError = false;
	
	$scope.cadastrarUsuario = function(provedor, usuario, confirmarSenha){
		
		if(provedor == "EMAIL"){
			if(usuario.senha == confirmarSenha){
				var usuario = usuarioAPI.create(usuario, provedor);
				
				$scope.salvarUsuario(usuario);
			}else{
				//TODO: Mostrar mensagem de erro
				$scope.errorMessage = "Senhas não correspondem";
				$scope.hasError = true;
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
			if(response.data.error){
				$scope.errorMessage = response.data.userMessage;
				$scope.hasError = true;
				
				$(".alert").fadeTo(2000, 500).slideUp(1000, function(){
					$scope.hasError = false;
				});
			}else{
				delete $scope.contato;
				$scope.usuarioForm.$setPristine();
				window.location.href = 'UsuarioAction.dashboard.mtw';
			}
			console.log(response);
		}, function myError(response) {
			//TODO: Mostrar mensagem de erro
			console.log(response);
		});
	}
	
});


angular.module("usuario").controller("dashboardController", function ($scope, $filter, $http) {
	$scope.app = "Dashboard do Usuário";
});
