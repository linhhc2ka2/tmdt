// Code Angularjs
app.controller('login-page-ctrl', function ($scope, $http) {
    $scope.showRecoverPasswordForm = false;
    $scope.handleSetStatusForm = function (status) {
        $scope.showRecoverPasswordForm = status;
    };
});

// Code Javascript
