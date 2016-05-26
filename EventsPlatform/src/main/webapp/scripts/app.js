var app = angular.module('eventsApp', [
  'ngRoute',
  'ngResource',
  'uiGmapgoogle-maps'
]);

app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({
    redirectTo: '/events'
  });
}]);

