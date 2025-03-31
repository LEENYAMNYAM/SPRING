<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2025-03-21
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
    <h2> 개인 정보 수정 </h2>
    <form action="update" method="post">
        이름 : <input type="text" name="name" value="${person.name}"}><br>
        아이디 : ${person.id}<br>
        <input type="hidden" name="id" value="${person.id}">
        패스워드 : <input type="password" name="password" value="${person.password}"><br>
        성별 :
        <label for="man"> 남</label>
        <input type="radio" name="gender" id="man" value="남">
        여 <input type="radio" name="gender" value="여"><br>
        직업 :
        <select name="job" id="job">
            <option value="회사원">회사원</option>
            <option value="학생">학생</option>
            <option value="기타">기타</option>
        </select><br><br>

        <%--제이쿼리통해서 gender속성과 option 값 가져오기--%>
<%--        <script>--%>
<%--            $("input:radio[value='${person.gender}']").prop("checked", true);--%>
<%--            ${"#job option"}.each(function (){--%>
<%--                if($(this).val() =="${person.job}"){--%>
<%--                    $(this).prop("selected", true)--%>
<%--                }--%>
<%--            })--%>
<%--        </script>--%>
        <%-- 자바스크립트로 gender속성과 option 속성값 가져오기--%>
        <script>
            document.querySelector("input[value='${person.gender}']").setAttribute("checked", true)

            document.querySelector("#job option").value = "${person.job}"
            /* for 문을 사용한다면 */
            <%--document.querySelectorAll("#job option").forEach((currentElement, index)=>{--%>
            <%--    if(currentElement.value =="${[person.job]}"){--%>
            <%--        document.querySelector("#job").value = "${person.job}"--%>
            <%--    }--%>
            <%--})--%>
            /* 제이쿼리문도 for문 안써도 됨. */

        </script>
            <input type="submit" value="수정">
            <input type="reset" value="취소">
    </form>

</body>
</html>
