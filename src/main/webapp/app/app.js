var app = angular.module('blogApp', []);

app.controller('blogsController', function() {
	var blogsController = this;
	
	blogsController.blog = {};
	blogsController.blogs = [];
	
	blogsController.addBlog = function() {
		blogsController.blogs.push(blogsController.blog);
		blogsController.blog = {};
	};
});