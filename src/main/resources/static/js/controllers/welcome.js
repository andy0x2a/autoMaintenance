'use strict';

angular.module('autoMaintenanceApp.welcome', ['ngRoute', 'autoMaintenanceApp.service'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/welcome', {
            templateUrl: '../views/welcome.html',
            controller: 'welcomeController'
        });
    }])

    .controller('welcomeController', ['$scope', 'apiService', function ($scope, api) {

        $scope.welcomeMessage = "Auto Maintenance Web Application";

        $scope.createInventory = function() {
            var apiTask = api.initializeDatabase();
            apiTask.then(function(data) {
              window.href="#/vehicles";
            },function(error) {
                //TODO, show error messages
            });

        }  ;
    }]);
