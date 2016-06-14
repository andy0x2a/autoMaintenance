'use strict';

angular.module('autoMaintenanceApp.service', ['autoMaintenanceApp.constants'])

    .service('apiService', ['constants', '$http', function (constants, $http) {
        var _initializeDatabase = function () {
            var req = {
                method: 'POST',
                url: constants.config.apiBase + '/init/'
            };
            return $http(req);
        };
        var _findAllVehicles = function () {
            var req = {
                method: 'GET',
                url: constants.config.apiBase + '/vehicle/'
            };
            return $http(req);
        };
        var _getVehicle = function (id) {
            var req = {
                method: 'GET',
                url: constants.config.apiBase + '/vehicle/' + id
            };
            return $http(req);
        };
        var _createVehicle = function (vehicle) {
            var req = {
                method: 'POST',
                url: constants.config.apiBase + '/vehicle/',
                data:vehicle
            };
            return $http(req);
        };
        var _updateVehicle = function (vehicle, id) {
            var req = {
                method: 'PUT',
                url: constants.config.apiBase + '/vehicle/' + id,
                data:vehicle
            };
            return $http(req);
        };
        var _findAllMaintenanceTypes = function () {
            var req = {
                method: 'GET',
                url: constants.config.apiBase + '/maintenanceType/'

            };
            return $http(req);
        };
        var _findAllVehicleTypes = function () {
            var req = {
                method: 'GET',
                url: constants.config.apiBase + '/vehicleType/'

            };
            return $http(req);
        };
        var _getMaintenanceById = function (id) {
            var req = {
                method: 'GET',
                url: constants.config.apiBase + '/maintenance/' +id

            };
            return $http(req);
        };

        return {
            initializeDatabase: _initializeDatabase,
            findAllVehicles:_findAllVehicles,
            getVehicle:_getVehicle,
            createVehicle:_createVehicle,
            updateVehicle:_updateVehicle,
            getMaintenanceById:_getMaintenanceById,


            findAllMaintenanceTypes:_findAllMaintenanceTypes,
            findAllVehicleTypes:_findAllVehicleTypes
        }
    }]);
