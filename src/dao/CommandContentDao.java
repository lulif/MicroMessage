package dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.CommandContent;
import db.DbAccess;

public class CommandContentDao {
	/**
	 * ��������
	 */
	public void insertBatch(List<CommandContent> contentList) {
		DbAccess dbAccess = new DbAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// ͨ��sqlSessionִ��SQL���
			IMessage commandContent = sqlSession.getMapper(IMessage.class);
			commandContent.insertBatch(contentList);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}

