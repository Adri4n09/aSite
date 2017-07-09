'use strict';

App.factory('ArticlesService', ['$http', '$q', function($http, $q) {
    return {
        getAllArticles: function() {
            console.info("article service");
            return $http.get('http://localhost:8080/getArticles')
                .then(
                    function(response) {
                        console.log('articles: ' + response.data);
                        return response.data;
                    },
                    function(errResponse) {
                        console.error('error while fetching articles');
                        return $q.reject(errResponse);
                    }
                );
        }
    };
}]);