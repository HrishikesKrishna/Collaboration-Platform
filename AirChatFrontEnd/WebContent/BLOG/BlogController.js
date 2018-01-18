myapp.controller("BlogController",function($scope,$http,$location,$rootScope,$cookieStore){
$scope.Blog={blogname:"",blogcontent:"",username:$rootScope.currentUser.emailId,status:"P",likes:0}
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
	
	 $http.get("http://localhost:8080/AirChatMiddleWare/blog/getBlogComments/"+blogid)
		.then(function(response)
		{
			
			$rootScope.blogcomm=response.data;
			console.log($rootScope.blogcomm)
			$cookieStore.put('blogcommen',$rootScope.blogcomm);
		},function(error)
		{
		console.log("blog comments not fetched")	
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
	$location.path('/viewblog')
}
});



myapp.controller("BlogRequestController",function($scope,$http,$location,$rootScope,$cookieStore){

	function fetchBlogReq()
	{
		$http.get('http://localhost:8080/AirChatMiddleWare/blog/getBlogReq/')
		.then(function(response)
				{
					$scope.blogreq=response.data;
					$location.path('/manage')
					
				},function(error)
					{
						console.log("Blog request not fetched");
					});
	}
	fetchBlogReq();






	$scope.approveBlog=function(id)
	{
		 
		 
		console.log("blog approval")
		 $http.get("http://localhost:8080/AirChatMiddleWare/blog/approveBlog/"+id)
		 .then(fetchBlogReq(),function(response){
			 
			 console.log("blogrequets approved successfully");
			 $location.path('/manage')
								
			},function(error){
				console.error("Error while accepting blogrequets");
			});
		$location.path('/manage')

		 
	}



	$scope.rejectBlog=function(id)
	{
		 
		 
		console.log("in blog request  reject method")
		 $http.get("http://localhost:8080/AirChatMiddleWare/blog/rejectBlog/"+id)
		 .then(fetchBlogReq(),function(response){
			 
			 console.log("blogrequets rejected  successfully");
			
								
			},function(error){
				console.error("Error while rejecting blogrequets");
			});
		$location.path('/manage')
		 
	}
	});