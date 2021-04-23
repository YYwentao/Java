jQuery.noConflict(); // 让渡 $ 的使用权，其他脚本库可以使用 $
(function($) {
$(document).ready(function() {
	var $formArea = $("ul.classlist").eq(2);
	var $commentInputs = $formArea.find(":input");
	var $commentArea = $formArea.prev("ul").children();

	$("#commentSubmit").click(function() {
		var paramsArray = $commentInputs.serializeArray();
		// console.log(paramsArray);
		var queryString = $.param(paramsArray);
		// console.log(queryString);
		$.post("util/news?opr=addComment", queryString, afterComment, "JSON");
		function afterComment(data) {
			if (data[0].result == "success") {
				var $newComment = $("<tr><td> 留言人： </td><td>cauthor</td>"
                    	+ "<td> IP： </td><td>cip</td>"
                    	+ "<td> 留言时间： </td><td>cdate</td></tr>"
                    	+ "<tr><td colspan=\"6\">ccontent</td></tr>"
                    	+ "<tr><td colspan=\"6\"><hr /></td></tr>");
                $(paramsArray).each(function() {
                	$newComment.find("td:contains('cdate')").text(data[0].cdate);
                	$newComment.find("td:contains('"+this.name+"')")
                				.text(this.value);
                }); 
                $commentArea.prepend($newComment);
			} else {
				alert(data[0].result);
			}
		}
	});
});
})(jQuery);