<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2025-03-24
  Time: 오전 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>상세보기</h2>
    <form>
    이름 : <input type="text" id="name" name="name" value="${person.name}"> <br/>
    아이디 : <input type="text" id="id" name="id" value="${person.id}" readonly="readonly"> <br/>
    성별 : <input type="text" id="gender" name="gender" value="${person.gender}"> <br/>
    직업 : <input type="text" id="job" name="job" value="${person.job}"> <br/>

        <a href="update?id=${person.id}" > 수정폼 </a>
        <a href="delete?id=${person.id}" > 삭제 </a>
    </form>
</body>
</html>
