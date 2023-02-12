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

    <h3 class=".bg-secondary">Employee List</h3>
    <hr>

    <a href="/employees/showFormForAdd" class="btn btn-primary btn-sm mb-3">Add Employee</a>
    <a href="/roles/showFormForAddRole" class="btn btn-primary btn-sm mb-3">Add Role</a>
    <a href="/users/showFormForAddUser" class="btn btn-primary btn-sm mb-3">Add User</a>
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${employees}" var="employee">
        <tr>

                <td>${employee.firstName} </td>
                <td>${employee.lastName}</td>
                <td>${employee.email} </td>

           <td>
                <div class="row">

                    <div class="col-small">

                        <form action="/employees/showFormForUpdate" method="GET">

                            <input type="hidden" name="employeeId" value="${employee.id}"/>
                            <button type="submit" class="btn btn-primary btn-sm ml-3 mr-1">Update</button>

                        </form>
                    </div>

                    <div class="col-small">
                        <form action="/employees/delete" method="POST">

                            <input type="hidden" name="employeeId" value="${employee.id}"/>
                            <button type="submit" class="btn btn-danger btn-sm"
                                    onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">
                                Delete
                            </button>
                        </form>
                    </div>
                </div>
            </td>

        </tr>
         </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>



