/**
 * Created by Fxl on 2016-10-19.
 */
var currentAppend='';//表格第一列要追加的内容，即赠菜退菜原因列；
var recordNumTd='';//表格的第二列；
var recordNum=1;//表格的第二列的数字；
var currentAppend2='';//表格第三列追加的内容，即2退1这列；
var currentDelete='';//当前点击的行，即tr；
var currentPrice='';//当前点击的行的价格
var returnTotal=1;//退菜的总量；
var Total='';//已有菜总量；
var productType = 684;   //684 表示正常  687表示加菜  686表示赠菜   685表示退菜

var orderPrice = 0;		//子订单的总价格
var orderNum = 0;		//子订单的总数量
var pageHeight=$(window).height();
$('body,.orderLeft,.orderRight').css('height',pageHeight);
var tableName = "";
var tableID = $("#tableID").val();
var storageName = "";




function checkStorageName(){
	if(tableName != ""){
		storageName = tableID+"-"+tableName;
	}else{
		storageName = tableID;
	}
}
function tc_zhankai(e,id){
	 var content=$(e).parents('.setMealOrder').children().children('.lightGreen');
    if($(e).hasClass('icon-zhankai')){
        $(e).removeClass('icon-zhankai');
        $(e).addClass('icon-shouqi-copy');
        content.show();
    } else {
        $(e).addClass('icon-zhankai');
        $(e).removeClass('icon-shouqi-copy');
        content.hide();
    }
    
   
    
    if(e&&e.stopPropagation){//非IE
		e.stopPropagation();
    }else{//IE
		window.event.cancelBubble=true;
    }
}

