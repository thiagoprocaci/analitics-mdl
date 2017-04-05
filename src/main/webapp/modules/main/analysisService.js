app.service('analysisService', function($http) {

    this.perform = function ( courseId) {
        var promise =  $http.get('/analysis/' + courseId);
         return promise;
    };


    this.findGoodHelpers = function(dataList) {
        var countGood = 0;
        var countBad = 0
        if(dataList) {
            for (var i = 0; i < dataList.length; i++){
                    var obj = dataList[i];
                    for (var key in obj){
                        if("indegreeDesc" == key) {
                            var attrValue = obj[key];
                            if("Excellent" === attrValue || "Good" == attrValue) {
                                countGood++;
                            } else {
                                countBad++;
                            }
                        }
                    }
                }
        }
        return {"good" : countGood, "bad" : countBad}
     };
});