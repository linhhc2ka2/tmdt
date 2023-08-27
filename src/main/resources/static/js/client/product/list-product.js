app.controller('list-product-page-ctrl', function ($scope, $http, shareService) {
    // Get param category in url ==> list product
    const urlSearchParams = new URLSearchParams(window.location.search);
    $scope.keyUrl = urlSearchParams.get('key');

    // Load list products default
    $scope.listProducts = [];
    $scope.getAllProducts = function (key) {
        $http.get(`/api/products/` + key).then((result) => {
            const newResult = shareService.enCodeURI(result.data);
            $scope.listProducts = newResult;
        });
    };

    $scope.getAllProducts($scope.keyUrl);

    // Sort prodcts
    $scope.idSort = '';
    function sortListProducts(keySort, listProducts) {
        switch (keySort) {
            case 'alpha_desc':
                listProducts.sort(function (a, b) {
                    if (a.name.toUpperCase() < b.name.toUpperCase()) {
                        return -1;
                    }
                    if (a.name.toUpperCase() > b.name.toUpperCase()) {
                        return 11;
                    }
                    return 0;
                });
                break;
            case 'alpha_asc':
                listProducts.sort(function (a, b) {
                    if (a.name.toUpperCase() < b.name.toUpperCase()) {
                        return 1;
                    }
                    if (a.name.toUpperCase() > b.name.toUpperCase()) {
                        return -1;
                    }
                    return 0;
                });
                break;
            case 'price_desc':
                listProducts.sort(function (a, b) {
                    if (a.price < b.price) {
                        return -1;
                    }
                    if (a.price > b.price) {
                        return 1;
                    }
                    return 0;
                });
                break;
            case 'price_asc':
                listProducts.sort(function (a, b) {
                    if (a.price < b.price) {
                        return 1;
                    }
                    if (a.price > b.price) {
                        return -1;
                    }
                    return 0;
                });
                break;
            case 'create_desc':
                listProducts.sort(function (a, b) {
                    if (a.createAt < b.createAt) {
                        return 1;
                    }
                    if (a.createAt > b.createAt) {
                        return -1;
                    }
                    return 0;
                });
                break;
            case 'create_asc':
                listProducts.sort(function (a, b) {
                    if (a.createAt < b.createAt) {
                        return -1;
                    }
                    if (a.createAt > b.createAt) {
                        return 1;
                    }
                    return 0;
                });
                break;

            default:
                break;
        }

        return listProducts;
    }

    $scope.sortBy = function (keySort) {
        let newListProducts = sortListProducts(keySort, $scope.listProducts);
        $scope.idSort = keySort;
        if (keySort === '') {
            $scope.listProducts = $scope.getAllProducts($scope.keyUrl);
        } else {
            $scope.listProducts = newListProducts;
        }
    };

    // Filter products by price
    $scope.clickCheckbox1 = false;
    $scope.clickCheckbox2 = false;
    $scope.clickCheckbox3 = false;
    $scope.clickCheckbox4 = false;
    $scope.clickCheckbox5 = false;
    $scope.clickCheckbox6 = false;

    function filterListProducts(keyFilter, listProducts) {
        switch (keyFilter) {
            case 'filter-duoi-200-000d':
                $scope.clickCheckbox1 = !$scope.clickCheckbox1;

                if ($scope.clickCheckbox1) {
                    return listProducts.filter(
                        (product) => product.price - (product.price * product.sale) / 100 < 200000,
                    );
                }
                break;
            case 'filter-tu-200-000d-500-000d':
                $scope.clickCheckbox2 = !$scope.clickCheckbox2;

                if ($scope.clickCheckbox2) {
                    return listProducts.filter(
                        (product) =>
                            product.price - (product.price * product.sale) / 100 >= 200000 &&
                            product.price - (product.price * product.sale) / 100 <= 500000,
                    );
                }
                break;
            case 'filter-tu-500-000d-den-1tr':
                $scope.clickCheckbox3 = !$scope.clickCheckbox3;

                if ($scope.clickCheckbox3) {
                    return listProducts.filter(
                        (product) =>
                            product.price - (product.price * product.sale) / 100 >= 500000 &&
                            product.price - (product.price * product.sale) / 100 <= 1000000,
                    );
                }
                break;
            case 'filter-tu-1tr-2tr':
                $scope.clickCheckbox4 = !$scope.clickCheckbox4;

                if ($scope.clickCheckbox4) {
                    return listProducts.filter(
                        (product) =>
                            product.price - (product.price * product.sale) / 100 >= 1000000 &&
                            product.price - (product.price * product.sale) / 100 <= 2000000,
                    );
                }
                break;
            case 'filter-tu-2tr-5tr':
                $scope.clickCheckbox5 = !$scope.clickCheckbox5;

                if ($scope.clickCheckbox5) {
                    return listProducts.filter(
                        (product) =>
                            product.price - (product.price * product.sale) / 100 >= 2000000 &&
                            product.price - (product.price * product.sale) / 100 <= 5000000,
                    );
                }
                break;
            case 'filter-tren-5tr':
                $scope.clickCheckbox6 = !$scope.clickCheckbox6;

                if ($scope.clickCheckbox6) {
                    return listProducts.filter(
                        (product) => product.price - (product.price * product.sale) / 100 > 5000000,
                    );
                }
                break;

            default:
                break;
        }
    }

    $scope.filterBy = function (keyFilter) {
        let newlistProducts = filterListProducts(keyFilter, $scope.listProducts);
        if (
            ($scope.clickCheckbox1 === false && keyFilter === 'filter-duoi-200-000d') ||
            ($scope.clickCheckbox2 === false && keyFilter === 'filter-tu-200-000d-500-000d') ||
            ($scope.clickCheckbox3 === false && keyFilter === 'filter-tu-500-000d-den-1tr') ||
            ($scope.clickCheckbox4 === false && keyFilter === 'filter-tu-1tr-2tr') ||
            ($scope.clickCheckbox5 === false && keyFilter === 'filter-tu-2tr-5tr') ||
            ($scope.clickCheckbox6 === false && keyFilter === 'filter-tren-5tr')
        ) {
            $scope.listProducts = $scope.getAllProducts($scope.keyUrl);
        } else {
            $scope.listProducts = newlistProducts;
        }
    };
});
