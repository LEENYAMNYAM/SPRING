<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
 <%@ include file ="../includes/header.jsp" %>
<div class="container mt-5">
	<h2>Board LIST(${count })</h2>
	
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
<%--	검색 --%>
	  <form class="d-inline-flex" action="list">
		<select class="form-select" id="searchField" name ="searchField">
			<option value="title">제목</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" class="form-control" id="searchWord" name="searchWord">
		<button type="submit" class="btn btn-success btn-sm">Search</button>
	 </form>

<%--	페이징 --%>
	<div class="d-flex justify-content-between mt-3">
		<ul class="pagination">
			<!-- 이전 버튼이 나와야 하는 if문 -->
			<c:if test="${p.startPage > p.blockPage}">
				<li class="page-item"><a class="page-link" href="list?pageNum=${p.startPage-p.blockPage}&searchField=${p.searchField}&searchWord=${p.searchWord}">Previous</a></li>
			</c:if>
			<!-- 페이지번호 -->
			<c:forEach begin="${p.startPage }" end="${p.endPage }" var="i">
				<c:if test="${p.currentPage!=i}">
					<li class="page-item"><a class="page-link" href="list?pageNum=${i}&searchField=${p.searchField}&searchWord=${p.searchWord}">${i}</a></li>
				</c:if>
				<c:if test="${p.currentPage==i}">
					<li class="page-item active"><a class="page-link" href="#">${i}</a></li>
				</c:if>
			</c:forEach>
			<!-- 이후 버튼이 나와야 하는 if문 -->
			<c:if test="${p.endPage < p.totPage}">
				<li class="page-item"><a class="page-link" href="list?pageNum=${p.endPage+1}&searchField=${p.searchField}&searchWord=${p.searchWord}">Next</a></li>
			</c:if>
		</ul>
	</div>


</div>
</body>
</html>