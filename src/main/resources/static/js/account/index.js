// Code Angularjs
app.controller('login-page-ctrl', function ($scope) {
    $scope.showRecoverPasswordForm = false;
    $scope.handleSetStatusForm = function (status) {
        $scope.showRecoverPasswordForm = status;
    };
});

app.controller('sign-up-page-ctrl', function ($scope) {
    console.log('Đangky');
});

// Code Javascript
