<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25. 4. 4.
  Time: 오전 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<div class="container mt-3">
    <form action="join" method="post" id="frm">
        <div class="mb-3 mt-3">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
        </div>

        <div class="row">
            <div class="col mb-3">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
            </div>
            <div class="col mb-3 align-self-end">
                <span id="idcheck"></span>
            </div>
        </div>

        <div class="mb-3">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="pwd">
        </div>

        <div class="mb-3">
            <label for="pwd_check">Password_check:</label>
            <input type="password" class="form-control" id="pwd_check" placeholder="Enter password_check" name="pwd_chek">
        </div>

        <div class="mb-3">
            <label for="addr">Address:</label>
            <input type="text" class="form-control" id="addr" placeholder="Enter address" name="addr">
        </div>

        <div class="mt-3">
            <button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
        </div>
    </form>
</div>
<script>
    $("#btnJoin").click(function(){

        const data = {
            id : $("#id").val(),
            name : $("#name").val(),
            password : $("#password").val(),
            addr : $("#addr").val()
        }
        $.ajax({
            type : "post",
            url : "/member/join",
            contentType : "application/json;charset=utf-8",
            data : JSON.stringify(data)
        }).done(function(resp){
            if(resp == "success") {
                alert("회원 가입을 축하합니다.");
                $("#idcheck").html("");
                location.href="/member/login"
            }else if(resp == "fail"){
                $("#idcheck").html("<b> 아이디 중복확인 하세요</b>")
                $("#id").val("");
            }
        }).fail(function(e){
            alert("회원가입 실패 : " + e);
        })

    })
</script>

</body>
</html>
