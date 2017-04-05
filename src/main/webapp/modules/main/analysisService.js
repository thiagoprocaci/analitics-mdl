app.service('analysisService', function($http) {

    this.perform = function ( courseId) {
        var promise =  $http.get('/analysis/' + courseId);
         return promise;
    };

    this.askerHelperAnalysis = function(dataList) {
        var goodAskerGoodHelper = 0
        var goodAskerBadHelper = 0
        var badAskerGoodHelper = 0
        var badAskerBadHelper = 0
        if(dataList) {
            for (var i = 0; i < dataList.length; i++){
                    var goodhelper = false;
                    var goodAsker = false;
                    var obj = dataList[i];
                    for (var key in obj) {
                        if("indegreeDesc" === key || "outdegreeDesc" === key) {
                            if("indegreeDesc" == key) {
                                var attrValue = obj[key];
                                if("Excellent" === attrValue || "Good" == attrValue) {
                                    goodhelper = true;
                                }
                            }
                            if("outdegreeDesc" == key) {
                                var attrValue = obj[key];
                                if("Excellent" === attrValue || "Good" == attrValue) {
                                    goodAsker = true;
                                }
                            }
                        }
                    }
                    if(goodAsker && goodhelper) {
                        goodAskerGoodHelper++;
                    } else if(goodAsker && !goodhelper) {
                        goodAskerBadHelper++;
                    } else if(!goodAsker && goodhelper) {
                        badAskerGoodHelper++;
                    } else if(!goodAsker && !goodhelper) {
                        badAskerBadHelper++;
                    }
                }
        }
        return {"goodAskerGoodHelper" : goodAskerGoodHelper, "goodAskerBadHelper" : goodAskerBadHelper, "badAskerGoodHelper" :  badAskerGoodHelper, "badAskerBadHelper" :  badAskerBadHelper}
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