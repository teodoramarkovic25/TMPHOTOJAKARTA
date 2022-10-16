<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Register</title>
</head>
<body>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                        <form method="post" action="register">




                            <div class="row">
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" id="username" name="username" class="form-control form-control-lg " placeholder="username"/>
                                             <p style="color: aqua"><%=request.getAttribute("message")%>></p>
                                    </div>


                                </div>
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="password" id="password" name="password" class="form-control form-control-lg" placeholder="password" />

                                    </div>

                                </div>
                            </div>






                            <div class="row">
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" id="firstName" name="name" class="form-control form-control-lg " placeholder="First Name"/>

                                    </div>

                                </div>
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" id="lastName" name="surname" class="form-control form-control-lg" placeholder="Last Name " />

                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <input type="email" id="emailAddress" name="email" class="form-control form-control-lg" placeholder="email" />

                                    </div>

                                </div>
                                <div class="col-md-6 mb-4 pb-2">



                                </div>
                            </div>

                            <div class="row">
                                <div class="col-12">
                                    <div>

                                        <label class="form-label select-label">Choose town</label>
                                    </div>


                                    <select class="select form-control-lg w-50" id="town " name="town" required="true">

                                        <c:forEach items = "${townList} " var = "town">
                                            <option> ${town}</option>
                                        </c:forEach>

                                    </select>


                                </div>
                            </div>

                            <div class="mt-4 pt-2">
                                <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
                            </div>




                            <div class="text-center">
                                <p>Back to login? <a href="login">Login</a></p>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
