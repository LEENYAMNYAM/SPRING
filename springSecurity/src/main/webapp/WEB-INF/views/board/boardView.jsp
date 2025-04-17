<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<div class="container mt-5">
		<h2>Board View</h2>
		<input type="hidden" name="num" id="num" value="${board.num }">
		<table class="table table-hover">
			<tr>
				<th>글번호</th>
				<td>${board.num }</td>
				<th>조회수</th>
				<td>${board.hitcount }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer }</td>
				<th>작성일</th>
				<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/> </td>
			</tr>
			<tr>
				<th>글제목</th>
				<td colspan="3">${board.title }</td>
			</tr>
			<tr>
				<th>내용</th>
			<td colspan="3">${board.content }</td>
			</tr>
		</table>
			<sec:authorize access="isAuthenticated()">
				<c:if test="${pinfo.memberDTO.userid == board.writer}">
					<button type="submit" class="btn btn-primary"
					 onclick="location.href='update/${board.num}'">수정</button>
					<button type="button" class="btn btn-secondary"
					 id="btnDelete">삭제</button>
				</c:if>
				<div class = "container mt-3">
					<label for="msg">msg:</label>
					<textarea class="form-control" id="msg" name="msg"
							  placeholder="Content goes here" rows=5></textarea>
					<button class="btn btn-success btn-sm mt-3" id="btnComment">Comment Write</button>
					<div class="mt-3">Comment(<span class="cntSpan"></span>)</div>
				</div>
			</sec:authorize>
		<div class = "container mt-3">
			<div id="result"></div>
		</div>
</div>
<script>
	//board 삭제
	$("#btnDelete").click(function(){
		if(!confirm("정말 삭제할까요?")){
			return false;
		}
		$.ajax({
			type : "Delete",
			url : "/board/delete/${board.num}",
			success : function (resp){
				alert(resp + "번 삭제 성공")
				location.href="/board/list"
			},
			error:function (e){
				alert("삭제실패 : " + e)
			}
		})
	})

	// 댓글 리스트 & 삭제버튼 출력

	const init = function (){
		$.ajax({
			type : "get",
			url : "/reply/commentList/${board.num}"
		}).done(function (resp) {
			let str = "<table class='table table-sub-heading-color'>" +
					"<tr>" +
					"<th class='col-2'>작성자</th>" +
					"<th class='col-6'>댓글</th>" +
					"<th class='col-2'>작성일</th>" +
					"<th class='col-2'></th>" +
					"</tr>";

			const loginUser = document.getElementById("loginUser").value;

			$.each(resp.clist, function (key, val) {
				str += "<tr>";
				str += "<td>" + val.userid + "</td>";
				str += "<td>" + val.content + "</td>";
				str += "<td>" + val.regdate + "</td>";

				if (val.userid.trim() === loginUser) {
					str += "<td><a href='javascript:fdel(" + val.cnum + ")'> 삭제 </a></td>";
				} else {
					str += "<td></td>";
				}

				str += "</tr>";
			});

			str += "</table>";
			$(".cntSpan").html(resp.count);
			$("#result").html(str);
		}).fail(function (e){
			alert("실패 : " + e)
		})

	}

	// 댓글 삭제(a태그)
	function fdel(cnum){
		$.ajax({
			type : "DELETE",
			url : "/reply/delete/" + cnum
		}).done(function (resp){
			alert(resp + " 번 삭제 성공")
			init()
		}).fail(function (e){
			alert("삭제 실패 : " + e)
		})
	}

	// 댓글 작성
	$("#btnComment").click(function(){
		if($("#msg").val() == ""){
			alert("댓글 내용을 입력하세요")
			return;
		}
		const dataVal = {
			"bnum" : $("#num").val(),
			"content" : $("#msg").val()
		}
		$.ajax({
			type : "POST",
			url : "/reply/commentInsert",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(dataVal),
			success: function (resp){
				$("#msg").val()
				alert("댓글추가" + resp)
				init()
			},
			error:function(e) {
				alert("댓글 추가 실패 : " + e)
			}
		})
	})

	init()

</script>

</body>
</html>




