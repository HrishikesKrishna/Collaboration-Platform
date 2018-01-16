myapp.controller("ForumController",function($scope,$http,$location,$rootScope,$cookieStore)
{
	console.log("Front End Forum Controller")
$scope.forum={forumName:'',forumContent:'',userName:$rootScope.currentUser.emailId,status:'a'}
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
}	
});