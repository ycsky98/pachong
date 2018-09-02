// 验证码
var verifyCode = new GVerify("v_container");
var login_form=document.querySelector('.loginForm');
var login_btn=document.querySelectorAll('.login_item');
var res;   
login_form.onsubmit=function(){ 
    res = verifyCode.validate(document.getElementById("code_input").value);  
    if(res)
    {
        $.post("checkRole",{"username":$("#username").val(),"pwd":$("#pwd").val()},function(result){
        	if(result.state==1){
        		window.location.href="index";
        	}else{
        		alert(result.message);
        	}
        });
        return false;
    }else{
        alert("验证码错误");
        return false;
    }
}
$('input:eq(0)').keydown(function(){
    $('.login_passIcon:eq(0)').css('color','#fff');
    if($(this).css('color')=='rgb(1, 1, 1)'){
        $('.login_passIcon:eq(0)').css('color','#fff');
    }
});
$('input:eq(0)').keyup(function(){
    console.log($(this).css('color'));
    if($(this).css('color')!='rgb(1, 1, 1)'){
        $('.login_passIcon:eq(0)').css('color','#000');
    }
});
