<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Login</title>
</head>



<div style="justify-content: center; margin-top: 100px;padding-right: 35%; padding-left: 25%">

    <form action="authentication" method="post">

        <div class="form-outline mb-4">
            <label for="username" class="form-label">Username</label>
            <input id="username" name="username" type="text" placeholder="Enter username " required class="form-control">
        </div>
        <div  class="form-outline mb-4">
            <label class="form-label" for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Enter password " required class="form-control">
        </div>


        <button type="submit" class="btn btn-primary btn-block mb-4 w-100">Sign in</button>



        <div class="text-center">
            <p>Not a member? <a href="registration">Register</a></p>
        </div>



    </form>
</div>



</body>
</html>