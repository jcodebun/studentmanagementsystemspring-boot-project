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
				action="${pageContext.request.contextPath}/home/login/changepassword"
				modelAttribute="form">
				<sf:hidden path="id" />
				<h1 class="text-center">Change Password!</h1>
				<div>
					<%@ include file="businessMessage.jsp"%>
				</div>
				<div class="form-group">
									<s:bind path="oldPassword">
										<label for="inputEmail4" class="form-label">Old Password</label>
										<sf:input type="password" path="${status.expression}"
											placeholder="Enter Password" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
								<div class="form-group">
									<s:bind path="newPassword">
										<label for="inputEmail4" class="form-label">New Password</label>
										<sf:input type="password" path="${status.expression}"
											placeholder="Enter Password" class="form-control" />
										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
								<div class="form-group">
									<s:bind path="confirmPassword">
										<label for="inputEmail4" class="form-label">Confirm Password</label>
										<sf:input type="password" path="${status.expression}"
											placeholder="Enter Password" class="form-control" />
										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
								<div class="text-center mt-2">
								<div align="center">
									<input id="login" type="submit" name="operation" class="btn btn-primary"
										value="Save" />
										<input id="login" type="submit" name="operation" class="btn btn-primary"
										value="Reset" />
										
								</div></div>
			</sf:form>
		</div>
	</div>
</div>
