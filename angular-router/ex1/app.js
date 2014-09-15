angular.module('myApp', ['ngRoute'])

  .controller('MainController', function($scope, $route, $routeParams, $location) {
    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;
    $scope.$on('$routeChangeSuccess', function(event, toState, fromState){
      console.log('event',event);
      console.log('toState',toState);
      console.log('fromState',fromState);
    })
  })

  .controller('View1Ctrl', function($scope) {
    $scope.ctr = 1;
    $scope.increment = function() {
      $scope.ctr ++;
    }
  })

  .config(function ($routeProvider) {
    $routeProvider
      .when('/view1', {
        templateUrl: 'viewTemplate1.html',
        controller: 'View1Ctrl'
      })
      .when('/view2', {
        templateUrl: 'viewTemplate2.html'
      })
      .otherwise({
        redirectTo: '/view1'
      });
  });