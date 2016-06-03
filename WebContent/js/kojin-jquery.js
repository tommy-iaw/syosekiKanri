
$(function($) {
    $('.li').pagination({
        pager        : $('.pager'),
        prevText     : '＜',
        nextText     : '＞',
        firstText    : '≪',
        lastText     : '≫',
        viewNum      : 12,
        pagerNum     : 5,
        ellipsis     : false,
        linkInvalid  : true,
        goTop        : true,
        firstLastNav : true,
        prevNextNav  : true
    });
});


$(function() {
    $('#passcheck').change(function(){
        if ( $(this).prop('checked') ) {
            $('.password').attr('type','text');
        } else {
            $('.password').attr('type','password');
        }
    });
});