$(function(){
	$(window).resize(function(){
        orderRightHeight();
        orderRightWidth();
        orderLeftHeight()
    });
    orderRightHeight();
    orderRightWidth();
    orderLeftHeight()
    first_lastLi();
    
    
    if($("#mealsID").val()==0){
    	var code = getMealsList(0);
    	if(code == "empty"){
    		if(getMealsList(1)  == "empty"){
        		layer.msg('此区域无餐次信息');
    		}
    	}
    }
    
	/************************zhoufy-start*******************************/
	
	
	//菜品搜索按钮  zhoufy
	$('.orderRightBottom .suosuo').click(function(){
        loadProductList(); 
    })
    //动态触发搜索
    $("#searchCode").bind('input propertychange',function(e){  
    	loadProductList(); 
    });  
    

	//餐次桌台信息
//    var segmentID = $("#segmentID").val();
//	var mealTableInfo = getMealTableMappingInfo(segmentID);
//	var mydate = new Date(mealTableInfo.startTime);
//	var jstime = mydate.getTime()==undefined?0:Math.floor(((new Date()).getTime()-mydate.getTime())/1000/60);
//	$(".area .tableName").text(mealTableInfo.tableName==undefined?'':mealTableInfo.tableName+"号");
//	$(".area .areaName").text(mealTableInfo.areaName);
//	$(".area .personNum span").text(mealTableInfo.customerNumber==undefined?$("#peopleNum").val():mealTableInfo.customerNumber);
//	$(".area .icon-shizhongfill").next("span").text(jstime+"分钟");
//	$(".area .remark").text(mealTableInfo.memo);
//	
	

	
		
	
    
    /************************zhoufy-end*******************************/
	
	
	/**
	 * 初始化数据库已经下单的菜品列表
	 */
	loadDBproductList($("#subOrderID").val(),$("#mealsID").val(),$("#tableID").val());
	
	/**初始化localStorage已点菜列表**/
	var producthtml = '';
	var combohtml = '';
	if(localStorage.getItem(storageName)){
		var students = localStorage.getItem(storageName);
		students = JSON.parse(students);//把字符串转换成JSON对象
		if(students.order){
			for (var i = 0; i < students.order.length; i++) {
				if(students.order[i].type == 684 || students.order[i].type == 687){
					if(students.order[i].comboID){
						var varianHtml = '';
						var varianPriceHtml = '';
						combohtml += '\
							<tr class="setMealOrder" onclick="clickOrder(this,0)">\
							<td style="width: 50%" id="product-'+students.order[i].comboID+'">\
								<i class="blueCircle_15"></i>\
								<p class="fL">'+students.order[i].productName+'</p>\
								<div class="greenCircle">套</div>\
							';
						for (var y = 0; y < students.order[i].combo.length; y++) {
								combohtml += '\
									<div class="secondMenu lightGreen clear f12"  onclick="secondMenuClick(this)">\
										<i class="blueCircle_12"></i>\
										'+students.order[i].combo[y].variantName+'\
									</div>\
									';
								varianHtml += '<div class="lightGreen">'+students.order[i].productNum+'</div>';
								var vprice = students.order[i].combo[y].variantPrice == undefined ? 0: students.order[i].combo[y].variantPrice;
								varianPriceHtml += '<div class="lightGreen f12">￥<span>'+vprice+'</span></div>';
						}
						combohtml += '</td>\
										<td style="width: 15%;" class="countTotal" ><span class="total">'+students.order[i].productNum+'</span>'+varianHtml+'</td>\
										<td style="width: 25%" class="price"><div >￥<span>'+students.order[i].comboPrice+'</span></div>'+varianPriceHtml+'</td>\
										<td style="width: 10%"><i class="iconfont click_zhankai icon-zhankai" onclick="tc_zhankai(this)"></i>\
										</td>\
									</tr>';
						
					}else{
						var practice = students.order[i].practice;
						var practiceHtml = '';
						if(practice){
							practiceHtml ='<div class="tasteAppend">'+'<i class="taste">口味</i>' +practice+'</div>'
						}
						producthtml += '\
							<tr onclick="clickOrder(this,0)" >\
								<td style="width: 50%" id="variant-'+students.order[i].variantID+'">\
									<i class="blueCircle_15"></i>'+students.order[i].productName+''+practiceHtml+'\
								</td>\
								<td style="width: 15%;"><div class="total">'+students.order[i].productNum+'</div></td>\
								<td style="width: 25%" class="price">\
									<div>￥<span class="currentPrice">'+students.order[i].productPrice+'</span></div>\
								</td>\
								<td style="width: 10%"></td>\
						  	</tr>\
						  ';
						
					}
				}
			}
		}
		

		$('#notOrder tbody').prepend(combohtml);
		$('#notOrder tbody').prepend(producthtml);
		if(orderNum == undefined){
			orderNum = 0;
		}
		if(orderPrice == undefined){
			orderPrice = 0;
		}
		//初始化html 价格 数量 
		$("#totalNum").html(students.totalNum + orderNum);
		$("#total").html(parseFloat(numAdd(students.totalPrice,orderPrice)).toFixed(2));
	}else{
		if(orderNum == undefined){
			orderNum = 0;
		}
		if(orderPrice == undefined){
			orderPrice = 0;
		}
		//创建localStorage
		var storage =   
		{  
			order:[],
			totalNum:0,
			totalPrice:0,
			allNum:orderNum,
			allPrice:orderPrice
		  
		}//要存储的JSON对象 
		storage = JSON.stringify(storage);
		localStorage.setItem(storageName,storage);
		//初始化html 价格 数量

		$("#totalNum").html(orderNum);
		$("#total").html(orderPrice);
	}
	
	/**初始化localStorage已点菜列表结束**/
	
	

    
	//加载分类列表
	$.getJSON({
		type: 'post',
		url: "../getCategoryInfoList.action",
		success: function (data) {
			console.info(data);
			var li = '<li class="selectClassify pa" onclick="getProductList(this,0)" id="0"  style="left: 0%;">全部</li><li  class="pa"  id="-1" style="left:25%;" onclick="getProductList(this,-1)" >套餐系列</li>';
			if(!$.isEmptyObject(data)){
				var m =50;
				for (var i = 0; i < data.length; i++) {
					li += '<li class="pa" style="left:'+m+'%;" id="'+data[i].categoryID+'" onclick="getProductList(this,'+data[i].categoryID+')" >'+data[i].categoryName+'</li>';
					m += 25;
				}
			}
			$("#categoryList").html(li);
		},
		error:function(xhr, status, error){layer.msg('分类列表获取失败,请联系管理员')}
	});
	  
	

    $('.editOrder').click(function(){
        return false;
    });


    


    //做法切换
    $('.methodClassify li').click(function(){
        var currentIndex=$(this).index();
        $(this).addClass('selectClassify');
        $(this).siblings('li').removeClass('selectClassify');
        $('.detailMethod').hide();
        $('.detailMethod').eq(currentIndex).show();
    });

    //编辑菜单中的暂停
    $('.suspend').click(function(){
    	if($('.currentPosition').html()){
	    	if($('.currentPosition').attr('id')){
	    		if($(this).children('i').hasClass('icon-pause')){
	    			layer.msg('请先和后台确认？', {
    				  time: 0 //不自动关闭
    				  ,btn: ['确定', '取消']
    				  ,yes: function(index){
    				    layer.close(index);
    				    //修改订单明细 制作状态为等叫
    				    updateOrderStatus(1,this);
    				  }
    				});
	            }else {
	                //修改订单明细 制作状态为制作中
	                updateOrderStatus(2,this);
	                $('.editOrder').hide();
	            }
	    		
			}else{
				layer.msg('下单的菜品才能操作');
			}
    	}else{
    		layer.msg('请选中一个菜品');
    	}
        
    })

    //做法
    $('.method').click(function(){
    	if($(this).hasClass('unClick')){
            return false;
        }
    	if($('.currentPosition').html()){
    		if($('.currentPosition').attr('id')){
        		layer.msg('未下单的菜品才能操作');
    		}else{
    			var food = $('.currentPosition').parent().attr('id');
    		
    			var vfood = food.substring(0,food.indexOf('-'));
    			if(vfood == "variant"){
    				var foodId = food.substring(food.indexOf('-')+1,food.length);
    				$.ajax({
    				 	async: false,
    					type: 'post',
    					data: {"variantID":foodId}, 
    					url: "../getProductAttributeInfo.action",
    					success: function (data) {
    						var productAttribute = $.parseJSON(data);
    						
    						
    						if(!$.isEmptyObject(productAttribute)){
    							var productAttributeHtml = '<ul class="methodClassify clearfix">';
        						var attrValueHtml = '';
        						for (var i = 0; i < productAttribute.attribute.length; i++) {
    								
    								if(i==0){
    									attrValueHtml += '<ul class="detailMethod clearfix mt10" style="display: block;">';	
    									productAttributeHtml += '<li class="selectClassify" onclick="attribute(this)">'+productAttribute.attribute[i].attributeName+'</li>';
    								}else{
    									attrValueHtml += '<ul class="detailMethod clearfix mt10">';	
    									productAttributeHtml += '<li onclick="attribute(this)">'+productAttribute.attribute[i].attributeName+'</li>';
    								}
    								if(i==productAttribute.attribute.length-1){
    									productAttributeHtml += '<li class="clickCustom" onclick="attribute(this)">自定义做法</li>';
    								}
    								
    			    				for (var y = 0; y < productAttribute.attribute[i].attributeValue.length; y++) {
    			    					attrValueHtml += '<li onclick="detailMethod(this)">'+productAttribute.attribute[i].attributeValue[y].attributeValue+'</li>';
    			    				}
    			    				attrValueHtml += '</ul>';
    							}
        						productAttributeHtml += '</ul>'+attrValueHtml+'\
    				    						<div class= "detailMethod custom mt10"  style="display: none;">\
    												<textarea rows="5" style="border: none;width: 95%;outline: none;color: #a24f9c;"></textarea>\
    											</div>\
    											<div class="clearfix pa" style="bottom: 0px;width: 90%;">\
    												<input type="button" class="btn_cancel" value="取消" style="height: 40px !important;" onclick="layerClose()">\
    												<input type="button" class="btn_confirm fR" value="确定" style="height: 40px !important;" onclick="getAttributeValue()">\
    											</div>\
        						';
        						$("#productAttribute").html(productAttributeHtml);
        						
        						$('.editOrder').hide();
        	        	        $('.targetmethod').show();
    						}else{
    							layer.msg("此菜品目前还没有做法");
    						}
    					},
    					error:function(xhr, status, error){layer.msg('error')}
    				});
    				
    			}else{
    				layer.msg("套餐不能选择做法");
    			}
    		}
    	}else{
    		layer.msg('请选中一个菜品');
    	}
        
    });

 // 赠菜lsh===================================================================
	// 打开赠菜权限页面
	var showZcPermissionDiv = function(type){
		zcQuick=type || 0;
		$("#presentLoginName").val("");
		$("#presentLoginPassword").val("");
		$('.editOrder').hide();
		$("#presentCheckPermissionDiv").hide();
		$("#presentCheckPermissionDiv2").hide();
		$(".targetgift").show();
		$("#presentLimited").show();
	}
	//打开赠菜权限验证通过页面
	var showZcDiv = function(){
		$("#presentNumber").val(1);
		$("#presentReason").val("");
		$("#presentLimited").hide();
		$('.editOrder').hide();
		$(".targetgift").show();
		$("#presentCheckPermissionDiv").show();
		$("#presentCheckPermissionDiv2").show(); 
	}
	//点击赠菜按钮
	$('.gift').click(function() {
		if ($(this).hasClass('unClick')) {
			return false;
		}
		if ($('.currentPosition').html()) {
			if ($('.currentPosition').attr('id')) {
				// 判断是否具有赠菜权限
				if (zcPermission) {
					showZcDiv();
				} else {
					showZcPermissionDiv();
				}
			} else {
				layer.msg('下单的菜品才能操作');
			}
		} else {
			layer.msg('请选中一个菜品');
		}
	});
	// 验证赠菜权限按钮
	$("#presentBtn").click(
			function() {
				var loginName = $("#presentLoginName").val();
				var password = $("#presentLoginPassword").val();
				if (!loginName) {
					showError('请输入账号');
					return;
				}
				if (!password) {
					showError('请输入密码');
					return;
				}
				checkPermissionByLoginNameAndPassword(loginName,
						password,archiveID, 'UserPrivilege:PresenteDish', function(res) {
							if (res.code == "SUCCESS") {
								// 权限验证通过 
								zcLoginID = res.loginID;
								if(zcQuick){
									presentProductClick(); 
								}else{
									showZcDiv();
								}
								
							} else {
								showTips(res.msg); 
							}
						});

			})
	// 赠菜确定按钮
	var presentProductClick= function(){
		var detailID = $('.currentPosition').attr('id');
		var presentNumber = $("#presentNumber").val();
		var presentReason = $("#presentReason").val();
		var loginID = zcLoginID || cuLoginID;
		disBtn("presentCheckOkBtn");
		$.getJSON(basePath + '/reception/presentProduct.action', {
			loginID : loginID,
			money : 100,
			detailID : detailID,
			presentNumber : presentNumber,
			presentReason : presentReason
		}, function(res) {
			enBtn("presentCheckOkBtn");
			if (res.code == "SUCCESS") {
				showTips('赠菜成功');
				zcLoginID = "";
				$(".targetgift").hide();
				loadDBproductList($('#subOrderID').val(), $('#mealsID')
						.val(), $('#tableID').val());
			} else {
				if (res.code == "1001") { 
					showConfirm(res.msg+",是否切换权限用户?",function(){
						showZcPermissionDiv(1);
					},function(){
						$(".targetgift").hide();
					});
				}else{
					showError(res.msg);
				}
			}
		});
	}
	$('.targetgift .btn_confirm').click(
			function() {
				presentProductClick();
			}
			);
	// 赠菜lsh===================================================================
    //称重
    $('.weight').click(function(){
    	if($(this).hasClass('unClick')){
            return false;
        }
     	if($('.currentPosition').html()){
	    	if($('.currentPosition').attr('id')){
	    		if($(".currentPosition").attr('needweigh')!='undefined'){
	    				$.ajax({
		    			 	async: false,
		    				type: 'post',
		    				data: {"detailID":$('.currentPosition').attr('id')}, 
		    				url: "../getOrderDetailByID.action",
		    				success: function (data) {
		    					var orderDetail = $.parseJSON(data);
		    					if(!orderDetail.floatQuantity){
		    						 $.ajax({
		    							 	async: false,
		    								type: 'post',
		    								data: {"areaID":$("#areaID").val(),"mealsID":$("#mealsID").val(),"variantID":orderDetail.variantID}, 
		    								url: "../queryWeighProcutInfoByVarianID.action",
		    								success: function (data2) {
		    									var weighProduct =$.parseJSON(data2);
		    									var barCode =  weighProduct.barCode == undefined ? 0 :weighProduct.barCode;
		    									var confirmWeigh = '\
		    		    							<div class="editTitle">称重确认</div>\
		    				    						<div class="f16 blue clearfix mt20 ml20">\
		    				    						<div class="clearfix">\
		    				    							<p style="line-height: 30px;">品码：<span class="mr30">'+barCode+'</span>单位：'+weighProduct.dictionaryName+'</p>\
		    				    							<p style="line-height: 30px;">品名：<span class="mr30">'+orderDetail.productName+'</span></p>\
		    				    							<p style="line-height: 30px;">价格：<span class="mr30">'+weighProduct.priceCopy+'</span></p>\
		    				    							<p style="line-height: 30px;" class="count">称重确认量：<input type="text" id="weighNum" onkeyup="clearNoNum(this)"  width="50%" class="number total on" value="1.00"> '+weighProduct.dictionaryName+'</p>\
		    				    							<div class="calculator mt10"></div>\
		    				    						</div>\
		    				    					</div>\
		    				    					<div class="clearfix pa" style="bottom: 0px;width: 90%;">\
		    				    						<input type="button" class="btn_cancel" value="取消" style="height: 40px !important;" onclick="layerClose()">\
		    				    						<input type="button" class="btn_confirm fR" value="确定" style="height: 40px !important;" onclick="confirmWeighProduct('+$('.currentPosition').attr('id')+',\''+weighProduct.dictionaryName+'\')">\
		    				    					</div>\
		    		    							';
		    									$("#confirmWeigh").html(confirmWeigh);
		    									$.getScript('../../statics/scripts/modules/common/calculator.js',function(){});
		    									$('.editOrder').hide();
		    			    			        $('.targetweight').show();
		    								},
		    								error:function(xhr, status, error){layer.msg('error')}
		    						});
		    						
		    						
		    						
		    					}else{
		    						layer.msg('此菜品已经称重了');
		    					}
		    				},
		    				error:function(xhr, status, error){layer.msg('error')}
		    		  });
	    		}else{
	    			layer.msg('此菜品不能进行称重');
	    		}
			}else{
				layer.msg('下单的菜品才能操作');
			}
    	}else{
    		layer.msg('请选中一个菜品');
    	}
    	
    	
        
    });

    //口味选择
    $('.detailMethod li').click(function(){
    	if($(this).hasClass('unClick')){
            return false;
        }
        $(this).siblings('li').removeClass('detailSelected');
        $(this).addClass('detailSelected');

    })
    //删除菜
    $('.editOrder .delete').click(function(){
    	if($(this).hasClass('unClick')){
            return false;
        }
    	if($('.currentPosition').html()){
        	if($('.currentPosition').attr('id')){
        		layer.msg('未下单的菜品才能操作');
    		}else{
    			layer.msg('确定要删除此菜品吗？', {
		  		  time: 0 //不自动关闭
		  		  ,btn: ['确定', '取消']
		  		  ,yes: function(index){
		  		    layer.close(index);
		  		    var loadId = $('.currentPosition').parent().attr('id');
                  	var id = loadId.substring(loadId.indexOf('-')+1,loadId.length);
                  	var name = loadId.substring(0,loadId.indexOf('-'));
          			if(localStorage.getItem(storageName)){
          				var students = localStorage.getItem(storageName);
          				students = JSON.parse(students);//把字符串转换成JSON对象 
          				for(var i = 0;i<students.order.length;i++){
          					if(name == "variant"){
          					
          						if(students.order[i].variantID == id ){
              						students.totalNum -= students.order[i].productNum;
              						students.allNum -= students.order[i].productNum;
              						$("#totalNum").html(parseInt($("#totalNum").html()) - students.order[i].productNum);
              						//如果是称重菜不删除价格
              						
              						if(students.order[i].needWeigh == false){
              							students.totalPrice = parseFloat(numSub(students.totalPrice, numAdd(students.order[i].totalAmount,students.order[i].maketotalPrice))).toFixed(2);
                  						students.allPrice = parseFloat(numSub(students.allPrice, numAdd(students.order[i].totalAmount,students.order[i].maketotalPrice))).toFixed(2);
                  						$("#total").html(parseFloat(numSub($("#total").html(), numAdd(students.order[i].totalAmount,students.order[i].maketotalPrice))).toFixed(2));
              						}
              						students.order.splice(i,1);
              						currentDelete.remove();
              					}
          					}else if(name == "product"){
          						if(students.order[i].comboID == id ){
              						students.totalNum -= students.order[i].productNum;
              						students.allNum -= students.order[i].productNum;
              						$("#totalNum").html(parseInt($("#totalNum").html()) - students.order[i].productNum);
              						
              						students.totalPrice = parseFloat(numSub(students.totalPrice, numAdd(students.order[i].totalAmount,students.order[i].maketotalPrice))).toFixed(2);
              						students.allPrice = parseFloat(numSub(students.allPrice, numAdd(students.order[i].totalAmount,students.order[i].maketotalPrice))).toFixed(2);
              						$("#total").html(parseFloat(numSub($("#total").html(), numAdd(students.order[i].totalAmount,students.order[i].maketotalPrice))).toFixed(2));
              						students.order.splice(i,1);
              						currentDelete.remove();
              					}
          					}
          					
          				}
          				students = JSON.stringify(students);
          				localStorage.setItem(storageName,students);
          			 }
    		  		}
		  		});
    			
        		
    		}
    	}else{
    		layer.msg('请选中一个菜品');
    	}

    	
    })
    
    //点击催菜
    $(".urge").click(function(){
    	if($(this).hasClass('unClick')){
            return false;
        }
    	if($('.currentPosition').html()){
	    	if($('.currentPosition').attr('id')){
	    		 $.ajax({
	    			 	async: false,
	    				type: 'post',
	    				data: {"detailID":$('.currentPosition').attr('id'),"smsContent":$('.currentPosition').next().html()}, 
	    				url: "../sendReminder.action",
	    				success: function (data) {
	    					layer.open({
	    		                type: 1,
	    		                title: false,
	    		                area: ['370px', '450px'],
	    		                time:3000,
	    		                closeBtn: 0,
	    		                scrollbar: false,
	    		                content: $('.targeturge')
	    		            });
	    					loadDBproductList($('#subOrderID').val(),$('#mealsID').val(),$('#tableID').val());
	    					 $('.editOrder').hide();
	    				},
	    				error:function(xhr, status, error){layer.msg('error')}
	    		  });
			}else{
				layer.msg('下单的菜品才能操作');
			}
    	}else{
    		layer.msg('请选中一个菜品');
    	}
        
    });


    //点击确定追加选中的口味
    $('.targetmethod .btn_confirm').click(function(){
        var selected=$('.detailMethod .detailSelected');
        var selectedAll=[];
        var textareaText=$('.custom').children('textarea').val();
        for(var i=0;i<selected.length;i++){
            selectedAll+=selected.eq(i).text()+', ';
        }
        currentAppend.append('<div class="tasteAppend">'+'<i class="taste">口味</i>' +selectedAll+textareaText+'</div>');
        $('.custom').children('textarea').val('');
        currentAppend='';
        $('.targetmethod ').hide();
    })

    
        //退菜
    $('.return').click(function(){
    	if($(this).hasClass('unClick')){
            return false;
        }
    	if($('.currentPosition').html()){
	    	if($('.currentPosition').attr('id')){
	    		
	    		
	    		
	            var vreturnTotal = parseInt( $('.currentPosition').parent().next().children('div:eq(0)').html());//退菜里面的数量
	            var returnNumDiv =  $('.currentPosition').parent().next().children('div.returnNum');
	            var returnTotalNum = 0;
	            for (var i = 0; i < returnNumDiv.length; i++) {
	            	returnTotalNum += parseInt($(returnNumDiv).eq(i).html());
	            }
	            returnTotalNum = 0-returnTotalNum;
	            returnTotalNum += 1;
	            $("#surplusNum").html(vreturnTotal - returnTotalNum);
	            
	            
	            $("#returnNumber").val(1);
	            $("#returnReson").val("");	
	    		$('input:radio:checked').removeAttr("checked");
	    		
	            /**
	             * 权限判断 
	             * true表示当前登录用户有退菜权限 直接退菜即可
	             * false表示当前登录用户没有退菜权限 需登录别的账号
	             */
	            if(tcPermission){	
	            	$('.editOrder').hide();
	            	$("#tcBigDiv").show();
	            	$("#tcNoPermissionDiv").hide();
	            	$("#tcCheckPermissionDivBtn").show();
	            	$('#tcCheckPermissionDiv').show();
	    		}else{
	    			$('.editOrder').hide();
			        $("#tcBigDiv").show();
	            	$("#tcNoPermissionDiv").show();
	             	$("#tcCheckPermissionDivBtn").hide();
	            	$('#tcCheckPermissionDiv').hide();
	    		}
			}else{
				layer.msg('下单的菜品才能操作');
			}
    	}else{
    		layer.msg('请选中一个菜品');
    	}
    	
    });
    
        // 退菜权限验证  
    $('#returnNextStep').click(function () {
        var userName=$('#tcName').val();
        var userPassword=$('#tcPassword').val();
        if(!userName || userName == "") {
            layer.msg('账号不能为空');
            return;
        }
        if(!userPassword || userPassword == "") {
            layer.msg('密码不能为空');
            return;
        }else {
        	checkPermissionByLoginNameAndPassword(userName,userPassword,archiveID,'UserPrivilege:Retreatfood',function(res){
        		if(res.code=="SUCCESS"){
        			tcPermission = true;
        			$("#tcBigDiv").show();
	            	$("#tcNoPermissionDiv").hide();
	            	$('.editOrder').hide();
	            	$("#tcCheckPermissionDivBtn").show();
	            	$('#tcCheckPermissionDiv').show();
        		}else{
        			layer.msg(res.msg);
        		}
        	})
          
        }

    });
    

    //点击退菜确定追加退菜理由
    $('.targetreturn .btn_confirm').click(function(){
    	
    	if(!checkReturnProductNum()){
    		return false;
    	}
    	$('.currentPosition').attr("name")
		var selected=$(this).parent().siblings().children('.textarea').val();
		var selectedInput = $('input:radio:checked');
		var radioText=selectedInput.next('span').text();
		var returnNum =parseInt($(this).parent().prev().children().children('div:eq(0)').children('input').val());//编辑里面的数量
		var productName = $('.currentPosition').next().html();
		var vreturnTotal = parseInt( $('.currentPosition').parent().next().children('div:eq(0)').html());//列表选中的数量
	    $.ajax({
			 	async: false,
				type: 'post',
				data: {"detailID":$('.currentPosition').attr('id')}, 
				url: "../getOrderDetailByID.action",
				success: function (data) {
					var orderDetail = $.parseJSON(data);
					var tag = 0;
					if(orderDetail.needWeigh == 1){
						//称重菜
						if(orderDetail.floatQuantity != undefined){
							if(returnNum != vreturnTotal){
								layer.msg('已经称重的菜品退菜必须全退'); 
								return false;
							}
						}
					}
					
					
					$.getJSON({
					 	async: false,
						type: 'post',
						data: {"detailID":$('.currentPosition').attr('id'),"productMum":returnNum,"reason":selected+' '+radioText}, 
						url: "../returnProduct.action",
						success: function (o) {
							loadDBproductList($('#subOrderID').val(),$('#mealsID').val(),$('#tableID').val());
							if(o > 0){
								layer.msg("成功");
							}else if(o == -1){
								layer.msg('退菜失败');
							}else if(o == -2){
								layer.msg("打印失败");
							}
						},
						error:function(xhr, status, error){
							layer.msg('退菜失败'); 
						}
				    });
					
					$('.targetreturn ').hide();
				}
	    });
    });






    $(document).click(function(){
        $('.editOrder').hide();
        $('.keyboard').hide();
    })


     //右边菜品块的高度自适应
    var liWidth=$('.orderName_ul li').width();
    var liHeight=liWidth/2;
    $('.orderRightCenter ul li').css('height',liHeight);
    var PriceHeight=$('.orderNamePrice').height()+'px';
    $('.orderNamePrice').css('line-height',PriceHeight);


    //一品多菜弹窗
    $('.multiple li').click(function(){
        layer.open({
            type: 1,
            title: false,
            area: ['50%', '70%'],
            closeBtn: 0,
            scrollbar: false,
            content: $('.popup_multiple')
        });
    });
    //点击弹出编辑中的加和减
    $('.minus').click(function(){
    	if($('.currentPosition').html()){
	    	if($('.currentPosition').attr('id')){
		        layer.msg('未下单的菜品才能操作');
			}else{
				if($(this).next().val() > 1){
					minusNum(this);
					var cur_num=$(this).next().val();
					updatelocalStorageDateNum(1,cur_num);
			        var newTotal=$('.currentPosition').parent().next().find('.total');
			        newTotal.text(cur_num);
				}else{
					layer.msg('数量必须大于1才能减');
				}
			}
    	}else{
    		layer.msg('请选中一个菜品');
    	}
       
    });
    $('.add').click(function(){
    	if($('.currentPosition').html()){
	    	if($('.currentPosition').attr('id')){
		        layer.msg('未下单的菜品才能操作');
			}else{
		        addNum(this);
		        var cur_num=$(this).prev().val();
		        var newTotal=$('.currentPosition').parent().next().find('.total');
		        newTotal.text(cur_num);
		        updatelocalStorageDateNum(2,cur_num);
			}
    	}else{
    		layer.msg('请选中一个菜品');
    	}
    })

    
    
  //全部分类的菜品数据
    loadProductList();
    $('.heightScroll').mCustomScrollbar();
    $('.productList').mCustomScrollbar();
})
//操作localStoage 修改数量
function updatelocalStorageDateNum(type,num){
	if($('.currentPosition').html()){
		if($('.currentPosition').attr('id')){
    		layer.msg('未下单的菜品才能操作');
		}else{
			var food = $('.currentPosition').parent().attr('id');
			var vfood = food.substring(0,food.indexOf('-'));
			var id =  food.substring(food.indexOf('-')+1,food.length);
			var storage = localStorage.getItem(storageName);
			storage = JSON.parse(storage);//把字符串转换成JSON对象 
			if(vfood == "variant"){
				for(var i = 0;i<storage.order.length;i++){
					if(storage.order[i].variantID == id){
						storage.order[i].productNum = parseInt(num);
						storage.order[i].totalAmount = num * storage.order[i].productPrice;
						storage.order[i].maketotalPrice = num * storage.order[i].makePrice;
						if(type == 1){
							storage.allNum -= 1;
							storage.totalNum -= 1;
							if(!storage.order[i].needWeigh){
								storage.totalPrice = parseFloat(numSub(storage.totalPrice, numAdd(storage.order[i].productPrice,storage.order[i].makePrice))).toFixed(2);
								storage.allPrice = parseFloat(numSub(storage.allPrice, numAdd(storage.order[i].productPrice,storage.order[i].makePrice))).toFixed(2);
							}
							
						}else{
							storage.allNum += 1;
							storage.totalNum += 1;
							if(!storage.order[i].needWeigh){
								storage.totalPrice = parseFloat(numAdd(storage.totalPrice, numAdd(storage.order[i].productPrice,storage.order[i].makePrice))).toFixed(2);
								storage.allPrice = parseFloat(numAdd(storage.allPrice, numAdd(storage.order[i].productPrice,storage.order[i].makePrice))).toFixed(2);
							}
						}
					}
				}
			}else{
				for(var i = 0;i<storage.order.length;i++){
					if(storage.order[i].comboID == id){
						storage.order[i].productNum = parseInt(num);
						storage.order[i].totalAmount = num * storage.order[i].comboPrice;
						storage.order[i].maketotalPrice = num * storage.order[i].makePrice;
						if(type == 1){
							storage.allNum -= 1;
							storage.totalNum -= 1;
							if(!storage.order[i].needWeigh){
								storage.totalPrice = parseFloat(numSub(storage.totalPrice, numAdd(storage.order[i].comboPrice,storage.order[i].makePrice))).toFixed(2);
								storage.allPrice = parseFloat(numSub(storage.allPrice, numAdd(storage.order[i].comboPrice,storage.order[i].makePrice))).toFixed(2);
							}
						}else{
							storage.allNum += 1;
							storage.totalNum += 1;
							if(!storage.order[i].needWeigh){
								storage.totalPrice = parseFloat(numAdd(storage.totalPrice, numAdd(storage.order[i].comboPrice,storage.order[i].makePrice))).toFixed(2);
								storage.allPrice = parseFloat(numAdd(storage.allPrice, numAdd(storage.order[i].comboPrice,storage.order[i].makePrice))).toFixed(2);
							}
						}
					}
				}
			}
			var div = $("#product-"+id).next().children('div');
			for(var y = 0;y<div.length;y++){
				$(div[y]).html(parseInt(num));					
			}
			$("#totalNum").html(storage.allNum);
			$("#total").html(parseFloat(storage.allPrice).toFixed(2));
			storage = JSON.stringify(storage);
			localStorage.setItem(storageName,storage);
		}
	}else{
		layer.msg('请选中一个菜品');
	}
}


