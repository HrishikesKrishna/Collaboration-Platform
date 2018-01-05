myapp.controller("UserController",function($scope,$http){
$scope.User={firstName:"",lastName:"",password:"",emailId:"",role:"user",status:"NA",isOnline:"YES"}
	
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
				console.log('logged in');
			})
	,(function(error)
	{
		console.log('user not logged in');
	});
}
});