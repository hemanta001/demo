<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: deerholdnepal
  Date: 28/09/2021
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
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
    <a class="btn btn-primary" href="/demo_war_exploded/user?page=add" role="button">Add</a>
    <h2>User List</h2>
    <table class="table">
        <thead>
        <tr>
            <th>S.N.</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Username</th>
            <th>Password</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList }" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getUsername()}</td>
                <td>${user.getPassword()}</td>
                <td><a class="btn btn-primary" href="/demo_war_exploded/user?id=${user.getId()}&page=edit" role="button">Edit</a></td>
                <td><a class="btn btn-danger" href="#" role="button">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
