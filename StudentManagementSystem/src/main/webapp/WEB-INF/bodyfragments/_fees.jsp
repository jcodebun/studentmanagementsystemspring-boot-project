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
								action="${pageContext.request.contextPath}/home/login/fees"
								modelAttribute="form">
								<sf:hidden path="id"/>
			<h1 class="text-center">Add Fee!</h1>
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
									<s:bind path="month">
										<label for="inputEmail4" class="form-label">Month</label>
										<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="---Select---" />
									<sf:options items="${months}"/></sf:select>
								
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="amount">
										<label for="inputEmail4" class="form-label">Amount</label>
										<sf:input type="text" path="${status.expression}"
											placeholder="Enter Amount" class="form-control" />
										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="totalFee">
										<label for="inputEmail4" class="form-label">Total Fee</label>
										<sf:input path="${status.expression}"
											placeholder="Enter Total Fee" class="form-control" id="totalFees" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="paidFee">
										<label for="inputEmail4" class="form-label">Paid Fee</label>
										<sf:input type="text" path="${status.expression}"
											placeholder="Enter Paid Fee" class="form-control" id="paidFees" onchange="myFunction()"  />
										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="balanceFee">
										<label for="inputEmail4" class="form-label">Balance Fee</label>
										<sf:input path="${status.expression}"
											placeholder="Enter Balance Amount" class="form-control" id="demo" />
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
									<s:bind path="date">
										<label for="inputEmail4" class="form-label">Date</label>
										<sf:input id="datepicker" path="${status.expression}"
											placeholder="Enter Date in DD/MM/YYYY format" class="form-control" />
										<font color="red" style="font-size: 13px"> <sf:errors
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

<script>
function myFunction() {
  var x = document.getElementById("paidFees").value;
  var y = document.getElementById("totalFees").value;
  var z = y - x;
  document.getElementById("demo").value = z;
}
</script>