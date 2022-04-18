<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>All Patients</title>

<link rel="stylesheet" type="text/css" href="./css/GetAllPAtientsCss.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="main header">
		<h1>MANUH HOSPITAL</h1>
	</div>
	</div>

	<div class="logout">
		<a href="menu">
			<button type="submit">Back To Menu</button>
		</a>
	</div>
	<div class="container">
		<div class="header">
			<h2 class="sub">All Patient Records</h2>
		</div>
		<div class="main">
			<table name="dataTable">
				<thead>
					<tr>
						<th>Patient Id</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>gender</th>
						<th>Age</th>
						<th>phone number</th>
						<th>address</th>
						<th>Date Of Join</th>
						<th>Date Of Discharge</th>
						<th colspan="4">Actions</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${patientList}" var="patient">
        <tr>
        <td><c:out value="${patient.pid}" /></td>
          <td><c:out value="${patient.firstName}" /></td>
          <td><c:out value="${patient.lastName}" /></td>
          <td><c:out value="${patient.gender}" /></td>
          <td><c:out value="${patient.age}" /></td>
          <td><c:out value="${patient.phn}" /></td>
          <td><c:out value="${patient.address}" /></td>
          <td><c:out value="${patient.dateOfJoin}" /></td>
          <td><c:out value="${patient.dateOfDischarge}" /></td>
          <td><a href="EditPatientServlet?pid=<c:out value="${patient.pid}" />"><button><i class="fas fa-edit"></i></button></a>
								
							</td>
						<td><a href="DeleteServlet?pid=<c:out value="${patient.pid}" />"><button name="deleteButton" onclick="return confirm('Are you sure you want to delete patient record')">
								<i class="fas fa-trash-alt"></i>
							</button>
							</a></td>
						<td><a href="AddDoctorServlet?pid=<c:out value="${patient.pid}" />"><button name="deleteButton">
								<i class="fa fa-plus-square"></i>
							</button>
							</a></td>
						<td><a href="ViewServlet?pid=<c:out value="${patient.pid}" />"><button name="deleteButton">
								<i class="fas fa-eye"></i>
							</button>
							</a></td>
        </tr>
      </c:forEach>
					

				</tbody>
				</div>
				<br>
				  <form action="SearchPatient">
				<input type="number" placeholder="Enter Patient Id " name="pid">
				<button class="logout" type="submit">Search</button>
				</form>
				<a href="AddPatientData">
					<button type="submit" class="logout">Add New Patient Data</button>
				</a>
				<a href="SortPatientList" >
					<button type="submit" class="logout">Sort by age</button>
				</a>
				</table>





			<!-- 	<script type="text/javascript" src="GetAllPatientsJs.js"></script> -->
</body>
</html>