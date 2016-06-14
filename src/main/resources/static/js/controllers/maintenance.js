'use strict';

angular.module('autoMaintenanceApp.maintenance', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/maintenance', {
            templateUrl: '../views/maintenance.html',
            controller: 'maintenanceController'
        });
    }])

    .controller('maintenanceController', [function() {

    }]);