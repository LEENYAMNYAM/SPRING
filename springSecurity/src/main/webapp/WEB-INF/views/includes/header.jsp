<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 톰캣 9버전 라이브러리 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 시큐리티 태그 라이브러리 --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
<nav class="navbar navbar-expand-sm bg-success navbar-dark">
	<div class="container-fluid">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link active" href="#">Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/board/write">BOARDWRITE</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/board/list">BOARDLIST</a>
			</li>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li class="nav-item">
				<a class="nav-link" href="/product/insert">PRODUCTINSERT</a>
			</li>
			</sec:authorize>
		</ul>
		<sec:authentication property="principal" var="pinfo" />

		<ul class="navbar-nav">
			<%-- 시큐리티 authorize: 권한, isAnonymous() : 누구나, isAuthenticated() : 권한이 있는 사람만 --%>
			<sec:authorize access="isAnonymous()">
				<c:set var="loginUserid" value="" />
				<li class="nav-item">
					<a class="nav-link" href="/customLogin">LOGIN</a>
				</li>
			</sec:authorize>
				<%-- 헤더에 principal 객체를 저장 --%>

			<sec:authorize access="isAuthenticated()">
			<li class="nav-item">
				<c:set var="loginUserid" value="${pinfo.memberDTO.userid}" />
				<a class="nav-link" href="/customLogout">LOGOUT(<sec:authentication property="principal.memberDTO.username"/>)</a>
			</li>
			</sec:authorize>
				<input type="hidden" id="loginUser" value="${loginUserid}" />
		</ul>
	</div>
</nav>
