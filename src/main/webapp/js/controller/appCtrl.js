app.controller('appCtrl', function($scope, courseService) {

    $scope.courseList = [];
    $scope.findAll = function() {

    courseService.findAll()
            .then(function sucesso(response) {
                $scope.courseList = response.data;

            });
    };

    $scope.findAll();
});