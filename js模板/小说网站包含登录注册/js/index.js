

	//鼠标导航滑块跟随效果
	$("#Logo ul li").not(".first,.last").hover(function(){
		//移上去
		var _left=$(this).position().left; //li与 ul左边的距离
		var _width=$(this).width(); //获取 li宽度
		$("#Logo ul li.last").show().css("width",_width).stop().animate({left:_left},300);
	},function(){
		//移开
		$("#Logo ul li.last").hide();
		//$("#Logo ul li.last").css("width","78px").stop().animate({left:"190px"},300);
	});
	


	//左侧二级悬浮菜单
	$(".Menu ul li").hover(function(){
		$(this).addClass("hover");
		var _index=$(this).index();
		var _top=$(this).position().top;
		var _height=$(this).find(".moreNav").height()/3;
		//document.title=_top +"--"+_height;
			
		if(_top>_height){//当高度大于 1/3时
			
			if(_index==5){ //当序列号为 5 最后一个
				$(this).find(".moreNav").css("bottom","0px");
			}else{
				$(this).find(".moreNav").css("top","-"+_height+"px");	
			}
	
		}else{

			$(this).find(".moreNav").css("top","-1px");
		}
	},function(){
		$(this).removeClass("hover");
	});


/*首页轮播图特效*/
var _index=0;
var _qindex=0;
var clearTime=null;

var ktime=new Date();//获取当前时间
$(".But span").mouseover(function(){
	clearInterval(clearTime);
	_index=$(this).index();//获取序列号
	scrollPlay();//调用播放方法
	_qindex=_index;//把当前的值赋作为下一次的前一个序列号
	
}).mouseout(function(){
	autoPlay();
});

//右切换按扭
$(".flash a.next").click(function(){
	var newtime=new Date();
	
	if(newtime-ktime>300){
		_index++;//序列号加1 
		if(_index>6){
			_index=0;
			_qindex=6;
		}
		scrollPlay();
		_qindex=_index;

	}
	ktime=new Date();//重新设置时间

});

$(".flash a.prev").click(function(){

	_index--;
	if(_index<0){
		_qindex=0;
		_index=6;
	}
		scrollPlay();
	_qindex=_index;
});



$("a.next,a.prev").hover(function(){
	clearInterval(clearTime);
},function(){
	autoPlay();
});

autoPlay();
//自动轮播
function autoPlay(){
	clearTime=setInterval(function(){
		_index++;//序列号加1 

		if(_index>6){
			_index=0;
			_qindex=6;
		}
		scrollPlay();
		_qindex=_index;

	},2000);
	

}


function scrollPlay(){
	$(".But span").eq(_index).addClass("hover").siblings("span").removeClass("hover");
	if(_index==0 && _qindex==6){
		next();
	}else if(_index==6 && _qindex==0){
		prev();
	}else if(_index>_qindex){//左移
		next();
	}else if(_index<_qindex){//往右移
		prev();
	}

}

//下一张，左移
function next(){
		$(".scroll img").eq(_qindex).animate({"left":"-820px"},300);
		$(".scroll img").eq(_index).css("left","820px").animate({"left":"0px"},300);

};

//上一张 ，右移
function prev(){
		$(".scroll img").eq(_qindex).animate({"left":"820px"},300);
		$(".scroll img").eq(_index).css("left","-820px").animate({"left":"0px"},300);
}
//按扭显示隐藏
$(".flash").hover(function(){
	//显示
	$("a.prev,a.next").show();
},function(){
	//隐藏
	$("a.prev,a.next").hide();
});
function setTab(name,cursel){
	cursel_0=cursel;
	for(var i=1; i<=links_len; i++){
		var menu = document.getElementById(name+i);
		var menudiv = document.getElementById("con_"+name+"_"+i);
		if(i==cursel){
			menu.className="off";
			menudiv.style.display="block";
		}
		else{
			menu.className="";
			menudiv.style.display="none";
		}
	}
}
