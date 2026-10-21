<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<c:url var="addUrl" value="/home/login/marksheet" />

<c:url var="addSearch" value="/home/login/marksheet/search" />

<c:url var="editUrl" value="/home/login/marksheet?id=" />

<sf:form method="post"
	action="${pageContext.request.contextPath}/home/login/marksheet/search"
	modelAttribute="form">
	<div class="container mt-4"
		style="position: relative; min-height: 100vh">
		<h2>Get Marksheet</h2>
		<hr />
		<table class="table table-bordered">
			<c:forEach items="${list}" var="marks_list" varStatus="u">
				<c:if test="${sessionScope.user.id==marks_list.user.id }">
					<tr>
						<td>Name: ${marks_list.user.firstName}</td>
						<td>Roll No: ${marks_list.rollNo}</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<table class="table table-bordered">
		<thead class="bg-footer text-white">
		<tr>
						<td>Subject</td>
						<td>Subject Code</td>
						<td>Grade</td>
					</tr></thead>
			<c:forEach items="${list}" var="marks_list" varStatus="u">
				<c:if test="${sessionScope.user.id==marks_list.user.id }">
						<tr>
							<td>Physics</td>
							<td>EVB 2213</td>
							<td>${marks_list.physics}</td>
						</tr>
						<tr>
							<td>Chemistry</td>
							<td>EVB 2014</td>
							<td>${marks_list.chemistry}</td>
						</tr>
						<tr>
							<td>Physics</td>
							<td>EVB 2312</td>
							<td>${marks_list.maths}</td>
						</tr>
				</c:if>
			</c:forEach>
		</table>
		<table class="table table-bordered">
			<c:forEach items="${list}" var="marks_list" varStatus="u">
				<c:if test="${sessionScope.user.id==marks_list.user.id }">
					<tr>
						<td>Result: </td>
						<td>
							<c:if test="${marks_list.physics + marks_list.chemistry + marks_list.maths < 50 }">
								<h4 class="text-danger">FAIL</h4>
							</c:if>
							<c:if test="${marks_list.physics + marks_list.chemistry + marks_list.maths >= 50 }">
								<h4 class="text-primary">PASS</h4>
							</c:if>
						</td>
						<td>
							Total:
						</td>
						<td>
						${marks_list.physics + marks_list.chemistry + marks_list.maths}
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
</sf:form>

