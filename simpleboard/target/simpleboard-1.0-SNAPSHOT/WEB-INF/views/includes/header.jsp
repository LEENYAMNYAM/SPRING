<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
 <script src="https://code.jquery.com/jquery-3.7.1.min.js" ></script>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-danger navbar-dark">
	<div class="container-fluid">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link active" href="#">Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/board/list">BOARDINSERT</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/board/list">BOARDLIST</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/fileList">FILEBOARLIST</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/fileInsert">FILEBOARDINSERT</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/uploadFile">UPLOADFILE</a>
			</li>
		</ul>
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty sessionScope.sMember}">
			<li class="nav-item">
				<a class="nav-link" href="/member/login">LOGIN</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/member/join">JOIN</a>
			</li>
				</c:when>
				<c:otherwise>
			<li class="nav-item">
				<a class="nav-link" href="/member/logout">LOGOUT(${sMember.name})</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/member/update">USERUPDATE</a>
			</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>
