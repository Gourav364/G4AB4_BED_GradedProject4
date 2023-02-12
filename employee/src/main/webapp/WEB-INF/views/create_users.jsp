<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
        integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <title>Save Student</title>
</head>

<body>

<div class="container">

  <h3 class=".bg-secondary">Employee Management System</h3>
  <hr>

  <p class="h4 mb-4">Create User</p>
  <form class = 'card p-3 bg-light' action="/users/save" method="POST">

    <input type="text" name="username"
           class="form-control mb-4 col-4" placeholder="Username" value="${user.username}">

      <input type="text" name="password"
           class="form-control mb-4 col-4" placeholder="Password" value="${user.password}">

        <select name="roles" multiple="true" value="${user.roles}" class="form-control mb-4 col-4 select">
            <c:forEach items="${roleList}" var="role">
                <option value="${role.id}"  ${fn:contains(user.roles, role) ? 'selected' : ''} >${role.name}</option>
            </c:forEach>
        </select>

    <button type="submit" class="btn btn-primary col-2">Save</button>
  </form>
  <hr>
  <a href="/employees/list">Back to Employee List</a>
</div>
</body>

</html>










