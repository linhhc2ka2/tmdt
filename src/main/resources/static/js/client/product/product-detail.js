app.controller('product-detail-page-ctrl', function ($scope, $http) {
    // Get param category in url ==> list product
    const urlSearchParams = new URLSearchParams(window.location.search);
    $scope.keyUrl = urlSearchParams.get('key');
});
