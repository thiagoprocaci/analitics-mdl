app.service('courseService', function($http) {

    this.findAll = function () {
        var promise =  $http.get('/course');
         return promise;
    };
});