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
/*$scope.login=function()
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
*/
$scope.login=function()
{
	$http.post('http://localhost:8080/AirChatMiddleWare/user/login',$scope.User)
	.then(function(response)
	{
		$scope.user=response.data;
		$rootScope.currentUser=response.data;
		if($rootScope.currentUser.errorMessage!="Login Success")
			{
				alert($rootScope.currentUser.errorMessage)
			}
		if($rootScope.currentUser.errorMessage=="Please wait for Admin approval" || $rootScope.currentUser.errorMessage=="Your account request has been rejected " || $rootScope.currentUser.errorMessage=="Email ID or password incorrect" || $rootScope.currentUser.errorMessage=="Not yet registered")
		{
			$location.path("/login")
		}
		else
		{
		console.log('Role:'+$rootScope.currentUser.role);
		$cookieStore.put('currentUser',$rootScope.currentUser)
		$location.path("/blog")
		}
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


myapp.controller("UserRequestController",function($scope,$http,$location,$rootScope,$cookieStore){

function fetchUserReq()
{
	$http.get('http://localhost:8080/AirChatMiddleWare/user/getUserReq/')
	.then(function(response)
			{
				$scope.userreq=response.data;
				$location.path('/manage')
				
			},function(error)
				{
					console.log("User request not fetched");
				});
}
fetchUserReq();






$scope.approveUser=function(id)
{
	 
	 
	console.log("user approval")
	 $http.get("http://localhost:8080/AirChatMiddleWare/user/approveUser/"+id)
	 .then(fetchUserReq(),function(response){
		 
		 console.log("userrequets accepted  successfully");
		 $location.path('/manage')
							
		},function(error){
			console.error("Error while accepting userrequets");
		});
	$location.path('/manage')

	 
}



$scope.rejectUser=function(id)
{
	 
	 
	console.log("in user request  reject method")
	 $http.get("http://localhost:8080/AirChatMiddleWare/user/rejectUser/"+id)
	 .then(fetchUserReq(),function(response){
		 
		 console.log("userrequets rejected  successfully");
		
							
		},function(error){
			console.error("Error while rejecting userrequets");
		});
	$location.path('/manage')
	 
}
});

