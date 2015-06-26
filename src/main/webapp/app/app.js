var app = angular.module('blogApp', ['noteService']);

app.controller('blogsController', ['$scope','BlogService', function($scope,BlogService) {
	var blogsController = this;

	var service = BlogService;
	blogsController.blog = {};
	blogsController.blogs =[];
	
	blogsController.addBlog = function(newBlog) {
		service.addBlog(newBlog);
	};

	$scope.$watch(function () {
        return service.blog();
    }, function(value) {
        blogsController.blog = value;
    });

    $scope.$watch(function () {
            return service.blogs();
        }, function(value) {
            blogsController.blogs = value;
        });

}]);