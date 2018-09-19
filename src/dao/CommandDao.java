package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Command;
import db.DbAccess;

//与指令表对应的数据库操作一对多
public class CommandDao {
	public List<Command> queryCommandList(String name, String description) {
		List<Command> commandList = new ArrayList<Command>();
		Command command = new Command();
		command.setName(name);
		command.setDescription(description);
		DbAccess dbAccess = new DbAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			commandList = sqlSession.selectList("dao.ICommand.queryCommandList", command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
    //新增指令
	public void insertCommand(Command command) {
		DbAccess dbAccess = new DbAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			ICommand com = sqlSession.getMapper(ICommand.class);
			com.insertCommand(command);
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