function updateOrderStatus(status,_this){
	var detailID = 0;
	if($('.blueCircle_12_selected').attr('id')){
		detailID = $('.blueCircle_12_selected').attr('id');
		
		// status = 1 表示把制作状态改为等叫   2 表示把制作状态改为制作中
		$.ajax({
		 	async: true,
			type: 'post',
			data: {"recordID":detailID,"status":status}, 
			url: "../updateComboDetaStatus.action",
			success: function (data) {
				if($.parseJSON(data).result == 1){
					if($(_this).children('i').hasClass('icon-pause')){
		                $(_this).children('i').removeClass('icon-pause');
		                $(_this).children('i').addClass('icon-bofang');
		                $(_this).children('.fnName').text('叫起');
		            }else {
		                $(_this).children('i').addClass('icon-pause');
		                $(_this).children('i').removeClass('icon-bofang');
		                $(_this).children('.fnName').text('等叫');
		            }
					layer.msg("成功");
					loadDBproductList($('#subOrderID').val(),$('#mealsID').val(),$('#tableID').val());
				}else{
					layer.msg("失败");
				}
			},
			error:function(xhr, status, error){layer.msg('失败,请联系管理员')}
		});
	}else{
		detailID = $('.currentPosition').attr('id');
		
		// status = 1 表示把制作状态改为等叫   2 表示把制作状态改为制作中
		$.ajax({
		 	async: true,
			type: 'post',
			data: {"detailID":detailID,"status":status}, 
			url: "../updateOrderStatus.action",
			success: function (data) {
				if($.parseJSON(data).result == 1){
					if($(_this).children('i').hasClass('icon-pause')){
		                $(_this).children('i').removeClass('icon-pause');
		                $(_this).children('i').addClass('icon-bofang');
		                $(_this).children('.fnName').text('叫起');
		            }else {
		                $(_this).children('i').addClass('icon-pause');
		                $(_this).children('i').removeClass('icon-bofang');
		                $(_this).children('.fnName').text('等叫');
		            }
					layer.msg("成功");
					loadDBproductList($('#subOrderID').val(),$('#mealsID').val(),$('#tableID').val());
				}else{
					layer.msg("失败");
				}
			},
			error:function(xhr, status, error){layer.msg('失败,请联系管理员')}
		});
	}
	
	

}

