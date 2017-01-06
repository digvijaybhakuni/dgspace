(function($) {

	if (typeof (EventSource) !== "undefined") {

		function ListnerSse() {
			var ssevent = new EventSource("stream");
			ssevent.onmessage = function(event) {
				console.log(event);
			};
			ssevent.addEventListener('open', function(e) {
				console.log('connected');
			});

			ssevent.addEventListener('message', function(e) {
				$("#list").append("<li>" + e.data + "</li>");
			}, false);

			ssevent.addEventListener('error', function(e) {
				if (e.readyState == EventSource.CLOSED) {
					console.log("Error");
					ListnerSse();
				}
			}, false);
		}

		ListnerSse();
	} else {
		$("#result").text(
				"Sorry, your browser does not support server-sent events...");
	}

})(jQuery);
