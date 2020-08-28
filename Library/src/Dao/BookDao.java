package Dao;

import java.util.*;

import bean.Book;

import java.sql.*;  
  
public class BookDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
        }catch(Exception e)
        {
        	System.out.println(e);
        	}  
        return con;  
    } 
    
    
    public static int create(Book e){  
        int status=0;  
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into book values (?,?,?,?)");  
            ps.setString(1,e.getId());  
            ps.setString(2,e.getName());  
            ps.setString(3,e.getAuthor());  
            ps.setString(4,e.getPublisher());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }  
          
        return status;  
    }  
    
    
    
    
    public static int update(Book e){  
        int status=0;  
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update book set name=?,author=?,publisher=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getAuthor());  
            ps.setString(3,e.getPublisher());  
            ps.setString(4,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    
    
    public static int delete(String id){  
        int status=0;  
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from book where id=?");  
            ps.setString(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    
    
    
    public static Book getBookById(String id){  
      Book b = new Book();  
          
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from book where id=?");  
            ps.setString(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                b.setId(rs.getString(1));  
                b.setName(rs.getString(2));  
                b.setAuthor(rs.getString(3));  
                b.setPublisher(rs.getString(4));  
               
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return b;  
    }  
    
}  