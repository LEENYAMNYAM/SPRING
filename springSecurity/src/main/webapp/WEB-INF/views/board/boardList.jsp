<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file ="../includes/header.jsp" %>
<div class="container mt-5">
	<h2>Board List(${count})</h2>
	
	<table class="table table-hover">
		<thead>
		        <tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
		      	</tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${barr }" var="board"  varStatus="st">
		  		<tr>
		  			<td>${board.num } </td>
		  			<td><a href="view?num=${board.num }">${board.title }</a></td>
		  			<td>${board.writer }</td>
		  			<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
		  		</tr>
		</c:forEach>
  </tbody>
  </table>

<%--	페이징 --%>
	<div class="d-flex justify-content-between mt-3">
		<ul class="pagination">
			<!-- 이전 버튼이 나와야 하는 if문 -->
			<c:if test="${p.startPage > p.blockPage}">
				<li class="page-item"><a class="page-link" href="list?pageNum=${p.startPage-p.blockPage}">Previous</a></li>
			</c:if>
			<!-- 페이지번호 -->
			<c:forEach begin="${p.startPage }" end="${p.endPage }" var="i">
				<c:if test="${p.currentPage!=i}">
					<li class="page-item"><a class="page-link" href="list?pageNum=${i}">${i}</a></li>
				</c:if>
				<c:if test="${p.currentPage==i}">
					<li class="page-item active"><a class="page-link" href="#">${i}</a></li>
				</c:if>
			</c:forEach>
			<!-- 이후 버튼이 나와야 하는 if문 -->
			<c:if test="${p.endPage < p.totPage}">
				<li class="page-item"><a class="page-link" href="list?pageNum=${p.endPage+1}">Next</a></li>
			</c:if>		</ul>
	</div>
</div>




</body>
</html>