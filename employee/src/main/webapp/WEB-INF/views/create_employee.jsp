<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Employee Management System</title>
</head>
<body>

<div class="container">

    <h3 class=".bg-secondary">Employee Management System</h3>
    <hr>

    <p class="h4 mb-4">Create Employee</p>

    <form class = 'card p-3 bg-light' action="/employees/save" method="POST">

      <input type="hidden" name="id" value="${employee.id}" />
        <input type="text" name="firstName" value="${employee.firstName}"
               class="form-control mb-4 col-4" placeholder="Employee First Name">

        <input type="text" name="lastName"  value="${employee.lastName}"
               class="form-control mb-4 col-4" placeholder="Employee Last Name">

        <input type="text" name="email"  value="${employee.email}"
               class="form-control mb-4 col-4" placeholder="Employee Email">

        <button type="submit" class="btn btn-primary col-2">Save</button>

    </form>

    <hr>
    <a href="/employees/list">Back to Employee List</a>

</div>
</body>

</html>










