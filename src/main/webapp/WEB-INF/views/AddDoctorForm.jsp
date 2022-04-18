<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


			
				
				<p class="error"><c:out value="${emptyFieldError }"></c:out></p>
			
				<input type="hidden" placeholder="Doctor Id*" name="did" value='<c:out value="${doctor.did}" />' > 
				
			
				<input placeholder="Name*" name="DName" value='<c:out value="${doctor.DName}" />'><br>
				  <select name="DGender">
				 	<option value="">Select</option>
					<option value="M">Male</option>
					<option value="F">Female</option>
					<option value="O">Others</option>
				</select> 
				<input placeholder="Age*" name="DAge" value='<c:out value="${doctor.DAge}" />'> 
				<input placeholder="city" name="DAddress" value='<c:out value="${doctor.DAddress}" />'>
				<input placeholder="Designation" name="Designation" value='<c:out value="${doctor.designation}" />'>  
				<input placeholder="phone number" name="DPhn" value='<c:out value="${doctor.DPhn}" />'> <br>
				
				

		

