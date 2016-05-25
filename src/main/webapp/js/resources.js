"use strict";

var app = angular.module('app');

app.factory('Register',function($resource) {
	return $resource('/api/register', null,{});
});

app.factory('Login',function($resource) {
	return $resource('/api/login', null,{});
});


app.factory('User',function($resource) {
	return $resource('/api/user', null,{});
});