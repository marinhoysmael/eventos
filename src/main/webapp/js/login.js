angular.module("login", []);


angular.module("login").controller("loginCtrl", function ($scope, $filter, $http) {
	$scope.app = "Eventos Acadêmicos | Login";
	
	
	$scope.logar = function(login){
		console.log(login);

		$http({
			url: "LoginAction.efetuarLogin.mtw",
			method: "POST",
			params: login
			
		}).then(function successCallback(response) {
			
			if(response.data.error){
				
			}else{
				window.location = 'AdministracaoAction.dashboard.mtw';
			}
			console.log(response)
		}, function errorCallback(response) {
			console.log(response);
		});
	};
});