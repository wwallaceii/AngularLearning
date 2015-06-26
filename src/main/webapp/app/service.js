var noteService = angular.module('noteService', ['ngResource']);

noteService.factory('BlogService', ['$resource',
  function($resource) {
    var blogResource = $resource('notes/:id');
    var blogs = blogResource.query();
    var blog = {};

    return {
        'blogs' : function() { return blogs; },
        'blog' : function() {return blog; },
        'addBlog' : function(saveBlog) {
            var newBlog = blogResource.save(saveBlog);
            blogs.push(newBlog);
            blog = {};
        }
    };
}]);