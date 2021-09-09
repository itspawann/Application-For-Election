<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {

  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #04AA6D;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: red;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  
<script>  
$(document).ready(function(){  
    $("input").focus(function(){  
	$(this).css("background-color","lightgreen");
       
    });  
	$("input").blur(function(){  
	$(this).css("background-color","yellow");
       
    });  
});  
</script> 

</head>
<body bgcolor=#D3D3D3>


<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="ll" method="get">
      
        <div class="row">
          <div class="col-50">
            <h3>Leader Registration</h3>
            <label for="fname"><i class="fa fa-user"></i>Name</label>
            <input type="text" id="fname" name="name" pattern="[A-Za-z]{1,20}" placeholder="John M. Doe">
            
             <label for="fname"><i class="fa fa-institution"></i>State</label>
           
  <select name="state" id="state">
  	<option value="KR">Karnataka</option>
    <option value="AP">Andra Pradesh</option>
    <option value="TN">Tamil Nadu</option>
    <option value="UP">Uthar Pradesh</option>
    <option value="KL">Kerala</option>
  </select></p>
 <label for="city"><i class="fa fa-institution"></i> City</label>
            <input type="text" id="city" name="city" placeholder="New York">
            <label for="city"><i class="fa fa-institution"></i> Party</label>
            <input type="text" id="city" name="party" placeholder="New York">
               <label for="adr"><i class="fa fa-address-card-o"></i> Aadhar</label>
            <input type="text" id="adr" name="adhar" pattern="[0-9]{10}" placeholder="Your Aadhar Number">
         
           
        
         
           

            <div class="row">
              <div class="col-50">
             
              </div>
              <div class="col-50">
               
              </div>
            </div>
          </div>

          <div class="col-50">
            <h3>Also Fill This</h3>
                 
            <p>Gender: <input type=radio id=male name=gender value=male /><labe>Male</labe>
			<input type=radio id=female name=gender value=female /><labe>Female</labe>
			<input type=radio id=other name=gender value=other /><labe>Other</labe></p>
             <label for="city"><i class="fa fa-institution"></i> DOB</label>
             <input type="text" size=65 name="dob" placeholder="YYYY-MM-DD" pattern="(?:19|20)(?:(?:[13579][26]|[02468][048])-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))|(?:[0-9]{2}-(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:29|30))|(?:(?:0[13578]|1[02])-31)))" title=" Formate is YYYY-MM-DD">
            
               <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" placeholder="john@example.com">
            <label for="cname">Phone</label>
            <input type="text" id="cname" name="phone" pattern="[0-9]{10}" placeholder="Your Phone Number">
           
         
          
            <div class="row">
              <div class="col-50">
                
              </div>
              <div class="col-50">
              
              </div>
            </div>
          </div>
          
        </div>
       
        <input type="submit" value="Register" class="btn">
      </form>
    </div>
  </div>

  </div>
</div>

</body>
</html>
