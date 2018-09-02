$(function(){
	$.post("LoginUser",{},function(result){
		if(result.data!=null){
			$(".rightInfo span:eq(1) a").html("切换账号");
			$(".rightInfo span:eq(1) a").attr("href","login");
			$(".rightInfo span:eq(0)").html(result.data);
			findAjax(result.data);
		}
	});
})