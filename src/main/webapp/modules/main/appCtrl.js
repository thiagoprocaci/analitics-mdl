app.controller('appCtrl', function($scope, courseService, analysisService) {

    $scope.gridCourseOptions = {
        paginationPageSizes: [25, 50, 75],
        paginationPageSize: 25,
        enableFiltering: true,
        columnDefs: [
          {field: 'fullName', displayName: 'Name', } ,
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
              {field: 'label', displayName: 'Name'} ,
              {field: 'betweennessDesc', displayName: 'Betweenness'} ,
              {field: 'closenessDesc', displayName: 'Closeness'} ,
              {field: 'eccentricityDesc', displayName: 'Eccentricity'} ,
              {field: 'harmonicClosenessDesc', displayName: 'Harmonic Closeness'} ,
              {field: 'pageRankDesc', displayName: 'Page Rank'} ,
              {field: 'indegreeDesc', displayName: 'Indegree'} ,
              {field: 'outdegreeDesc', displayName: 'Outdegree'} ,
              {field: 'degreeDesc', displayName: 'Degree'} ,
              {field: 'eigenvectorDesc', displayName: 'Eigenvector'} ,
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
});