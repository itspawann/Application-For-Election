package com.pawan.voting;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {
	@RequestMapping("/welcome")
	public String showForm()
	{
		return "welcome";
	}
	

	@RequestMapping("/vl")
	public String voter(@RequestParam("name") String name,@RequestParam("state") String state,@RequestParam("city") String city,@RequestParam("adhar") String adhar,@RequestParam("gender") String gender,@RequestParam("dob") String dob,@RequestParam("email") String email,@RequestParam("phone") int phone,@RequestParam("password") String pass,Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		Voter v=new Voter();
		String id="";
		List<Map<String,Object>> l=f.id1();
		Iterator<Map<String,Object>> itr=l.iterator();
		while(itr.hasNext())
		{
		Map<String,Object> o=itr.next();
		id=(String)o.get("voterId");
		}
		
		System.out.println(id);
		String status="pending";
		
		String id2=id.substring(5);
		int id3=Integer.parseInt(id2);
	     id3++;
		String id4='V'+state+"00"+id3;
		System.out.println(id4);
		v.setVoterId(id4);
		v.setVoterName(name);
		v.setState(state);
		v.setCity(city);
		int ad=Integer.parseInt(adhar);
		v.setAadhaar(ad);
		v.setGender(gender);
		v.setDob(dob);
		v.setEmail(email);
		v.setPhone(phone);
		v.setPassword(pass);
		v.setStatus(status);
		f.insert(v);
		
		m.addAttribute("id", id4);
		m.addAttribute("status", status);
		return "voterStatus";
		
	}
	@RequestMapping("/ll")
	public String leader(@RequestParam("name") String name,@RequestParam("state") String state,@RequestParam("city") String city,@RequestParam("party") String party,@RequestParam("adhar") String adhar,@RequestParam("gender") String gender,@RequestParam("dob") String dob,@RequestParam("email") String email,@RequestParam("phone") int phone,Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		
		Leader l=new Leader();
		String id="";
		List<Map<String,Object>> li=f.leaderId();
		Iterator<Map<String,Object>> itr=li.iterator();
		while(itr.hasNext())
		{
		Map<String,Object> o=itr.next();
		id=(String)o.get("leaderId");
		}
		
		System.out.println(id);
		String status="pending";
		
		String id2=id.substring(5);
		int id3=Integer.parseInt(id2);
	     id3++;
		String id4='L'+state+"00"+id3;
		System.out.println(id4);
		
		l.setLeaderId(id4);
		l.setLeaderName(name);
		l.setState(state);
		l.setCity(city);
		int ad=Integer.parseInt(adhar);
		l.setAadhaar(ad);
		l.setGender(gender);
		l.setDob(dob);
		l.setEmail(email);
		l.setPhone(phone);
		l.setStatus(status);
		l.setParty(party);
		f.insertLeader(l);
		m.addAttribute("id", id4);
		m.addAttribute("status", status);
		
		return "leaderStatus";
}


	@RequestMapping(value="/al", method = {RequestMethod.GET})
	public String admin(@RequestParam("usr") String user,@RequestParam("pass") String pass,HttpServletRequest request){

			if(user.equals(pass))
		{ 
				HttpSession hs=request.getSession();
				hs.setAttribute("session", user);
				
				return "adminpage";
		}
			else
			{
				return "adminLogin";
}
	}
	@RequestMapping("/penl")
	public String pendingLeader(Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		
	
		List<Map<String,Object>> li=f.pendingL();
		
//		while(itr.hasNext())
//		{
//		Map<String,Object> o=itr.next();
//		l1.add(o.get("leaderId"));
//		l1.add(o.get("leaderName"));
//		l1.add(o.get("state"));
//		l1.add(o.get("city"));
//		l1.add(o.get("party"));
//		l1.add(o.get("aadhaar"));
//		l1.add(o.get("gender"));
//		l1.add(o.get("dob"));
//		l1.add(o.get("email"));
//		l1.add(o.get("phone"));
//		l1.add(o.get("status"));	
//		System.out.println(o.get("leaderId"));
//		System.out.println(o.get("status"));
//		}
		m.addAttribute("l", li);
		
		return "adminpagePL";
	}
	@RequestMapping("/penv")
	public String pendingVoter(Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		
	
		List<Map<String,Object>> li=f.pendingV();
         m.addAttribute("lv", li);
		
		return "adminpagePV";
	}
	@RequestMapping("/allv")
	public String allV(Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		
	
		List<Map<String,Object>> li=f.allVoter();
         m.addAttribute("allv", li);
		
		return "adminpageAllV";
	}
	@RequestMapping("/all")
	public String allL(Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		
	
		List<Map<String,Object>> li=f.allLeader();
         m.addAttribute("l", li);
		
		return "adminpageAllL";
	}
	@RequestMapping("/app")
	public String appV(@RequestParam("appv") String id,@RequestParam("s") String sta,Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		if (sta.equals("approve"))
		f.updateVA(id);
		else if (sta.equals("reject"))
		f.updateVR(id);
		m.addAttribute("message", "Voter List Updated");
		return "adminpage";
	}
	@RequestMapping("/appL")
	public String appL(@RequestParam("appL") String id, @RequestParam("s") String sta,Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		if (sta.equals("approve"))
			f.updateLA(id);
			else if (sta.equals("reject"))
			f.updateLR(id);
		m.addAttribute("mess", "Leader List Updated");
		return "adminpage";
	}
	@RequestMapping(value="/voterLogin", method = {RequestMethod.GET})
	public String voterLogin(@RequestParam("id") String id,@RequestParam("pass") String pass, HttpServletRequest request,Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		String p="";
		String sta = "";
		String state ="";
		String x = "Check your status and try to login again";
		List<Map<String,Object>> li=f.vLogin(id);
		List<Map<String,Object>> l1=f.stateR();
	
		
		Iterator<Map<String,Object>> it=li.iterator();
		while(it.hasNext())
		{
			Map<String,Object> o=it.next();
			 p=(String)o.get("password");
			sta = (String)o.get("status");
			state = (String)o.get("state");
			
		}
		List<Map<String,Object>> l2=f.leaderState(state);
		if(p.equals(pass) && sta.equals("approved"))
		{
			HttpSession hsv=request.getSession();
			hsv.setAttribute("ses", id);
	        m.addAttribute("l", l2);
	        
			return "voting";
		}
		else
		{
			m.addAttribute("message",x);
			return "VotingWrong";
		}
		
	
	}
	@RequestMapping(value ="/votingValue",method = {RequestMethod.GET})
	public String votingValue(@RequestParam("party") String party,HttpServletRequest request, Model m)
	{
		try {
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		Voting v = new Voting();
		
		HttpSession hsv = request.getSession();
		String o1 = (String)hsv.getAttribute("ses");
		
		List<Map<String,Object>> name = f.selectId(party);
				Iterator<Map<String,Object>> it=name.iterator();
		while(it.hasNext())
		{
			Map<String,Object> o=it.next();
		 v.setLeaderId((String)o.get("leaderId"));
		 v.setStateCode((String)o.get("state"));
		 
			
		}
		
		v.setVoterId(o1);
		v.setParty(party);
		f.insertVote(v);
		
		m.addAttribute("message", "Thank You For Your Vote");
		return "votingComplete";
		}
		catch (Exception e) {
			
			m.addAttribute("messagev","You have already voted!");
			return "votingComplete";
		}
	}
		
	@RequestMapping("/adminpageee")
	public String ad()
	{
		return "adminpage";
	}
	@RequestMapping(value="/logout", method = {RequestMethod.GET})
	public String logout(HttpServletResponse res,HttpServletRequest req,Model m)
	{
	
        
		
		
         try {
			req.getRequestDispatcher("VotingPage.jsp").include(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
           
         HttpSession hs=req.getSession();  
         hs.invalidate();  
           
        m.addAttribute("message","You are successfully logged out!");
		  return "VotingPage";
	}
	
	@RequestMapping(value="/logoutv", method = {RequestMethod.GET})
	public String logoutV(HttpServletResponse res,HttpServletRequest req,Model m)
	{
	
        
		
		
         try {
			req.getRequestDispatcher("VotingPage.jsp").include(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
           
         HttpSession hsv=req.getSession();  
         hsv.invalidate();  
           
        m.addAttribute("message","You are successfully logged out!");
		   
        return "VotingPage";
	}
	
	@RequestMapping("/stateR")
	public String stateR(Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		
		List<Map<String,Object>> name = f.stateR();
		m.addAttribute("state", name);
		return "stateResult";
	}
	@RequestMapping("/partyR")
	public String partyR(Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		
		List<Map<String,Object>> name = f.stateR();
		m.addAttribute("state", name);
		return "partyResult";
	}
	@RequestMapping("/stateRR")
	public String stateRR(@RequestParam("state") String state,Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		
		long i=0;
		List<Map<String,Object>> l1 = f.stateMax(state);
//		Iterator<Map<String,Object>> it=l1.iterator();
//		while(it.hasNext())
//		{
//			Map<String,Object> o=it.next();
//			 o.get("count(party)");
//			
//			
//		}
//		
		m.addAttribute("m1", "Total Number Of Votes");
		
		m.addAttribute("count", l1);
		return "stateResult1";
	}
	@RequestMapping("/partyPP")
	public String partyRR(@RequestParam("party") String party,Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		
		List<Map<String,Object>> c = f.partyMax(party);
//		Iterator<Map<String,Object>> it=name.iterator();
//		while(it.hasNext())
//		{
//			c++;
//		}
		m.addAttribute("m1", "Total Number Of Votes");
		m.addAttribute("count", c);
		return "partyResult1";
	}
	@RequestMapping("/reset")
	public String reset(@RequestParam("email") String email,@RequestParam("pass") String pass,@RequestParam("cpass") String cpass,Model m)
	{
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("config.xml");

		JdbcFunctions f=(JdbcFunctions)ctx1.getBean("jdbcobj");
		String em="";
	List<Map<String,Object>> c=f.emailv(email);
	Iterator<Map<String,Object>> it=c.iterator();
	while(it.hasNext())
	{
		Map<String,Object> o=it.next();
	em=(String)o.get("email");		
	}
	System.out.println(em);
	
		if(pass.equals(cpass) && em.equals(email))
	
			{
			f.resetpass(pass,email);
	
			m.addAttribute("message", "Password Reset Successfull");
			return "VotingPage";
					
	}
		
	else
	{
		m.addAttribute("mes", "Check Your Email And Password");
		return "VotingPage";
	}

}
}
	