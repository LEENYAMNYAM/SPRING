<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<div class="container mt-3">
    <c:forEach items="${fileArr}" var="file" >
        fileName : ${file} </br>
    </c:forEach>
</div>
</body>
</html>
