function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}
function deleteBatch(basepath) {
	$("#mainForm").attr("action", basepath + "DeleteBatchServlet.action");
	$("#mainForm").submit();
}

function isSelect() {
	
	if (!$("input[type='checkbox']").is(':checked')) {		
		alert("请先勾选，再点击删除！");
		return false;
	} else {
		return confirm("确定删除勾选的信息?");
	}

}

