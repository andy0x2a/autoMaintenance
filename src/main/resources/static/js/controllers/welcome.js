'use strict';

angular.module('autoMaintenanceApp.welcome', ['ngRoute', 'autoMaintenanceApp.service'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/welcome', {
            templateUrl: '../views/welcome.html',
            controller: 'welcomeController'
        });
    }])

    .controller('welcomeController', ['$scope', '$location', 'apiService', function ($scope, $location, api) {

        $scope.welcomeMessage = "Auto Maintenance Web Application";
         $scope.welcomeDescription = "Click  'Create Sample Inventory' to let the server generate some sample data," +
             " or navigate through the website, and create your own.";

        $scope.createInventory = function() {
            var allVehicles = api.findAllVehicles();
            allVehicles.then(function(data){
                if(typeof(data.data) =="undefined" || data.data.length ==0) {
                    var apiTask = api.initializeDatabase();
                    apiTask.then(function() {
                        $location.path( "/#/login" );
                    },function(error) {
                        //TODO, show error messages

                    });
                }else {
                    alert("Sorry, but data has already been created");
                }
            });


        }  ;
    }]);
