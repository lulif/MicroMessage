package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DeleteService;

//����servlet
//@WebServlet("/deleteOneServlet")
public class DeleteOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteOneServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ����ʽ���Ժ��������һ��������
		request.setCharacterEncoding("UTF-8");
		String  id=request.getParameter("id");
		DeleteService maintainService=new DeleteService();
		maintainService.deleteOne(id);
		
		request.getRequestDispatcher("/List.action").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
