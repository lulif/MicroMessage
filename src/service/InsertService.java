package service;

import java.util.ArrayList;
import java.util.List;

import bean.Command;
import bean.CommandContent;
import dao.CommandContentDao;
import dao.CommandDao;

public class InsertService {
	public void InsertCommandContent(String commandid, String[] content) {
		List<CommandContent> listCommandContent = new ArrayList<CommandContent>();

		for (String c : content) {
			CommandContent commandContent = new CommandContent();
			commandContent.setCommandId(Integer.valueOf(commandid));
			commandContent.setContent(c);
			listCommandContent.add(commandContent);
		}
		CommandContentDao commandContentDao = new CommandContentDao();
		commandContentDao.insertBatch(listCommandContent);
		
	}
	
	public void InsertCommand(String name,String description){
		Command command=new Command();
		command.setName(name);
		command.setDescription(description);
		CommandDao commandDao=new CommandDao();
		commandDao.insertCommand(command);
	} 

}
