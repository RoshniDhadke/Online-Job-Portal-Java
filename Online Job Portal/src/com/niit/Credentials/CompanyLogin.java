package com.niit.Credentials;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.Credentials.dao.CompanyLoginDao;
import com.niit.SqlConnect.SqlConnection;

@WebServlet("/CompanyLogin")
public class CompanyLogin extends HttpServlet {
	
    public CompanyLogin() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");
		String s1=request.getParameter("mail");
		String s2=request.getParameter("passwd");
		
		HttpSession s=request.getSession();
		s.setAttribute("Mail",s1);
		System.out.println(s.getAttribute("Mail"));
	
		CompanyLoginDao dao=new CompanyLoginDao();
		if(dao.validate(s1, s2)){response.sendRedirect("CompanyHomePage.jsp");}
		else{response.sendRedirect("CompanyLogin.html");}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
