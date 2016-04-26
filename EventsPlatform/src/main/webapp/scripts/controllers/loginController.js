app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {
    templateUrl: 'views/login.html',
    controller: 'loginController'
  });
}]);

app.controller('loginController',['$scope','$http',function($scope,$http) {
  $http({
    method: 'GET',
    url: '/EventsPlatform/webapi/users'
  }).then(function successCallback(response) {
      $scope.users=response.data;
    }, function errorCallback(response) {
      $scope.users="no events"
    });

}]);
