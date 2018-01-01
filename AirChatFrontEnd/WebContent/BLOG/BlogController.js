app.controller("BlogController",function($scope,$http){

$scope.Blog={blogname:'',blogcontent:'',status:'NA',likes:0};

$scope.insertBlog=function()
{
	$http.post('http://localhost:8080/AirChatMiddleWare/blog/insertBlog')
	.then(function(response)
	{
		console.log('Blog Entered');
	});
}
});