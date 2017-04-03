app.controller('appCtrl', function($scope, courseService) {

    $scope.gridOptions = {
        columnDefs: [
          {field: 'id', displayName: 'Id'},
          {field: 'shortName', displayName: 'Name'} ,
          { name: 'analysis',
            displayName: 'Analysis',
            cellTemplate: '<button type="button" class="btn-small" ng-click="grid.appScope.analysis(row.entity.id)" >Analysis</button> '
          }
        ]
      };

    $scope.findAll = function() {
        courseService.findAll()
            .then(function sucesso(response) {
                $scope.gridOptions.data = response.data
            });
     };

    $scope.analysis = function(courseId) {
        console.log(courseId)
    };

    $scope.findAll();
});