function addNum(e){
    var curNum=parseInt($(e).siblings('input').val());
    curNum+=1;
    $(e).siblings('input').val(curNum);
};

function addNumVPresent(e){
    var curNum=parseInt($(e).siblings('input').val());
    curNum+=1;
    var checkInNum = $("#alreadyOrder i.currentPosition").attr('quantity');
    if(checkInNum && curNum<=(checkInNum-0)){
    	$(e).siblings('input').val(curNum);
    }
};


function minusNum(e){
    var curNum=parseInt($(e).siblings('input').val());
    curNum-=1;
    if(curNum<1){
    	curNum=1;
    }
    $(e).siblings('input').val(curNum);
}

function minusNumVPresent(e){
    var curNum=parseInt($(e).siblings('input').val());
    curNum-=1;
    if(curNum>0){
    	$(e).siblings('input').val(curNum); 
    }
}

function returnProductMinsNum(e){
	var curNum=parseInt($(e).siblings('input').val());
	if(curNum<2){
		return false;
	}
    curNum-=1;
    $(e).siblings('input').val(curNum);
}
function addreturnProductNum(e){
	
	var returnNumDiv =  $('.currentPosition').parent().next().children('div.returnNum');
	var returnTotalNum = 0;
    for (var i = 0; i < returnNumDiv.length; i++) {
    	returnTotalNum += parseInt($(returnNumDiv).eq(i).html());
    }
    returnTotalNum = 0-returnTotalNum;
	
	var vreturnTotal = parseInt( $('.currentPosition').parent().next().children('div:eq(0)').html());//列表选中的数量
	vreturnTotal -= returnTotalNum;
	var curNum=parseInt($(e).siblings('input').val());
    if(curNum >= vreturnTotal){
    	layer.msg("退菜数不能超过点菜数量");
    	return false;
    }
    curNum+=1;
    $(e).siblings('input').val(curNum);
}

function checkReturnProductNum(){
	var vreturnTotal = parseInt( $('.currentPosition').parent().next().children('div:eq(0)').html());//列表选中的数量
	var num = $("#returnNumber").val();
	if(num == 0){
		layer.msg("退菜数不能为0");
		return false;
	}
	if(num > vreturnTotal){
		layer.msg("退菜数不能超过点菜数量");
		$("#returnNumber").val(1);
		return false;
	}else{
		return true;
	}
}


//显示菜单编辑功能
function currentChose(e){
	if($(e).parents().hasClass('notOut')){
        $('.editOrder').children('.return,.suspend,.weight,.gift,.urge').hide();
        $('.editOrder').children('.delete,.method').show();
    }else {
        $('.editOrder').children('.return,.suspend,.weight,.gift,.urge').show();
        $('.editOrder').children('.delete,.method').hide();

        //出单的整个套餐点击无叫起等叫
        if($(e).hasClass('setMealOrder')){
    		$('.editOrder').children('.suspend').hide();
    	}
    }
    currentDelete=$(e).parents('.orderTable').find('tr').eq($(e).index());
    currentAppend=$(e).parents('.orderTable').find('tr').eq($(e).index()).children('td').eq(0);
    
    recordNumTd=$(e).parents('.orderTable').find('tr').eq($(e).index()).children('td').eq(1);
    
    currentPrice=$(e).parents('.orderTable').find('tr').eq($(e).index()).children('td').eq(2).find('.currentPrice').text();
    currentAppend2=$(e).parents('.orderTable').find('tr').eq($(e).index()).children('td').eq(2);

    $('.currentPosition').text('');
    $('.currentPosition').removeClass('currentPosition');
    
    currentAppend.children('i').addClass('currentPosition');
    currentAppend.children('i').text('√');
    $('.editOrder').show();
    $('.editOrder .count').children('input').val(parseInt($('.currentPosition').parent().next().children('.total').text()));
    stopEvent();
}


//        获取事件
function getEvent(){
    if(window.event)    {return window.event;}
    func=getEvent.caller;
    while(func!=null){
        var arg0=func.arguments[0];
        if(arg0){
            if((arg0.constructor==Event || arg0.constructor ==MouseEvent
                || arg0.constructor==KeyboardEvent)
                ||(typeof(arg0)=="object" && arg0.preventDefault
                && arg0.stopPropagation)){
                return arg0;
            }
        }
        func=func.caller;
    }
    return null;
}

function stopEvent(){ //阻止冒泡事件
    var e=getEvent();
    if(window.event){
        //e.returnValue=false;//阻止自身行为
        e.cancelBubble=true;//阻止冒泡
    }else if(e.preventDefault){
        //e.preventDefault();//阻止自身行为
        e.stopPropagation();//阻止冒泡
    }
}

//键盘块
var chtml=  '<li>1</li>' +
    '<li>2</li>' +
    '<li>3</li>' +
    '<li>4</li>' +
    '<li>5</li>' +
    '<li>6</li>' +
    '<li>7</li>' +
    '<li>8</li>' +
    '<li>9</li>' +
    '<li>0</li>' +
    '<li>Q</li>' +
    '<li>W</li>' +
    '<li>E</li>' +
    '<li>R</li>' +
    '<li>T</li>' +
    '<li>Y</li>' +
    '<li>U</li>' +
    '<li>I</li>' +
    '<li>O</li>' +
    '<li>P</li>' +
    '<li>A</li>' +
    '<li>S</li>' +
    '<li>D</li>' +
    '<li>F</li>' +
    '<li>G</li>' +
    '<li>H</li>' +
    '<li>J</li>' +
    '<li>K</li>' +
    '<li>L</li>' +
    '<li class="keySearch" style="position: absolute;right: -4px;top: 0;box-sizing: border-box;padding-top: 20px;">搜<br>索</li>' +
    '<li style="clear: both;">Z</li>' +
    '<li>X</li>' +
    '<li>C</li>' +
    '<li>V</li>' +
    '<li>B</li>' +
    '<li>N</li>' +
    '<li>M</li>' +
    '<li class="keyBack">退 格</li>';
$('.keyboard').append(chtml);
keyHeight();
function keyboard(){
    var keyboardW=$('.keyboard li').eq(0).width();
    $('.keyboard li').css('height',keyboardW);
    $('.keyboard li').css('line-height',keyboardW+'px');
    $('.keySearch').css('height',keyboardW*2+5+'px');
    $('.keySearch').css('line-height','25px');
    $('.keySearch').css('top',keyboardW*2+20+'px');
    $('.keyBack').css('width',keyboardW*2+5+'px')
}

//键盘的高度与宽度相等&&键盘设置&&获取焦点弹出键盘
function keyHeight(){
    var searchInput=$('.orderRightBottom .search input');
    var searchInputV=$('.orderRightBottom .search input').val();
    searchInput.focus(function(){
        $('.keyboard').show();
        keyboard()
    });
    $('.orderRightBottom').click(function(){
        return false;
    });
    $('.keyboard li').not($('.keyBack,.keySearch')).click(function(){
        var getText=$(this).text();
        searchInputV+=getText;
        $('.orderRightBottom .search input').val(searchInputV);
    })
    $('.keyBack').click(function(){
       var newV= searchInputV.substr(0,searchInputV.length-1);
        searchInputV=newV;
        $('.orderRightBottom .search input').val(newV)
    })
    //搜索中的叉
    $('.search .icon-cuowu').click(function(){
        keyHeight();
        $(this).next().val('');
        loadProductList();
    })


}

function attribute(_this){
	 var currentIndex=$(_this).index();
     $(_this).addClass('selectClassify');
     $(_this).siblings('li').removeClass('selectClassify');
     $('.detailMethod').hide();
     $('.detailMethod').eq(currentIndex).show();
}

function detailMethod(_this){
	 $(_this).siblings('li').removeClass('detailSelected');
     $(_this).addClass('detailSelected');

}

/**
 * 关闭窗口
 */
function layerClose(){
	$('.targetmethod ').hide();
	$('.targetweight ').hide();
}

/**
 * 得到属性值
 */
function getAttributeValue(){
	 var selected=$('.detailMethod .detailSelected');
	 var selectedAll=[];
	 var textareaText=$('.custom').children('textarea').val();
	 for(var i=0;i<selected.length;i++){
	     selectedAll+=selected.eq(i).text()+' ';
	 }
	 if(currentAppend.children('.tasteAppend').text()){//当原来存在的情况下
         currentAppend.children('.tasteAppend').text('');
    	 currentAppend.append('<div class="tasteAppend">'+'<i class="taste">口味</i>' +selectedAll+textareaText+'</div>');
     }else {
    	 currentAppend.append('<div class="tasteAppend">'+'<i class="taste">口味</i>' +selectedAll+textareaText+'</div>');
     }
	 $('.custom').children('textarea').val('');
	 currentAppend='';
	 $('.targetmethod ').hide();
	 
	 
    var variant = $('.currentPosition').parent().attr('id');
    var variantID = variant.substring(variant.indexOf("-")+1,variant.length);
    var storage = localStorage.getItem(storageName);
    storage = JSON.parse(storage);//把字符串转换成JSON对象
	for (var i = 0; i < storage.order.length; i++) {
		if(storage.order[i].variantID == variantID){
			storage.order[i].practice = selectedAll+textareaText;
		}
	}
	storage = JSON.stringify(storage);
	localStorage.setItem(storageName,storage);
//     currentAppend='';
//     currentAppend2='';
}

/**
 * 确认称重菜品
 */
function confirmWeighProduct(orderDetail,unit){
	var num = $("#weighNum").val();
	
	if(isNaN(num)){
		layer.msg('请输入数字');
		return false;
	}else{
		if(num <= 0){
			layer.msg('请输入大于0的数字');
			return false;
		}else{
			num = parseFloat(num);
		}
	}
	return;
	 $.ajax({
		 	async: false,
			type: 'post',
			data: {"detailID":orderDetail,"num":num,"unit":unit}, 
			url: "../confirmWeighProduct.action",
			success: function (data) {
				var returnPrice = JSON.parse(data).result-0;
				if(returnPrice > 0){
					$("#total").html(returnPrice.toFixed(2));
					layer.msg('称重成功');
				}else{
					layer.msg('称重失败,请联系管理员');
				}
				$('.targetweight ').hide();
			},
			error:function(xhr, status, error){layer.msg('称重内部错误')}
		});
}

