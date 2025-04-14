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
				<c:if test="${pinfo.username == board.writer}">
					<button type="submit" class="btn btn-primary"
					 onclick="location.href='update/${board.num}'">수정</button>
					<button type="button" class="btn btn-secondary"
					 id="btnDelete">삭제</button>
				</c:if>
			</sec:authorize>
</div>
<script>
	//삭제
	$("#btnDelete").click(function(){
		if(!confirm("정말 삭제할까요?")){
			return false;
		}
		$.ajax({
			type : "Delete",
			url : "/board/delete/${board.num}",   /* 레스트 or 레스트풀방식 이라고 부름*/
			success : function (resp){
				alert(resp + "번 삭제 성공")
				location.href="/board/list"
			},
			error:function (e){
				alert("삭제실패 : " + e)
			}
		})
	})
</script>

</body>
</html>




