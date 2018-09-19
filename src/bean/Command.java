package bean;

import java.util.List;

public class Command {
	private String id;
	private String name;
	private String description;
	private List<CommandContent> ContentList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//һ��ָ���Ӧ�Զ��ظ������б�
	public List<CommandContent> getContentList() {
		return ContentList;
	}

	public void setContentList(List<CommandContent> contentList) {
		ContentList = contentList;
	}
}
