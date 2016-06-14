'use strict';

angular.module('autoMaintenanceApp.service', ['autoMaintenanceApp.constants'])

    .service('apiService', ['constants', '$http', function (constants, $http) {
        var _initializeDatabase = function () {
            var req = {
                method: 'POST',
                url: constants.config.apiBase + '/init'
            };
            return $http(req);
        };

        return {
            initializeDatabase: _initializeDatabase
        }
    }]);
