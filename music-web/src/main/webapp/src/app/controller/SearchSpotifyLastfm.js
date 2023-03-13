'use strict';


// angular.module('music').controller('SearchSpotifyLastfm', function($rootScope, $scope, User, Restangular) {
//     // Edit user
//     $scope.searchSpotify = function() {

//         $scope.testReturn="success";

//         var testReturn2="again";

//     //   Restangular.one('user').post('', $scope.user).then(function() {
//     //     $scope.user = {};
//     //     toaster.pop('success', 'Account update', 'Password successfully changed');
//     //     $scope.editUserForm.submitted = false;
//     //   });
//     };
  
//     // // Refresh Last.fm data
//     // var refreshLastFm = function() {
//     //   Restangular.one('user/lastfm').get().then(function(data) {
//     //     $scope.lastFm = data;
//     //   });
//     // };
  
//     // // If the user is already connected to Last.fm, refresh data
//     // User.userInfo().then(function(data) {
//     //   if (data.lastfm_connected) {
//     //     refreshLastFm();
//     //   }
//     // });
  
//     // // Connect to Last.fm
//     // $scope.connectLastFm = function() {
//     //   Restangular.one('user/lastfm').put($scope.lastfm).then(function() {
//     //     $scope.lastfm = {};
//     //     $rootScope.userInfo.lastfm_connected = true;
//     //     toaster.pop('success', 'Last.fm', 'Account successfully connected');
  
//     //     // Refresh Last.fm data to populate the box
//     //     refreshLastFm();
//     //   }, function(data) {
//     //     toaster.pop('error', 'Last.fm', data.data.message);
//     //   });
//     // }
  
//     // // Disconnect from Last.fm
//     // $scope.disconnectLastFm = function() {
//     //   Restangular.one('user/lastfm').remove().then(function() {
//     //     $rootScope.userInfo.lastfm_connected = false;
//     //   });
//     // };
//   });


  angular.module('music').controller('SearchSpotifyLastfm', function($scope, $http) {
    var searchUrl = 'https://api.spotify.com/v1/search?q=Arijit singh&type=album&market=ES&limit=10&offset=10';
    // Replace QUERY with your search term
    
    $http.get(searchUrl, {headers: { Authorization: 'Bearer BQC8L6LwnfTZqq7uiGImwyFPQzuwBkA34EfwVj20Pm1EXdo4Ztp5vMnFZCqvjCOEQFKvtZPliOhoVSVDOzehbXArvcHcNtP3UJy1BVsM9r3dYPKIO-yXQvrd9AXMSBbUK_jUTs_4MYfHkWo4kxwCFeA2GqjYMdryyNDBTwSmgTZlSo1P5-uvcFRiNvv9gQhBRw6E'}})
      .then(function(response) {
        // $scope.testReturn = response.data.tracks.items;
        console.log('fetching data: ', response.data);
        // $scope.testReturn="success";
      }, function(error) {
        console.log('Error fetching data: ', error);
      });
  });