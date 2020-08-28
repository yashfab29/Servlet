package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.BookDao;

public class Delete extends HttpServlet{

	 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	   {
		   HttpSession session=request.getSession();
			session.setAttribute("", true);
			   PrintWriter out = response.getWriter();

	String id=request.getParameter("id");   
    int status=BookDao.delete(id);  
    
    if(status>0){  
        out.print("<p>Book deleted successfully!!!</p>");  
        request.getRequestDispatcher("delete.html").include(request, response);  
    }else{  
        out.println("Sorry! unable to delete a book");  
    }  
    
    out.close();  
  
    
    
       }
}
