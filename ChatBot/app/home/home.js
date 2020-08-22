/*!
 * メインページ
 */

/**
 * 車両情報
 */
// const carInfo = new Vue({
//   el: '#campaignInfo',
//   methods: {
//     clickButton: function (event) {
//       // window.location.href = 'C:/VSCode/ChatBot/app/selectcarpage/selectcarpage.html';
//       // window.location.href = 'http://isidg85186:8080/assets/app/selectcarpage/selectcarpage.html';
//       window.location.href = 'http://18.217.114.128:8080/assets/app/selectcarpage/selectcarpage.html';
//     }
//   }
// });

/**
 * 5分ください - クリック
 */
// const fiveMinutes = new Vue({
//   el: '#fiveMinutes',
//   methods: {
//     click: function (event) {
//       window.open('https://www.oka-daihatsu.co.jp/product/insurance/', '_blank');
//       // 追従スクロールをOFF
//       $('#fiveMinutes').removeClass('fixed');
//       $(window).off('scroll');
//     }
//   }
// });

/**
 * 5分ください - スクロール
 */
var _window = $(window),
    _header = $('#fiveMinutes'),
    heroBottom;
_window.on('scroll',function(){     
    heroBottom = $('#header').height();
    if(_window.scrollTop() > heroBottom){
        _header.addClass('fixed');
    }
    else{
        _header.removeClass('fixed');
    }
});
_window.trigger('scroll');