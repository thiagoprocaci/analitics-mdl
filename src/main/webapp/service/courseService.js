app.service('courseService', function($scope, $http) {

    this.findAll = function () {

      var promisse =  $http.get('course');
      return promisse;
    }

});