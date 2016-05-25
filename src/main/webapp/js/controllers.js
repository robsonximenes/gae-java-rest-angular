"use strict";

var app = angular.module('app');

app.controller('MainCtrl', function($scope) {
	$scope.message = "Todos scripts foram carregados!";
});


app.controller('RegisterCtrl', function($scope, Register) {	
	$scope.user = {email:"teste@tes.com", password: "", name: ""};
	
	$scope.register = function(){		
		Register.save({},$scope.user, function(result){
			  	console.log(result);
			  }
		)
	};
});


app.controller('LoginCtrl', function($scope, Login, AuthenticationService ) {	
	$scope.user = {email:"", password: ""};	
	
	$scope.login = function(){		
		Login.save({},$scope.user, function(result){
		  	AuthenticationService.SetCredentials($scope.user.email, $scope.user.password);
		  }
		)
	};
});


app.controller('HomeCtrl', function($scope, User) {	
	$scope.list = [];	
	
	User.query({}, function(result){
		$scope.list = result;
	  }
	);
});