app.service('analysisService', function($http) {

    this.perform = function ( courseId) {
        var promise =  $http.get('/analysis/' + courseId);
         return promise;
    };
});