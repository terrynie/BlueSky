$(function() {
	$('.list_ul ul li').click(function() {
		$(this).addClass("openline");
		$(this).siblings().removeClass("openline");
	});
})