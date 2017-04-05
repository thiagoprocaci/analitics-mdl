app.controller('appCtrl', function($scope, courseService, analysisService) {


    $scope.courseList;
    $scope.helperProvidersAnalysisLabels = ["Like asking and Like helping",
                                            "Like asking and don't like helping",
                                            "Don't like asking and like helping",
                                            "Don't like asking and don't like helping"];
    $scope.helperProvidersAnalysisData = [];
    $scope.chartOptions = {
        legend: {
          display: true
        }
      };


    $scope.findAll = function() {
        courseService.findAll()
            .then(function sucesso(response) {
                $scope.courseList = response.data
            });
     };

    $scope.analysis = function(courseId) {
        analysisService.perform(courseId)
                    .then(function sucesso(response) {
                        console.log(response.data.nodes.length)
                        var analysis = analysisService.askerHelperAnalysis(response.data.nodes)
                        $scope.helperProvidersAnalysisData = []
                        $scope.helperProvidersAnalysisData.push(analysis.goodAskerGoodHelper)
                        $scope.helperProvidersAnalysisData.push(analysis.goodAskerBadHelper)
                        $scope.helperProvidersAnalysisData.push(analysis.badAskerGoodHelper)
                        $scope.helperProvidersAnalysisData.push(analysis.badAskerBadHelper)
                    });
    };

    $scope.findAll();

});