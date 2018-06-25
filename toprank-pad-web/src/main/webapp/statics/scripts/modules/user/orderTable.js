/**
 * 点菜餐台信息
 * @author ZhouFY
 */

$(function(){  
	
	

	//桌台信息显示
    var mealsID = $("#mealsID").val()
    var tableID = $("#tableID").val();
    getOrderTableInfo(tableID,mealsID);
    

	
	//人数编辑点击事件
	$(".area dd").click(function(){
		layer.open({
		  type: 1,
		  title: false,
		  area: ['295px', '350px'],
		  closeBtn: 0,  
		  scrollbar: false, 
		  content: $('.editPeople')
		});
		//  ------
		var personNum=$(".area .personNum span").text();
		$('.editPeople input').eq(0).val(personNum);	
	
		var remark=$(".area .remark").text();
		$('.editPeople textarea').val(remark);
	})
	
	//人数金额编辑的确定按钮
    $('.editPeople .btn_confirm').click(function(){
        var peopleNum=$(this).parent().siblings('.count').find('input').val();
        var selectText = $('.editPeople textarea').val();
        
       if(peopleNum<1) {
    	   layer.msg(' 人数不能小于1');
           return ;
       } 
      //修改餐次桌台信息（人数、备注）
       var hisID = $(".area #hisID").val();
       if (hisID>0) {
    	   var result = modifyOrderTableInfo(hisID,peopleNum,selectText);
    	   if (result == 1) {
    		   $(".area .personNum span").text(peopleNum);
    		   $(".area .remark").text(selectText);
    	   } else {
    		   layer.msg(' 修改失败！');
    	   }
		} else {
			layer.msg(' 修改失败！');   //   
		}
    }); 
	
    //点击取消按钮
    $('.btn_cancel').click(function(){
        $(this).parent().parent().hide();
    })
	
});

/**
 * 获取点菜桌台信息
 * @returns
 * @author ZhouFY
 */
function getOrderTableInfo(tableID,mealsID){
	var orderTableInfo;
	$.ajax({
	 	async: false,
		type: 'post',
		data: {"tableID":tableID,"mealsID":mealsID}, 
		url: "../orderTableInfo.action",
		success: function (data) {
			orderTableInfo = $.parseJSON(data);
			
			var mydate = new Date(orderTableInfo.startTime);
			var jstime = mydate.getTime()==undefined?0:Math.floor(((new Date()).getTime()-mydate.getTime())/1000/60);
			jstime=jstime>0?jstime:0
			$(".area .tableName").text(orderTableInfo.tableName==undefined?"号":orderTableInfo.tableName+"号");
			$(".area .areaName").text(orderTableInfo.areaName);
			$(".area .personNum span").text(orderTableInfo.customerNumber==undefined?$("#peopleNum").val():orderTableInfo.customerNumber);
			$(".area .icon-shizhongfill").next("span").text(jstime+"分钟");
			$(".area .remark").text(orderTableInfo.memo);
			$(".area #hisID").val(orderTableInfo.hisID);
			
		},
		error:function(xhr, status, error){layer.msg('获取点菜桌台信息失败')},
	});
}

/**
 * 修改点菜桌台信息
 * @returns
 * @author ZhouFY
 */
function modifyOrderTableInfo(hisID,customerNumber,memo){
	var result = 0;
	$.ajax({
	 	async: false,
		type: 'post',
		data: {"hisID":hisID,"customerNumber":customerNumber,"memo":memo}, 
		url: "../modifyOrderTableInfo.action",
		success: function (data) {
			result = $.parseJSON(data).result; // modifyResult  1:成功  ， 2:失败
		},
		error:function(xhr, status, error){},
	});
	return result
}
