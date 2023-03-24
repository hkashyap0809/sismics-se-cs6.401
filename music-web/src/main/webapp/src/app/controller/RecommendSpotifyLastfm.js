'use strict';
//to be removed from here and updated in playlist
angular.module('music').controller('RecommendSpotifyLastfm', function($scope,Restangular, $http) {
//var searchUrl = 'https://api.spotify.com/v1/search?q=Arijit singh&type=album&market=ES&limit=10&offset=10';
	$scope.recommendSpotify = function() {
    	var queryString = $scope.recommendQueryString.replace(/\s+/g, "+");
		var queryParams = {thirdPartyType:'SPOTIFY',queryString:queryString, queryType:$scope.recommendQueryType}
		console.log(queryParams);
  		Restangular.one('search/recommend-third-party').get(queryParams).then(function(data) {
	   		console.log('Data fetched')
			console.log(data)
    		$scope.recommendData = data;
  		}, function(error){
	  		console.log("Error Fetching data")
	  		console.log(error)
  		});
  		
  	}
  	
  	$scope.recommendLastfm = function(){
		var queryString = $scope.recommendQueryString.replace(/\s+/g, "+");
		var queryParams = {thirdPartyType:'LASTFM',queryString:queryString, queryType:$scope.recommendQueryType}
		console.log(queryParams)
		Restangular.one('search/recommend-third-party').get(queryParams).then(function(data) {
	   		console.log('data fetched');
			console.log(data);
    		$scope.recommendData = data;
  		}, function(error){
	  		console.log("Error Fetching data");
	  		console.log(error);
  		});
	  }
});