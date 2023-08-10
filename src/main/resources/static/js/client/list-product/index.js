app = angular.module('list-product-page', []);
app.controller('list-product-page-ctrl', function ($scope, $http) {
    // Load list products default
    $scope.products = [];

    $scope.getAllProducts = function () {
        $http.get(`/api/list-product`).then((result) => {
            $scope.products = result.data;
        });
    };

    $scope.getAllProducts();
});
