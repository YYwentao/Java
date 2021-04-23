jQuery.noConflict(); // 让渡 $ 的使用权，其他脚本库可以使用 $
(function($) {
$(document).ready(function() {
	var $optArea = $("#opt_area");

	function initNews() {//使用Ajax技术获取新闻列表数据
		$optArea.load("../util/news", "opr=listHtml");
	}
	initNews();//执行新闻列表初始化工作

	function initTopics() {//使用Ajax技术获取主题列表数据
		$optArea.load("../util/topics", "opr=listHtml");
	}
	
	var $leftLinks = $("#opt_list a"); // 获取页面左侧功能链接
	$leftLinks.eq(3).click(initTopics);
	$leftLinks.eq(1).click(initNews);
	$leftLinks.eq(2).click(function() {
		$optArea.load("../newspages/topic_add.jsp #opt_area>*");
	});
	
	var $msg = $("#msg");
	
	$optArea.on("click", "#addTopicSubmit", function() {
		var $tname = $optArea.find("#tname");
		var tnameValue = $tname.val();
		if (tnameValue == "") {
			$msg.html("请输入主题名称！").fadeIn(1000).fadeOut(5000);
			$tname.focus();
			return false;
		}
		$.getJSON("../util/topics", "opr=add&tname="+tnameValue, afterTopicAdd);
		function afterTopicAdd(data) {
			if (data[0].status == "success") {
				$msg.html(data[0].message).fadeIn(1000).fadeOut(5000);
				$optArea.load("../util/topics", "opr=listHtml");
			} else if (data[0].status == "exist") {
				$msg.html(data[0].message).fadeIn(1000).fadeOut(5000);
				$tname.select();
			} else if (data[0].status == "error") {
				$msg.html(data[0].message).fadeIn(1000).fadeOut(5000);
				$optArea.load("../util/topics", "opr=listHtml");
			}
		}
	});
	
	$optArea.on("click", "#topicsList>li .tpsMdfLink", function() {
		var params = this.id.split(":");
		$optArea.load("../newspages/topic_modify.jsp #opt_area>*",
				"tid=" + params[0] + "&tname=" + params[1]);
	});
	
	$optArea.on("click", "#updateTopicSubmit", function() {
		var $tname = $optArea.find("#tname");
		var tnameValue = $tname.val();
		if (tnameValue == "") {
			$msg.html("请输入主题名称！").fadeIn(1000).fadeOut(5000);
			$tname.focus();
			return false;
		}
		var tidValue = $optArea.find("#tid").val();
		$.getJSON("../util/topics", "opr=update&tid=" + tidValue
				+ "&tname=" + tnameValue, afterTopicUpdate);
		function afterTopicUpdate(data) {
			if (data[0].status == "success") {
				$msg.html(data[0].message).fadeIn(1000).fadeOut(5000);
				$optArea.load("../util/topics", "opr=listHtml");
			} else if (data[0].status == "exist") {
				$msg.html(data[0].message).fadeIn(1000).fadeOut(5000);
				$tname.select();
			} else if (data[0].status == "error") {
				$msg.html(data[0].message).fadeIn(1000).fadeOut(5000);
				$optArea.load("../util/topics", "opr=listHtml");
			}
		}
	});
	
	$optArea.on("click", "#topicsList>li .tpsDelLink", function() {
		if (confirm("确定要删除该主题吗？")) {
			var a = this;
			$.getJSON("../util/topics", "opr=del&tid="+this.id, function(data) {
				$msg.html(data[0].message).fadeIn(1000).fadeOut(5000);
				if (data[0].status == "success")
					$(a).parent().remove();
			});
		}
	});
	/*
	function initNews() {//使用Ajax技术获取新闻列表数据
		$.getJSON("../util/news", "opr=list", processNewsList);
	}
	function processNewsList(data) {//展示新闻列表
		var $newsList = $("#opt_area>ul").empty();
		for (var i = 0; i < data.length;) {
			$newsList.append("<li>" + data[i].ntitle + "<span> 作者："
					+ data[i].nauthor + " &#160;&#160;&#160;&#160; "
					+ "<a href='#'>修改</a> &#160;&#160;&#160;&#160; "
					+ "<a href='#' onclick='return clickdel()'>删除</a>" 
					+ "</span></li>");
			if ((++i) % 5 == 0) {
				$newsList.append("<li class='space'></li>");
			}
		}
	}
	*/
	/*
	function initTopics() {//使用Ajax技术获取主题列表数据
		$.getJSON("../util/topics", "opr=list", processTopicsList);
	}
	function processTopicsList(data) {//展示主题列表
		var $topicsList = $("#opt_area>ul").empty();
		for (var i = 0; i < data.length; ++i) {
			$topicsList.append("<li> &#160;&#160;&#160;&#160; "
					+ data[i].tname + " &#160;&#160;&#160;&#160; "
					+ "<a href='../newspages/topic_modify.jsp?tid="
					+ data[i].tid + "&tname=" + data[i].tname + "'>修改</a>"
					+ " &#160;&#160;&#160;&#160; <a href='../util/topics?opr=del&tid="
					+ data[i].tid + "'>删除</a> </li>");
		}
	}
	*/
});
})(jQuery);