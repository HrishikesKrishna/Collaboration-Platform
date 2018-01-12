myapp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore){
$scope.User={firstName:"",lastName:"",password:"",emailId:"",role:"ROLE_USER",status:"P",isOnline:"OFFLINE"}
	
$scope.insertUser=function()
{
	console.log($scope.User);
	$http.post('http://localhost:8080/AirChatMiddleWare/user/insertUser',$scope.User)
	.then(function(response)
	{
			console.log('user entered');
	})
	,(function(error)
	{
		console.log('user not entered');
	});
	}
$scope.login=function()
{
	$http.post('http://localhost:8080/AirChatMiddleWare/user/login',$scope.User)
	.then(function(response)
	{
		$scope.user=response.data;
		$rootScope.currentUser=response.data;
		console.log('Role:'+$rootScope.currentUser.role);
		$cookieStore.put('currentUser',$rootScope.currentUser)
		$location.path("/blog")
	})
	,(function(error)
	{
		console.log('user not logged in');
	});
}
$scope.logout=function()
{
	console.log($rootScope.currentUser.emailId)
	$http.get('http://localhost:8080/AirChatMiddleWare/user/logout/'+$rootScope.currentUser['emailId'])
	.then(function(response)
	{
		alert(response.data)
		$cookieStore.remove('currentUser')
		$rootScope.currentUser={}
		$location.path("/")
	},function(error)
	{
		
	});
}
});