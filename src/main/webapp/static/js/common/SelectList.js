var SelectList = {};
SelectList.singelSelect = function(eleName, attr, data) {
	var result = false;
	$("#" + eleName).find("a").each(function(i, d) {
		if ($(this).attr(attr) == data) {
			if ($(this).hasClass('active')) {
				$(this).removeClass('active');
			} else {
				$(this).addClass('active');
				result = true;
			}
		} else {
			$(this).removeClass('active');
		}
	});
	return result;
};

/**
 * 对当前项是否已选进行判断，当前项已选则改为未选且返回true，当前项已选则改为未选且返回false
 */
SelectList.mutiSelect = function(me) {
	me = $(me);
	if (me.hasClass("active")) {
		me.removeClass("active");
		return false;
	} else {
		me.addClass("active");
		return true;
	}
};
SelectList.clearSelect = function(eleName) {
	$("#" + eleName).find("a").each(function(i, d) {
		$(this).removeClass('active');
	});
};