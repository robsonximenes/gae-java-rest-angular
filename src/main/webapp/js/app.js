"use strict";

var app = angular.module('app', [ 'ui.router', 'ngResource','ngCookies']);

app.run(['$rootScope', '$location', '$cookieStore', '$http', '$state',
         function ($rootScope, $location, $cookieStore, $http, $state) {
    // keep user logged in after page refresh
    $rootScope.globals = $cookieStore.get('globals') || {};
    if ($rootScope.globals.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
    }
    
    $rootScope.$on("$stateChangeStart", function(event, toState, toParams, fromState, fromParams){      
    	if (toState.url !== '/login'  
    		&& toState.url !== '/register' 
    		&& !$rootScope.globals.currentUser){
            $state.transitionTo("login");
            event.preventDefault();
        }
    });
}]);