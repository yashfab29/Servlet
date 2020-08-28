package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Dao.BookDao;
import bean.Book;


public class Create extends HttpServlet{


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
	          	
	       int status=BookDao.create(b);  
	        if(status>0){  
	            out.print("<p>Book saved successfully!!!</p>");  
	            request.getRequestDispatcher("create.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to add book");  
	        }  
	        
	        System.out.println(b);
	        out.close();  
		  
		   
	   }

	  
	}