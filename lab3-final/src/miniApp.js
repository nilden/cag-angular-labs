angular.module('miniApp', ['ngRoute'])

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

  .controller('BooksCtrl', function($scope, $http) {
    $http.get('http://localhost:8080/books')
      .success(function(data, status, headers, config){
        console.log('data: %o, status: %o, headers: %o, config: %o', data, status, headers(), config);
        $scope.books = data._embedded ? data._embedded.books : [];
      })
      .error(function(data, status, headers, config) {
        console.log('data: %o, status: %o, headers: %o, config: %o', data, status, headers(), config);
        alert('Schmäll!!!\nFelkod: '+status+', felinfo: "'+data+'"');
      });

    $scope.select = function(book) {
      $scope.selectedBook = book;
    }
  })

  .config(function ($routeProvider) {
    $routeProvider
      .when('/books', {
        templateUrl: 'booksTemplate.html',
        controller: 'BooksCtrl'
      })
      .when('/authors', {
        templateUrl: 'authorsTemplate.html'
      })
      .otherwise({
        redirectTo: '/books'
      });
  });