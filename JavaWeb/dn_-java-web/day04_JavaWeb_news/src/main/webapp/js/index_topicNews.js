jQuery.noConflict(); // 让渡 $ 的使用权，其他脚本库可以使用 $
//var getPati;
(function($) {
$(document).ready(function() {
	// 显示新闻列表的首页中心区域
	var $centerNewsList = $("#container .main .content .classlist");
	// 主题列表区域
	var $topicsList = $centerNewsList.prev("ul.class_date");
	// 左侧最新消息栏
	var $latestNewsList = $("#container .sidebar");
	
	function pagi(datas) { // 分页查询的回调函数
		var tid = datas.tid == "null" ? "" : datas.tid;
		var currPageNo = datas.index;
		var totalPageCount = datas.totalPageCount;
		// 获得分页相关数据
		var data = datas.newsList;


		$centerNewsList.html("");
		if (data == null)
			$centerNewsList.html("<h6>出现错误，请稍后再试或与管理员联系</h6>");
		else if (data.length == 0)
			$centerNewsList.html("<h6>抱歉，没有找到相关的新闻</h6>");
		else {
			var news;

			for(var i = 0; i < data.length;) {
				news = data[i];

				$centerNewsList.append(
						"<li><a href='util/news?opr=readNew&nid="
						+ news.nid + "'>" + news.ntitle + "</a><span>"
						+ news.ncreateDate + "</span></li>");
				if ((++i) % 5 == 0)
					$centerNewsList.append("<li class='space'></li>");
			}
		}


		var $operArea = $("<p align=\"center\"> 当前页数:[" + currPageNo
						  + "/" + totalPageCount + "]&nbsp;</p>")
						.appendTo($centerNewsList);

		if (currPageNo > 1) {
			var $first = $("<a href=\"javascript:;\">首页</a>").click(
					function() { getPagi(tid, 1); });
			var $prev = $("<a href=\"javascript:;\">上一页</a>").click(
					function() { getPagi(tid, (currPageNo - 1)); });
			$operArea.append($first).append("&nbsp;").append($prev);
		}
		if (currPageNo < totalPageCount) {
			var $next = $("<a href=\"javascript:;\">下一页</a>").click(
					function() { getPagi(tid, (currPageNo + 1)); });
			var $last = $("<a href=\"javascript:;\">末页</a>").click(
					function() { getPagi(tid, totalPageCount); });
			$operArea.append($next).append("&nbsp;").append($last);
		}
	} // end of pagi()
	
	function getPagi(tid, pageIndex) { // 发送Ajax请求实现分页
		var data = "name=topicNews"; // 准备请求参数
		if (tid)
			data += "&tid="+tid;
		if (pageIndex && pageIndex > 0)
			data += "&pageIndex="+pageIndex;
		$.getJSON("/news", data, pagi); // 发送Ajax请求
	};
	
	function getTopicLatest() { // 初始化左侧最新消息栏目
		$latestNewsList.empty().load("/news", "name=topicLatest");
	}
	
	function getAllTopics() {
		$.getJSON("/news", "name=topiclist", function(data) {
			// 生成新闻主题链接
			var $oneLineTopics;
			$(data).each(function (i) {
				if (i % 11 == 0)
					$oneLineTopics = $("<li id='class_month'></li>").appendTo($topicsList);
				$oneLineTopics.append("<a href=\"javascript:;\" id=\""+this.tid+"\"><b>"+this.tname+"</b></a>");
			});
			// 为新闻主题链接注册点击事件
			$topicsList.find("a").each(function() {
				var a = this;
				a.onclick = function() { getPagi(a.id, 1); };
			});
		});
	}
	
	getTopicLatest(); // 首页加载时，初始化左侧最新消息
	getAllTopics(); // 首页加载时，初始化所有新闻主题链接
	getPagi(); // 首页加载时，初始化加载新闻列表

});
})(jQuery);