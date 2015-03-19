var noteService = angular.module('noteService', ['ngResource']);

noteService.factory('Notes', ['$resource', 
  function($resource) {
	return $resource('notes/:id');
}]);