$('input:eq(0)').keydown(function(){
	//判断是否按了tab键
    var keynum = (event.keyCode ? event.keyCode : event.which);    
    if(keynum == '9'){            
    }else{
    	 $('.login_passIcon:eq(0)').css('color','#fff');
    } 
    if($(this).css('color')=='rgb(1, 1, 1)'){
        $('.login_passIcon:eq(0)').css('color','#fff');
    }
});
$('input:eq(0)').keyup(function(){
    if($(this).css('color')!='rgb(1, 1, 1)'){
        $('.login_passIcon:eq(0)').css('color','#000');
    }
});
$('input:eq(1)').keydown(function(){
    var keynum = (event.keyCode ? event.keyCode : event.which);    
    if(keynum == '9'){            
    }else{
    	 $('.login_passIcon:eq(1)').css('color','#fff');
    } 
    if($(this).css('color')=='rgb(1, 1, 1)'){
        $('.login_passIcon:eq(1)').css('color','#fff');
    }
});
$('input:eq(1)').keyup(function(){
    if($(this).css('color')!='rgb(1, 1, 1)'){
        $('.login_passIcon:eq(1)').css('color','#000');
    }
});
$('input:eq(2)').keydown(function(){
    var keynum = (event.keyCode ? event.keyCode : event.which);    
    if(keynum == '9'){            
    }else{
    	 $('.login_passIcon:eq(2)').css('color','#fff');
    } 
    if($(this).val()!=$('input:eq(1)').val()){
        $('.login_passIcon:eq(2)').css('color','#fff');
    }
});
$('input:eq(2)').keyup(function(){
    if($(this).val()==$('input:eq(1)').val()){
        $('.login_passIcon:eq(2)').css('color','#000');
    }
});
$('input:eq(3)').keydown(function(){
    var keynum = (event.keyCode ? event.keyCode : event.which);    
    if(keynum == '9'){            
    }else{
    	 $('.login_passIcon:eq(3)').css('color','#fff');
    } 
    if($(this).css('color')=='rgb(1, 1, 1)'){
        $('.login_passIcon:eq(3)').css('color','#fff');
    }
});
$('input:eq(3)').keyup(function(){
    if($(this).css('color')!='rgb(1, 1, 1)'){
        $('.login_passIcon:eq(3)').css('color','#000');
    }
});
//点击按钮
$('.loginForm').submit(function(){
	if($('input:eq(2)').val()!=$('input:eq(1)').val() || $('input:eq(2)').val()==""){
		alert("密码不一致");
		return false;
	}else{
		var params = {"id":$("#username").val(),"pwd":$("#pwd").val(),"r_id":$("#ch").val(),"email":$("#email").val()};
		console.log(params);
		$.ajax({
			url:"insertUser",
			type:"post",
			data:params,
			success:function(result){
				if(result.state==1){
					window.location.href="login";
					return false;
				}else{
					alert(result.message);
					return false;
				}
			}
		})
	}
	return false;
});