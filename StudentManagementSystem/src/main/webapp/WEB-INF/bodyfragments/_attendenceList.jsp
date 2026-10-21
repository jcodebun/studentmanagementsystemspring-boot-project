<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<c:url var="addUrl" value="/home/login/attendence" />

<c:url var="addSearch" value="/home/login/attendence/search" />

<c:url var="editUrl" value="/home/login/attendence?id=" />

<sf:form method="post"
	action="${pageContext.request.contextPath}/home/login/attendence/search"
	modelAttribute="form">
	<div class="container mt-4"
		style="position: relative; min-height: 100vh">
		<h2>Attendance List</h2>
		<hr/>
		<div class="row">
			<div class="col">
				<s:bind path="subjectId">
										<label for="inputEmail4" class="form-label">Select Subject</label>
										<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="---Select---" />
									<sf:options itemLabel="subjectName"  itemValue="id"  items="${subjectList}"/></sf:select>
								
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
				</s:bind>
				
			</div>
			<div class="col">
				<s:bind path="classId">
										<label for="inputEmail4" class="form-label">Select Class</label>
										<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="---Select---" />
									<sf:options itemLabel="className"  itemValue="id"  items="${classList}"/></sf:select>
								
										<font color="red" style="font-size: 13px"> <sf:errors
												path="${status.expression}" /></font>
				</s:bind>
				
			</div>
			
			<div>
			<div class="col mt-2 text-center">
				<div class="form-group">

					<input type="submit" class="btn btn-sm btn-outline-primary"
						name="operation" value="Search"></input> or <input type="submit"
						class="btn btn-sm btn-outline-secondary" name="operation"
						value="Reset">

				</div>
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
						<c:if test="${sessionScope.user.roleId == 1}">
							<th scope="col">Select
								All</th>
						</c:if>

						<th scope="col">S.No</th>
						<th scope="col">Student Name</th>
						<th scope="col">Subject Name</th>
						<th scope="col">Class</th>
						<th scope="col">Date</th>
						<th scope="col">LectureTitle</th>
						<th scope="col">Status</th>
						
					</tr>
				</thead>
				<tbody>


					<c:forEach items="${list}" var="att_list" varStatus="u">
						<tr>
							<c:if test="${sessionScope.user.roleId == 1}">
								<td><input type="checkbox" class="case" name="ids"
									value="${att_list.id}"></td>
							</c:if>
							<c:if test="${ sessionScope.user.roleId == 1 || sessionScope.user.roleId == 3  ||sessionScope.user.id==att_list.student.id}">
							<td scope="row">${u.index+1}</td>
							<td scope="row">${att_list.student.firstName}</td>
							<td scope="row">${att_list.subjectName}</td>
							<td scope="row">${att_list.classes.className}</td>
							<td scope="row">${att_list.date}</td>
							<td scope="row">${att_list.lectureTitle}</td>
							
							<c:if test="${att_list.status.equalsIgnoreCase('PRESENT')}">						
								<td><i class="fa fa-check-square-o" style="color: green;"></i></td>
							</c:if>
							<c:if test="${att_list.status.equalsIgnoreCase('ABSENT')}">						
								<td><i class="fa fa-close" style="color: red"></i></td>
							</c:if> 
							</c:if>
							<%-- 
							<td><a class="text-dark" href="${editUrl} ${att_list.id}"
									><i class="fas fa-edit"></i></a></td> --%>
							 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
		<div class="clearfix">
			<c:if test="${sessionScope.user.roleId == 1}">
				<input type="submit" name="operation"
					class="btn btn-sm btn-danger float-start"
					<c:if test="${listsize == 0}">disabled="disabled"</c:if>
					value="Delete"> 
				
				
			</c:if>
			<c:if test="${sessionScope.user.roleId == 1}">
				<input type="submit" name="operation"
					class="btn btn-sm btn-secondary float-start"
					<c:if test="${listsize == 0}">disabled="disabled"</c:if>
					value="Present"> 
				
			</c:if>
			<c:if test="${sessionScope.user.roleId == 1}">
				<input type="submit" name="operation"
					class="btn btn-sm btn-warning float-start"
					<c:if test="${listsize == 0}">disabled="disabled"</c:if>
					value="Absent"> 
				
			</c:if>
				
				


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