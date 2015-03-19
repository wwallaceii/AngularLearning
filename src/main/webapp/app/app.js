var app = angular.module('blogApp', ['noteService']);

app.controller('blogsController', ['Notes', function(Notes) {
	var blogsController = this;
	
	blogsController.blog = {};
	blogsController.blogs = Notes.query();
	
	blogsController.addBlog = function() {
		var blog = Notes.save(blogsController.blog);
		blogsController.blogs.push(blog);
		blogsController.blog = {};
	};
}]);