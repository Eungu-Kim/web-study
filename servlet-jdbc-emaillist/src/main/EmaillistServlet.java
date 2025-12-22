package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "이메일리스트 서블릿", urlPatterns = {"/emaillist"})
public class EmaillistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmaillistServlet() {
      super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("EmaillistServlet.doGet() 호출");
      request.setCharacterEncoding("utf-8");

      String actionName = request.getParameter("a");
      
      if("deleteform".equals(actionName)) {
        System.out.println("actionName => " + actionName);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/emaillist2/deleteform.jsp");
        rd.forward(request, response);
      }else if("add".equals(actionName)) {
        System.out.println("actionName => " + actionName);
        request.setCharacterEncoding("UTF-8");
        String lastName = request.getParameter("ln");
        String firstName = request.getParameter("fn");
        String email = request.getParameter("email");
        
        EmaillistVo vo = new EmaillistVo(lastName, firstName, email);
        
        EmaillistDao dao = new EmaillistDao();
        dao.insert(vo);

        response.sendRedirect("/helloweb6/emaillist");
      }else if("delete".equals(actionName)) {
        System.out.println("actionName => " + actionName);
        request.setCharacterEncoding("utf-8");
        
        String no = request.getParameter("no");
        
        EmaillistVo vo = new EmaillistVo();
        vo.setNo(Integer.parseInt(no));
        EmaillistDao dao = new EmaillistDao();
        
        dao.delete(vo);
        
        response.sendRedirect("/helloweb6/emaillist");
      }else {
        // list 
        System.out.println("actionName => " + actionName);
        EmaillistDao dao = new EmaillistDao();
        List<EmaillistVo> list = dao.getList();

        request.setAttribute("list", list);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/emaillist/index.jsp");
        rd.forward(request, response);
      }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}