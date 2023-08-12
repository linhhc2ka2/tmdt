'use strict';

// Code Angularjs
const app = angular.module('app-client', []);

app.controller('wrapper-ctrl', function ($scope, $http) {
    // == Header ================================================

    // Load list suggest
    $scope.listCategories = [];
    $scope.loadListCategories = function () {
        $http.get(`/api/categories/all`).then((result) => ($scope.listCategories = result.data));
    };
    $scope.loadListCategories();
});

// Code Javascript
const buttonBackToTop = document.getElementById('backtotop');

window.addEventListener('scroll', () => {
    // Lấy vị trí hiện tại của cuộn trang
    const scrollPosition = window.scrollY;

    // Nếu vị trí cuộn trang đạt tới 200px, thêm class vào thẻ button
    if (scrollPosition >= 200) {
        buttonBackToTop.classList.add('show');
    } else {
        buttonBackToTop.classList.remove('show');
    }
});
