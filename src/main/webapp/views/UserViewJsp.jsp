<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/table.css">










<div class="container">
<div class="row col-md-6 col-md-offset-2 custyle">
<table class="table table-striped custab">
<thead>
<a href="${pageContext.servletContext.contextPath}/addusers" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new User</a>
<a href="/deleteall" class="btn btn-primary btn-xs pull-left"><b>+</b> Delete All</a>
<tr>
    <th>ID:</th>
    <th>Name:</th>
    <th>Lastname:</th>
    <th>Email:</th>
    <th>Country:</th>
    <th>City:</th>
    <th class="text-center">Action</th>
</tr>
</thead>
<c:forEach items="${users}" var="users" varStatus="status">
    <tr>
    <td>${users.getUserid()}</td>
    <td>${users.getName()}</td>
    <td>${users.getLastname()}</td>
    <td>${users.getEmail()}</td>
    <td>${users.getCountry()}</td>
    <td>${users.getCity()}</td>

    <td class="text-center">
    <a class='btn btn-info btn-xs' href="${pageContext.servletContext.contextPath}/useredit?id=${users.getUserid()}"><span class="glyphicon glyphicon-edit"></span> Edit</a>
    <a href="${pageContext.servletContext.contextPath}/deleteuser?id=${users.getUserid()}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
    </tr>
    </c:forEach>
    </table>
    </div>
    </div>

