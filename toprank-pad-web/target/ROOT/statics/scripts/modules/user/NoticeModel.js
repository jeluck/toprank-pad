var NoticeModel = function(){
  return {
    err:function(selector,msg){
      //alert( selector.next().text())
      selector.focus().next('.wrong').show().html('<i class="iconfont icon-caveat"></i>'+msg);
    },
    err_hide: function(selector){
      selector.next('.err').hide().text('');
    }
  }
}();