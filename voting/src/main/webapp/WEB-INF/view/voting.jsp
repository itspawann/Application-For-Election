<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
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
</head>

<body bgcolor=#f1f1f1>

<%
HttpSession hsv=request.getSession(false);
 Object o=hsv.getAttribute("ses");
String s=(String)o;

%>

<div align=right><b><a href="logout">Logout</a><br><%out.println(s);%></b></div>
<br><br>
<center>
<h2>
Cast Your Vote Here
<form action="votingValue" method="get">

<br><br>
Select Party:<select name="party" >
<c:forEach items="${l}" var="elementss"> 
<option  value="${elementss.party}">${elementss.state}-${elementss.party}-->${elementss.leaderName}</option>
</c:forEach>
</select>
<br>
<br>
<button type="submit" class="button button4">Vote</button>

</form>
</h2>
</center>
</body>
</html>