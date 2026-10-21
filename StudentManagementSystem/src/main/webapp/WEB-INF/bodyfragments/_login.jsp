<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container mt-2"
	style="position: relative; min-height: 100vh">
	<div class="row">
		<div class="col-xs-12 main-content">
			<div class="row">
				<div class="col-md-5 col-sm-6">

					<br>
					<br>
					<br>

					<div class="header-lined">
						<h1>Login</h1>
						<hr>
					</div>

					
					
						<%@ include file="businessMessage.jsp"%>
					
					<div class="providerLinkingFeedback"></div>

					<div class="row">
						<div class="col-sm-12">

							<sf:form method="post"
								action="${pageContext.request.contextPath}/home/login"
								modelAttribute="form">

								<div class="form-group">
									<s:bind path="login">
										<label for="inputEmail4" class="form-label">Email</label>
										<sf:input path="${status.expression}"
											placeholder="Enter Email" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>

								<div class="form-group">
									<s:bind path="password">
										<label for="inputEmail4" class="form-label">Password</label>
										<sf:input type="password" path="${status.expression}"
											placeholder="Enter Password" class="form-control" />
										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>


								<div class="text-center mt-2"></div>
								<div align="left">
									<input id="login" type="submit" name="operation" class="btn btn-primary"
										value="Login" />
										<input id="login" type="submit" name="operation" class="btn btn-primary"
										value="Reset" />
										
								</div>
							</sf:form>

						</div>
						<div class="col-sm-5 hidden"></div>
					</div>

				</div>
				<div
					class="col-sm-6 col-md-6 col-md-offset-1 text-center imageoflogin">

					

				</div>
			</div>
		</div>
	</div>
</div>