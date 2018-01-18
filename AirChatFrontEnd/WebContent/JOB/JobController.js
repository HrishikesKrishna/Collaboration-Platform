myapp.controller("JobController",function($scope,$http,$location,$rootScope,$cookieStore){
$scope.Job={jobProfile:"",jobDesc:"",qualification:""};


$scope.insertJob = function()
{
	console.log('entered insertJob');
	$http.post('http://localhost:8080//AirChatMiddleWare/job/addJob',$scope.Job).then(fetchAllJobs(), function(response) {
		console.log(" jobs entered");
		$location.path("/createjob")
	});
}
function getAllJobs()
{
	console.log('Fetching Jobs')
	$http.get('http://localhost:8080/AirChatMiddleWare/job/getAllJobs')
	.then(function(response)
	{
		$rootScope.jobl=response.data;
		console.log($scope.jobl)
	}
	,function(error)
	{
		console.log("Error in retrieving jobs")
	});
	
}
getAllJobs();
});