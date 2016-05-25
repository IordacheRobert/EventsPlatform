app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/addEvent', {
    templateUrl: 'views/addEvent.html',
    controller: 'eddEventController'
  });
}]);


app.controller('eddEventController',['$scope','$http','userService','$location',function($scope,$http,userService,$location) {
  $scope.profileButton=userService.getAuthenticationState();


}]);
