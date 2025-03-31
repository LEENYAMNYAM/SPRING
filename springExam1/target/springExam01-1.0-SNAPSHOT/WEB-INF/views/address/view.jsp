<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상세보기</h3>
<form action="update" method="post">
<%-- <input type="hidden" name="num" value="<%=address.getNum() %>"> --%>
	<table>
		<tr>
			<th>번호</th>
		<%-- 	<td><%=address.getNum() %></td>  --%>
		<td><input type="text" name="num" value="${address.num }"  readonly="readonly"> </td>
		</tr>	
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" value="${address.name}" ></td>
		</tr>	
		<tr>
			<th>우편번호</th>
			<td><input type="text" name="zipcode"  id="zipcode" value="${address.zipcode }"   size=7 >
			<button type="button" onclick="zipfinder()">검색</button>
			</td>
		</tr>	
		<tr>
			<th>주소</th>
			<td><input type="text" name="addr" id="addr"  value="${address.addr }" size=50></td>
		</tr>	
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="tel"  value="${address.tel }" ></td>
		</tr>	
		<tr>
			<td colspan="2">
			<button>수정</button>
			<input type="reset" value="수정취소">
			<button type="button" onclick="location.href='delete?num=${address.num}'">삭제</button>
			<button type="button" onclick="location.href='list'">전체보기</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>







