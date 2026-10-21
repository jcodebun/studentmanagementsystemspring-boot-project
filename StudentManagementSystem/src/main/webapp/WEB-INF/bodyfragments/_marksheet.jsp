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
								action="${pageContext.request.contextPath}/home/login/marksheet"
								modelAttribute="form">
								<sf:hidden path="id"/>
			<h1 class="text-center">Add Marksheet!</h1>
			<div>
			<%@ include file="businessMessage.jsp"%>
			<div class="row">
			<div class="col-lg-6">
			<div class="form-group">
									<s:bind path="userId">
										<label for="inputEmail4" class="form-label">Select Student</label>
										<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="---Select---" />
									<sf:options itemLabel="firstName"  itemValue="id"  items="${studentList}" /></sf:select>
								
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
			</div>
				
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="rollNo">
										<label for="inputEmail4" class="form-label">Roll No</label>
										<sf:input path="${status.expression}"
											placeholder="Enter Roll No" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					
				</div>
				<div class="row">
					<div class="col-lg-3">
						<div class="form-group">
									<s:bind path="physics">
										<label for="inputEmail4" class="form-label">Physics</label>
										<sf:input type="number" min="0" path="${status.expression}"
											placeholder="Enter Marks of Physics" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-3">
						<div class="form-group">
									<s:bind path="chemistry">
										<label for="inputEmail4" class="form-label">Chemistry</label>
										<sf:input type="number" min="0" path="${status.expression}"
											placeholder="Enter Chemistry Marks" class="form-control"   />
										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-3">
						<div class="form-group">
									<s:bind path="maths">
										<label for="inputEmail4" class="form-label">Maths</label>
										<sf:input type="number" min="0" path="${status.expression}"
											placeholder="Enter Maths Marks" class="form-control"   />
										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				
				
				
				
				</div>
				
				
				<div class="text-center mt-2">
								<div align="center">
									<input id="login" type="submit" name="operation" class="btn btn-primary"
										value="Save" />
										<input id="login" type="submit" name="operation" class="btn btn-primary"
										value="Reset" />
										
								</div></div>
			</div>
		</sf:form>	
		</div>
	</div>

</div>

