
//汉堡按钮菜单
$('.menuBtn').click(function(){
	if($('.menu').css('opacity')==1){
		$('.menu').css('opacity','0');
		$('.menu').css('transform','translateY(10px)');
		$('.menu').css('z-index','-1');
	}else{
		$('.menu').css('z-index','100');
		$('.menu').css('opacity','1');
		$('.menu').css('transform','translateY(0px)');
	}
}); 