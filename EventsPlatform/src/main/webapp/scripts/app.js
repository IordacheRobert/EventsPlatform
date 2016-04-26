var app = angular.module('eventsApp', [
  'ngRoute',
  'ngResource',
  'ui.bootstrap'
]);

app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({
    redirectTo: '/login'
  });
}]);
