"use strict";

angular.module('app').config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/login");
	$stateProvider.state('login', {
		url : "/login",
		controller: "LoginCtrl",
		templateUrl : "views/login.html"
	}).state('register', {
		url : "/register",
		controller: "RegisterCtrl",
		templateUrl : "views/register.html"		
	}).state('home', {
		url : "/",
		controller: "HomeCtrl",
		templateUrl : "views/home.html"		
	});
});
