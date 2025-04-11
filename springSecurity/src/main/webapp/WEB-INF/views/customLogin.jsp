<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file ="includes/header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container mt-5">
    <h2> Login Form </h2>
    <form method="post" action="/login">
        <div class="mb-3 mt-3">
            <label for="username">ID:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        </div>
        <div class="mb-3 mt-3">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <button type="submit" class="btn btn-primary"> 로그인 </button>
    </form>
</div>
</body>
</html>
