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
	  <form class="d-inline-flex" action="list">
		<select class="form-select" id="field" name ="field">
				<option value="title">title</option>
				<option value="writer">writer</option>
				<option value="content">content</option>
		</select>
		<input type="text" class="form-control" id="word" name="word">
		<button type="submit" class="btn btn-success btn-sm">Search</button>
	 </form>
</div>
</body>
</html>