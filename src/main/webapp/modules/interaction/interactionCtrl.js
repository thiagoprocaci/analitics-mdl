app.controller('interactionCtrl', function($scope, courseService, analysisService) {


    $scope.courseList;

    // interactions chart
    $scope.helperProvidersAnalysisLabels = ["Like asking and like helping",
                                            "Like asking and don't like helping",
                                            "Don't like asking and like helping",
                                            "Don't like asking and don't like helping"];
    $scope.helperProvidersAnalysisData = [];
    $scope.chartOptions = {
        legend: {
          display: true
        }
      };


    $scope.nodesCount = 0;
    $scope.isolatedNodeList = []
    $scope.mostConnectedNodeList = []

    // kind of users chart
     $scope.kingOfUserAnalysisLabels = ["Asker", "Helper", "Bridging", "Information Spreader"];
    $scope.kingOfUserAnalysisData = [];

    $scope.findAll = function() {
        courseService.findAll()
            .then(function sucesso(response) {
                $scope.courseList = response.data
            });
     };

    $scope.analysis = function(courseId) {
        analysisService.perform(courseId)
                    .then(function sucesso(response) {

                        var analysis = analysisService.askerHelperAnalysis(response.data.nodes)
                        $scope.helperProvidersAnalysisData = []
                        $scope.helperProvidersAnalysisData.push(analysis.goodAskerGoodHelper)
                        $scope.helperProvidersAnalysisData.push(analysis.goodAskerBadHelper)
                        $scope.helperProvidersAnalysisData.push(analysis.badAskerGoodHelper)
                        $scope.helperProvidersAnalysisData.push(analysis.badAskerBadHelper)
                        $scope.nodesCount = analysis.sum;

                        $scope.isolatedNodeList = analysisService.findIsolated(response.data.nodes);
                        $scope.mostConnectedNodeList = analysisService.findMostConnected(response.data.nodes);

                        var kingOfUserAnalysis = analysisService.kindOfUsersAnalysis(response.data.nodes);
                        $scope.kingOfUserAnalysisData = [];
                        $scope.kingOfUserAnalysisData.push(kingOfUserAnalysis.askerCount);
                        $scope.kingOfUserAnalysisData.push(kingOfUserAnalysis.helperCount);
                        $scope.kingOfUserAnalysisData.push(kingOfUserAnalysis.bridgeCount);
                        $scope.kingOfUserAnalysisData.push(kingOfUserAnalysis.infSpreaderCount);

                    });
    };

    $scope.findAll();

});