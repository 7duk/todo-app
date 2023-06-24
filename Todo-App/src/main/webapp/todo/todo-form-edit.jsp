<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="model.bean.Todo"%>
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
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: silver">
			<div>
				<a href="#" class="navbar-brand"> Todo
					</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="/LTM_JSP/SellectAllController?load=1"
					class="nav-link">Todos</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/LogoutController"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form action="<%=request.getContextPath()%>/EditController?edit=1"
					method="post">
					<caption>
						<h2>Edit Todo</h2>
					</caption>

					<%
					Todo list = new Todo();
					list = (Todo)request.getAttribute("list");
					%>
					<input type="hidden" name="id" value="<%=list.getId() %>" />
					

					<fieldset class="form-group">
						<label>Todo Title</label> <input type="text"
							value="<%=list.getTitle() %>" class="form-control"
							name="title" required="required" minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>Todo Decription</label> <input type="text"
							value="<%=list.getDescription() %>"
							class="form-control" name="description" minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>Todo Status</label> <select class="form-control"
							name="isDone">
							<option value="false">In Progress</option>
							<option value="true">Complete</option>
						</select>
					</fieldset>

					<fieldset class="form-group">
						<label>Todo Target Date</label> <input type="date"
							value="<%=list.getTargetDate()%>" class="form-control"
							name="targetDate" required="required">
					</fieldset>

					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
