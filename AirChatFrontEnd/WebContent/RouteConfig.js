var myapp = angular.module("AirChat", ["ngRoute"]);
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
        templateUrl : "forum.html"
    }).otherwise({redirectTo: '/'});
    $locationProvider.hashPrefix('');
}]);
