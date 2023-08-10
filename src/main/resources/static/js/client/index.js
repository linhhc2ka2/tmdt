'use strict';

var app = angular.module('app-client', []);

app.controller('wrapper-ctrl', function ($scope, $http) {
    $scope.img = 'search_icon.svg';
});
