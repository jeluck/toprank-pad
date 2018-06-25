 
var oQtyFmt=new Array(10,2);
var bDebug_=false;     
var bDateType_=true;  // 日期格式是否为西元格式
var sDateSepa_="";     // 日期是否使用分隔符号
var sTimeSepa_="";     // 时间是否使用分隔符号
var iCurrPage_=1;      // 目前分页之页码

// ***************************** 字串函数 **********************************
// 重复产生字串
// sCh:重复字元
// iLen:重复个数
function emisReplicate(sCh, iLen) {
  var _sStr = "";
  for (var i=0; i < iLen; i++)
      _sStr += sCh;
  return _sStr;
}

// 左边去空白
// sValue:传入之字串
function emisLtrim(sValue) {
   for (var i=0; i<=sValue.length; i++) {
      if(sValue.substring(i,i+1)!=" ")
         break;
   }
   return sValue.substring(i,sValue.length);
}

// 右边去空白
// sValue:传入之字串
function emisRtrim(sValue) {
   for (var i=sValue.length; i>=0; i--) {
      if(sValue.substring(i-1,i)!=" ")
         break;
   }
   return sValue.substring(0, i);
}

// 左右边去空白
// sValue:传入之字串
function emisTrim(sValue) {
   return emisRtrim(emisLtrim(sValue));
}

// 左边补空白
// sValue:传入之字串
// iLen:补入个数sPad 未传入, 以 " " 字串
// sPad 未传入, 以 " " 字串
//2004/06/15 Jacky 判断是否空值若为空值责传回空字串
function emisPadl(sStr, iLen, sPad,isEmpty) {
  if (arguments.length==2) sPad=" ";
  if (! emisEmpty(isEmpty)){
    if (emisEmpty(sStr))
      return sStr;
  }
  sStr = "" + sStr;
  //2004/10/20 [1176] Jacky 判断若内容若没有%则补零
  if ( sStr.indexOf("%") < 0 )
    sStr = emisReplicate(sPad, iLen-emisLength(sStr)) + sStr ;    
  return sStr;
}

 

 
// 取得中文字串长度
// sValue:传入之字串
function emisLength(sValue) {
  var _iLength = 0;

  //中文算两码长度，英文算一码长度
//  for( var i=0; i < sValue.length ; i++) {
//    if( sValue.charCodeAt(i) >= 0x2E80 )
//      _iLength +=2;
//    else
//      _iLength +=1;
//  }

  //中文英文都算一码长度，UTF-8资料库 2009/11/05 by fang
  _iLength=sValue.length;

  return _iLength;
}
 

 
 
// *************************** 日期时间函数 ********************************
// 取得今天或传入日期的字串
// sDate: 传入之日期的字串, 不传预设为今天
// sSep: 日期格式分隔字, 不传预设为 ""
function emisDate(sDate) {
  var _iDateYear  =bDateType_? 0: 1911;    // 是否为西元年格式
//var _iDateLength=emisTrim(sDateSepa_).length;    // 日期是否多加一位数
  var _iDateLength=bDateType_? 1: 0;       // 日期是否多加一位数
//var _sSep = "-";
  if (emisEmpty(sDate)) {
    var _oDate = new Date();
    return emisPadl(_oDate.getFullYear()-_iDateYear, 3+_iDateLength, "0") +  "-" +
           emisPadl(_oDate.getMonth()+1, 2, "0") +  "-" +
           emisPadl(_oDate.getDate(), 2, "0");
  }
  else {
//  var _sSep ="-";
    sDate=sDate.replace(new RegExp( "-", "g"),"");

    if (sDate.length<7+_iDateLength)
      sDate=emisPadl(sDate, 7+_iDateLength, "0");
    else if (sDate.length>7+_iDateLength)
      sDate=emisPadl(sDate.substr(0,4)-_iDateYear, 3+_iDateLength, "0") +
            sDate.substr(4,2) + sDate.substr(6,2);

    if ( "-"!="")
      sDate=sDate.substr(0,3+_iDateLength) +  "-" + sDate.substr(3+_iDateLength,2) +  "-" + sDate.substr(5+_iDateLength,2);
    return sDate;
  }
} // emisDate()

// 取得今天或传入日期之"年"的字串
// sDate: 传入之日期的字串, 不传预设为今天
function emisYear(sDate) {
  var _iDateYear  =bDateType_? 0: 1911;    // 是否为西元年格式
  var _iDateLength=bDateType_? 1: 0;       // 日期是否多加一位数
  if (emisEmpty(sDate))
    return emisPadl(new Date().getFullYear()-_iDateYear, 3+_iDateLength, "0");
  else {
    sDate=emisDate(sDate);
    return sDate.substr(0,3+_iDateLength);
  }
}

// 取得今天或传入日期之"月"的字串
// sDate: 传入之日期的字串, 不传预设为今天
function emisMonth(sDate) {
  var _iDateLength=bDateType_? 1: 0;       // 日期是否多加一位数
  if (bDateType_)
    sDate=emisDate(sDate, "/");
  else
    sDate=emisCtoa(emisDate(sDate), "/");
  return emisPadl(new Date(sDate).getMonth()+1, 2, "0");
}

// 取得今天或传入日期之"日"的字串
// sDate: 传入之日期的字串, 不传预设为今天
function emisDay(sDate) {
  var _iDateLength=bDateType_? 1: 0;       // 日期是否多加一位数
  if (bDateType_)
    sDate=emisDate(sDate, "/");
  else
    sDate=emisCtoa(emisDate(sDate), "/");
  return emisPadl(new Date(sDate).getDate(), 2, "0");
}

