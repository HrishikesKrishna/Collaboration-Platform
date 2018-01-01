var myapp=angular.module("myApp",["ngRoute"]);

myapp.config(function($routeProvider)
{
	$routeProvice.when("/",{templateUrl:"index.html"})
				 .when("#/Blog",{templateUrl:"Blog.html"})
				 .when("#/Forum",{templateUrl:"Forum.html"});
				 .when("#/User",{templateUrl:"User.html"});
});