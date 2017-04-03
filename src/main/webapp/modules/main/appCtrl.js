app.controller('appCtrl', function($scope, courseService, analysisService) {

    $scope.gridOptions = {
        paginationPageSizes: [25, 50, 75],
        paginationPageSize: 25,
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
        analysisService.perform(courseId)
                    .then(function sucesso(response) {
                        console.log(response.data)
                    });
    };
    $scope.findAll();
});