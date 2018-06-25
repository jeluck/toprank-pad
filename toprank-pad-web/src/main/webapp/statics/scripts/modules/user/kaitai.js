/**
 * Created by Fxl on 2016-11-5.
 */
$(function(){
    //弹出预定开台
    $('.yuding').click(function () {
        layer.closeAll();
        layer.open({
            type: 1,
            title: false,
            area: ['60%', '80%'],
            closeBtn: 0,
            scrollbar: false,
            content: $('.yudingkaitai')

        });
        coverRight()
    });

    //点击确定
    $('.yudingkaitai').find('.confirm').click(function () {
        layer.closeAll();
    });

    //除最后一行tr外，其余的都有下划线
    var yudingTable=$('.yudingkaitai').find('table').eq(0);
    var selectedTr=yudingTable.find('tr:not(:last)');
    var firstTr=yudingTable.find('tr:first');
    selectedTr.css('border-bottom','1px solid #d8d8d8');
    firstTr.css('background','#f7faff');
    firstTr.css('border-bottom','none');

    //选中标识
    yudingTable.find('i').on('click',function(){

        if($(this).hasClass('choose')){
            $(this).removeClass('choose');
        }
        else{
            $(this).addClass('choose');
        }
        var signLength=yudingTable.find('.choose');//选出被选中的标识
        $('.yudingkaitai').find('.chooseTable').text(signLength.length);
    })

    $('.yudingkaitai').find('.selectedAll').click(function(){
        selectedAll();
        var signLength=yudingTable.find('.choose');//选出被选中的标识
        $('.yudingkaitai .chooseTable').text(signLength.length);
    });
    $('.yudingkaitai').find('.cancelAll').click(function(){
        cancelAll();
        var signLength=yudingTable.find('.choose');//选出被选中的标识
        $('.yudingkaitai .chooseTable').text(signLength.length);
    })

})

//全选
function selectedAll(){
    var table=$('.yudingkaitai table').eq(0);
    var sign=table.find('td').find('i');
    sign.addClass('choose');
}
//全消
function cancelAll(){
    var table=$('.yudingkaitai table').eq(0);
    var sign=table.find('td').find('i');
    sign.removeClass('choose');
}

//确定

