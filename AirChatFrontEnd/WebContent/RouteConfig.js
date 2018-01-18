var myapp = angular.module("AirChat", ["ngRoute","ngCookies"]);
myapp.config(["$routeProvider","$locationProvider", function ($routeProvider,$locationProvider) {
    $routeProvider

    .when('/', {
        templateUrl : "homepage.html"
    })
    .when("/blog", {
        templateUrl : "BLOG/Blog.html"
    })
    .when("/home", {
        templateUrl : "homepage.html"
    })
     .when("/login", {
        templateUrl : "USER/User.html"
    })
    .when("/forum", {
        templateUrl : "FORUM/Forum.html"
    })
    .when("/viewblog",{
    	templateUrl : "BLOG/BlogRead.html"
    })
    .when("/manage", {
        templateUrl : "ADMIN/Manage.html"
    })
    .when("/viewforum", {
        templateUrl : "FORUM/ForumParticipate.html"
    })
    .when("/chat",{
    	templateUrl : "CHAT/Chat.html"
    })
    .when("/myspace",{
    	templateUrl : "USER/MySpace.html"
    })
    .when("/jobsoffer",{
    	templateUrl : "JOB/JobOffers.html"
    })
    .when("/createjob",{
    	templateUrl : "JOB/CreateJob.html"
    })
    .otherwise({redirectTo: '/'});
    $locationProvider.hashPrefix('');
}]);




myapp.run(function($rootScope,$cookieStore)
{
	$rootScope.currentUser=$cookieStore.get("currentUser")||{};
	
});