function tab_list(thisObj, n) {
		if (thisObj.className == "active openline")
			return;
		var tabList = document.getElementById("ul_style4")
				.getElementsByTagName("li");
		for (i = 0; i < tabList.length; i++) {
			if (i == n) {
				thisObj.className = "active openline";
				document.getElementById("list_data" + i).style.display = "block";
			} else {
				tabList[i].className = "normal";
				document.getElementById("list_data" + i).style.display = "none";
			}
		}
	}