app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signup', {
    templateUrl: 'views/signup.html',
    controller: 'signUpController'
  });
}]);


app.controller('signUpController',['$scope','$http','userService','$location',function($scope,$http,userService,$location) {
  $scope.profileButton=userService.getAuthenticationState();


}]);
