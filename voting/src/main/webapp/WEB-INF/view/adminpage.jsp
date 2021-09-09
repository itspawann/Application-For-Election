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
  background-color: red;
}

.active {
  background-color: red;
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
<center>

<h1>${message}</h1>
<h1>${mess}</h1>

</center>
</body>
</html>