//   打印台单   胡涛
function printReceipt(){
	if($("#subOrderID").val()=="") {
		layer.msg("请先点菜");
	}
	$.ajax({
	 	async: false,
		type: 'post',
		data: {
				"subOrderID":$("#subOrderID").val()
			  }, 
		url: "../print/Receipt.action",
		success: function (data) {
			if(data > 0){
				layer.msg("打印成功");
			}else {
				layer.msg('打印失败');
			}
		},
		error:function(){
			layer.msg('打印失败')
			}
	});	
}


//下单
function addOrder(mark){
	if(localStorage.getItem(storageName)){
		localStorage.getItem(storageName)
		var storagel =  localStorage.getItem(storageName);
		storagel = JSON.parse(storagel);//把字符串转换成JSON对象
		if(storagel.order.length > 0){
			var i = layer.load(0, {shade: 0.2,offset : ['380px' , '15%']}); 
			$.ajax({
			 	async: false,
				type: 'post',
				data: {
						"productResult":localStorage.getItem(storageName),
						"areaID":$("#areaID").val(),
						"mealsID":$("#mealsID").val(),
						"peopleNum":$("#peopleNum").val(),
						"tableID":$("#tableID").val(),
						"orderID":$("#orderID").val(),
						"subOrderID":$("#subOrderID").val(),
						"produceStatus":mark
					  }, 
				url: "../addOrder.action",
				success: function (data) {
					hideLoad(i);
					if(data > 0){
						layer.msg("成功");
					}else if(data == -1){
						layer.msg('下单失败');
						return false;
					}else if(data == -2){
						localStorage.removeItem(storageName);
						layer.msg("打印失败");
						loadDBproductList($("#subOrderID").val(),$("#mealsID").val(),$("#tableID").val());
						$("#notOrder tbody").html("");
						return false;
					}
					localStorage.removeItem(storageName);
					loadDBproductList(data,$("#mealsID").val(),$("#tableID").val());
					$('#notOrder tbody').html('');
					$('#subOrderID').attr("value",data);
				},
				error:function(xhr, status, error){layer.msg('下单错误')}
			});
		}else{
			layer.msg("请先点菜");
		}
	}else{
		layer.msg("请先点菜");
	}
}


//添加菜品到列表
function addProducts(_this,type,id,vid,name,produceCost,areaID,mealsID,needWeigh){
	needWeigh = needWeigh || false;
	if(produceCost==undefined){
		produceCost = 0;
	}
    if(areaID==undefined){
        areaID = 0;
    }
	var orderName=$(_this).children('.orderName').children('span:eq(0)').text();
 	var orderNamePrice=$(_this).children('.orderNamePrice').text() == '￥undefined' ? 0: $(_this).children('.orderNamePrice').text();;//价格
	var price = orderNamePrice.substring(1,orderNamePrice.length);
	price -= 0; 
//    orderName=orderName.match(/[\u4e00-\u9fa5]/g);//只取汉字部分
    var result=orderName;//菜名
	if(type == 3){  //类型为一品多菜
		$.ajax({
		 	async: false,
			type: 'post',
			data: {"productID":id,"areaID":$("#areaID").val(),"mealsID":$("#mealsID").val()}, 
			url: "../getMenuProductVarianList.action",
			success: function (data) {
				var html = '<div class="popup_multiple_title f16 blue">'+name+'</div><div class="popup_multiple_content"><ul class="liStyle clearfix">';
				for (var i = 0; i < $.parseJSON(data).productVariantMsg.length; i++) {
					var productVariantInfo = $.parseJSON(data).productVariantMsg[i];
					var productVariantPrice = productVariantInfo.price == undefined ? 0 : productVariantInfo.price;
					html += '\
								<li onclick ="addProducts(this,2,'+productVariantInfo.variantID+',1,'+productVariantInfo.produceCost+')">\
									<p class="orderID" style="display:none;">'+productVariantInfo.variantID+'</p>\
									<p class="orderName"><span>'+productVariantInfo.variantName+'</span><br><span>100121</span></p>\
									<p class="orderNamePrice">￥'+productVariantPrice+'</p>\
								</li>\
							';
				}
				html += '\
						</ul></div><div class="popup_multiple_btn">\
								<div class="clearfix pa" style="bottom: 10px;width: 100%;text-align: center;">\
								<input type="button" class="btn_cancel mr20" value="取消" style="height: 40px !important;" onclick="layer.closeAll()">\
								<input type="button" class="btn_confirm" value="确定" style="height: 40px !important;" onclick="layer.closeAll()">\
							</div>\
						</div>\
						';
				$("#popup_multiple").html(html);
				var liWidth=$('.productList li').width();
			    var liHeight=liWidth/2;
				$('.orderRightCenter ul li').css('height',liHeight);
			},
			error:function(xhr, status, error){layer.msg('error')}
		});
		layer.open({
	        type: 1,
	        title: false,
	        area: ['50%', '70%'],
	        closeBtn: 0,
	        scrollbar: false,
	        content: $('.popup_multiple')
	    });
	}else if(type == 2){  //类型为一品一菜
		var variantID = vid;
		var students ={};
		var flag = 0;
		var html = '';
		if(localStorage.getItem(storageName)){
			students = localStorage.getItem(storageName);
			students = JSON.parse(students);//把字符串转换成JSON对象
			for(var i = 0;i<students.order.length;i++){
				//如果localStorage 中存在variantID
				if(variantID == students.order[i].variantID){
					//存在则加数量
					students.order[i].productNum += 1;
					students.order[i].totalAmount = students.order[i].productPrice * students.order[i].productNum;
					students.order[i].maketotalPrice = students.order[i].makePrice * students.order[i].productNum;
					
					//改变已存在的html数量
					var htmlNum = $("#variant-"+variantID).next().children('div:eq(0)').html();
					$("#variant-"+variantID).next().children('div:eq(0)').html(parseInt(htmlNum)+1);
					
					students.totalNum += 1;
					students.allNum += 1; 
					$("#totalNum").html(parseInt($("#totalNum").text())+1);
					//称重菜不计算价格
					if(needWeigh == false){
						students.totalPrice = parseFloat(numAdd(students.totalPrice,numAdd(students.order[i].productPrice,students.order[i].makePrice))).toFixed(2);
						students.allPrice = parseFloat(numAdd(students.allPrice,numAdd(students.order[i].productPrice,students.order[i].makePrice))).toFixed(2);
						$("#total").html(parseFloat(numAdd($("#total").text(),numAdd(students.order[i].productPrice,students.order[i].makePrice))).toFixed(2));
					}
					flag = 1;
				}
			}
			if(flag == 0){
				var pepole= {
								productName:result,productPrice:price,totalAmount:price,productNum:1,
								variantID:variantID,type:productType, comboID:"",comboName:"",
								comboPrice:0.0,practice:"",makePrice:produceCost,maketotalPrice:produceCost,
								areaID:areaID,mealsID:mealsID,needWeigh:needWeigh};
				students.order.push(pepole);
				
				students.totalNum += 1;
				students.allNum += 1; 
				$("#totalNum").html(parseInt($("#totalNum").text())+1);
				//称重菜不计算价格
				if(needWeigh == false){
					students.totalPrice = parseFloat(numAdd(students.totalPrice,numAdd(price,produceCost))).toFixed(2);
					students.allPrice = parseFloat(numAdd(students.allPrice,numAdd(price,produceCost))).toFixed(2);
					$("#total").html(parseFloat(numAdd($("#total").text(),numAdd(price,produceCost))).toFixed(2));
				}
				html = '\
					<tr onclick="clickOrder(this,0);">\
						<td style="width: 50%" id="variant-'+variantID+'">\
							<i class="blueCircle_15"></i>'+result+'\
						</td>\
						<td style="width: 15%"><div class="total">1</div></td>\
						<td style="width: 25%" class="price">\
							<div>￥'+price+'</div>\
						</td>\
						<td style="width: 10%"></td>\
				  	</tr>\
				  ';
				$('#notOrder tbody').prepend(html);
			}
		}else{
			var newprice = price;
			if(orderPrice > 0){
				newprice = orderPrice+price;
			}
			
			//创建localStorage
			students =   {  
							order:[
							       {	
							    	   	productName:result,productPrice:price,totalAmount:price,productNum:1,
										variantID:variantID,type:productType, comboID:"",comboName:"",
										comboPrice:0.0,practice:"",makePrice:produceCost,maketotalPrice:produceCost,
										areaID:areaID,mealsID:mealsID,needWeigh:needWeigh
							       }
							      ],
							totalNum:1,
							totalPrice:parseFloat(numAdd(price,produceCost)).toFixed(2),
							allNum:orderNum+1,
							allPrice:parseFloat(numAdd(newprice,produceCost)).toFixed(2)
						  
						}//要存储的JSON对象 
			html = '\
				<tr onclick="clickOrder(this,0);">\
					<td style="width: 50%" id="variant-'+variantID+'">\
						<i class="blueCircle_15"></i>'+result+'\
					</td>\
					<td style="width: 25%"><div class="total">1</div></td>\
					<td style="width: 15%" class="price">\
						<div>￥'+price+'</div>\
					</td>\
					<td style="width: 10%"></td>\
			  	</tr>\
			  ';
			$('#notOrder tbody').prepend(html);
			
			$("#totalNum").html($("#totalNum").text()-0+1);
			$("#total").html(parseFloat(numAdd($("#total").text(),numAdd(price,produceCost))).toFixed(2));
			
			//称重菜不计算价格
			if(needWeigh == true){
				students.totalPrice = parseFloat(numSub(students.totalPrice,numAdd(price,produceCost))).toFixed(2);
				students.allPrice = parseFloat(numSub(students.allPrice,numAdd(price,produceCost))).toFixed(2);
				$("#total").html(parseFloat(numSub($("#total").text(),numAdd(price,produceCost))).toFixed(2));
			}
		}
		students = JSON.stringify(students);
		localStorage.setItem(storageName,students);
		
		
		
	}else{ //套餐
	    $.ajax({
		 	async: false,
			type: 'post',
			data: {"productID":id}, 
			url: "../getProductVarianList.action",
			success: function (data) {
				var productVariant = $.parseJSON(data).productVariantMsg;
				var html= '\
							<tr class="setMealOrder" onclick="clickOrder(this,0);">\
							<td  style="width: 50%" id="product-'+id+'" >\
								<i class="blueCircle_15"></i>\
								<p class="fL">'+result+'</p>\
								<div class="greenCircle">套</div>\
							';
				var varianHtml = '';
				var varianPriceHtml = '';
				var students ={};
				var flag = 0;
				if(localStorage.getItem(storageName)){
					students = localStorage.getItem(storageName);
					students = JSON.parse(students);//把字符串转换成JSON对象
					
					for(var i = 0;i<students.order.length;i++){
						//如果localStorage 中存在comboID
						if(id == students.order[i].comboID){
							//存在则加数量
							students.order[i].productNum += 1;
							//修改总价
							students.order[i].totalAmount = students.order[i].productNum * students.order[i].comboPrice;
							//修改加工总价
							students.order[i].maketotalPrice = students.order[i].makePrice * students.order[i].productNum;
							//修改变体价格
							for(var y = 0;y<students.order[i].combo.length;y++){
								var vtPrice = students.order[i].productNum * students.order[i].combo[y].variantPrice;
								students.order[i].combo[y].variantTotalAmount = vtPrice;
							}
							
							//改变已存在的html数量
							var htmlNum = $("#product-"+id).next().children('span').html();
							$("#product-"+id).next().children('span').html(parseInt(htmlNum)+1);
							var div = $("#product-"+id).next().children('div');
							for(var y = 0;y<div.length;y++){
								$(div[y]).html(parseInt(htmlNum)+1);					
							}
							
							students.totalNum +=1; 
							students.allNum +=1;
							$("#totalNum").html(parseInt($("#totalNum").text())+1);
							
							students.totalPrice = parseFloat(numAdd(students.totalPrice,numAdd(students.order[i].comboPrice,students.order[i].makePrice))).toFixed(2);
							students.allPrice = parseFloat(numAdd(students.allPrice,numAdd(students.order[i].comboPrice,students.order[i].makePrice))).toFixed(2);
							$("#total").html(parseFloat(numAdd($("#total").text(),numAdd(students.order[i].comboPrice,students.order[i].makePrice))).toFixed(2));
							flag = 1;
						}
						
					}
					students = JSON.stringify(students);
					localStorage.setItem(storageName,students);
					
					if(flag == 0){
						students = localStorage.getItem(storageName);
						students = JSON.parse(students);//把字符串转换成JSON对象
						if(students.order.length){
							var num = students.order.length;
							tag = students.order[num-1].tag + 1;
						}
						var pepole= {
								productName:result,productPrice:price,totalAmount:price,productNum:1,
								variantID:0,type:productType,
								comboID:id,comboName:productVariant[0].variantName,
								comboPrice:price,combo:[],makePrice:produceCost,maketotalPrice:produceCost,
								areaID:areaID,mealsID:mealsID
							};
						students.order.push(pepole);
						students.totalNum +=1;
						students.allNum +=1;
						$("#totalNum").html(parseInt($("#totalNum").text())+1);
						
						students.totalPrice = parseFloat(numAdd(students.totalPrice,numAdd(price,produceCost))).toFixed(2);
						students.allPrice = parseFloat(numAdd(students.allPrice,numAdd(price,produceCost))).toFixed(2);
						$("#total").html(parseFloat(numAdd($("#total").text(),numAdd(price,produceCost))).toFixed(2));
						
						students = JSON.stringify(students);
						localStorage.setItem(storageName,students);
						
						for (var i = 0; i < $.parseJSON(data).productVariantMsg.length; i++) {
							html += '\
									<div class="secondMenu lightGreen clear f12" onclick="secondMenuClick(this)">\
										<i class="blueCircle_12"></i>\
										'+$.parseJSON(data).productVariantMsg[i].variantName+'\
									</div>\
									';
							varianHtml += '<div class="lightGreen">1</div>';
							var vprice = productVariant[i].price == undefined ? 0: productVariant[i].price;
							varianPriceHtml += '<div class="lightGreen f12">￥<span>'+vprice+'</span></div>';
							
							if(localStorage.getItem(storageName)){
								students = localStorage.getItem(storageName);
								students = JSON.parse(students);//把字符串转换成JSON对象
								var num = students.order.length;
								var combo = {
									variantName:productVariant[i].variantName,variantID:productVariant[i].variantID,variantPrice:vprice,variantTotalAmount:vprice
								};
								students.order[num-1].combo.push(combo);
							}
							students = JSON.stringify(students);
							localStorage.setItem(storageName,students);
						}
						html += '</td>\
									<td style="width: 15%" class="countTotal"><span class="total">1</span>'+varianHtml+'</td>\
									<td style="width: 25%" class="price"><div >￥<span>'+price+'</span></div>'+varianPriceHtml+'</td>\
									<td style="width: 10%"><i class="iconfont click_zhankai icon-zhankai" onclick="tc_zhankai(this)"></i>\
									</td>\
									</tr>';
						$('#notOrder tbody').prepend(html);
					}
				}else{
					var newprice = price;
					if(orderPrice > 0){
						newprice = orderPrice+price;
					}
					//创建localStorage
					students =   {  
									order:[
									       {	
									    	   productName:result,productPrice:price,totalAmount:price,productNum:1,
												variantID:0,type:productType,
												comboID:id,comboName:productVariant[0].variantName,
												comboPrice:price,combo:[],makePrice:produceCost,maketotalPrice:produceCost,
												areaID:areaID,mealsID:mealsID
									       }
									      ],
									totalNum:1,
									totalPrice:parseFloat(numAdd(price,produceCost)).toFixed(2),
									allNum:orderNum+1,
									allPrice:parseFloat(numAdd(newprice,produceCost)).toFixed(2)
								  
								}//要存储的JSON对象 
					
					students = JSON.stringify(students);
					localStorage.setItem(storageName,students);
					
					
					for (var i = 0; i < $.parseJSON(data).productVariantMsg.length; i++) {
						html += '\
								<div class="secondMenu lightGreen clear f12" onclick="secondMenuClick(this)">\
									<i class="blueCircle_12"></i>\
									'+$.parseJSON(data).productVariantMsg[i].variantName+'\
								</div>\
								';
						varianHtml += '<div class="lightGreen">1</div>';
						var vprice = productVariant[i].price == undefined ? 0: productVariant[i].price;
						varianPriceHtml += '<div class="lightGreen f12">￥<span>'+vprice+'</span></div>';
						
						if(localStorage.getItem(storageName)){
							students = localStorage.getItem(storageName);
							students = JSON.parse(students);//把字符串转换成JSON对象
							var num = students.order.length;
							var combo = {
								variantName:productVariant[i].variantName,variantID:productVariant[i].variantID,variantPrice:vprice,variantTotalAmount:vprice
							};
							students.order[num-1].combo.push(combo);
						}
						students = JSON.stringify(students);
						localStorage.setItem(storageName,students);
					}
					html += '</td>\
								<td style="width: 25%" class="countTotal"><span class="total">1</span>'+varianHtml+'</td>\
								<td style="width: 15%" class="price"><div >￥<span>'+price+'</span></div>'+varianPriceHtml+'</td>\
								<td style="width: 10%"><i class="iconfont click_zhankai icon-zhankai" onclick="tc_zhankai(this)"></i>\
								</td>\
								</tr>';
					
					$("#totalNum").html($("#totalNum").text()-0+1);
					$("#total").html(parseFloat(numAdd($("#total").text(),numAdd(price,produceCost))).toFixed(2));
					$('#notOrder tbody').prepend(html);
				}
			},
			error:function(xhr, status, error){layer.msg('error')}
		});
	}
}

