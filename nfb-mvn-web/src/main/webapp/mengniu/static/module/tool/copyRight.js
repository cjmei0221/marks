define(['zepto'], function($) {

    var exports = {};

    var defaultOpt = {
        year: '2016',
        company: '欧世蒙牛'
    };

    var copyRightHtml = '<div class="copyContent f-10 txtCenter">&copy; '+ defaultOpt.year +' '+ defaultOpt.company +'</div>';

    exports.init = function(){

        $('.content').append(copyRightHtml);

    }

    return exports.init();

});