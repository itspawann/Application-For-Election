<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: red			;
}

.active {
  background-color: #04AA6D;
}

#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #A9A9A9;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

.button {
  background-color:#04AA6D; /* Green */
  border: none;
  color: white;
  padding: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {border-radius: 2px;}
.button2 {border-radius: 4px;}
.button3 {border-radius: 8px;}
.button4 {border-radius: 12px;}
.button5 {border-radius: 50%;}


</style>
<title>Admin Page</title>
</head>
<body bgcolor=#f1f1f1>
	<%
HttpSession hs=request.getSession(false);
 Object o=hs.getAttribute("session");
String s=(String)o;

%>

<ul>
  <li> <a href="penv">Pending Voters</a></li>
  <li><a href="allv">Voters List</a></li>
 <li> <a href="penl">Pending Leaders</a></li>
  <li><a href="all">Leaders List</a></li>
  <li style="float:right"><a class="active" href="logout">Logout: <%out.println(s);%></a></li>
</ul>
	<h1>Pending Voters</h1>
	
<table id="customers" border=2>
  <tr>
    <th>Leader ID</th>
    <th>Name</th>
    <th>State</th>
     <th>City</th>
     <th>Party</th>
    <th>Aadhar</th>
    <th>Gender</th>
     <th>DOB</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Status</th>
    </tr>
  <c:forEach items="${l}" var="elements">    
  <tr>
     <td><c:out value="${elements.leaderId}" />
      <td><c:out value="${elements.leaderName}" />
       <td><c:out value="${elements.state}" />
        <td><c:out value="${elements.city}" />
        <td><c:out value="${elements.party}" />
                  <td><c:out value="${elements.aadhaar}" />
           <td><c:out value="${elements.gender}" />
            <td><c:out value="${elements.dob}" />
             <td><c:out value="${elements.email}" />
              <td><c:out value="${elements.phone}" />
               <td><c:out value="${elements.status}" />
               
 </tr>
</c:forEach>
</table>
<br><br>
<center>
<h3>
<form action="appL" method="get">
Select ID:<select name="appL" >
<c:forEach items="${l}" var="elementss"> 
<option  value="${elementss.leaderId}">${elementss.leaderId}</option>
</c:forEach>
</select>
<p> <input type=radio id=approve name=s value=approve /><labe>Approve</labe>
			<input type=radio id=reject name=s value=reject /><labe>Reject</labe><br><br>
			
<button type="submit" class="button button4">Submit</button>
</form>
</h3>
</center>
</body>
</html>