// 取得今天或传入日期之"星期"的字串
// sDate: 传入之日期的字串, 不传预设为今天
// lNum: 星期之格式, 不传预设为星期日、一..., 传值则为数值 0,1...
function emisWeek(sDate, lNum) {
  if (bDateType_)
    sDate=emisDate(sDate, "/");
  else
    sDate=emisCtoa(emisDate(sDate), "/");

  var _nDay = new Date(sDate).getDay();
  if (emisEmpty(lNum))
     return "星期" + "日一二三四五六".substr(_nDay, 1);
  else
    return _nDay;  // 星期日传回 "0"
}

 

 
// 加减 iMonth 月数后的年月
// sMonth: 传入之年月的字串, 不传预设为今天
// iDiff: 相加月数
// sSep: 日期格式分隔字, 不传预设为 ""
function emisMonthCal(sMonth, iMonth, sSep) {
  var _sSep = emisEmpty(sSep) ? sDateSepa_ : sSep;
  var _sDate =emisDate(emisEmpty(sMonth)?"": sMonth + _sSep + "01");
  var _iYear =emisYear(_sDate) -0 + parseInt(iMonth/12);
  var _iMonth=emisMonth(_sDate) - 0 + iMonth%12;

  if(_iMonth==0) {
    _iYear =_iYear - 1;
    _iMonth="12";
  }
  else if(_iMonth>12) {
    _iYear =_iYear + 1;
    _iMonth=_iMonth%12;
  }
  else if(_iMonth<0) {
    _iYear =_iYear - 1;
    _iMonth=12 + _iMonth%12;
  }

  var _iDateLength=bDateType_? 1: 0;       // 日期是否多加一位数
  return emisPadl(_iYear,3+_iDateLength,"0") + _sSep + emisPadl(_iMonth,2,"0");
}

// 加减 iMonth 月数后的日期
// sDate: 传入之日期的字串, 不传预设为今天
// iDiff: 相加月数
function emisMonthDiff(sDate, iMonth) {
  var _iYear =emisYear(sDate) -0 + parseInt(iMonth/12);
  var _iMonth=emisMonth(sDate) - 0 + iMonth%12;
  var _iDay  =emisDay(sDate);

  if(_iMonth==0) {
    _iYear =_iYear - 1;
    _iMonth="12";
  }
  else if(_iMonth>12) {
    _iYear =_iYear + 1;
    _iMonth=_iMonth%12;
  }
  else if(_iMonth<0) {
    _iYear =_iYear - 1;
    _iMonth=12 + _iMonth%12;
  }

  var _iDateLength=bDateType_? 1: 0;       // 日期是否多加一位数
  return emisDate(emisPadl(_iYear,3+_iDateLength,"0") + emisPadl(_iMonth,2,"0") + emisPadl(_iDay,2,"0"));
}

// 加减 iDiff 天数后的日期
// sDate: 传入之日期的字串, 不传预设为今天
// iDiff: 相加减天数
function emisDateDiff(sDate, iDiff) {
  var _sDate=sDate;
  if (bDateType_)
    _sDate=emisDate(sDate,"/");
  else
    _sDate=emisCtoa(sDate,"/");

  var _oDate=new Date(_sDate);
  var _iDiffSec=_oDate.getTime()+(24*60*60*1000*iDiff);
  var _oDiffDate=new Date();
  _oDiffDate.setTime(_iDiffSec);
  if (bDateType_)
    return emisDate(_oDiffDate.getFullYear() + emisPadl(_oDiffDate.getMonth()+1,2,"0") +
                    emisPadl(_oDiffDate.getDate(),2,"0"));
  else
    return emisAtoc(_oDiffDate.getFullYear() + emisPadl(_oDiffDate.getMonth()+1,2,"0") +
                    emisPadl(_oDiffDate.getDate(),2,"0"));
}

 
// 判断是否为空白
// xVaule:传入之任何形态值
function emisEmpty(xValue) {
  if (xValue == null || xValue == "null" || xValue == "undefined" || xValue == "NaN" || xValue == "")
    return true;
  return false;
}
 
// 判断日期是否为正确
// sDate: 传入之日期的字串
// sSep: 日期格式分隔字, 不传预设为 ""
function emisChkDate(sDate, sSep) {
  // 处理补 "0", 及 "/"
  //add by Ben 2005/03/30 防止输入‘2000103’可以通过。
  var tempDate_ = sDate.replace(/\D/g,"");
  if(bDateType_ && tempDate_.length!=8
    && tempDate_.length!=4 && tempDate_.length!=2){
    return false;
  }
  sDate=emisDate(sDate, sSep);

  // 强迫转型为西元格式, 且加 "/"
  var _sDate;
  if (bDateType_) {
    _sDate=emisDate(sDate, "/");
  } else {
    _sDate=emisCtoa(sDate,"/");
  }

  var _oDate=new Date(_sDate);
  _sDate=emisDate(_oDate.getFullYear() + emisPadl(_oDate.getMonth()+1,2,"0") +
                  emisPadl(_oDate.getDate(),2,"0"), sSep);

  // 判断日期与实际 Date() 传回是否相同, 相同则正确
  if (_sDate==sDate)
    return true;
  return false;
}

// 判断年月是否为正确
// sDate: 传入之日期的字串
// sSep: 日期格式分隔字, 不传预设为 ""
function emisChkMonth(sMonth, sSep) {
  var _sSep = emisEmpty(sSep) ? sDateSepa_ : sSep;
  return emisChkDate(sMonth+_sSep+"01", sSep)
}

 
 