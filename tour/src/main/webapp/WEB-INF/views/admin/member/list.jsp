<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<h2 class="my-5">
			<i class="fas fa-list"></i> 회원 목록
		</h2>
		<div class="text-right">
			<a href="create"><i class="fas fa-edit"></i> 글쓰기</a> (총 :
			${pi.totalCount} 건)
		</div>
		<table class="table table-striped table-hover">
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>등급</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>등록일</th>
			</tr>
			<c:forEach var="member" items="${pi.list}">
				<tr>
					<td>${member.userId}</td>
					<td><a href="view/${member.userId}?page=${pi.page}">
							${member.name}
							<iot:newToday test="${member.regDate}"></iot:newToday>
							</a></td>
					<td>${member.email}</td>
					<td>${member.phone}</td>
					<td>${member.address}</td>
					<td><fmt:formatDate value="${member.regDate}"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
		<!-- 페이지네이션 -->
		<iot:pagination pageInfo="${pi}"></iot:pagination>
	</div>
	<!-- end of div.contatiner -->
</body>
</html>