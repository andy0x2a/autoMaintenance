'use strict';

angular.module('autoMaintenanceApp.vehicles', ['ngRoute', 'autoMaintenanceApp.service'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/vehicles', {
            templateUrl: '../views/vehicles.html',
            controller: 'vehiclesController'
        });
    }])

    .controller('vehiclesController', ['$scope', 'apiService', function ($scope, api) {

        $scope.vehicles = [];
        $scope.isEditingVehicle = false;

        var loadVehicles = function () {
            var allVehiclesTask = api.findAllVehicles();
            allVehiclesTask.then(function (data) {
                $scope.vehicles = data.data;
            }, function (error) {
                //TODO, better error handling.
                alert(error);

            });
        };
        loadVehicles();

        var maintenanceTypeTask = api.findAllMaintenanceTypes();
        maintenanceTypeTask.then(function (data) {
            $scope.maintenanceTypes = data.data;
        }, function (error) {
            //TODO, better error handling.
            alert(error);
        });

        var vehicleTypeTask = api.findAllVehicleTypes();
        vehicleTypeTask.then(function (data) {
            $scope.vehicleTypes = data.data;
        }, function (error) {
            //TODO, better error handling.
            alert(error);
        });

        var maintenanceStatusTask = api.findAllMaintenanceStatuses();
        maintenanceStatusTask.then(function (data) {
            $scope.maintenanceStatuses = data.data;
        }, function (error) {
            //TODO, better error handling.
            alert(error);
        });
        $scope.getValidMaintenanceForVehicle = function (vehicleType) {
            return vehicleType.validMaintenanceTypes;
        }

        $scope.editVehicle = function (vehicle) {
            $scope.isEditingVehicle = true;
            $scope.vehicleToEdit = vehicle;
            $scope.vehicleToEdit.validMaintenance = $scope.getValidMaintenanceForVehicle(vehicle.vehicleType);

        };
        $scope.addVehicle = function () {
            var newVehicle = {};
            newVehicle.maintenanceList = [{}];
            $scope.vehicleToEdit = newVehicle;
            $scope.isEditingVehicle = true;
            $scope.vehicles.push(newVehicle);
        };
        $scope.saveVehicle = function (vehicle) {
            var task;
            if (typeof(vehicle.id) !== "undefined") {
                task = api.updateVehicle(vehicle, vehicle.id);
            } else {
                task = api.createVehicle(vehicle);
            }
            task.then(function (response) {
                loadVehicles();
                $scope.vehicleToEdit = undefined;
                $scope.isEditingVehicle = false;
            }, function (error) {
                alert("Something went wrong saving");

            });
        }
        $scope.addNewMaintenance = function (vehicleToEdit) {
            vehicleToEdit.maintenanceList.push({});

        }
    }]);