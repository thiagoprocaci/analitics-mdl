app.controller('appCtrl', function($scope, courseService, analysisService) {


    $scope.courseList;
    $scope.helperProvidersAnalysis;
    $scope.helperProvidersAnalysisLabels = ["Providing more helping than the median", "Providing less helping than the median"];
    $scope.helperProvidersAnalysisData = [];
    $scope.helperProvidersAnalysisColours = ['#72C02C', '#3498DB'];

    $scope.findAll = function() {
        courseService.findAll()
            .then(function sucesso(response) {
                $scope.courseList = response.data
            });
     };

    $scope.analysis = function(courseId) {
        analysisService.perform(courseId)
                    .then(function sucesso(response) {
                        $scope.helperProvidersAnalysis = analysisService.findGoodHelpers(response.data.nodes)
                        $scope.helperProvidersAnalysisData = []
                        $scope.helperProvidersAnalysisData.push($scope.helperProvidersAnalysis.good)
                        $scope.helperProvidersAnalysisData.push($scope.helperProvidersAnalysis.bad)
                    });
    };

    $scope.findAll();




});