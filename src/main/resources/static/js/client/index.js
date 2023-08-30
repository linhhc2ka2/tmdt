'use strict';

// Code Angularjs
const app = angular.module('app-client', ['angularUtils.directives.dirPagination', 'ngRoute']);

// Routing
app.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when('/', {
            title: 'Thương mại điện tử',
            templateUrl: '/client/pages/home/index.html',
            controller: 'home-page-ctrl',
        })
        .when('/account/login', {
            title: 'Đăng nhập tài khoản',
            templateUrl: '/client/pages/login/index.html',
            controller: 'login-page-ctrl',
        })
        .otherwise({ redirectTo: '/' });

    // Enable HTML5 mode
    $locationProvider.html5Mode(true);
});

app.run([
    '$rootScope',
    '$route',
    function ($rootScope, $route) {
        $rootScope.$on('$routeChangeSuccess', function (newVal, oldVal) {
            if (oldVal !== newVal) {
                document.title = $route.current.title;
                $rootScope.title = $route.current.title;
            }
        });
    },
]);

app.controller('wrapper-ctrl', function ($scope, $http) {
    // == Header ================================================

    // Load list suggest
    $scope.listCategories = [];
    $scope.loadListCategories = function () {
        $http.get(`/api/categories/all`).then((result) => ($scope.listCategories = result.data));
    };
    $scope.loadListCategories();

    // Get param category in url ==> list product
    const urlSearchParams = new URLSearchParams(window.location.search);
    $scope.valueUrl = urlSearchParams.get('value');
});

app.service('shareService', function () {
    this.enCodeURI = function (array) {
        const newData = [];
        array.map((data) => {
            data.nameURL = encodeURIComponent(data.name);
            newData.push(data);
        });
        return newData;
    };
});

// Code Javascript

// Button back to top
window.addEventListener('scroll', () => {
    const buttonBackToTop = document.getElementById('backtotop');

    if (window.scrollY >= 200) {
        buttonBackToTop.classList.add('show');
    } else {
        buttonBackToTop.classList.remove('show');
    }
});
