function updateSequenceCode(url,id, sequencecode) {
	$.post(url, {
		topic_id : id,
		topic_sequence_code : sequencecode
	});
}
