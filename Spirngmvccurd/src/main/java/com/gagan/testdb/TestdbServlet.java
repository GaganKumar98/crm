package com.gagan.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestdbServlet
 */
public class TestdbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String JdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		 String Driver="com.mysql.jdbc.Driver";
	        String user="root";
	        String pass="root1";
	      
	        try {
	        	PrintWriter out = response.getWriter();
	        	System.out.println("connecting to database : "+JdbcUrl);
	        	Class.forName(Driver);
	        	Connection myConn=DriverManager.getConnection(JdbcUrl,user,pass);
	        	System.out.println("connection Sucessful!!!");
	        	out.println(JdbcUrl);
	        	out.println("connection Sucessful!!!");
	        	myConn.close();
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        	e.printStackTrace();
	        	throw new ServletException(e);
	        }
	}

}
