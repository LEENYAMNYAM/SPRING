<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25. 4. 10.
  Time: 오후 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Admin</h1>
    <p> princial : <sec:authentication property="principal" /></p>
    <p> Member : <sec:authentication property="principal.memberDTO" /></p>
    <p> 사용자 이름 : <sec:authentication property="principal.memberDTO.username" /></p>
    <p> 사용자 ID : <sec:authentication property="principal.memberDTO.userid" /></p>
    <p> 사용자 ID(username) : <sec:authentication property="principal.username" /></p>
    <p> 권한 : <sec:authentication property="principal.memberDTO.authList" /></p>
</body>
</html>
