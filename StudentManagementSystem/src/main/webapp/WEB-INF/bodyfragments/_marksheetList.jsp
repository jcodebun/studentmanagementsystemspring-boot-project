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
		<h2>Marksheet List</h2>
		<hr/>
		<div class="row">
			<div class="col">
				<s:bind path="rollNo">
					<div class="col">
						<sf:input path="${status.expression}"
							class="form-control form-control-sm"
							placeholder="Search By Roll No" />
					</div>
				</s:bind>
			</div>
			
			<div class="col">
				<div class="form-group">

					<input type="submit" class="btn btn-sm btn-outline-primary"
						name="operation" value="Search"></input> or <input type="submit"
						class="btn btn-sm btn-outline-secondary" name="operation"
						value="Reset">

				</div>
			</div>
			
		</div>
		<div class="container mt-2" style="width: 50%"><b><%@ include file="businessMessage.jsp"%></b></div>
		<sf:input type="hidden" path="pageNo" />
		<sf:input type="hidden" path="pageSize" />

		<sf:input type="hidden" path="listsize" />
		<sf:input type="hidden" path="total" />
		<sf:input type="hidden" path="pagenosize" />
		<div class="table-responsive">
			<table class="table bg-header rounded shadow-sm table-hover mt-5">
				<thead class="bg-footer text-white">
					<tr>
						<c:if test="${sessionScope.user.roleId == 3}">
							<th scope="col">Select
								All</th>
					</c:if>

						<th scope="col">S.No</th>
						<th scope="col">Roll No</th>
						<th scope="col">Student Name</th>
						<th scope="col">Physics Marks</th>
						<th scope="col">Chemistry Marks</th>
						<th scope="col">Maths Marks</th>
						<c:if test="${sessionScope.user.roleId == 3}">
						<th scope="col">Action</th>
						</c:if>
					</tr>
				</thead>
				<tbody>


					<c:forEach items="${list}" var="marks_list" varStatus="u">
						<tr>
							<c:if test="${sessionScope.user.roleId == 3}">
								<td><input type="checkbox" class="case" name="ids"
									value="${marks_list.id}"></td></c:if>
							<c:if test="${ sessionScope.user.roleId == 1 || sessionScope.user.roleId == 3  ||sessionScope.user.id==marks_list.user.id}">
							<td scope="row">${u.index+1}</td>
							<td scope="row">${marks_list.rollNo}</td>
							<td scope="row">${marks_list.user.firstName}</td>
							<td scope="row">${marks_list.physics}</td>
							<td scope="row">${marks_list.chemistry}</td>
							<td scope="row">${marks_list.maths}</td>
							</c:if>
							<c:if test="${sessionScope.user.roleId == 3}">
							<td><a class="text-dark" href="${editUrl} ${marks_list.id}"
									><i class="fas fa-edit"></i></a></td></c:if>
							 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
		<div class="clearfix">
			
				<input type="submit" name="operation"
					class="btn btn-sm btn-danger float-start"
					<c:if test="${listsize == 0}">disabled="disabled"</c:if>
					value="Delete"> 
				
		
				
				


			<nav aria-label="Page navigation example float-end">
				<ul class="pagination justify-content-end" style="font-size: 13px">
					<li class="page-item"><input type="submit" name="operation"
						class="page-link"
						<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
						value="Previous"></li>
					<c:forEach var="i" begin="1" end="${(listsize/10)+1}">
						<c:if test="${i== pageNo}">
							<li class="page-item active"><a class="page-link activate"
								href="${addSearch}?pageNo=${i}">${i}</a></li>
						</c:if>
						<c:if test="${i != pageNo}">
							<li class="page-item"><a class="page-link"
								href="${addSearch}?pageNo=${i}">${i}</a></li>
						</c:if>
					</c:forEach>
					<li class="page-item"><input type="submit" name="operation"
						class="page-link"
						<c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
						value="Next"></li>
				</ul>
			</nav>
		</div>


	</div>
		
	</div>
</sf:form>		