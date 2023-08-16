app.controller('list-product-page-ctrl', function ($scope, $http) {
    // Get param category in url ==> list product
    const urlSearchParams = new URLSearchParams(window.location.search);
    $scope.keyUrl = urlSearchParams.get('key');

    // Load list products default
    $scope.products = [];
    $scope.getAllProducts = function () {
        $http.get(`/api/products/` + $scope.keyUrl).then((result) => {
            $scope.products = result.data;
        });
    };

    $scope.getAllProducts();
});
