$(function(){

	$.post("LoginUser",{},function(result){
		if(result.data!=null){
			$(".rightInfo span:eq(1) a").html("切换账号");
			$(".rightInfo span:eq(1) a").attr("href","login");
			$(".rightInfo span:eq(0)").html(result.data);
		}
	});
})

//轮播图
$("#carouselMenu").carousel({
    interval: 5000,
    wrap: true
});
//图表
var ctx1 = document.getElementById("myChart_1");
var myPieChart = new Chart(ctx1,{
    type: 'pie',
    data: data = {
	    datasets: [{
	        data: [455, 285],
	        backgroundColor: [
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 99, 132, 0.2)'
            ],
            borderColor: [
                'rgba(54, 162, 235, 1)',
                'rgba(255,99,132,1)'
            ],
	    }],
	    labels: [
	        '专任教师',
	        '校外兼职教师',
	    ]
	},
    options: 100
});
var ctx2 = document.getElementById("myChart_2");
var myPieChart = new Chart(ctx2,{
    type: 'pie',
    data: data = {
	    datasets: [{
	        data: [90, 10],
	        backgroundColor: [
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 99, 132, 0.2)'
            ],
            borderColor: [
                'rgba(54, 162, 235, 1)',
                'rgba(255,99,132,1)'
            ],
	    }],
	    labels: [
	        '硕士及以上学位',
	        '其他学位',
	    ]
	},
    options: 100
});
var ctx3 = document.getElementById("myChart_3");
var myPieChart = new Chart(ctx3,{
    type: 'pie',
    data: data = {
	    datasets: [{
	        data: [71.64, 28.36],
	        backgroundColor: [
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 99, 132, 0.2)'
            ],
            borderColor: [
                'rgba(54, 162, 235, 1)',
                'rgba(255,99,132,1)'
            ],
	    }],
	    labels: [
	        '“双师”素质教师',
	        '其他教师',
	    ]
	},
    options: 100
});
var ctx4 = document.getElementById("myChart_4");
var myPieChart = new Chart(ctx4,{
    type: 'pie',
    data: data = {
	    datasets: [{
	        data: [51, 49],
	        backgroundColor: [
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 99, 132, 0.2)'
            ],
            borderColor: [
                'rgba(54, 162, 235, 1)',
                'rgba(255,99,132,1)'
            ],
	    }],
	    labels: [
	        '有行业企业经历',
	        '无行业企业经历',
	    ]
	},
    options: 100
});
//实习情况 多图轮播
var fieldwork_item_3d=[];//存放需要平移值
var fieldwork_item_size=$('.fieldwork_item_li').length;//获取有多少个需要平移的li项
var fieldwork_item_width;//获取父元素宽度来获得每个item的宽度
var fieldwork_item_i=0;//记录目前处于数组的哪个位置
getFieldworkItemWidth();
//响应式
function getFieldworkItemWidth(){
	fieldwork_item_3d=new Array();
	if($(document).width()>=1000){
		//默认显示4个
		fieldwork_item_width=$('.fieldwork_inner').width()*0.25;
		for(var i=0;i<Math.ceil(fieldwork_item_size)/4;i++){
			fieldwork_item_3d[i]=fieldwork_item_width*4*i;
		}
	}
	//屏幕小于1000显示3个
	if($(document).width()<1000 && $(document).width()>=650){
		fieldwork_item_width=$('.fieldwork_inner').width()*0.33;
		for(var i=0;i<Math.ceil(fieldwork_item_size)/3;i++){
			fieldwork_item_3d[i]=fieldwork_item_width*3*i;
		}
	}	
	//屏幕小于650显示2个	
	if($(document).width()<650 && $(document).width()>=400){
		fieldwork_item_width=$('.fieldwork_inner').width()*0.50;
		for(var i=0;i<Math.ceil(fieldwork_item_size)/2;i++){
			fieldwork_item_3d[i]=fieldwork_item_width*2*i;
		}
	}
	//屏幕小于400显示1个	
	if($(document).width()<420){
		fieldwork_item_width=$('.fieldwork_inner').width();
		for(var i=0;i<fieldwork_item_size;i++){
			fieldwork_item_3d[i]=fieldwork_item_width*i;
		}
	}				
}
//设置li宽度
$('.fieldwork_item_li').width(fieldwork_item_width);
//当窗口调整时，重新设置
$(window).resize(function(){
	$('.fieldwork_item_ul').css('transform','translate3d(0,0,0)');
	fieldwork_item_i=0;
	getFieldworkItemWidth();
	$('.fieldwork_item_li').width(fieldwork_item_width);
});
//每格几秒自动轮播
var fieldwork_time=window.setInterval(function(){
	fieldworkItemNext();
},3000);
$('.fieldwork_item_ul').mouseover(function(){
	window.clearInterval(fieldwork_time);
});
$('.fieldwork_item_ul').mouseout(function(){
	fieldwork_time=window.setInterval(function(){
		fieldworkItemNext();
	},3000);
});
function fieldworkItemNext(){
	fieldwork_item_i++;
	if(fieldwork_item_i+1>fieldwork_item_3d.length){
		fieldwork_item_i=0;
	}
	$('.fieldwork_item_ul').css('transform','translate3d(-'+fieldwork_item_3d[fieldwork_item_i]+'px,0,0)');
}
function fieldworkItemPrev(){
	if(fieldwork_item_i<=0){
		fieldwork_item_i=fieldwork_item_3d.length-1;
	}else{
		fieldwork_item_i--;	
	}
	$('.fieldwork_item_ul').css('transform','translate3d(-'+fieldwork_item_3d[fieldwork_item_i]+'px,0,0)');			
}
//按钮
$('.fieldwork_prev').click(function(){
	fieldworkItemNext();
});
$('.fieldwork_next').click(function(){
	fieldworkItemPrev();
});

