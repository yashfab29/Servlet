package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.BookDao;
import bean.Book;

public class Search extends HttpServlet{

	 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	   {
		   HttpSession session=request.getSession();
			session.setAttribute("", true);
			   PrintWriter out = response.getWriter();

	String id=request.getParameter("id");   
    Book b=BookDao.getBookById(id);  
    if (b!=null)
    {
    	request.getRequestDispatcher("search.html").include(request, response);
    	out.println("<center><br><br><h3>Book Id="+ b.getId()+ "<br>Book Name="+ b.getName() + "<br>Author's Name="+ b.getAuthor() + "<br>Publisher's Name="+ b.getPublisher() + "</h3></center>");
    }
    else
    {
    	request.getRequestDispatcher("search.html").include(request, response);
    	out.println("<center>Book not found</center>");
    }
    out.close();  
  
    
    
       }
}
