myapp.controller("ForumController",function($scope,$http,$location,$rootScope,$cookieStore)
{
	console.log("Front End Forum Controller")
$scope.forum={forumName:'',forumContent:'',userName:$rootScope.currentUser.emailId,status:'P'}
$scope.ForumComment={forumcomment:'',forumId:'',userName:''}	
$scope.addForum=function()
{
	console.log("Forum Insertion inside Controller",$scope.forum)
	$http.post("http://localhost:8080/AirChatMiddleWare/forum/insertForum",$scope.forum)
	.then(function(response)
	{
		console.log('Forum inserted')
	},function(error)
	{
		console.log('Forum not inserted',error)
	});
	$location.path('/forum')
}	
	
	function getAllForums()
	{
		console.log('Fetching Forums')
		$http.get('http://localhost:8080/AirChatMiddleWare/forum/getAllForums')
		.then(function(response)
		{
			$rootScope.foruml=response.data;
			console.log($scope.foruml)
		}
		,function(error)
		{
			console.log("Error in retrieving forums")
		});
		
	}
	getAllForums();	
	
	$rootScope.participate=getSelectedForum
	function getSelectedForum(forumId)
	{
		console.log("Fetching forum by id")
		$http.get("http://localhost:8080/AirChatMiddleWare/forum/getForum/"+forumId)
		.then(function(response){
		$rootScope.forumbyid=response.data;
		$cookieStore.put('forum',$rootScope.forumbyid);
		console.log("forum fetched by id")
	},function(error){
		console.log("forum not fetched")
	});
		
		 $http.get("http://localhost:8080/AirChatMiddleWare/forum/getForumComments/"+forumId)
			
		 .then(function(response)
			{
			 console.log("inside middleware getForumComments")
				$rootScope.forumcomm=response.data;
			 	console.log(response.data)
				console.log($rootScope.forumcomm)
				$cookieStore.put('forumcommen',$rootScope.forumcomm);
			},function(error)
			{
			console.log("forum comments not fetched")	
	});
	$location.path('/viewforum')
	}

	$scope.addForumComment=function()
	{
		console.log('Add ForumComment Method')
		console.log($rootScope.forumbyid.forumId+$rootScope.currentUser.emailId+$scope.ForumComment.forumcomment)
		console.log()
		$http.get("http://localhost:8080/AirChatMiddleWare/forum/insertForumComment/"+$rootScope.forumbyid.forumId+"/"+$rootScope.currentUser.emailId+"/"+$scope.ForumComment.forumcomment)
		.then(function(response)
		{
			console.log("Comment about Forum added")
		},function(error){
			console.log("Forum Comment not added")
		});
		$location.path('/viewforum')
	}
});


myapp.controller("ForumRequestController",function($scope,$http,$location,$rootScope,$cookieStore){

	function fetchForumReq()
	{
		$http.get('http://localhost:8080/AirChatMiddleWare/forum/getForumReq/')
		.then(function(response)
				{
					$scope.forumreq=response.data;
					$location.path('/manage')
					
				},function(error)
					{
						console.log("Forum request not fetched");
					});
	}
	fetchForumReq();






	$scope.approveForum=function(id)
	{
		 
		 
		console.log("Forum approval")
		 $http.get("http://localhost:8080/AirChatMiddleWare/forum/approveForum/"+id)
		 .then(fetchForumReq(),function(response){
			 
			 console.log("Forumrequets accepted  successfully");
			 $location.path('/manage')
								
			},function(error){
				console.error("Error while accepting Forumrequets");
			});
		$location.path('/manage')

		 
	}



	$scope.rejectForum=function(id)
	{
		 
		 
		console.log("in Forum request  reject method")
		 $http.get("http://localhost:8080/AirChatMiddleWare/forum/rejectForum/"+id)
		 .then(fetchForumReq(),function(response){
			 
			 console.log("Forumrequets rejected  successfully");
			
								
			},function(error){
				console.error("Error while rejecting Forumrequets");
			});
		$location.path('/manage')
		 
	}
	});