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
    
    userService.get_my_events().then(function(events){
         $scope.userPublishedEvents=events;
    })
    
    
    $scope.map = { center: { latitude: $scope.userInfo.value.location.latitude, longitude:         $scope.userInfo.value.location.longitude }, zoom:15};

  
}]); 
