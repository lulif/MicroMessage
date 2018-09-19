package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Message;
import db.DbAccess;

//和message表相关的数据库操作
public class MessageDao {
	
//	// mybatis根据查询条件查询消息列表
//	public List<Message> queryMessageList(String command, String description) {
//		List<Message> messageList = new ArrayList<Message>();
//		Message message = new Message();
//		message.setCommand(command);
//		message.setDescription(description);
//		DbAccess dbAccess = new DbAccess();
//		SqlSession sqlSession = null;
//		try {
//			sqlSession = dbAccess.getSqlSession();
//			messageList = sqlSession.selectList("Message.queryMessageList", message);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//		return messageList;
//	}
	
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(Map<String,Object> parameter) {
		DbAccess dbAccess = new DbAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageList(parameter);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter) {
		DbAccess dbAccess = new DbAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageListByPage(parameter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}

	
	//单行删除
		public void deleteOne(int i) {
			DbAccess dbAccess = new DbAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				sqlSession.delete("dao.IMessage.deleteOne", i);
				//mybatis对其封装过了不加会删除失败
				sqlSession.commit();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}

			}
		}
		
		//批量删除
		public void deleteBatch(List<Integer> ids) {
			DbAccess dbAccess = new DbAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				sqlSession.delete("dao.IMessage.deleteBatch",ids);
				sqlSession.commit();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}

			}
			
		}
		
		/**
		 * 根据查询条件查询消息列表的条数
		 */
		public int count(Message message) {
			DbAccess dbAccess = new DbAccess();
			SqlSession sqlSession = null;
			int result = 0;
			try {
				sqlSession = dbAccess.getSqlSession();
				// 通过sqlSession执行SQL语句
				IMessage imessage = sqlSession.getMapper(IMessage.class);
				result = imessage.count(message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(sqlSession != null) {
					sqlSession.close();
				}
			}
			return result;
		}
	// jdbc根据查询条件查询消息列表
	// public List<Message> queryMessageList(String command, String description) {
	// List<Message> messageList = new ArrayList<Message>();
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mriomessage",
	// "root",
	// "llf952634");
	// StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT
	// from message where 1=1");
	// List<String> paramList = new ArrayList<String>();
	// if (command != null && !"".equals(command.trim())) {
	// sql.append(" and COMMAND=?");
	// paramList.add(command);
	// }
	// if (description != null && !"".equals(description.trim())) {
	// sql.append(" and DESCRIPTION like '%' ? '%'");
	// paramList.add(description);
	// }
	// PreparedStatement statement = (PreparedStatement)
	// conn.prepareStatement(sql.toString());
	// for (int i = 0; i < paramList.size(); i++) {
	// statement.setString(i + 1, paramList.get(i));
	// }
	// ResultSet rs = statement.executeQuery();
	//
	// while (rs.next()) {
	// Message message = new Message();
	// message.setId(rs.getString("ID"));
	// message.setCommand(rs.getString("COMMAND"));
	// message.setDescription(rs.getString("DESCRIPTION"));
	// message.setContent(rs.getString("CONTENT"));
	// messageList.add(message);
	// }
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return messageList;
	//
	// }

}
