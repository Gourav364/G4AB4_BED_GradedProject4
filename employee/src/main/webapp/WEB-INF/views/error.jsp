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
    <h1><span class="label label-default">Some Error Occurred</span></h1>

    <p>Requested resource was not found. Please contact the administrator.</p>
    <table class="table table-bordered table-striped">
        <tr>
            <td>Status</td>
            <td >${errorObject.status}</td>
        </tr>
        <tr>
            <td>Message</td>
            <td>${errorObject.message}</td>
        </tr>
    </table>
    <a href="/employees/list">Back to Employee List</a>
</div>
</body>
</html>