<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: deerholdnepal
  Date: 16/09/2021
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Add</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">LMS</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="/demo_war_exploded/user?page=list" methods="get">User</a></li>
            <li><a href="#">Book</a></li>
            <li><a href="#">Requested Book</a></li>
        </ul>

    </div>
</nav>

<div class="container">
    <c:if test="${user!=null}">
    <form action="/demo_war_exploded/user?page=update" method="post">
        <input type="hidden" name="id" class="form-control" value="${user.getId()}">
        </c:if>
        <c:if test="${user==null}">
        <form action="/demo_war_exploded/user?page=insert" method="post">
            </c:if>
            <div class="form-group">
                <label for="firstName">FirstName:</label>
                <input type="text" name="firstName" class="form-control" id="firstName" value="${user.getFirstName()}">
            </div>
            <div class="form-group">
                <label for="lastName">LastName:</label>
                <input type="text" name="lastName" class="form-control" id="lastName" value="${user.getLastName()}">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" name="email" class="form-control" id="email" value="${user.getEmail()}">
            </div>
            <div class="form-group">
                <label for="username">UserName:</label>
                <input type="text" name="username" class="form-control" id="username" value="${user.getUsername()}">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="text" name="password" class="form-control" id="password" value="${user.getPassword()}">
            </div>
            <c:if test="${user!=null}">
                <button type="submit" class="btn btn-default">Update</button>
            </c:if>
            <c:if test="${user==null}">
                <button type="submit" class="btn btn-default">Save</button>
            </c:if>

        </form>
</div>

</body>
</html>
