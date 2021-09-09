package com.pawan.voting;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml"); 
		JdbcFunctions f=(JdbcFunctions)context.getBean("jdbcobj");
		List<Map<String, Object> > al = f.pendingL();
		response.getWriter().println("<html><body bgcolor=pink><a href=\"adminpage.jsp\">Home</a><center><table border=1>");//<tr><th>FlowerId</th><th>FlowerName</th><th>FlowerColor</th></tr>");
		
		Iterator<Map<String, Object>> itr = al.iterator();
		
		while(itr.hasNext())
			
		{
			//Flower f = (Flower)itr.next();
			//response.getWriter().println("<tr><td>"+f.getFlowerdId()+"</td><td>"+f.getFowerName()+"</td><td>"+f.getFlowerColor()+"</td></tr>" );
			System.out.println("kuch bhi part 2");
			Map<String, Object> o1 = itr.next();
			response.getWriter().println("<tr><th>"+o1.get("leaderId")+"</th>");
			response.getWriter().println("<th>"+o1.get("leaderName")+"</th>");
			response.getWriter().println("<th>"+o1.get("state")+"</th>");
			response.getWriter().println("<th>"+o1.get("city")+"</th>");
			response.getWriter().println("<th>"+o1.get("party")+"</th>");
			response.getWriter().println("<th>"+o1.get("aadhaar")+"</th>");
			response.getWriter().println("<th>"+o1.get("gender")+"</th>");
			response.getWriter().println("<th>"+o1.get("dob")+"</th>");
			response.getWriter().println("<th>"+o1.get("email")+"</th>");
			response.getWriter().println("<th>"+o1.get("phone")+"</th>");
			
				response.getWriter().println("<th>"+o1.get("status")+"</th></tr>");		
					
			}
		
		System.out.println("kuch bhi ");
		response.getWriter().println("</table></center></body></html>");
	
	}

}