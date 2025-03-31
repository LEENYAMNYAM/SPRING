<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2025-03-21
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>개인 정보 입력</h2>
<form action="pinsert" method="post">
    이름    : <input type="text" name="name"><br>
    아이디: <input type="text" name="id"><br>
    패스워드 : <input type="password" name="password"><br>
    성별:
    <label for="man">  남</label>
    <input type="radio" name="gender" id="man"  value="남" checked >
    여 <input type="radio" name="gender" value="여"><br>
    직업:
    <select name="job">
        <option value="회사원">회사원
        <option value="학생">학생
        <option value="기타">기타
    </select><br><br>
    <input type="submit" value="확인">
    <input type="reset"  value="취소">
</form>
</body>
</html>
