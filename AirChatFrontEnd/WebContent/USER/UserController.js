
app.controller("UserController",function($scope,$http){

	$scope.User={firstName:'',lastName:'',password:'',emailId:'',role:'',status:'',isOnline:''};
	
	$scope.insertUser=function(){
	
		$http.post('http://localhost:8080/AirChatMiddleWare/user/insertUser')
	.then(function(response)
	{
			console.log('user entered')
	});
	}
});