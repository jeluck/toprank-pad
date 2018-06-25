
function initCalculator(){
	  //html布局封装
	  var calculator='<ul class="show_num">' +
	      '<li>' +
	      '<button class="calc_int" value="1" >1</button>' +
	      '<button class="calc_int" value="2" >2</button>' +
	      '<button class="calc_int" value="3" >3</button>' +
	      '<button class="calc_int" value="4" >4</button>' +
	      '</li>' +
	      '<li>' +
	      '<button class="calc_int" value="5" >5</button>' +
	      '<button class="calc_int" value="6" >6</button>' +
	      '<button class="calc_int" value="7" >7</button>' +
	      '<button class="calc_int" value="8" >8</button>' +
	      '</li>' +
	      '<li>' +
	      '<button class="calc_int" value="9" >9</button>' +
	      '<button class="calc_int" value="0" >0</button>' +
	      '<button class="calc_int" value="." >.</button>' +
	      '<button class="calc_back" value="&larr;" >&larr;</button>' +
	      '</li>' +
	      '</ul>';

	  $('.calculator').html(calculator);
	  
 
	  
	}
	initCalculator();
  
  
  
  

	
	
//含中文
  var calculator_t='<ul class="show_num_t">' +
      '<li>' +
      '<button class="calc_int" value="1" >1</button>' +
      '<button class="calc_int" value="2" >2</button>' +
      '<button class="calc_int" value="3" >3</button>' +
      '</li>' +
      '<li>' +
      '<button class="calc_int" value="4" >4</button>' +
      '<button class="calc_int" value="5" >5</button>' +
      '<button class="calc_int" value="6" >6</button>' +
      '</li>' +
      '<li>' +
      '<button class="calc_int" value="7" >7</button>' +
      '<button class="calc_int" value="8" >8</button>' +
      '<button class="calc_int" value="9" >9</button>' +
      '</li>' +
      '<li>' +
      '<button class="calc_back" value="回删" >回删</button>' +
      '<button class="calc_int" value="0" >0</button>' +
      '<button   value="确定" class="sh_ckt">确定</button>' +
      '</li>' +
      '</ul>';

  $('.calculator_t').append(calculator_t);



//html布局封装
  var calculator_xin='<ul class="show_num_xin">' +
      '<li>' +
      '<button class="calc_int" value="1" >1</button>' +
      '<button class="calc_int" value="2" >2</button>' +
      '<button class="calc_int" value="3" >3</button>' +
      '<button class="calc_int" value="4" >4</button>' +
      '</li>' +
      '<li>' +
      '<button class="calc_int" value="5" >5</button>' +
      '<button class="calc_int" value="6" >6</button>' +
      '<button class="calc_int" value="7" >7</button>' +
      '<button class="calc_int" value="8" >8</button>' +
      '</li>' +
      '<li>' +
      '<button class="calc_int" value="9" >9</button>' +
      '<button class="calc_int" value="0" >0</button>' +
      '<button class="calc_back" value="&larr;" style="width:50%" >&larr;</button>' +
      '</li>' +
      '</ul>';

  $('.calculator_xin').append(calculator_xin);


//html布局封装
  var calculator_xin2='<ul class="show_num_xin">' +
      '<li>' +
      '<button class="calc_int" value="1" >1</button>' +
      '<button class="calc_int" value="2" >2</button>' +
      '<button class="calc_int" value="3" >3</button>' +
      '<button class="calc_int" value="4" >4</button>' +
      '</li>' +
      '<li>' +
      '<button class="calc_int" value="5" >5</button>' +
      '<button class="calc_int" value="6" >6</button>' +
      '<button class="calc_int" value="7" >7</button>' +
      '<button class="calc_int" value="8" >8</button>' +
      '</li>' +
      '<li>' +
      '<button class="calc_int" value="9" >9</button>' +
      '<button class="calc_int" value="0" >0</button>' +
      '<button class="calc_int" value="." >.</button>' +
      '<button class="calc_back" value="&larr;"   >&larr;</button>' +
      '</li>' +
      '</ul>';

  $('.calculator_xin2').append(calculator_xin2);








  /*
   ** global vars
   */

  var a = 0,
      b = 0,
      is_a = true,
      is_b = false,
      o = 'nil',
      answer = 0,
      first_a = true,
      first_b = true,
      is_submission = false,
      soft_sub = false,
      display = jQuery('.total');



  /*
   ** tool functions
   */
  display.click(function(event){
    display.each(function(index,el){
      $(this).removeClass("on")

    })
    $(this).addClass("on")
  })

// 改变值
  function changeDisplayVal(i) {
    $(".on").val($(".on").val() + i);
  }
// make * into ×
  function  visOps(x) {
    if ( x === '*' ) {
      // return 'u00D7';
      return '×';
    } else if ( x === '/' ) {
      // return 'u00F7';
      return '÷';
    } else {
      return x;
    }
  }


// 设置值
  function setDisplayVal(x) {
    $(".on").val(visOps(x))

  }

// 设置值
  function set_a(i) {
    if ( is_a ) {
      // 如果一个重复的十进制
      if ( i === '.' && a.toString().indexOf('.') !== -1 ) {
//    write('Duplicate Decimal');
        i = '';
      } else if ( i === '.' && first_a ) {
        i = '0.';
      }
      // first_a时间，我们需要清楚的显示
      if ( first_a === true ) {
        if ( i === '0' ) {
          i = '';
        } else {
          // set display value
          setDisplayVal(i);
          // no longer first_a
          first_a = false;
        }
      } else {
        // add int to current display value
        changeDisplayVal(i);
      }

      a = display.val();

//  write('Set "a" to ' + a);
    }
  }




// 回删值发生变化
  function backspace() {
    if ( $(".on").val() !== '' && $(".on").val() !== '0' ) {
      $(".on").val( $(".on").val().substring(0, $(".on").val().length - 1) );
      if ( is_a === true ) {
        a = parseFloat(a.toString().substring(0, a.toString().length - 1 ));
      } else {
        b = parseFloat(b.toString().substring(0, b.toString().length - 1 ));
      }
    } else {
//  write('Nothing Left to Backspace');
    }
  }









//点击数字和小数点的点击事件
  $(".calc_int").click(function(){
//  $("body").on("click",".calc_int",function(){
	  var value = jQuery(this).val();
      if ( is_submission === false ) {
        if ( is_a === true ) {
          set_a(value);
        }
      } else {
        reset_calc();
        set_a(value);
      }
  });
 

// 回删
  jQuery('.calc_back').click(function() {

    backspace();
  });


  jQuery('.calc_c').click(function(){
    reset_calc();
  })




  //重置计算器
  function reset_calc() {
    a = 0;
    b = 0;
    o = 'nil';
    answer = 0;
    is_a = true;
    is_b = false;
    first_a = true;
    first_b = true;
    is_submission = false;
    soft_sub = false;

    $(".display .on").val(0);

    // reset display value
    setDisplayVal(0);

//write('Calculator Reset');
  }

  
  
  
  