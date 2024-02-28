<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Xworkz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<h2 class="text-white h4">Xworkz</h2>
		<nav class="nav nav-pills flex-column flex-sm-row">
			<a class="flex-sm-fill text-sm-center nav-link active"
				aria-current="page" href="index.jsp">Home</a>

		</nav>
		
	</nav>
	<br>
	<h1>Registration form</h1>
	
	<span style="color:red">
		<c:forEach var="objectErrors" items="${error}">
			${objectErrors.defaultMessage}<br>
		</c:forEach>
	</span>
	<span  style="color:red">
	${uniqueError }
	</span>
	<form action="vendor" method="post" class="p-3 mb-2 bg-secondary text-white">
	
		<div class="row">
			<div class="col">
				<input type="text" class="form-control" placeholder="VendorName"
					aria-label="First name" name="vendorName"  value="${entity.getVendorName()}"/>
			</div>
			<div class="col">
				<input type="text" class="form-control" placeholder="Location"
					aria-label="Last name" name="location" value="${entity.getLocation()}"/>
			</div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col">
				<input type="text" class="form-control" placeholder="GstNo"
					aria-label="First name" name="gstNo"value="${entity.getGstNo()}" id="gstNo" onchange="onGstNo()">
					<span id="gstError" style="color:red"></span>
			</div>
			<div class="col">
				<input type="Date" class="form-control"
					placeholder="CompanyStartDate" aria-label="Last name"
					name="companyStartDate" value="${entity.getCompanyStartDate()}"/>
			</div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col">
				<input type="text" class="form-control" placeholder="OwnerName"
					aria-label="First name" name="ownerName" value="${entity.getOwnerName()}"/>
			</div>
			<div class="col">
				<select name="serviceType" class="form-control"  placeholder="Service Type">
					<option>-Select field-</option>
					<option value="Financial Services" <c:if test="${entity.getServiceType()=='Financial Services'}"> selected="selected"</c:if>>Financial Services</option>
					<option value="Healthcare Services" <c:if test="${entity.getServiceType()=='Healthcare Services'}"> selected="selected"</c:if>>Healthcare Services</option>
					<option value="Education Services" <c:if test="${entity.getServiceType()=='Education Services'}"> selected="selected"</c:if>>Education Services</option>
					<option value="Legal Services" <c:if test="${entity.getServiceType()=='Legal Services'}"> selected="selected"</c:if>>Legal Services</option>
					<option value="Hospitality Services" <c:if test="${entity.getServiceType()=='Hospitality Services'}"> selected="selected"</c:if>>Hospitality Services</option>
					<option value="Retail Services" <c:if test="${entity.getServiceType()=='Retail Services'}"> selected="selected"</c:if>>Retail Services</option>
					
				</select>
			</div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col">
				<input type="number" class="form-control"
					placeholder="Contact number" aria-label="First name"
					name="contactNo" value="${entity.getContactNo()}" id="contact" onchange="onContact()"/>
					   <span id="contactError" style="color:red"></span> 
					
			</div>
			<div class="col">
				<input type="number" class="form-control"
					placeholder="AlternativeNo" aria-label="Last name"
					name="alternativeNo" value="${entity.getAlternativeNo()}"/>
			</div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col">
				<input type="text" class="form-control" placeholder="Email"
					aria-label="First name" name="email" value="${entity.getEmail()}" id="mail" onchange="onEmail()">
					   <span id="mailError" style="color:red"></span>
					
			</div>
			<div class="col">
				<input type="text" class="form-control" placeholder="Website"
					aria-label="Last name" name="website" value="${entity.getWebsite()}" id="website" onchange="onWebsite()">
					   <span id="webError" style="color:red"></span>
					
			</div>
		</div>
		<br>
		<br>
		<div class="col-12">
			<button type="submit" class="btn btn-primary">Register</button>
		</div>

	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
		<script>

		function onGstNo() {
			console.log("Running onGstNo...")
			var gstValue=document.getElementById('gstNo').value
			console.log(gstValue)
			if(gstValue !=null && gstValue!=" " && gstValue.length>3 && gstValue.length<30) 
				{
				console.log('valid gst');
				document.getElementById('gstNo').innerHTML='';
				
				const xhttp=new XMLHttpRequest();
				xhttp.open("GET","http://localhost:8080/vmanage/uniqueGst/"+gstValue);
				xhttp.send();
				xhttp.onload=function()
				{
					console.log(this);
					document.getElementById('gstError').innerHTML= this.responseText;	
				}
				}
				else{
					console.log('invalid gst');
					document.getElementById('button').disabled='disabled';
					document.getElementById('gstError').innerHTML='Enter a valid gstNo';
					
				}
			
		}
		function onContact()
		{
			console.log("Running onContact...")
			var contactValue=document.getElementById('contact').value
			console.log(contactValue)
			if(contactValue != "" && contactValue.length == 10) 
				{
				console.log('valid contact');
				document.getElementById('contact').innerHTML='';
			
				const xhttp=new XMLHttpRequest();
				xhttp.open("GET","http://localhost:8080/vmanage/uniqueContact/"+contactValue);
				xhttp.send();
				xhttp.onload=function()
				{
					console.log(this);
					document.getElementById('contactError').innerHTML= this.responseText;
					
				} 
				}
				else{
					console.log('invalid contact');
					document.getElementById('button').disabled='disabled';
					document.getElementById('contactError').innerHTML="<span style='color:red'>Enter a valid number</span>";
					return true;
					
				
				}
			}
			
		

		function onEmail() {
			console.log("Running onEmail...")
			var mailsValue=document.getElementById('mail').value
			console.log(mailsValue)
			if(mailsValue !=null && mailsValue!=" " && mailsValue.length>3 && mailsValue.length<30) 
				{
				console.log('valid email');
				document.getElementById('mail').innerHTML='';
				
				const xhttp=new XMLHttpRequest();
				xhttp.open("GET","http://localhost:8080/vmanage/uniqueEmail/"+mailsValue);
				xhttp.send();
				xhttp.onload=function()
				{
					console.log(this);
					document.getElementById('mailError').innerHTML= this.responseText;		
				}
				}
				else{
					console.log('invalid email');
					document.getElementById('button').disabled='disabled';
					document.getElementById('mailError').innerHTML='Enter a valid email';
				}
			
		}
		function onWebsite()
		{
			console.log("Running onWebsite...")
			var webValue=document.getElementById('website').value
			console.log(webValue)
			if(webValue !=null && webValue!=" " && webValue.length>3 && webValue.length<30) 
				{
				console.log('valid website');
				document.getElementById('website').innerHTML='';
				
				const xhttp=new XMLHttpRequest();
				xhttp.open("GET","http://localhost:8080/vmanage/uniqueWebsite/"+webValue);
				xhttp.send();
				xhttp.onload=function()
				{
					console.log(this);
					document.getElementById('webError').innerHTML= this.responseText;
					
				}
				}
				else{
					console.log('invalid website');
					document.getElementById('button').disabled='disabled';
					document.getElementById('webError').innerHTML='Enter a valid website';
						
				}
			}
		</script>
</body>
</html>