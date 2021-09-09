<html>
<head>
</head>
<body bgcolor=#f1f1f1>
<form method="get" action="voterinsert">
<p>Name:<input type="text" size=65 name="name"pattern="WEL.+" placeholder="Start your name with WEL and your name" title="Start your name with WEL and must have only alphabets"></p><br>
<p><label for="state">State:</label>
  <select name="state" id="state">
  	<option value="KR">Karnataka</option>
    <option value="AP">Andra Pradesh</option>
    <option value="TN">Tamil Nadu</option>
    <option value="UP">Uthar Pradesh</option>
    <option value="KL">Kerala</option>
  </select></p>
  <br><br>
<p>City:<input type="text" name=city /></p>
<p>Adhar Id:<input type="text" size=65 name="adhar" placeholder="Adhar ID" pattern="[0-9]{16}" title="Phone number must be integer no alphabet"></p><br>
<p>Gender: <input type=radio id=male name=gender value=male /><labe>Male</labe>
			<input type=radio id=female name=gender value=female /><labe>Female</labe>
			<input type=radio id=other name=gender value=other /><labe>Other</labe></p>
<p>DOB:<input type="text" size=65 name="dob" placeholder="YYYY-MM-DD" pattern="(?:19|20)(?:(?:[13579][26]|[02468][048])-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))|(?:[0-9]{2}-(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:29|30))|(?:(?:0[13578]|1[02])-31)))" title=" Formate is YYYY-MM-DD"></p><br>
<p>Email: <input type=text name=email placeholder="Email ID" /></p>
<p>Phone:<input type="text" size=65 name="phone" placeholder="Enter your 10 Digit mobile no" pattern="[0-9]{10}" title="Phone number must be integer no alphabet"></p><br>
<p>Password:<input type="password" size=50 name="password" placeholder="one integer is required" pattern="(^(?=.\d)(?=.[a-z])(?=.[A-Z])(?!.\s).*$)"></p><br>
<p><input type="submit" value="send" name="Submit"></p>
</form>
</body>
</html>