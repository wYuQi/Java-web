var mainHeight = 0;
$(function(){
	$("#main_ifrm").load(function() {
		mainHeight = document.documentElement.clientHeight - parseInt($(".head_bj").css("height")) - 30;
		$("#main_ifrm").css("height", mainHeight + "px");
	});
	
	$(".nav_2, .nav_1").mouseover(function() {
		$(".nav_layer").hide();
		$(this).parent().find(".nav_layer").show();
		$(".nav_sh").attr("class", "nav_2 nav_sh");
		$(".nav_sh[name='first']").attr("class", "nav_1 nav_sh");
		if (this.name == "first") {
			this.className = "nav_1_hover nav_sh";
		} else {
			this.className = "nav_2_hover nav_sh";
		}
	});
	$("#main_ifrm, .head_1").mouseover(function() {
		$(".nav_layer").hide();
		$(".nav_sh").attr("class", "nav_2 nav_sh");
		$(".nav_sh[name='first']").attr("class", "nav_1 nav_sh");
	});
});