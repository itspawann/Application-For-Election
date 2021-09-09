<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 200px;
  background-color: #f1f1f1;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color: #04AA6D;
  color: white;
}

li a:hover:not(.active) {
  background-color: red;
  color: white;
}
</style>
</head>
<body bgcolor=#f1f1f1>


<ul>
  <li><a class="active" href="voterlogin.jsp" target = "frame3">Voter Registration</a></li>
  <li><a href="leaderlogin.jsp" target = "frame3">Leader Registration</a></li>
  <li><a href="adminLogin.jsp" target = "frame3">Admin Login</a></li>
  <li><a href="VotingPage.jsp" target = "frame3">Voting Page</a></li>
  <li><a href="votingresults.jsp" target = "frame3">Voting Results</a></li>
</ul>

</body>
</html>
