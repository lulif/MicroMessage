package service;

import java.util.ArrayList;
import java.util.List;

import dao.MessageDao;

//维护相关业务功能
public class DeleteService {
	public MessageDao messagedao = new MessageDao();
	// 单条删除
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			messagedao.deleteOne(Integer.valueOf(id));
		}
	}
	//批量删除
	public void deleteBatch(String[] ids) {
		List<Integer> idList=new ArrayList<Integer>();
		for(String id:ids) {
			idList.add(Integer.valueOf(id));
		}
		messagedao.deleteBatch(idList);
	}

}
