'use strict';

angular.module('autoMaintenanceApp.vehicles', ['ngRoute','autoMaintenanceApp.service'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/vehicles', {
            templateUrl: '../views/vehicles.html',
            controller: 'vehiclesController'
        });
    }])

    .controller('vehiclesControlller', ['$scope', 'apiService', function ($scope, api) {

        var allVehiclesTask = api.findAllVehicles();
        allVehiclesTask.then(function(data){
            console.log(data);

        }, function(error) {
            //TODO, better error handling.
            console.log(error);

        })

    }]);