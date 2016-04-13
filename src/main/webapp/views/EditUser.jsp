<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Simple jsp page</title>

    <script type="text/javascript" src="/scripts/jquery-1.11.2.min.js"> </script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="/css/style.css">
    <script>
        function onch(){
            var country_id = document.getElementById('country').value;
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (xhttp.readyState == 4 && xhttp.status == 200) {
                    document.getElementById("city").innerHTML = xhttp.responseText;
                }
            };
            xhttp.open("GET","/addcity?id="+ country_id, true);
            xhttp.send();
        }
    </script>

</head>
<body>

<div class="container">
    <form class="form-horizontal" role="form" action="${pageContext.servletContext.contextPath}/useredit" method="post"  onsubmit="return check_info();">

        <div id = "reg"> <h2>Edit</h2> </div>

        <div class="form-group">
            <label for="firstName" class="col-sm-3 control-label"> Name</label>
            <div class="col-sm-9">
                <input type="text" name="name" id="firstName" placeholder="Full Name" class="form-control" value = "${users.getName()}" autofocus>
            </div>
        </div>


        <div class="form-group">
            <label for="firstName" class="col-sm-3 control-label">Last Name</label>
            <div class="col-sm-9">
                <input type="text" id="lastname" placeholder="Full Name" class="form-control" name="lastname" value = "${users.getLastname()}" autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="email" class="col-sm-3 control-label">Email</label>
            <div class="col-sm-9">
                <input type="email" id="email"  name="email" placeholder="Email" class="form-control" value = "${users.getEmail()}">
            </div>
        </div>

        <div class="form-group">
            <label for="country" class="col-sm-3 control-label">Country</label>
            <div class="col-sm-9">
                <select id="country" class="form-control"  onchange="onch()" name="id">
                    <option onclick="">Выберите Страну</option>
                    <c:forEach var="country" items="${country}" >
                        <option value="${country.getId()}" >
                            <c:out value="${country.getName()}"/></option>
                    </c:forEach>

                </select>
            </div>
        </div> <!-- /.form-group -->


        <div class="form-group">
            <label for="country" class="col-sm-3 control-label">City</label>
            <div class="col-sm-9">
                <select id="city" class="form-control" name="cit">
                    <option>

                    </option>

                </select>
            </div>
        </div> <!-- /.form-group -->


        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block">Edit</button>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->











</body>
</html>