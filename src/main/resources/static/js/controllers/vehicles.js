'use strict';

angular.module('autoMaintenanceApp.vehicles', ['ngRoute','autoMaintenanceApp.service'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/vehicles', {
            templateUrl: '../views/vehicles.html',
            controller: 'vehiclesController'
        });
    }])

    .controller('vehiclesController', ['$scope', 'apiService', function ($scope, api) {

        $scope.vehicles = [];
        $scope.isEditingVehicle = false;
        var allVehiclesTask = api.findAllVehicles();
        allVehiclesTask.then(function(data){
        $scope.vehicles = data.data;
        }, function(error) {
            //TODO, better error handling.
            console.log(error);

        }) ;

        $scope.editVehicle = function(vehicle) {
            $scope.isEditingVehicle = true;
            $scope.vehicleToEdit = vehicle;

        }
    }]);