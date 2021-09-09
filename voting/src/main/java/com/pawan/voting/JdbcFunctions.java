package com.pawan.voting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcFunctions {

	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	public List<Map<String,Object>> id1()
	{

		List<Map<String,Object>> l=template.queryForList("select voterId from voter");

		return l;
	}



	public void insertLeader(Leader l)  { 
		template.update("insert into leader values(?,?,?,?,?,?,?,?,?,?,?)",l.getLeaderId(),l.getLeaderName(),l.getState(),l.getCity(),l.getParty(),l.getAadhaar(),l.getGender(),l.getDob(),l.getEmail(),l.getPhone(),l.getStatus());

	}
	public List<Map<String,Object>> leaderId()
	{

		List<Map<String,Object>> l=template.queryForList("select leaderId from leader");

		return l;
	}



	public void insert(Voter v)  { 
		template.update("insert into voter values(?,?,?,?,?,?,?,?,?,?,?)",v.getVoterId(),v.getVoterName(),v.getState(),v.getCity(),v.getAadhaar(),v.getGender(),v.getDob(),v.getEmail(),v.getPhone(),v.getPassword(),v.getStatus());

	}

	public List<Map<String,Object>> pendingL()
	{

		List<Map<String,Object>> l=template.queryForList("select * from leader where status='pending'");

		return l;
	}
	public List<Map<String,Object>> pendingV()
	{

		List<Map<String,Object>> l=template.queryForList("select * from voter where status='pending'");

		return l;
	}
	public List<Map<String,Object>> allLeader()
	{

		List<Map<String,Object>> l=template.queryForList("select * from leader");

		return l;
	}
	public List<Map<String,Object>> allVoter()
	{

		List<Map<String,Object>> l=template.queryForList("select * from voter");

		return l;
	}
	public void updateVA(String id)
	{
		template.update("update voter set status='approved' where voterId=?", id);
	}
	public void updateLA(String id)
	{
		template.update("update leader set status='approved' where leaderId=?",id);
	}
	public void updateVR(String id)
	{
		template.update("update voter set status='rejected' where voterId=?", id);
	}
	public void updateLR(String id)
	{
		template.update("update leader set status='rejected' where leaderId=?", id);
	}
	public List<Map<String,Object>> vLogin(String id)
	{

		List<Map<String,Object>> l=template.queryForList("select * from voter where voterId=?",id);

		return l;
	}
	public void insertVote(Voting v)  { 
		template.update("insert into voting values(?,?,?,?)",v.getVoterId(),v.getLeaderId(),v.getStateCode(),v.getParty());

	}
	
	public List<Map<String,Object>> state()
	{

		List<Map<String,Object>> l=template.queryForList("select * from stateCode");

		return l;
	}

	public List<Map<String,Object>> selectId(String name)
	{

		List<Map<String,Object>> l=template.queryForList("select * from leader where party=?",name);

		return l;
	}
	public List<Map<String,Object>> leaderState(String name)
	{

		List<Map<String,Object>> l=template.queryForList("select * from leader where state=?",name);

		return l;
	}
	public List<Map<String,Object>> stateR()
	{

		List<Map<String,Object>> l=template.queryForList("select * from voting");

		return l;
	}
		
	public List<Map<String,Object>> stateRes(String state)
	{

		List<Map<String,Object>> l=template.queryForList("select * from voting where stateCode=?",state);

		return l;
	}
	public List<Map<String,Object>> partyPP(String party)
	{

		List<Map<String,Object>> l=template.queryForList("select * from voting where party=?",party);

		return l;
	}
	public List<Map<String,Object>> stateMax(String party)
	{

		List<Map<String,Object>> l=template.queryForList("select party,count(party) as cp from voting where stateCode=? group by party",party);

		return l;
	}
	public List<Map<String,Object>> partyMax(String party)
	{

		List<Map<String,Object>> l=template.queryForList("select stateCode, count(voterId) as cv from voting where party=? group by stateCode;",party);

		return l;
	}
	public void resetpass(String pass,String email)
	{
		template.update("update voter set password=? where email=?", pass,email);
	}
	public List<Map<String,Object>> emailv(String email)
	{

		List<Map<String,Object>> l=template.queryForList("select * from voter where email=?",email);

		return l;
	}
}
