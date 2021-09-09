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
  background-color: #111;
}

.active {
  background-color: #04AA6D;
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
</head>
<body bgcolor=#f1f1f1>

<ul>
  <li> <a href="stateR">Select By State</a></li>
  <li><a href="partyR">Select By Party</a></li>
 
  
</ul>
<br><br>
<center>
<h3>
<form method= get action =stateRR >
Select State:<select name="state" >
<c:forEach items="${state}" var="elementss"> 
<option  value="${elementss.stateCode}">${elementss.stateCode}</option>
</c:forEach>
</select>
<button type="submit" class="button button4">State Result</button>
</form>
</h3>
</center>

</body>
</html>