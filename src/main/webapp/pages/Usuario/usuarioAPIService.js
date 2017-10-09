angular.module("usuario").factory("usuarioAPI", function($http){
	
	//Se o provedor form email, significa que o data sao os valores do formulário de Usuario
	//Se o provedor form Google ou Facebook o data é o resultado da requisicao do firebase
	var _criarUsuario = function (data, provedor){

		if(provedor == "EMAIL"){
			data.conta = {
					identificador : data.emailContato,
					provedor : 'EMAIL',
					senha : data.senha
			}
			return data;
		}else{		
			return {
				nome : data.displayName,
				emailContato : data.email,
				numero : data.phoneNumber,
				imagemURL : data.photoURL,
				conta : {
					identificador : data.email,
					provedor : provedor,
					UID : data.uid,
					metaData : {
							photoURL : data.photoURL
					}
				}
			}
		}
	}
	
	var _salvarUsuario = function (usuario){
		return  $http({
	        method : "POST",
	        url : "UsuarioAction.salvar.mtw",
	        params: usuario
	    });
	}
	
	var _externalProvider = function(provedor){
		
		if(provedor == "FACEBOOK") return new firebase.auth.FacebookAuthProvider();
		if(provedor == "GOOGLE") return new firebase.auth.GoogleAuthProvider();
		
	}
	return{ 
		create : _criarUsuario,
		save   : _salvarUsuario,
		getProvider: _externalProvider
	};
})