<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25. 4. 10.
  Time: 오후 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/login">
        i d : <input type="text" name="username" id="username" placeholder="Enter ID"><br/>
        pwd : <input type="password" name="password" id="password" placeholder="Enter Password"><br/>
        <button type="submit"> 로그인 </button>
    </form>
</body>
</html>
