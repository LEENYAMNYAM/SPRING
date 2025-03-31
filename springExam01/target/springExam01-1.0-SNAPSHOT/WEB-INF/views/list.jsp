<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2025-03-21
  Time: 오전 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Person List</h2>
<c:forEach items="${personList}" var="person">
    이름 :${person.name}<br/>
    아이디 : ${person.id}<br/>
    성별 : ${person.gender}<br/>
    직업 : ${person.job}  <br/><br/>
</c:forEach>
</body>
</html>
