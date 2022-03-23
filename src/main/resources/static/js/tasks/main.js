'use strict';
var tasksModule = angular.module('tasksModule', [
    'ngRoute',
    'ui.router',
    'smart-table',
    'pascalprecht.translate',
    'ui.bootstrap',
    'Common'
]);

tasksModule.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('');
    $routeProvider.when('/tasks/editTask/:id', {
        templateUrl: 'views/tasks/editTask.html',
        controller: 'EditTaskController',
        resolve: {
            task: function (TasksService, $route, CommonService, $location) {
                return TasksService.getTaskById($route.current.params.id).then(function (response) {
                    return response.task;
                }, function (response) {
                    CommonService.openMessageModal('danger', response.errorMessage, 'big_modal');
                    $location.path('/tasks/createTask');
                });
            }
        }
    }).when('/tasks/createTask', {
        templateUrl: 'views/tasks/editTask.html',
        controller: 'EditTaskController',
        resolve: {
            task: function () {
                return {};
            }
        }
    }).when('/tasks', {
        templateUrl: 'views/tasks/viewTasks.html',
        controller: 'TasksController'
    }).otherwise({
        templateUrl: 'views/tasks/viewTasks.html',
        controller: 'TasksController'
    })
}]);