(function () {
  function handleError(data, status, headers, config) {
    console.log('data: %o, status: %o, headers: %o, config: %o', data, status, headers && headers(), config);
    alert('Schmäll!!!\nFelkod: ' + status + ', felinfo: "' + data + '"');
  }

  angular.module('miniApp', ['ngRoute'])
    .controller('BooksCtrl', function ($scope, $http) {
        $http.get('http://localhost:8080/books')
          .success(function (data, status, headers, config) {
            console.log('data: %o, status: %o, headers: %o, config: %o', data, status, headers && headers(), config);
            $scope.books = data._embedded ? data._embedded.books : [];
          })
          .error(handleError);

      $scope.select = function (book) {
        $scope.selectedBook = book;
        if ($scope.selectedBook.authors === undefined) {
          $http.get(book._links.authors.href).success(function (data) {
            var authors = data._embedded.authors || [];
            $scope.selectedBook.authors = [];
            authors.forEach(function (author) {
              $scope.selectedBook.authors.push(author);
            });
          }).error(handleError);
        }
      }
    })
    .controller('AuthorsCtrl', function ($scope, $http) {
      $http.get('http://localhost:8080/authors')
        .success(function (data, status, headers, config) {
          console.log('data: %o, status: %o, headers: %o, config: %o', data, status, headers && headers(), config);
          $scope.authors = (data._embedded ? data._embedded.authors : []).sort(function (a, b) {
            return a.surname > b.surname;
          });
        })
        .error(handleError);

      $scope.select = function (author) {
        $scope.selectedAuthor = author;
      }
    })

    .config(function ($routeProvider) {
      $routeProvider
        .when('/books', {
          templateUrl: 'booksTemplate.html',
          controller: 'BooksCtrl'
        })
        .when('/authors', {
          templateUrl: 'authorsTemplate.html',
          controller: 'AuthorsCtrl'
        })
        .otherwise({
          redirectTo: '/books'
        });
    });
}());
