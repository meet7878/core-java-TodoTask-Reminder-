<%@page import="com.bean.UserTaskBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>
<body>

<%
	   ArrayList<UserTaskBean> users = (ArrayList<UserTaskBean>) request.getAttribute("users");
	%>
	
	
	<header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: gray">
   <div>
    <a href="" class="navbar-brand"> Todo
     App</a>
   </div>

  <!--  <ul class="navbar-nav">
    <li><a href="Home.jsp">Todos</a></li>
   </ul> -->

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="LogoutController">Logout</a></li>
    
   </ul>
  </nav>
 </header>


<div class="container">
<h3 class="text-center">List of Todos</h3>
<hr>
<div class="container text-left">

    <a href="AddTask.jsp">Add Todo</a>
    </div>
    <br>
	 <table class="table table-bordered">

					<thead>

						<tr>
							<th>TaskId</th>
							<th>TaskName</th>
							<th>Description</th>
							<th>priority</th>
							<th>Due Date</th>
							<th>Time</th>
							<th>startdate</th>
							<th>status</th>
							<th>Action</th>
							<th>Delete Task</th>
							<th>Edit Task </th>
							
						</tr>

					</thead>
					
					<%	
				 		    for (UserTaskBean user : users){
						%>
						<tr>
							<td><%=user.getTaskid()%></td>
							<td><%=user.getTask()%></td>
							<td><%=user.getDescription()%></td>
							<td><%=user.getPriority()%></td>
							<td><%=user.getDate()%></td>
							<td><%=user.getTime()%></td>
							<td><%=user.getStartdate() %></td>
							<td><%=user.getStatus() %></td>
							<td><a href="UpdateUserTaskController?taskid=<%=user.getTaskid()%>">Done</a></td>
							<td><a href="DeleteTaskController?taskid=<%=user.getTaskid()%>">Delete</a> 
							<td><a href="EditTaskController?taskid=<%=user.getTaskid()%>">EditTask </a>${user.getTaskid()}
							
							
							
						</tr>

						<%
						    }
						%>
					
					</table>
					Score: <input type="text" value="${marks}" disable/>
					</div>
					</div>
					</div>
					
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" ></script>
	<script type="text/javascript">
	$(document).ready(function () {
	    $('#users').DataTable();
	});
	</script> 
					
</body>
</html>