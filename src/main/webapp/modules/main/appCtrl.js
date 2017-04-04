app.controller('appCtrl', function($scope, courseService, analysisService) {

    $scope.gridApi;

    $scope.gridCourseOptions = {
        paginationPageSizes: [25, 50, 75],
        paginationPageSize: 25,
        enableFiltering: true,
        enableRowSelection: true,
        multiSelect : false,
        enableRowHeaderSelection: false,
        columnDefs: [
          {field: 'fullName', displayName: 'Name', cellTooltip: true } ,
          { name: 'analysis',
            enableFiltering: false,
            displayName: 'Analysis',
            width : '20%',
            cellTemplate: '<button type="button" class="btn-small" ng-click="grid.appScope.analysis(row.entity.id)" >Analysis</button> '
          }
        ]
      };

    $scope.gridStudentOptions = {
            enableFiltering: true,
            paginationPageSizes: [25, 50, 75],
            paginationPageSize: 25,
            columnDefs: [
              {field: 'label', displayName: 'Name', cellTooltip: true} ,
              {field: 'betweennessDesc', displayName: 'Betweenness'} ,
              {field: 'closenessDesc', displayName: 'Closeness'} ,
              {field: 'eccentricityDesc', displayName: 'Eccentricity'} ,
              {field: 'harmonicClosenessDesc', displayName: 'Harmonic Closeness'} ,
              {field: 'pageRankDesc', displayName: 'Page Rank'} ,
              {field: 'indegreeDesc', displayName: 'Indegree'} ,
              {field: 'outdegreeDesc', displayName: 'Outdegree'} ,
              {field: 'degreeDesc', displayName: 'Degree'} ,
              {field: 'eigenvectorDesc', displayName: 'Eigenvector'} ,
              {field: 'interactionsDesc', displayName: 'Participation'} ,
            ]
          };

    $scope.findAll = function() {
        courseService.findAll()
            .then(function sucesso(response) {
                $scope.gridCourseOptions.data = response.data
            });
     };

    $scope.analysis = function(courseId) {
        analysisService.perform(courseId)
                    .then(function sucesso(response) {
                        $scope.gridStudentOptions.data = response.data.nodes
                    });
    };
    $scope.findAll();

     $scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
      $scope.series = ['Series A', 'Series B'];
      $scope.data = [
        [65, 59, 80, 81, 56, 55, 40],
        [28, 48, 40, 19, 86, 27, 90]
      ];
      $scope.onClick = function (points, evt) {
        console.log(points, evt);
      };
      $scope.datasetOverride = [{ yAxisID: 'y-axis-1' }, { yAxisID: 'y-axis-2' }];
        $scope.options = {
          scales: {
            yAxes: [
              {
                id: 'y-axis-1',
                type: 'linear',
                display: true,
                position: 'left'
              },
              {
                id: 'y-axis-2',
                type: 'linear',
                display: true,
                position: 'right'
              }
            ]
          }
        };
});