$(function() {
	$('#dashboard-menu li').click(function() {
		$(this).siblings().removeClass("active");
		$(this).addClass("active");
	});

});


$(window).scroll(function() {
	if ($(this).scrollTop() > 120) {
		
		$('#sidebar-nav').addClass('leftfixed');
		$('.content').css("margin-left","120px")
	} else {
		
	$('#sidebar-nav').removeClass('leftfixed');
	$('.content').remove("margin-left","120px")
	}
});