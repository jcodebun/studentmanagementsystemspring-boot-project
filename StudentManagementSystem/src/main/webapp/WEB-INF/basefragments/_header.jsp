<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav class="navbar navbar-expand-lg navbar-light bg-footer">

	<a class="navbar-brand container" href="<c:url value="/home"/>"> <b class="text-white"><i
			class="fa fa-student" style="color: yellow;"></i> Student Management System</b>
	</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav justify-content-end">

				<%-- <c:if test="${sessionScope.user != null}">
				<span class="navbar-text">
					Hello,${sessionScope.user.firstName} (${sessionScope.user.roleName }) </span>
			</c:if> --%>
				<c:if test="${sessionScope.user == null}">

				</c:if>
			</ul>

		</div>

	</div>
</nav>

<nav class="navbar navbar-expand-lg navbar-secondary bg-header">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/home"/>">Home <span class="sr-only">(current)</span></a>
			</li>

			<c:if test="${sessionScope.user != null}">
				<c:if test="${sessionScope.user.roleId == 1}">
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false">User</a>
				<ul class="dropdown-menu">

					<li><a class="dropdown-item" href="<c:url value="/home/user"/>">Add  User</a></li>

					<li><a class="dropdown-item" href="<c:url value="/home/login/users/search"/>">User List</a></li>
					
				</ul></li>
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false">Class</a>
				<ul class="dropdown-menu">

					<li><a class="dropdown-item" href="<c:url value="/home/login/classes"/>">Add  Class</a></li>

					<li><a class="dropdown-item" href="<c:url value="/home/login/classes/search"/>">Classes List</a></li>
					
				</ul></li>
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false">Subject</a>
				<ul class="dropdown-menu">

					<li><a class="dropdown-item" href="<c:url value="/home/login/subject"/>">Add  Subject</a></li>

					<li><a class="dropdown-item" href="<c:url value="/home/login/subject/search"/>">Subject List</a></li>
					
				</ul></li>
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false">Fee</a>
				<ul class="dropdown-menu">

					<li><a class="dropdown-item" href="<c:url value="/home/login/fees"/>">Add  Fees</a></li>

					<li><a class="dropdown-item" href="<c:url value="/home/login/fees/search"/>">Fee List</a></li>
					
				</ul></li>
					<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false">Attendance</a>
				<ul class="dropdown-menu">

					<li><a class="dropdown-item" href="<c:url value="/home/login/attendence"/>">Assign Students</a></li>

					<li><a class="dropdown-item" href="<c:url value="/home/login/attendence/search"/>">Attendance List</a></li>
					
				</ul></li>


				</c:if>
				<c:if test="${sessionScope.user.roleId == 2}">
					
						<li class="nav-item "><a class="nav-link "
						href="<c:url value="/home/login/student/marksheet/search"/>">Get Marksheet</a></li>
					<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false">Details</a>
				<ul class="dropdown-menu">

					<li><a class="dropdown-item" href="<c:url value="/home/login/subject/search"/>">Subject List</a></li>

					<li><a class="dropdown-item" href="<c:url value="/home/login/attendence/search"/>">Attendance List</a></li>
					
					<li><a class="dropdown-item" href="<c:url value="/home/login/fees/search"/>">Fees List</a></li>
					
				</ul></li>
					


					

					
				</c:if>
				<c:if test="${sessionScope.user.roleId == 3}">
					<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false">Marksheet</a>
				<ul class="dropdown-menu">

					<li><a class="dropdown-item" href="<c:url value="/home/login/marksheet"/>">Add  Marksheet</a></li>

					<li><a class="dropdown-item" href="<c:url value="/home/login/marksheet/search"/>">Marksheet List</a></li>
					
				</ul></li>
					<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false">Details</a>
				<ul class="dropdown-menu">

					<li><a class="dropdown-item" href="<c:url value="/home/login/subject/search"/>">Subject List</a></li>

					<li><a class="dropdown-item" href="<c:url value="/home/login/attendence/search"/>">Attendance List</a></li>
					
					<li><a class="dropdown-item" href="<c:url value="/home/login/fees/search"/>">Fees List</a></li>
					
				</ul></li>


				</c:if>
			</c:if>
		</ul>

	</div>
	<ul class="navbar-nav justify-content-end">
		<c:if test="${sessionScope.user != null}">

<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false"> Hello,${sessionScope.user.firstName} (${sessionScope.user.roleName }) </a>
				<ul class="dropdown-menu">

					<li><a class="dropdown-item" href="<c:url value="/home/login/myprofile"/>">My Profile</a></li>

					<li><a class="dropdown-item" href="<c:url value="/home/login/changepassword"/>">Change Password</a></li>
					
				</ul></li>
			

			<li class="nav-item "><a class="nav-link"
				style="padding: 6px; color: black;"
				href="<c:url value="/home/login"/>"><i class="fa fa-sign-out"></i> Logout</a></li>
		</c:if>
		<c:if test="${sessionScope.user == null}">
			
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/home/login"/>">Login</a></li>
			
		</c:if>
	</ul>
</nav>
