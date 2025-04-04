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
        <div class="mb-3 mt-3">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" value="${sMember.name}" placeholder="Enter Name" name="name">
        </div>

        <div class="row">
            <div class="col mb-3">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="id" value="${sMember.name}" placeholder="Enter ID" name="id" readonly="readonly">
            </div>
        </div>

        <div class="mb-3">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" value="${sMember.password}" placeholder="Enter password" name="pwd">
        </div>

        <div class="mb-3">
            <label for="pwd_check">Password_check:</label>
            <input type="password" class="form-control" id="pwd_check" placeholder="Enter password_check" name="pwd_chek">
        </div>

        <div class="mb-3">
            <label for="addr">Address:</label>
            <input type="text" class="form-control" id="addr" value= "${sMember.addr}" placeholder="Enter address" name="addr">
        </div>

        <div class="mt-3">
            <button type="button" class="btn btn-primary" id="btnUpdate">회원정보 수정</button>
        </div>
</div>
<script>
    $("#btnUpdate").click(function(){
        if( $("#password").val() != $("#pwd_check").val() ){
            alert("비밀번호가 맞지 않습니다.")
            $("#pwd_check").focus()
            return false;
        }
        const data = {
            id : $("#id").val(),
            name : $("#name").val(),
            password : $("#password").val(),
            addr : $("#addr").val()
        }
        $.ajax({
            type : "Put",
            url : "/member/update",
            contentType : "application/json;charset=utf-8",
            data : JSON.stringify(data)
        }).done(function(resp){
            if(resp == "success"){
            alert("회원정보 수정 성공")
            location.href = "/member/login"
            }
        }).fail(function(e){
            alert("회원정보 수정 실패 : " + e);
        })

    })
</script>

</body>
</html>
