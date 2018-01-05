myapp.controller("BlogController",function($scope,$http,$location){
$scope.Blog={blogname:"",blogcontent:"",username:"kjhj",status:"online",likes:0}

function getAllBlogs()
{
	console.log('Fetching Blogs')
	$http.get('http://localhost:8080/AirChatMiddleWare/blog/getAllBlogs')
	.then(function(response)
	{
		$scope.blogdata=response.data;
	});
	
}

$scope.insertBlog=function()
{
	$http.post('http://localhost:8080/AirChatMiddleWare/blog/insertBlog',$scope.Blog)
	.then(function(response)
	{
		console.log('Blog Entered');
	},function(error){
		console.log($scope.Blog);
		//console.log(error);
		console.error('Blog not entered');
	});
}
});