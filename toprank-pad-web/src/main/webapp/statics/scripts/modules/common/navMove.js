
///左右箭头选择
//定义当前页 与 总页数
function leftMove(e){
  var menuClassifyWidth=$(e).siblings('.menuClassify').width();
  var allLi=$(e).siblings('.menuClassify').children('li');
  var firstLi=$(e).siblings('.menuClassify').children('li:first');
  var li_width=$(e).siblings('.menuClassify').children('li:first').width();
  if(firstLi.position().left>=0){
    $(e).siblings('.menuClassify').find('li.selectClassify').prev().addClass('selectClassify');
    $(e).siblings('.menuClassify').find('li.selectClassify').next().removeClass('selectClassify');
  }
  else{
    allLi.animate({"left":'+='+li_width},100);
    $(e).siblings('.menuClassify').find('li.selectClassify').prev().addClass('selectClassify');
    $(e).siblings('.menuClassify').find('li.selectClassify').next().removeClass('selectClassify');
  }
  first_lastLi(e)
}
function rightMove(e){
  var lastLi=$(e).siblings('.menuClassify').children('li:last');
  var allLi=$(e).siblings('.menuClassify').children('li');
  var menuClassifyWidth=$(e).siblings('.menuClassify').width();
  var li_width=$(e).siblings('.menuClassify').children('li:first').width();
  if(lastLi.position().left>menuClassifyWidth*0.9){
    allLi.animate({"left":"-="+li_width},100);
    $(e).siblings('.menuClassify').find('li.selectClassify').next().addClass('selectClassify');
    $(e).siblings('.menuClassify').find('li.selectClassify').prev().removeClass('selectClassify');
  }else{
    $(e).siblings('.menuClassify').find('li.selectClassify').next().addClass('selectClassify');
    $(e).siblings('.menuClassify').find('li.selectClassify').prev().removeClass('selectClassify');
  }
  first_lastLi(e);

}
//$(".orderRightTop .leftArrow").on("click",function(){
//  leftMove();
//});
//$(".orderRightTop .rightArrow").on("click",function(){
//  rightMove();
//});
//分类选择
$("body").on('click','.menuClassify li',function(){
	var currentClass=$(this).attr('id');
  $(this).siblings('li').removeClass('selectClassify');
  $(this).addClass('selectClassify');
  first_lastLi(this);
})
 

//当选中第一个或最后一个时，不能再往左或右点
function first_lastLi(e){
  var currentElement=$(e).parents('.navScroll');
  var firstLi=currentElement.find('.menuClassify').children('li:first');
  var lastLi=currentElement.find('.menuClassify').children('li:last');
  if(firstLi.hasClass('selectClassify')){
    currentElement.find('.leftArrow').css('color','#999').css('cursor','default');
  }
  else {
    currentElement.find('.leftArrow').css('color','#a24f9c').css('cursor','pointer');
  }
  if(lastLi.hasClass('selectClassify')){
    currentElement.find('.rightArrow').css('color','#999').css('cursor','default');
  }else {
    currentElement.find('.rightArrow').css('color','#a24f9c').css('cursor','pointer');
  }

}