package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import bean.Command;
import bean.CommandContent;
import bean.Message;
import dao.CommandDao;
import dao.MessageDao;
import entity.Page;
import util.Iconst;

public class QueryService {
	/**
	 * 查询相关的业务功能
	 */
	public List<Message> queryMessageList(String command,String description,Page page) {
		// 组织消息对象
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		MessageDao messageDao = new MessageDao();
		// 根据条件查询条数
		int totalNumber = messageDao.count(message);
		// 组织分页查询参数
		page.setTotalNumber(totalNumber);
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("message", message);
		parameter.put("page", page);
		// 分页查询并返回结果
		return messageDao.queryMessageList(parameter);
	}
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(String command,String description,Page page) {
		Map<String,Object> parameter = new HashMap<String, Object>();
		// 组织消息对象
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		parameter.put("message", message);
		parameter.put("page", page);
		MessageDao messageDao = new MessageDao();
		// 分页查询并返回结果
		return messageDao.queryMessageListByPage(parameter);
	}
	
	public String queryByCommand(String command) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList;
		if (Iconst.HELP_COMMAND.equals(command)) {
			commandList = commandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < commandList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList = commandDao.queryCommandList(command, null);

		if (commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0).getContentList();
			CommandContent commandContent = contentList.get(new Random().nextInt(contentList.size()));
			return commandContent.getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}

}
