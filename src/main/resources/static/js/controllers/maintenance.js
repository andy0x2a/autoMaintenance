'use strict';

angular.module('autoMaintenanceApp.maintenance', ['ngRoute', 'autoMaintenanceApp.service'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/maintenance', {
            templateUrl: '../views/maintenance.html',
            controller: 'maintenanceController'
        });
    }])

    .controller('maintenanceController', ['$scope', 'apiService', function ($scope, api) {
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


        $scope.removeMaintenanceType = function (maintenanceType, index) {
            api.deleteMaintenanceType(maintenanceType.id).then(function () {
                $scope.maintenanceTypes.splice(index, 1);
            }, function (error) {
                alert(error);
            });
        };
        $scope.removeVehicleType = function (vehicleType, index) {
            api.deleteVehicleType(vehicleType.id).then(function () {
                $scope.vehicleTypes.splice(index, 1);
            }, function (error) {
                alert(error);
            });
        };
        $scope.saveVehicleTypes = function () {
            api.saveVehicleTypes($scope.vehicleTypes).then(function () {

            }, function (error) {
                alert(error);
            });
        }
        $scope.saveMaintenanceTypes = function () {
            api.saveMaintenanceTypes($scope.maintenanceTypes).then(function () {

            }, function (error) {
                alert(error);
            });
        }
    }]);