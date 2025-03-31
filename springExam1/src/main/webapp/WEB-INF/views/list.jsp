<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2025-03-21
  Time: 오전 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2> Person List(${count})</h2>

    <form action="plist">
        <select name = "field">
            <option value="name">이름</option>
            <option value="job">직업</option>
        </select>
        <input type="text" name="word">
        <input type="submit" value="검색">
    </form>


    <c:forEach items="${personList}" var="person">
        이름 : ${person.name} <br/>
        아이디 :<a href="pview?id=${person.id}"> ${person.id} </a> <br/>
        성별 : ${person.gender}<br/>
        직업 : ${person.job}<br/>
    </c:forEach>
</body>



</form>
</html>
