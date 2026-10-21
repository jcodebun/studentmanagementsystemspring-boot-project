<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container mt-2 mb-2"
	style="position: relative; min-height: 100vh">

	<div class="w-75 mx-auto shadow p-5 mt-2 bg-light">
		<div class="jumbotron">
		<sf:form method="post"
								action="${pageContext.request.contextPath}/home/user"
								modelAttribute="form">
								<sf:hidden path="id"/>
			<h1 class="text-center">Add User!</h1>
			<div>
			<%@ include file="businessMessage.jsp"%>
			<div class="row">
			<div class="form-group">
									<s:bind path="roleId">
										<label for="inputEmail4" class="form-label">Select User Type</label>
										<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="---Select---" />
									<sf:option value="1"  >ADMIN</sf:option>
									<sf:option value="2"  >STUDENT</sf:option>
									<sf:option value="3"  >FACULTY</sf:option>
								</sf:select>
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
			</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="firstName">
										<label for="inputEmail4" class="form-label">First Name</label>
										<sf:input path="${status.expression}"
											placeholder="Enter First Name" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="lastName">
										<label for="inputEmail4" class="form-label">Last Name</label>
										<sf:input type="text" path="${status.expression}"
											placeholder="Enter Last Name" class="form-control" />
										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="login">
										<label for="inputEmail4" class="form-label">Email</label>
										<sf:input path="${status.expression}"
											placeholder="Enter Email" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="password">
										<label for="inputEmail4" class="form-label">Password</label>
										<sf:input type="password" path="${status.expression}"
											placeholder="Enter Password" class="form-control" />
										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="contactNo">
										<label for="inputEmail4" class="form-label">Mobile No</label>
										<sf:input path="${status.expression}"
											placeholder="Enter Mobile No" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="gender">
										<label for="inputEmail4" class="form-label">Gender</label>
										<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="---Select---" />
									<sf:options   items="${gender}" />
								</sf:select>
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="dob">
										<label for="inputEmail4" class="form-label">Date Of Birth</label>
										<sf:input path="${status.expression}"
											placeholder="Enter DOB in DD/MM/YYYY format" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="country">
										<label for="inputEmail4" class="form-label">Country</label>
										<sf:input path="${status.expression}"
											placeholder="Enter Country" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="state">
										<label for="inputEmail4" class="form-label">State</label>
										<sf:input path="${status.expression}"
											placeholder="Enter State" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="city">
										<label for="inputEmail4" class="form-label">City</label>
										<sf:input path="${status.expression}"
											placeholder="Enter City" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="school">
										<label for="inputEmail4" class="form-label">School Name</label>
										<sf:input path="${status.expression}"
											placeholder="Enter School Name" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="course">
										<label for="inputEmail4" class="form-label">Course</label>
										<sf:input path="${status.expression}"
											placeholder="Enter Course" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				<div class="text-center mt-2">
								<div align="center">
									<input id="login" type="submit" name="operation" class="btn btn-primary"
										value="Add User" />
										<input id="login" type="submit" name="operation" class="btn btn-primary"
										value="Reset" />
										
								</div></div>
			</div>
		</sf:form>	
		</div>
	</div>

</div>