/**
 * 初始化数据库已经下单的菜品列表
 */
function loadDBproductList(subOrderID,mealsID,tableID){
	$('#alreadyOrder tbody').html('');
	var producthtml2 = '';
	var combohtml2 = '';
	$.getJSON({
	 	async: false,
		type: 'post',
		data: {"subOrderID":subOrderID,"mealsID":mealsID,"tableID":tableID}, 
		url: "../loadProductList.action",
		success: function (data) {
			console.info(data);
			if(!$.isEmptyObject(data)){
				var order = data;
				$('#subOrderID').attr("value",order.subOrderID);
				orderPrice = order.totalPrice || 0;
				orderNum = order.totalNum || 0;
				tableName = order.tableName || "";
				if(order.product){
					for (var i = 0; i < order.product.length; i++) {
						var varianHtml = '';
						var varianPriceHtml = '';
						if(order.product[i].comboID){
							combohtml2 += '\
								<tr class="setMealOrder" onclick="clickOrder(this,'+order.product[i].produceStatus+')">\
								<td style="width: 50%"v>\
									<i class="blueCircle_15"  id="'+order.product[i].detailID+'" name="'+order.product[i].produceStatus+'" quantity="'+order.product[i].quantity+'" needWeigh="'+order.product[i].needWeigh+'"></i>\
									<p class="fL">'+order.product[i].comboName+'</p>\
									<div class="greenCircle">套</div>\
								';
							if(order.product[i].combo){
								for (var y = 0; y < order.product[i].combo.length; y++) {
									var comboVprice = order.product[i].combo[y].comboVprice == undefined ? 0:order.product[i].combo[y].comboVprice;
										combohtml2 += '\
											<div class="secondMenu lightGreen clear f12" onclick="secondMenuClick(this)">\
												<i class="blueCircle_12" id="'+order.product[i].combo[y].recordID+'" name="'+order.product[i].combo[y].comboStatus+'" quantity="'+order.product[i].quantity+'" ></i>\
												'+order.product[i].combo[y].comboVname+'\
											</div>\
											<p class="status1"><span ></span></p>\
											';
										
										varianHtml += '<div class="lightGreen">'+order.product[i].quantity+'</div><div class="empty">&nbsp;</div>';
										varianPriceHtml += '<div class="lightGreen f12">￥<span>'+comboVprice+'</span></div><div class="empty">&nbsp;</div>';
								}
							}
							
							
							combohtml2 += '</td>\
												<td style="width: 15%;" class="countTotal"><span class="total">'+order.product[i].quantity+'</span>'+varianHtml+'</td>\
												<td style="width: 25%" class="price"><div >￥<span class="currentPrice" >'+order.product[i].comboPrice+'</span></div>'+varianPriceHtml+'</td>\
												<td style="width: 10%"><i class="iconfont click_zhankai icon-zhankai" onclick="tc_zhankai(this)"></i></td>\
											</tr>';
						}else{
							var reason ='';
							var num = '';
							var rePrice = '';
							var practice = order.product[i].detailDesc;
							var practiceHtml = '';
							if(practice){
								practiceHtml ='<div class="tasteAppend">'+'<i class="taste">口味</i>' +practice+'</div>'
							}
							producthtml2 += '\
								<tr  onclick="clickOrder(this,'+order.product[i].produceStatus+')">\
									<td style="width: 50%">\
										<i class="blueCircle_15" id="'+order.product[i].detailID+'"  name="'+order.product[i].produceStatus+'" needWeigh="'+order.product[i].needWeigh+'"  quantity="'+order.product[i].quantity+'"></i><span>'+order.product[i].productName+'</span>\
										<div class="status1"><span ></span></div>'+reason+''+practiceHtml+'\
									</td>\
									<td style="width: 15%;"><div class="total">'+order.product[i].quantity+'</div><div class="empty">&nbsp;</div>'+num+'</td>\
									<td style="width: 22%" class="price">\
										<div>￥<span class="currentPrice">'+order.product[i].price+'</span></div><div class="empty">&nbsp;</div>'+rePrice+'\
									</td>\
									<td style="width: 10%"></td>\
							  	</tr>\
							  ';
							
						}
					}
					$('#alreadyOrder tbody').html("");
					$('#alreadyOrder tbody').append(combohtml2);
					$('#alreadyOrder tbody').append(producthtml2);
				}
				if(order.returnProduct){
					var html = '';
					
					var returni = '';
					var divContent ='';
					for (var i = 0; i < order.returnProduct.length; i++) {
						var reasonHtml = '';
						if(order.returnProduct[i].reason != undefined && order.returnProduct[i].reason != " "){
							reasonHtml = '\
										<tr>\
											<td colspan="4">\
												<div class="reason">退菜理由:'+order.returnProduct[i].reason+'</div>\
											</td>\
										</tr>\
										';
						}
						if(i==0){
							returni = '<i class="returnCircle">退</i>退菜';
							divContent = '<div class="empty" style="display: block;">&nbsp;</div>';
						}else{
							returni = '';
							divContent ='';
						}
						html += '\
								<tr class="notClick">\
									<td style="width: 50%">'+returni+'\
								    	<div class="reason">'+order.returnProduct[i].name+'</div>\
									</td>\
									<td style="width: 15%;">'+divContent+'\
										<div class="returnNum">'+order.returnProduct[i].num+'</div>\
									</td>\
									<td style=width: 25%" class="price">'+divContent+'\
										<div class="returnPrice">\
											<span>￥'+order.returnProduct[i].price+'</span>\
										</div>\
									</td>\
									<td style="width: 10%"></td>\
								</tr>'+reasonHtml+'\
								';
						
						
					}
					
					$('#alreadyOrder tbody').append(html);
				}
				
				if(order.addProduct){
					
					var html = '';
					var reasonHtml = '';
					var returni = '';
					var divContent ='';
					for (var i = 0; i < order.addProduct.length; i++) {
						if(order.addProduct[i].reason != undefined && order.addProduct[i].reason != " "){
							reasonHtml = '\
										<tr>\
											<td colspan="4">\
												<div class="reason">赠菜理由:'+order.addProduct[i].reason+'</div>\
											</td>\
										</tr>\
										';
						}
						if(i==0){
							returni = '<i class="returnCircle">赠</i>赠菜';
							divContent = '<div class="empty" style="display: block;">&nbsp;</div>';
						}else{
							returni = '';
							divContent ='';
						}
						html += '\
								<tr class="notClick">\
									<td style="width: 50%">'+returni+'\
								    	<div class="reason">'+order.addProduct[i].name+'</div>\
									</td>\
									<td style="width: 15%;">'+divContent+'\
										<div class="returnNum">'+order.addProduct[i].num+'</div>\
									</td>\
									<td style=width: 25%" class="price">'+divContent+'\
										<div class="returnPrice">\
											<span>￥'+order.addProduct[i].price+'</span>\
										</div>\
									</td>\
									<td style="width: 10%"></td>\
								</tr>'+reasonHtml+'\
								';
						
						
					}
					$('#alreadyOrder tbody').append(html);
					
				}
			}
			
		},
		error:function(xhr, status, error){layer.msg('获取已下单菜品列表错误,请联系管理员')}
	});
	checkStorageName();
	checkHtmlPriceAndNum(localStorage.getItem(storageName));
}

