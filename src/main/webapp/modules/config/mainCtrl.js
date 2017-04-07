app.controller('mainCtrl', function($scope) {

  $scope.contentUrl = 'modules/interaction/interaction.html';

  $scope.changeContentUrl = function(url) {
    $scope.contentUrl = url;
  }

});