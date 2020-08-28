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

public class Update extends HttpServlet {
	

	   public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	   {
		   HttpSession session=request.getSession();
			session.setAttribute("", true);
		   PrintWriter out = response.getWriter();
		   
		   String id=request.getParameter("id");  
	        String name=request.getParameter("name");  
	        String author=request.getParameter("author");  
	        String publisher=request.getParameter("publisher");
	        
	        
	        Book b = new Book();
	        b.setId(id);
	        b.setName(name);
	        b.setAuthor(author);
	        b.setPublisher(publisher);
	          	
	       int status=BookDao.update(b);  
	        if(status>0){  
	            out.print("<p>Book Updated successfully!!!</p>");  
	            request.getRequestDispatcher("update.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to update book");  
	        }  
	        
	        System.out.println(b);
	        out.close();  
		  
		   
	   }

	 

}
