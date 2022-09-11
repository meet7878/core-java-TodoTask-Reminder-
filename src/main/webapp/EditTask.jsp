<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
	
</head>
<body>



<div style="background-color:#41aaa2; height:400px; width:400px; border-radius:30px; text-align:center;" class="col-md-offset-4">
<form method="post" action="UpdateController" >
<h1 style="text-align:center; padding-top:30px; color:#ffffff;">Edit Task</h1>
<input type="text" hidden="" name="taskid" value="${taskid}">
<div class="col-sm-12" style="padding-top:10px;">
<input type="text" class="form-control" id="firstname" placeholder="Enter Task Name:"  name="task" value="${taskValue}" style="border-radius:15px;">${taskError}
</div>
<div class="col-sm-12" style="padding-top:10px;">
<input type="text" class="form-control" id="lastname" placeholder="Enter Description:" name="description" style="border-radius:15px;">
</div>
<div class="col-sm-12" style="padding-top:10px;">
<!-- <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" style="border-radius:15px;"> -->

Enter The Priority:
					<select name="priority"  class="form-control">
                    <option  value="Low">Low</option> 
                    <option value="Medium">Medium</option> 
                    <option value="High">High</option> 
 </select><br><br>

${taskid }
</div>

<input type="submit" class="btn btn-primary"  value="Submit"><br><br>

</form>
</div>

<%-- <div class="container-fluid">
		<div class=row>
			<div class="col-md-4"></div>
			<div class="col-md-4">
<form method="post" action="AddTaskController">
Enter Task Name:<input type="text" name="task" class="form-control" value="${taskValue}" />${taskError}<br><br>
Enter Description:<input type="text" name="description" class="form-control"><br><br>
Enter The Priority:
					<select name="priority" class="form-control">
                    <option  value="Low">Low</option> 
                    <option value="Medium">Medium</option> 
                    <option value="High">High</option> 
 </select><br><br>
Due Date:<input type="date" name="date" class="form-control" ><br><br>
<input type="time" name="time" class="form-control" ><br><br>
<center><input type="submit" class="btn btn-primary"  value="Submit"><br><br>


</form>

</div>
</div>
</div> --%>


</body>
</html>





