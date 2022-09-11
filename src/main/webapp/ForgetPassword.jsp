<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

</head>
<body>



<section class="vh-100">
<form method="post" action="ForgotController">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
          class="img-fluid" alt="Sample image">
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
        
      


          <!-- Email input -->
          <div class="form-outline mb-4">
            <input type="email" name="email" id="form3Example3" class="form-control form-control-lg"
              placeholder="Enter a valid email address" />
            <label class="form-label" for="form3Example3">Email address</label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-3">
            <input type="text" name="sports" id="form3Example4" class="form-control form-control-lg"
              placeholder="Please Enter the Sports" />
            <label class="form-label" for="form3Example4">Sport</label>
          </div>

          <div class="d-flex justify-content-between align-items-center">
          
            
            <a href="#!" class="text-body">Please Correct Answer?</a>
          </div>

          <div class="text-center text-lg-start mt-4 pt-2">
            <input type="submit" value="correct" class="btn btn-primary btn-lg"
              style="padding-left: 2.5rem; padding-right: 2.5rem;"><br>
           
          </div>
          
          <center><span class="text-danger">${errormsg}</span></center>
          

        
      </div>
    </div>
  </div>
  </form>
  <div
    class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
   
</div>
  
</section>

  <%--   <form method="post" action="ForgotController">
    <div class="container">
    
    <div class="row"></div>
    <div class="col-md-4"></div>
<div class="col-md-4">
 <div class="form-group">
						Please Enter the Email<input type="email" name="email" class="form-control" />
					</div>
					<div>
						Please Enter the Sports<input type="text" name="sports" class="form-control" /><br>
					  
					</div>
					 
					<center><input type="submit" value="Reset" class="btn btn-primary" /></center>
					<center><span class="text-danger">${errormsg}</span></center>

</div>
</form>

</div> --%>
</body>
</html>

