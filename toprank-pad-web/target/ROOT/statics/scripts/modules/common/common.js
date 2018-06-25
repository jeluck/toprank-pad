/**
 * Created by Lsh on 2016-11-21.
 */
$(function() {
})

// demo
// sendValidateMessage("15902772751",function(data){
// alert(data);
// });
// sendRegisterMessage("15902772751",function(data){
// alret(1);
// })
// demo
/**
 * 快捷发送验证短信
 * 
 * @param phone
 * @param fn
 */
function sendValidateMessage(phone, fn) {
	sendMessage(phone, 'validate', '本次验证码为:', fn);
}
/**
 * 快捷发送注册短信
 * 
 * @param phone
 * @param fn
 */
function sendRegisterMessage(phone, fn) {
	sendMessage(phone, 'register', '本次注册码为:', fn);
}
/**
 * 公共发送短信接口 phone tips= 本次验证注册码为:给这个手机号发送注册验证码的短信 默认:本次注册您的验证码为 :
 * type=validate/register redis存放位置 默认register time 默认120s失效
 */
function sendMessage(phone, type, tips, fn) {
	var param = {};
	if (!phone) {
		showTips('请输入手机号');
	}
	param.phone = phone;
	if (tips)
		param.tips = tips;
	if (type)
		param.type = type;
	$.getJSON(
			"http://localhost:9999/gate-way-web/sms/sendJP.action?callback=?",
			param, function(data) {
				debugger;
				if (typeof (fn) == "function") {
					fn(data);
				}
			});
}

// 最普通的loading层
function showLoad(index, config) {
	return layer.load((index || 3), config);
}
function hideLoad(index) {
	if (index) {
		layer.close(index);
	} else {
		layer.closeAll('loading');
	}
}
// 最普通的提示框
function showTips(tip, fn, time) {
	layer.closeAll('loading');
	layer.msg(tip, {
		time : time || 1000,
		end : function() {
			if (fn) {
				fn();
			}
		}
	});
}
// 最普通的错误框
function showError(tip, fn) {
	layer.closeAll('loading');
	layer.msg(tip, {
		end : function() {
			if (fn) {
				fn();
			}
		}
	});
}
// 最普通的confirm框 只接受2个异步回调函数 成功or 失败
function showConfirm(tip,ok,no) {
	layer.confirm(tip, {
		btn : [ '确认', '取消', ], // 可以无限个按钮
		yes : function(index, layero) {
			layer.close(index);
			ok();
		},
		btn2:function(index){
			layer.close(index);
			no();
		}
	});
}
// 禁用某元素
function disBtn(o, flag) {
	if(typeof(o) == 'string'){
		o = $("#"+o);
	}
	if (!flag) {
		layer.load();
	}
	$(o).attr('disabled', "true");
}
// 解禁某元素
function enBtn(o, flag) {
	if(typeof(o) == 'string'){
		o = $("#"+o);
	}
	$(o).removeAttr('disabled');
	hideLoad();
}

// ----------权限相关---
// 打开一个验证页面 传入权限ID 输入账号密码验证是否具有权限
function openCheckPermission(privilegeID) {
	layer.open({
		type : 2,
		title : false,
		area : [ '550px', '390px' ],
		closeBtn : 0,
		scrollbar : false,
		content : basePath
				+ '/reception/permission/toCheckPermission.action?privilegeID='
				+ privilegeID
	});
}
function checkPermissionByLoginNameAndPassword(loginName, password,archiveID,
		privilegeCode, fn) {
	$.getJSON(basePath + '/reception/permission/check.action', {
		'loginName' : loginName,
		'password' : password,
		'archiveID':archiveID,
		'privilegeCode' : privilegeCode
	}, function(res) {
		fn(res);
	})
}
