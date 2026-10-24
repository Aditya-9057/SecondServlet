package com.adityabhosale;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 PrintWriter out = response.getWriter();
	       

	        String user = request.getParameter("usr");
	        String pass = request.getParameter("pwd");

	        RequestDispatcher rd;


	        Connection con = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        
	        try {
	            Class.forName("org.postgresql.Driver");
	           con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/fullstackdb","postgres","root@123");

	                stmt = con.createStatement();

	                rs = stmt.executeQuery("select * from users where uname='"+user+"' and pname='"+pass+"'");

	                if(rs.isBeforeFirst()){
	                   rd = request.getRequestDispatcher("Welcome");
	                   rd.forward(request,response);
	                }                
	                else
	                {
	                    rd = request.getRequestDispatcher("login.html");
	                    rd.include(request,response);
	                    out.println("Invalid User"); 
	                }

	             } catch (ClassNotFoundException cnfe) {
	            out.println("Unable to load jdbc Driver!" +cnfe.getMessage());
	            
	        }catch(SQLException sqle){
	            out.println("SQL problem! "+sqle.getMessage());
	        }catch(Exception e){
	            out.println("General Problem!"+e.getMessage());
	        };
	}

}