/**
 * 检查页面总价格和数量
 * @param storage
 */
function checkHtmlPriceAndNum(storage){
	if(storage){
		storage = JSON.parse(storage);//把字符串转换成JSON对象 
		$("#totalNum").html(storage.totalNum + orderNum);
		$("#total").html( parseFloat(numAdd(storage.totalPrice,orderPrice)).toFixed(2));
	}else{
		$("#totalNum").html(orderNum);
		$("#total").html(orderPrice);
	}
}


//点击菜单列表每一行触发事件

function clickOrder(_this,produceStatus){
	$('.blueCircle_12').removeClass('blueCircle_12_selected');
	if($(_this).parents().hasClass('notOut')){
        $('.editOrder').children('.return,.suspend,.weight,.gift,.urge').hide();
        $('.editOrder').children('.delete,.method').show();
    }else {
        $('.editOrder').children('.return,.suspend,.weight,.gift,.urge').show();
        $('.editOrder').children('.delete,.method').hide();
    }
	
    if($(_this).hasClass('setMealOrder')){
        var secondMenu= $(_this).find('.secondMenu ');
        var hideStyle=$(_this).children('td').eq(0).children().eq(1);
        hideStyle.click(function(){
        	$('.secondMenu').find('.blueCircle_12').removeClass('blueCircle_12_selected');
            $('.editOrder').children('div:gt(2)').css('color','#a24f9c');
            $('.editOrder').children('div:nth-child(2)').show();
            $('.editOrder').children('div:gt(2)').find('i').css('cursor','pointer');
            $('.editOrder').children('div:nth-child(2)').find('i').css('cursor','pointer');
            $('.editOrder').children('div:gt(2)').removeClass('unClick');
        });
        
    }else {
    	$('.currentPosition').parent().find('.status1').hide();
    	$('.currentPosition').parent().parent().find('.empty').hide();
    	$('.currentPosition').parent().find('.status2').hide();
    	
    	$(_this).find('.status1').show();
    	$(_this).find('.status2').show();
        $('.editOrder').children('div:gt(2)').removeClass('unClick');
        $('.editOrder').show();
        $('.targetmethod,.targetreturn,.targetgift,.targetweight').hide();
        $(_this).find('.status2').show();
        if($(_this).find('.status1:visible')||$(_this).find('.status2:visible')||$(_this).find('.status3:visible')){
            $(_this).find('.empty').show();
        }else {
            $(_this).find('.empty').hide();
        }
//        $('.secondMenu').children('i').removeClass('blueCircle_12_selected');
        $('.editOrder').children('div:gt(2)').css('color','#a24f9c');
        $('.editOrder').children('div:nth-child(2)').show();
        $('.editOrder').children('div:gt(2)').find('i').css('cursor','pointer');
        $('.editOrder').children('div:nth-child(2)').find('i').css('cursor','pointer');
    }
    currentChose(_this);
    
  
	if($('.currentPosition').attr('id')){
	    getProduceStatus();
	}

	//692未知 693制作中 694等叫 695催菜 696加急 697延时 698超时 699划单
	if(produceStatus == 693 || produceStatus == 696 || produceStatus == 697 || produceStatus == 698){
		$('.urge').show();
	}else{
		$('.urge').hide();
	}
	
    return false;
}

function clearNoNum(obj){
	
	obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符
	
	obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字而不是
	
	obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
	
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	
	obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数

}

function secondMenuClick(_this){
	$(_this).parent().parent().parent().find('.status1').hide();
	$(_this).parent().parent().parent().find('.status2').hide();
	$(_this).parent().parent().parent().find('.empty').hide();
	$('.secondMenu').children('i').removeClass('blueCircle_12_selected');
    $(_this).children('i').addClass('blueCircle_12_selected');
    //当前行中点击的是第几个.secondMenu
    var index=$(_this).parent().find('.secondMenu').index(_this);
    $(_this).next().show();
    //获取同行的空格
    var index2=$(_this).parent().siblings('.countTotal').find('.lightGreen').eq(index);
    var index3=$(_this).parent().siblings('.price').find('.lightGreen').eq(index);
    index2.next().show();
    index3.next().show();
    $('.editOrder').children('div:gt(2)').css('color','#ccc');
    $('.editOrder').children('div:nth-child(2)').hide();
    $('.editOrder').children('div:gt(2)').addClass('unClick');
    $('.editOrder').children('div:gt(2)').find('i').css('cursor','default');
    $('.editOrder').children('div:first').find('i').css('cursor','default');
    
    $('.currentPosition').text('');
    $('.currentPosition').removeClass('currentPosition');
    var i =$(_this).parent().children('i').eq(0);
    i.addClass('currentPosition');
    i.text('√');
    
    $('.editOrder').children('.suspend').show();
	 getProduceStatus();
    if(_this&&_this.stopPropagation){//非IE
    	_this.stopPropagation();
    }else{//IE
		window.event.cancelBubble=true;
    }
}

function getProduceStatus(){
	var detailID = 0;
	if($('.blueCircle_12_selected').attr('id') != undefined){
		detailID = $('.blueCircle_12_selected').attr('id');
		$.ajax({
		 	async: true,
			type: 'post',
			data: {"recordID":detailID}, 
			url: "../getComboDetailByID.action",
			success: function (data) {
				var orderDetail = $.parseJSON(data);
				changeStatus(orderDetail);
				
			}
		});
	}else{
		detailID = $('.currentPosition').attr('id');
		$.ajax({
		 	async: true,
			type: 'post',
			data: {"detailID":detailID}, 
			url: "../getOrderDetailByID.action",
			success: function (data) {
				var orderDetail = $.parseJSON(data);
				changeStatus(orderDetail);
				
			}
		});
	}
	
}

function changeStatus(orderDetail){
	if(orderDetail.produceStatus == 694){
		$('.suspend').children('i').addClass('icon-bofang');
        $('.suspend').children('i').removeClass('icon-pause');
        $('.suspend').children('.fnName').text('叫起');
    }else{
   	 	$('.suspend').children('i').addClass('icon-pause');
        $('.suspend').children('i').removeClass('icon-bofang');
        $('.suspend').children('.fnName').text('等叫');
    }
	var statusText = "";
	var date = "";
	var produceStatusClass = "status2";
	if(orderDetail.produceTime){
		date = new Date(orderDetail.produceTime);  
		date = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}
	if(orderDetail.produceStatus == 693){
		statusText = "制作中";
	}else if(orderDetail.produceStatus == 694){
		statusText = "等叫";
	}else if(orderDetail.produceStatus == 695){
		statusText = "催菜";
		date = "";
	}else if(orderDetail.produceStatus == 696){
		statusText = "加急";
	}else if(orderDetail.produceStatus == 697){
		statusText = "延时";
	}else if(orderDetail.produceStatus == 698){
		statusText = "超时";
		produceStatusClass = "status1";
	}
	if($('.blueCircle_12_selected').attr('id') != undefined){
		$('.blueCircle_12_selected').parent().next().attr("class",produceStatusClass);
		$('.blueCircle_12_selected').parent().next().html(statusText+"&nbsp;<span >"+date+"</span>")
	}else{
		if(!$('.currentPosition').parent().parent().attr("class")){
			$('.currentPosition').next().next().attr("class",produceStatusClass);
			$('.currentPosition').next().next().html(statusText+"&nbsp;<span >"+date+"</span>")
		}
		
	}
}

function selectMove(){
	var id = $(".selectClassify").attr("id");
	$.getJSON({
		 	async: false,
			type: 'post',
			data: {"orgID":$("#orgID").val(),"categoryID":id,"areaID":$("#areaID").val(),"mealsID":$("#mealsID").val()}, 
			url: "../getProductList.action",
			success: function (data) {
				var li = '<ul  class="productList">';
				if(!$.isEmptyObject(data)){
					for (var i = 0; i < data.productMsg.length; i++) {
						var productInfo = data.productMsg[i];
						var barCode = productInfo.barCode == undefined ? 0:productInfo.barCode;
						var price = productInfo.price == undefined ? 0:productInfo.price;
						var combo = '';
						var needWeigh = '';
						if(productInfo.productType == 1){
							combo = '<div class="triangle-topleft"></div><i class="setMealText">套</i>';
						}
						if(productInfo.needWeigh == true){
							needWeigh = '<div class="triangle-topleft"></div><i class="setMealText">称</i>';
						}
						li += '\
								<li onclick="addProducts(this,'+productInfo.productType+','+productInfo.productID+','+productInfo.variantID+',\''+productInfo.productName+'\','+productInfo.produceCost+','+productInfo.areaID+','+productInfo.mealsID+','+productInfo.needWeigh+')">'+combo+''+needWeigh+'\
									<p class="orderName"><span class="name_text">'+productInfo.productName+'</span><span>'+barCode+'</span></p>\
									<p class="orderNamePrice">￥'+price+'</p>\
								</li>\
								';
					}
				}
				li += '</ul>';
				$('.orderRightCenter').html(li);
				$('.productList').show();
				$('.productList').mCustomScrollbar();
			},
			error:function(xhr, status, error){layer.msg('error')}
	 });

}
//根据分类编号获取菜品列表
function getProductList(_this,id){
	 $(_this).addClass('selectClassify');
	 $(_this).siblings('li').removeClass('selectClassify');
	 loadProductList($("#searchCode").val());
	
}

/**
 * 结账
 */
