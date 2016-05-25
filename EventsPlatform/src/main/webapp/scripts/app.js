var app = angular.module('eventsApp', [
  'ngRoute',
  'ngResource'
]);

app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({
    redirectTo: '/events'
  });
}]);
