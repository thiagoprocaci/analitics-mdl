app.controller('interactionCtrl', function($scope, courseService, analysisService, ModalService) {


    $scope.courseList;

    // interactions chart
    $scope.helperProvidersAnalysisLabels = ["Ask to several and help several people",
                                            "Ask to several and help few people",
                                            "Ask to few and help several people",
                                       "Ask to few and help few people"];
    $scope.helperProvidersAnalysisData = [];
    $scope.chartOptions = {
        legend: {
          display: true
        }
      };

    $scope.nodesCount = 0;
    $scope.edgeCount = 0;
    $scope.isolatedNodeList = []
    $scope.mostConnectedNodeList = []
    $scope.mostActiveNodeList = []
    $scope.lessActiveNodeList = []


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
                        $scope.edgeCount = response.data.edges.length
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

                        $scope.mostActiveNodeList = analysisService.findMostActive(response.data.nodes);
                        $scope.lessActiveNodeList = analysisService.findLessActive(response.data.nodes);

                    });
    };

    $scope.userDetails = function(n) {

            ModalService.showModal({
              templateUrl: "modules/user/userModal.html",
              controller: "userCtrl",
              inputs: {
                user: n
              }
            }).then(function(modal) {
              modal.element.modal();
              modal.close.then(function(result) {
                //$scope.complexResult  = "Name: " + result.name + ", age: " + result.age;
              });
            });
    };

    $scope.findAll();

});