function checkout(){
	var names = "";
	var bs = 0;
	if($('#alreadyOrder tbody').html()){
		var alreadyOrderTr = $('#alreadyOrder tbody').children('tr');
		for(var y = 0;y<$(alreadyOrderTr).length;y++){
			
			var needweigh = $(alreadyOrderTr).eq(y).children('td:eq(0)').children('i').attr('needweigh');
			if(needweigh == 'true'){
				$.ajax({
				 	async: false,
					type: 'post',
					data: {"detailID":$(alreadyOrderTr).eq(y).children('td:eq(0)').children('i').attr('id')}, 
					url: "../getOrderDetailByID.action",
					success: function (data) {
						var orderDetail = $.parseJSON(data);
						if(!orderDetail.floatQuantity){
							names += $(alreadyOrderTr).eq(y).children('td:eq(0)').children('span:eq(0)').html()+" ";
							bs = 1;
						}
					},
					error:function(xhr, status, error){layer.msg('error')}
			     });
			}
		}
		if(bs == 1){
			layer.msg(names+"未进行称重不能结账");
		}else{
			location.href = '../../settlement/query.action?key='+storageName+'&orderIDs='+$("#subOrderID").val();
		}
	}else{
		layer.msg("请先下单!");
	}
}
//订单左边的宽度
function orderRightWidth(){
    var winWidth=$(window).width();
    //370是左边的高度
    $('.orderRight').css('width',winWidth-370+'px');
}

//订单右边中间的高度
function orderRightHeight(){
        var winHeight=$(window).height();
    //160是因为头部和底部都是80PX
        $('.orderRightCenter').css('height',winHeight-160);
}

//订单左边中间的高度
function orderLeftHeight(){
    var winHeight=$(window).height();
    //200是因为头部和底部都加起来的值
    $('.orderRightCenter').css('height',winHeight-200);
}







function clickMeals(mealsID){
	layer.closeAll();
	$("#mealsID").val(mealsID);
	loadDBproductList($("#subOrderID").val(),$("#mealsID").val(),$("#tableID").val());
	$.getJSON({
		type: 'post',
		data: {"orgID":$("#orgID").val(),"categoryID":0,"areaID":$("#areaID").val(),"mealsID":$("#mealsID").val()}, 
		url: "../getProductList.action",
		success: function (data) {
			var li = '';
			if(!$.isEmptyObject(data)){	
				for (var i = 0; i < data.productMsg.length; i++) {
					var productInfo = data.productMsg[i];
					var barCode = productInfo.barCode == undefined ? 0:productInfo.barCode;
					var price = productInfo.price == undefined ? 0:productInfo.price;
					var combo = '';
					var needWeigh = '';
					if(productInfo.productType == 1){
						combo = '<div class="triangle-topleft"></div><i class="setMealText">套</i>';
					}
					if(productInfo.needWeigh == true){
						needWeigh = '<div class="triangle-topleft"></div><i class="setMealText">称</i>';
					}
					li += '\
							<li onclick="addProducts(this,'+productInfo.productType+','+productInfo.productID+','+productInfo.variantID+',\''+productInfo.productName+'\','+productInfo.produceCost+','+productInfo.areaID+','+productInfo.mealsID+','+productInfo.needWeigh+')">'+combo+''+needWeigh+'\
								<p class="orderName"><span class="name_text">'+productInfo.productName+'</span><span>'+barCode+'</span></p>\
								<p class="orderNamePrice">￥'+price+'</p>\
							</li>\
							';
				}
			}
			$('.orderRightCenter').children('.productList').show();
			$('.orderRightCenter').children('.productList').html(li);
		},
		error:function(xhr, status, error){layer.msg('error')}
	});
}

//lsh 加载菜品列表
function loadProductList(){
	var categoryID = $("#categoryList li.selectClassify").attr('id'); 
	if(!categoryID){
		categoryID = 0;
	}
	var searchCode = $("#searchCode").val();
	$.getJSON({
	 	async: true,
		type: 'post',
		data: {"orgID":$("#orgID").val(),"categoryID":categoryID,"areaID":$("#areaID").val(),"mealsID":$("#mealsID").val(),'searchCode':searchCode}, 
		url: "../getProductList.action",
		success: function (data) {
	 		console.info(data);
			var li = '';
			if(!$.isEmptyObject(data)){
				for (var i = 0; i < data.length; i++) {
					var productInfo = data[i];
					var barCode = productInfo.barCode == undefined ? 0:productInfo.barCode;
					var price = productInfo.price == undefined ? 0:productInfo.price;
					var combo = '';
					var needWeigh = '';
					if(productInfo.productType == 1){
						combo = '<div class="triangle-topleft"></div><i class="setMealText">套</i>';
					}
					if(productInfo.needWeigh == true){
						needWeigh = '<div class="triangle-topleft"></div><i class="setMealText">称</i>';
					}
					li += '\
							<li onclick="addProducts(this,'+productInfo.productType+','+productInfo.productID+','+productInfo.variantID+',\''+productInfo.productName+'\','+productInfo.produceCost+','+productInfo.areaID+','+productInfo.mealsID+','+productInfo.needWeigh+')">'+combo+''+needWeigh+'\
								<p class="orderName"><span class="name_text">'+productInfo.productName+'</span><span>'+barCode+'</span></p>\
								<p class="orderNamePrice">￥'+price+'</p>\
							</li>\
							';
				}
			}
			$('.orderRightCenter').children('.productList').show();
			$('.orderRightCenter').children('.productList').html(li);
			
		},
		error:function(xhr, status, error){layer.msg('获取菜品列表失败,请联系管理员')}
 });
}
//lsh

//获取餐次
function getMealsList(type){
	var code = "success";
	$.getJSON({
  		 	async: false,
  			type: 'post',
  			data: {"areaID":$("#areaID").val(),"type":type}, 
  			url: "../getMealsList.action",
  			success: function (data) {
  				if(!$.isEmptyObject(data)){
	   				var li = '';
	   				for (var i = 0; i < data.meals.length; i++) {
	   					li += '<li onclick="clickMeals('+data.meals[i].mealsID+')"><p class="orderName"> <span class="name_text">'+data.meals[i].mealName+'</span></p></li>';
	   				}
		   			 var html = '\
					   				<div class="popup_multiple_title f16 blue" style="font-size:20px;">\
							 			选择餐次\
							 		</div>\
							 		<div class="popup_multiple_content">\
							 			<ul class="liStyle clearfix chooseDinner">'+li+'\
							 			</ul>\
							 		</div>\
							 	';
		   			$("#popup_multiple").html(html);
		   				
		   			 layer.open({
		   	            type: 1,
		   	            title: false,
		   	            area: ['800px', '400px'],
		   	            closeBtn: 0,
		   	            scrollbar: false,
		   	            content: $('.popup_multiple')
		   			 });
  				}else{
  					code = "empty";
  				}
  			},
  			error:function(xhr, status, error){layer.msg('获取餐次信息错误,请联系管理员')}
  	 	});
	 return code;
}


/** 
* 加法运算，避免数据相减小数点后产生多位数和计算精度损失。 
* 
* @param num1被减数 | num2减数 
*/ 
function numSub(num1, num2) { 
	var baseNum, baseNum1, baseNum2; 
	var precision;// 精度 
	try { 
		baseNum1 = num1.toString().split(".")[1].length; 
	} catch (e) { 
		baseNum1 = 0; 
	} 
	try {
		baseNum2 = num2.toString().split(".")[1].length; 
	} catch (e) { 
		baseNum2 = 0; 
	}
	baseNum = Math.pow(10, Math.max(baseNum1, baseNum2)); 
	precision = (baseNum1 >= baseNum2) ? baseNum1 : baseNum2; 
	return ((num1 * baseNum - num2 * baseNum) / baseNum).toFixed(precision); 
} 

/** 
* 加法运算，避免数据相加小数点后产生多位数和计算精度损失。 
* 
* @param num1加数1 | num2加数2 
*/ 
function numAdd(num1, num2) { 
	var baseNum, baseNum1, baseNum2; 
	try { 
		baseNum1 = num1.toString().split(".")[1].length; 
	} catch (e) { 
		baseNum1 = 0; 
	} 
	try { 
		baseNum2 = num2.toString().split(".")[1].length; 
	} catch (e) { 
		baseNum2 = 0; 
	} 
	baseNum = Math.pow(10, Math.max(baseNum1, baseNum2)); 
	return (num1 * baseNum + num2 * baseNum) / baseNum; 
};


function changeNumber(e){
	var num = $(e).val();

    if($('.currentPosition').html()){
        if($('.currentPosition').attr('id')){
            layer.msg('未下单的菜品才能操作');
        }else{
        	if(num>0){
                var food = $('.currentPosition').parent().attr('id');
                var vfood = food.substring(0,food.indexOf('-'));
                var id =  food.substring(food.indexOf('-')+1,food.length);
                var storage = localStorage.getItem(storageName);
                storage = JSON.parse(storage);//把字符串转换成JSON对象
                if(vfood == "variant"){
                    for(var i = 0;i<storage.order.length;i++){
                        if(storage.order[i].variantID == id){
                            changeLocalStorageProductNum(storage,i,num);
                        }
                    }
                }else{
                    for(var i = 0;i<storage.order.length;i++){
                        if(storage.order[i].comboID == id){
                            changeLocalStorageProductNum(storage,i,num);
                        }
                    }
                }
                var div = $("#product-"+id).next().children('div');
                for(var y = 0;y<div.length;y++){
                    $(div[y]).html(parseInt(num));
                }
                $("#totalNum").html(storage.allNum);
                $("#total").html(parseFloat(storage.allPrice).toFixed(2));
                storage = JSON.stringify(storage);
                localStorage.setItem(storageName,storage);

                var newTotal=$('.currentPosition').parent().next().find('.total');
                newTotal.text(num);
			}else{
                layer.msg('数量必须大于0');
				$(e).val($('.currentPosition').parent().next().find('.total').text());
			}
        }
    }else{
        layer.msg('请选中一个菜品');
    }
}


function  changeLocalStorageProductNum(storage,i,num){
	var type = 0;
	//改变前数量
	var beforeChangeNum = storage.order[i].productNum;
	var changeNum = 0;
	//大于表示增加了数量否则表示减少了
	if(num > beforeChangeNum){
        type = 2;
        changeNum = num - beforeChangeNum;
	}else if(beforeChangeNum > num){
        type = 1;
        changeNum = beforeChangeNum - num;
	}
    storage.order[i].productNum = parseInt(num);
    storage.order[i].totalAmount = num * storage.order[i].productPrice;
    storage.order[i].maketotalPrice = num * storage.order[i].makePrice;
	if(type == 1){
        storage.allNum -= changeNum;
        storage.totalNum -= changeNum;
        if(!storage.order[i].needWeigh){
            storage.totalPrice = parseFloat(numSub(storage.totalPrice, numAdd(storage.order[i].productPrice,storage.order[i].makePrice)*changeNum)).toFixed(2);
            storage.allPrice = parseFloat(numSub(storage.allPrice, numAdd(storage.order[i].productPrice,storage.order[i].makePrice)*changeNum)).toFixed(2);
        }

    }else if(type == 2){
        storage.allNum += changeNum;
        storage.totalNum += changeNum;
        if(!storage.order[i].needWeigh){
            storage.totalPrice = parseFloat(numAdd(storage.totalPrice, numAdd(storage.order[i].productPrice,storage.order[i].makePrice)*changeNum)).toFixed(2);
            storage.allPrice = parseFloat(numAdd(storage.allPrice, numAdd(storage.order[i].productPrice,storage.order[i].makePrice)*changeNum)).toFixed(2);
        }
    }
}