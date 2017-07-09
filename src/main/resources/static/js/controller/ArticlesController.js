'use strict';

App.controller('ArticlesController', ['$scope', 'ArticlesService', function($scope, ArticlesService) {
    var self = this;
    self.article = {id:'', username:'', title:'', content:''};
    self.articles=[];

    self.fetchAllArticles = function () {
        console.info("articlesController");
        ArticlesService.getAllArticles()
            .then(
                function(data) {
                    self.articles = data;
                },
                function(errResponse) {
                    console.error('Error while fetching articles ' + errResponse);
                }
            );
    };

    this.fetchAllArticles();

}]);