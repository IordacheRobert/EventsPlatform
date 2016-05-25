app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/profile', {
    templateUrl: 'views/profile.html',
    controller: 'profileController'
    // ,
    // resolve:{
    //     "check":function($location,userService){
    //         if(userService.getAuthenticationState()){
    //         }else{
    //            $location.path('/events');//redirect to events
    //         }
    //     }
    // }
  });
}]);



app.controller('profileController',['$scope','$http','userService','$location',function($scope,$http,userService,$location) {
  $scope.profileButton=userService.getAuthenticationState();
  $scope.userInfo=userService.getUser();

}]);
