package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.InsertService;

public class InsertActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertActionServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String addCommand = request.getParameter("addcommand");
		String addDescription = request.getParameter("adddescription");
		String[] addContent = request.getParameterValues("addcontent");
		String addCommandid = request.getParameter("addcommandid");
		
		InsertService insertService = new InsertService();
		insertService.InsertCommandContent(addCommandid, addContent);
		insertService.InsertCommand(addCommand, addDescription);
		
		request.setAttribute("addcommand", addCommand);
		request.setAttribute("adddescription",  addDescription);
		request.setAttribute("addcontent", addContent);
		request.setAttribute("addcommandid",addCommandid);
		
		request.getRequestDispatcher("/WEB-INF/jsp/back/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
