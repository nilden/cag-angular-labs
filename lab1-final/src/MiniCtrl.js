angular.module('miniApp').controller(
  'MiniCtrl', function ($scope, $timeout) {
    $scope.counter = 0;

    function increment() {
      $scope.counter++;
      $timeout(increment, 1000);
    }

    console.log('Timer started.');
    increment();


    //============= Array
    $scope.books = ['NgBook', 'Zlatan Book', 'Other Book'];

    $scope.removeBook = function (book) {
      var index = $scope.books.indexOf(book);
      $scope.books.splice(index, 1);
    };

    $scope.addBook = function (book) {
      if ($scope.addBookForm.$valid) {
        $scope.books.push(book);
        $scope.errorMsg = undefined;
      } else {
        $scope.errorMsg = 'Boken måste ha ett namn!';
      }
    };

    $scope.rightNow = new Date();

    $scope.showDate = function () {
      return $scope.books.length > 0;
    }













  }
);