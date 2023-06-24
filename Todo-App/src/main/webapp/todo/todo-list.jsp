<%@page import="javax.naming.PartialResultException"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="model.bean.Todo"%>
<%@ page language="java" import="controller.SellectAllController"%>

<html>
<head>
<title>User Management Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>



	
	<% if((String)session.getAttribute("user")== null)response.sendRedirect(request.getContextPath()+"/login/login.jsp"); 
	else{%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: silver">
			<div>
				<a href="#" class="navbar-brand"> Todo</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="SellectAllController?load=1"
					class="nav-link">Todos </a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/LogoutController"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Todos</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/todo/todo-form-add.jsp"
					class="btn btn-success">Add Todo</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Target Date</th>
						<th>Todo Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>


					<%
					ArrayList<Todo> list = new ArrayList<Todo>();
					list = (ArrayList<Todo>) request.getAttribute("list");
					if (list != null) {
						System.out.println("Duoc r ne");
						for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><%=list.get(i).getTitle()%></td>
						<td><%=list.get(i).getTargetDate()%></td>
						<td><%=list.get(i).getStatus()%></td>
						<td><a href="EditController?id=<%=list.get(i).getId()%>">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="DeleteController?id=<%=list.get(i).getId()%>">Delete</a></td>
					</tr>
					<%
					}
					} else {
					System.out.println("Loi ne");
					String load = request.getParameter("load");
						if(load==null){
							System.out.println("null");
						response.sendRedirect("SellectAllController?load=1");}
						else{
							System.out.println("load"+load);
							System.out.println("not null");
							//response.sendRedirect( request.getContextPath()+"/controller/SellectAllController?load=1");
							//response.se
						}
						
						

					}
					%>

				</tbody>

			</table>
		</div>
	</div>
	<%} %>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
