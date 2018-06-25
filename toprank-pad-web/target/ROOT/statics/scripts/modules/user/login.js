var Login=function(){
    var userName=$('.userName');
    var password=$('.password');
    var login=$('.login');
    var bindEvent=function(){
       login.bind('click',function(){
           if(userName.val()==''){
               NoticeModel.err(userName,'用户名不能为空');
               return false;
           }
           if(password.val()==''){
               NoticeModel.err(password,'密码不能为空');
               return false;
           }
       })
    }
    return{
        init:function(){
            bindEvent();
        }
    }
}();
$(function(){
    Login.init();
})