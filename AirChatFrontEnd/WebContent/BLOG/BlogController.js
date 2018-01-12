myapp.controller("BlogController",function($scope,$http,$location,$rootScope,$cookieStore){
$scope.Blog={blogname:"",blogcontent:"",username:"kjhj",status:"A",likes:0}
$scope.BlogComment={comment:'',blogId:'',userName:''}

function getAllBlogs()
{
	console.log('Fetching Blogs')
	$http.get('http://localhost:8080/AirChatMiddleWare/blog/getAllBlogs')
	.then(function(response)
	{
		$rootScope.blogl=response.data;
		console.log($scope.blogl)
	}
	,function(error)
	{
		console.log("Error in retrieving blogs")
	});
	
}
getAllBlogs();

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

$rootScope.view=getSelectedBlog
function getSelectedBlog(blogid)
{
	console.log("Fetching blog by id")
	$http.get("http://localhost:8080/AirChatMiddleWare/blog/getBlog/"+blogid)
	.then(function(response){
	$rootScope.blogbyid=response.data;
	$cookieStore.put('blog',$rootScope.blogbyid);
	console.log("blog fetched by id")
},function(error){
	console.log("blog not fetched")
});
$location.path('/viewblog')
}

$scope.addBlogComment=function()
{
	console.log('Add BlogComment Method')
	console.log($rootScope.blogbyid.blogid+$rootScope.currentUser.emailId+$scope.BlogComment.comment)
	$http.get("http://localhost:8080/AirChatMiddleWare/blog/insertBlogComment/"+$rootScope.blogbyid.blogid+"/"+$rootScope.currentUser.emailId+"/"+$scope.BlogComment.comment)
	.then(function(response)
	{
		console.log("Comment about Blog added")
	},function(error){
		console.log("Blog Comment not added")
	});
}



});