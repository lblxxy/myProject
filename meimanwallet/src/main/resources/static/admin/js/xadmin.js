$(function () {
    //加载弹出层
    layui.use(['form','element'],
    function() {
        console.log("start");
    });
    //判断是否显示左侧菜单
    $(window).resize(function(){
        width=$(this).width();
        if(width>1024){
            $('#side-nav').show();
        }
    });
});


//窄屏下的左侧菜单隐藏效果
$('.container .open-nav i').click(function(event) {
    $('#side-nav').toggle(400);
    // $('.wrapper .left-nav').toggle(400)
});

//左侧菜单效果
$('.left-nav #nav li').click(function () {
    if($(this).hasClass('open')){
        $(this).removeClass('open');
        $(this).find('.nav_right').html('&#xe697;');
        $(this).children('.sub-menu').slideUp();
        // $(this).siblings().children('.sub-menu').slideUp();
    }else{
        $(this).addClass('open');
        $(this).find('.nav_right').html('&#xe6a6;');
        $(this).children('.sub-menu').slideDown();
        $(this).siblings().children('.sub-menu').slideUp();
        $(this).siblings().removeClass('open');
    }

})

//初始化菜单展开样式
$('.left-nav #nav li .opened').siblings('a').find('.nav_right').html('&#xe6a6;');