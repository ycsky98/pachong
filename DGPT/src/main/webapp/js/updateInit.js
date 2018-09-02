$(function(){
	
	$.post("LoginUser",{},function(result){
		if(result.data!=null){
			$(".rightInfo span:eq(1) a").html("切换账号");
			$(".rightInfo span:eq(1) a").attr("href","login");
			$(".rightInfo span:eq(0)").html(result.data);
			findAjax(result.data);
		}
	});
	$("#update").click(function(){
		$.post("updateUser",{"id":$("#username").val(),"r_id":$("#r_id").val(),"email":$("#email").val(),"pwd":$("#pwd").val()},function(result){
			if(result.state==1){
				alert("修改成功");
			}
		});
	});
})

function findAjax(id){
	$.post("findUserById",{"id":id},function(result){
		if(result.state==1){
			$("#username").val(result.data.id);
			$("#r_id").val(result.data.r_id);
			if(result.data.r_id=="thr"){
				$("#role").val("教师");
			}
			if(result.data.r_id=="std"){
				$("#role").val("学生");
			}
			$("#email").val(result.data.email);
			$("#pwd").val(result.data.pwd);
		}
	});
}