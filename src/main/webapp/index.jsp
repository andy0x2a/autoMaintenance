<!DOCTYPE html>

<html lang="en" ng-app="autoMaintenanceApp" class="no-js">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Auto Maintenance SPA</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/bootstrap-theme.css">
    <link rel="stylesheet" href="./css/app.css">
    <script src="./jslib/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-default main">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#/welcome">Home</a>
                <a class="navbar-brand" href="#/vehicles">Vehicles</a>
                <a class="navbar-brand" href="#/maintenance">Maintenance</a>
        </div>
    </div>
    </nav>
<div ng-view class="main" >


</div>

<script src="/jslib/angular.min.js"></script>
<script src="/jslib/angular-route.min.js"></script>
<script src="/js/appRouting.js"></script>
<script src="/js/constants.js"></script>
<script src="/js/services/apiService.js"></script>
<script src="/js/controllers/maintenance.js"></script>
<script src="/js/controllers/welcome.js"></script>
<script src="/js/controllers/vehicles.js"></script>
</body>
</html>
