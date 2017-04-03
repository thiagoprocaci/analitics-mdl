var app = angular.module("app", ['ui.bootstrap', 'ui.grid', 'ui.grid.edit', 'ui.grid.pagination', 'ngRoute']);


// route
app.config(function ($routeProvider) {

              $routeProvider
                  .when('/', {templateUrl: 'index.html'})
                  .when('/userpage', {templateUrl: 'modules/user/user.html'})
                  .otherwise({redirectTo: '/'});


});
