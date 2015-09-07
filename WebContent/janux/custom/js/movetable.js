function moveUp(url, obj) {
	var current = $(obj).parent().parent();
	var prev = current.prev();
	if (current.index() >= 1) {
		var aftersequencecode = current.find("#sequence_code").text();
		current.find("#sequence_code").text(prev.find("#sequence_code").text());
		prev.find("#sequence_code").text(aftersequencecode);
		current.insertBefore(prev);
		var previd = prev.find("#id").text();
		var curid = current.find("#id").text();
		updateSequenceCode(url, previd, aftersequencecode);
		updateSequenceCode(url, curid, current.find("#sequence_code").text());
	}
}
function moveDown(url, obj) {
	var current = $(obj).parent().parent();
	var next = current.next();
	if (next) {
		var aftersequencecode = current.find("#sequence_code").text();
		current.find("#sequence_code").text(prev.find("#sequence_code").text());
		prev.find("#sequence_code").text(aftersequencecode);
		current.insertAfter(next);
		var previd = prev.find("#id").text();
		var curid = current.find("#id").text();
		updateSequenceCode(url, previd, aftersequencecode);
		updateSequenceCode(url, curid, current.find("#sequence_code").text());
	}
}