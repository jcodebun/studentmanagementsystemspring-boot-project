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
								action="${pageContext.request.contextPath}/home/login/attendence"
								modelAttribute="form">
								<sf:hidden path="id"/>
			<h1 class="text-center">Assign Student</h1>
			<div>
			<%@ include file="businessMessage.jsp"%>
			<div class="row">
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
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="subjectId">
										<label for="inputEmail4" class="form-label">Select Subject</label>
										<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="---Select---" />
									<sf:options itemLabel="subjectName"  itemValue="id"  items="${subjectList}"/></sf:select>
								
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="classId">
										<label for="inputEmail4" class="form-label">Select Class</label>
										<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="---Select---" />
									<sf:options itemLabel="className"  itemValue="id"  items="${classList}"/></sf:select>
								
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="date">
										<label for="inputEmail4" class="form-label">Date</label>
										<sf:input id="datepicker" path="${status.expression}"
											placeholder="Enter Date in DD/MM/YYYY" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="lectureTitle">
										<label for="inputEmail4" class="form-label">Lecture Title</label>
										<sf:input type="text" path="${status.expression}"
											placeholder="Enter Title" class="form-control"   />
										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				
				<div class="row">
					
						<%-- <div class="form-group">
									<s:bind path="status">
										<label for="inputEmail4" class="form-label">Select Status</label>
										<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="---Select---" />
									<sf:options  items="${statusList}"/></sf:select>
								
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div> --%>
					
					
					
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

