// Code AngularJS
app.controller('home-page-ctrl', function ($scope, $http) {
    // Load all slides
    $scope.listSlides = [];
    $scope.getAllSlides = function () {
        $http.get(`/api/slides/all`).then((result) => ($scope.listSlides = result.data));
    };
    $scope.getAllSlides();

    // Load all banners
    $scope.listBanners = [];
    $scope.getAllBanners = function () {
        $http.get(`/api/banners/all`).then((result) => ($scope.listBanners = result.data));
    };
    $scope.getAllBanners();

    // Load 5 products flash sale
    $scope.listProductsFlashSale = [];
    $scope.getProductsFlashSale = function () {
        $http.get(`/api/products/all`).then((result) => ($scope.listProductsFlashSale = result.data));
    };
    $scope.getProductsFlashSale();

    // Handle action button card
    $scope.handleAction = function (key) {
        if (key === 'Lựa chọn') {
            window.location.href = '/san-pham?categoryid=0';
        } else {
            console.log('cho vào giỏ');
        }
    };

    // Load all coupons
    $scope.listCoupons = [];
    $scope.getAllCoupons = function () {
        $http.get(`/api/coupons/all`).then((result) => ($scope.listCoupons = result.data));
    };
    $scope.getAllCoupons();

    // Load products outstanding by categoryId
    $scope.listProductsOutstanding = [];
    $scope.handleGetIdTab = function (categoryId) {
        $http
            .get(`/api/products/${categoryId ? categoryId : 1}`)
            .then((result) => ($scope.listProductsOutstanding = result.data));
    };
    $scope.handleGetIdTab();
});

// Code JS

// Countdown Flash Sale
// Đặt thời điểm kết thúc đếm ngược (ngày và giờ cụ thể)
const countdownDate = new Date('2023-12-31T23:59:59').getTime();

// Cập nhật đồng hồ đếm ngược mỗi giây
const countdownInterval = setInterval(function () {
    const now = new Date().getTime();
    const timeLeft = countdownDate - now;

    // const days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
    const hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
    const seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);

    const countdownElement = document.getElementById('countdown');
    countdownElement.innerHTML = `<span>${hours}</span>:<span>${minutes}</span>:<span>${seconds}</span>`;

    // Khi thời gian kết thúc, xóa đồng hồ đếm ngược và thông báo
    if (timeLeft < 0) {
        clearInterval(countdownInterval);
    }
}, 1000);

// == Swiper ==============================
let swiperBanner = new Swiper('.slider_banner', {
    pagination: {
        el: '.swiper-pagination',
    },
});

let swiperFlashSale = new Swiper('.slider_flashsale', {
    slidesPerView: 5,
    spaceBetween: 10,
    breakpoints: {
        350: {
            slidesPerView: 1.5,
            spaceBetween: 10,
        },
        768: {
            slidesPerView: 3,
            spaceBetween: 10,
        },
        1024: {
            slidesPerView: 5,
            spaceBetween: 10,
        },
    },
});

let swiperCoupons = new Swiper('.slider_coupons', {
    slidesPerView: 5,
    spaceBetween: 20,
    breakpoints: {
        350: {
            slidesPerView: 2,
            spaceBetween: 20,
        },
        768: {
            slidesPerView: 3,
            spaceBetween: 20,
        },
        1024: {
            slidesPerView: 5,
            spaceBetween: 20,
        },
    },
});

let swiperOutstanding = new Swiper('.slider_outstandings', {
    slidesPerView: 5,
    spaceBetween: 10,
    breakpoints: {
        350: {
            slidesPerView: 1.5,
            spaceBetween: 10,
        },
        768: {
            slidesPerView: 3,
            spaceBetween: 10,
        },
        1024: {
            slidesPerView: 5,
            spaceBetween: 10,
        },
    },
});
