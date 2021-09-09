<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
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

</style>
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

	<h1>All Leaders</h1>
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
	<c:forEach items="${l}" var="element">    
  <tr>
     <td><c:out value="${element.leaderId}" />
      <td><c:out value="${element.leaderName}" />
       <td><c:out value="${element.state}" />
        <td><c:out value="${element.city}" />
         <td><c:out value="${element.party}" />
          <td><c:out value="${element.aadhaar}" />
           <td><c:out value="${element.gender}" />
            <td><c:out value="${element.dob}" />
             <td><c:out value="${element.email}" />
              <td><c:out value="${element.phone}" />
               <td><c:out value="${element.status}" />              
   
  </tr>
</c:forEach>
</table>
</body>
</html>