angular.module('myApp', [])
  .controller('MainController', function ($scope, $http) {
    $scope.fetch = function (url) {
      $http.get(url)
        .then(function (response) {
          $scope.jsData = response.data;
          if ($scope.jsData._links) {
            var arr = [];
            for (var key in $scope.jsData._links) {
              arr.push(key);
            }
            return arr;
          } else {
            return [];
          }
        })
        .then(function(links){
          $scope.links = links;
        })
    };
  });

