package service;

import java.util.ArrayList;
import java.util.List;

import dao.MessageDao;

//ά�����ҵ����
public class DeleteService {
	public MessageDao messagedao = new MessageDao();
	// ����ɾ��
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			messagedao.deleteOne(Integer.valueOf(id));
		}
	}
	//����ɾ��
	public void deleteBatch(String[] ids) {
		List<Integer> idList=new ArrayList<Integer>();
		for(String id:ids) {
			idList.add(Integer.valueOf(id));
		}
		messagedao.deleteBatch(idList);
	}

}
