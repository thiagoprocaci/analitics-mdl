app.service('analysisService', function($http) {

    this.perform = function ( courseId) {
        var promise =  $http.get('/analysis/' + courseId);
         return promise;
    };


    this.kindOfUsersAnalysis = function (nodeList) {
         var askerCount = 0;
         var helperCount = 0;
         var bridgeCount = 0;
         var infSpreaderCount = 0;
         if(nodeList) {
             for (var i = 0; i < nodeList.length; i++){
                   var node = nodeList[i];
                   if(node.indegreeDesc === "Excellent" || node.indegreeDesc === "Good") {
                        helperCount++;
                   }
                   if(node.outdegreeDesc === "Excellent" || node.outdegreeDesc === "Good") {
                       askerCount++;
                   }
                   if(node.betweennessDesc === "Excellent" || node.betweennessDesc === "Good") {
                       bridgeCount++;
                   }
                   if(node.closenessDesc === "Excellent" || node.closenessDesc === "Good") {
                      infSpreaderCount++;
                   }
             }
         }
         return {"askerCount" : askerCount, "helperCount" : helperCount, "bridgeCount" : bridgeCount, "infSpreaderCount" : infSpreaderCount};
    };

    this.findIsolated = function (nodeList) {
         var isolatedNodeList = []
         if(nodeList) {
             for (var i = 0; i < nodeList.length; i++){
                   var node = nodeList[i];
                   if(node.degreeDesc === "Bad") {
                        isolatedNodeList.push({ "id" : node.id, "label" : node.label, "degree" : node.degree, "indegree" : node.indegree, "outdegree" : node.outdegree})
                   }
             }
         }
         return isolatedNodeList;
    };

    this.findMostConnected = function (nodeList) {
             var mostConnectedNodeList = []
             if(nodeList) {
                 for (var i = 0; i < nodeList.length; i++){
                       var node = nodeList[i];
                       if(node.degreeDesc === "Excellent") {
                            mostConnectedNodeList.push({ "id" : node.id, "label" : node.label, "degree" : node.degree, "indegree" : node.indegree, "outdegree" : node.outdegree})
                       }
                 }
             }
             return mostConnectedNodeList;
        };

    this.askerHelperAnalysis = function(nodeList) {
        var goodAskerGoodHelper = 0
        var goodAskerBadHelper = 0
        var badAskerGoodHelper = 0
        var badAskerBadHelper = 0
        var sum = 0
        if(nodeList) {
            for (var i = 0; i < nodeList.length; i++){
                    var goodhelper = false;
                    var goodAsker = false;
                    var node = nodeList[i];
                    if(node.indegreeDesc === "Excellent" || node.indegreeDesc === "Good") {
                        goodhelper = true;
                    }
                    if(node.outdegreeDesc === "Excellent" || node.outdegreeDesc === "Good") {
                        goodAsker = true;
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
            sum = nodeList.length;
        }

        return {"sum" : sum, "goodAskerGoodHelper" : goodAskerGoodHelper, "goodAskerBadHelper" : goodAskerBadHelper, "badAskerGoodHelper" :  badAskerGoodHelper, "badAskerBadHelper" :  badAskerBadHelper}
     };

});