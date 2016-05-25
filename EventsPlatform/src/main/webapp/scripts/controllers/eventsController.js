app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/events', {
    templateUrl: 'views/events.html',
    controller: 'eventsController'
  });
}]);

app.controller('eventsController',['$scope','$http','userService',function($scope,$http,userService) {

  $scope.profileButton=userService.getAuthenticationState();

  console.log('User state='+userService.getAuthenticationState());

  $http({
    method: 'GET',
    url: '/EventsPlatform/webapi/events'
  }).then(function successCallback(response) {
      $scope.events=response.data;
    }, function errorCallback(response) {
      $scope.users="no events"
    });

$scope.test="Robert";



}]);