//获奖情况 多图轮播
var awards_item_3d=[];//存放需要平移值
var awards_item_size=$('.awardsItemBox .awards_item_li').length;
var awards_item_width;//获取父元素宽度来获得每个item的宽度
var awards_item_i=0;//记录目前处于数组的哪个位置
getAwardsItemWidth();
//响应式
function getAwardsItemWidth(){
	awards_item_3d=new Array();
	if($(document).width()>=1000){
		//默认显示4个
		awards_item_width=$('.awardsItemBox').width()*0.25;
		for(var i=0;i<Math.ceil(awards_item_size)/4;i++){
			awards_item_3d[i]=awards_item_width*4*i;
		}
	}
	//屏幕小于1000显示3个
	if($(document).width()<1000 && $(document).width()>=650){
		awards_item_width=$('.awardsItemBox').width()*0.33;
		for(var i=0;i<Math.ceil(awards_item_size)/3;i++){
			awards_item_3d[i]=awards_item_width*3*i;
		}
	}	
	//屏幕小于650显示2个	
	if($(document).width()<650 && $(document).width()>=400){
		awards_item_width=$('.awardsItemBox').width()*0.50;
		for(var i=0;i<Math.ceil(awards_item_size)/2;i++){
			awards_item_3d[i]=awards_item_width*2*i;
		}
	}
	//屏幕小于400显示1个	
	if($(document).width()<417){
		awards_item_width=$('.awardsItemBox').width();
		for(var i=0;i<awards_item_size;i++){
			awards_item_3d[i]=awards_item_width*i;
		}
	}	
	$('.awards_item_li').width(awards_item_width);			
}

$(window).resize(function(){
	getAwardsItemWidth();
	awards_item_i=0;
	$('.awards_item_ul').css('transform','translate3d(0,0,0)');
});

//每隔几秒自动轮播
var awards_time=window.setInterval(function(){
	getAwardsItemNext()
},3000);
$('.awardsItemBox').mouseover(function(){
	window.clearInterval(awards_time);
});
$('.awardsItemBox').mouseout(function(){
	awards_time=window.setInterval(function(){
		getAwardsItemNext();
	},3000);
});
function getAwardsItemNext(){
	awards_item_i++;
	if(awards_item_i+1>awards_item_3d.length){
		awards_item_i=0;
	}
	$('.awards_item_ul').css('transform','translate3d(-'+awards_item_3d[awards_item_i]+'px,0,0)');
}
function getAwardsItemPrev(){
	if(awards_item_i<=0){
		awards_item_i=awards_item_3d.length-1;
	}else{
		awards_item_i--;	
	}
	$('.awards_item_ul').css('transform','translate3d(-'+awards_item_3d[awards_item_i]+'px,0,0)');			
}
//按钮
$('.awards_prev').click(function(){
	getAwardsItemPrev();
});
$('.awards_next').click(function(){
	getAwardsItemNext();
});	
//点击图片放大
$('[data-fancybox="school_lib_img"]').fancybox({
	selector : '[data-fancybox="school_lib_img"]',
    loop     : true
});
$('[data-fancybox="awards_img"]').fancybox({
	selector : '[data-fancybox="awards_img"]',
    loop     : true
});
$('[data-fancybox="design_img"]').fancybox({
	selector : '[data-fancybox="design_img"]',
    loop     : true
});
