'use strict';

angular.module('autoMaintenanceApp', [
    'ngRoute',
    'autoMaintenanceApp.vehicles',
    'autoMaintenanceApp.maintenance',
    'autoMaintenanceApp.welcome',

]).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.otherwise({redirectTo: '/welcome'});
    }]);
