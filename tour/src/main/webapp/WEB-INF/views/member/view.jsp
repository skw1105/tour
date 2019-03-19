<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

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

	<div class="row">
		<div class="col-sm-6 mx-auto">
			<h2 class="my-5 text-primary">
				<i class="fas fa-user"></i> 사용자 정보
			</h2>
			<div class="my-1">사용자 ID : ${member.userId}</div>
			<div class="my-1">이름 : ${member.name}</div>
			<div class="my-1">레벨 : ${member.userLevel}</div>
			<div class="my-1">email : ${member.email}</div>
			<div class="my-1">전화번호 : ${member.phone}</div>
			<div class="my-1">주소 : ${member.address}</div>
			<div class="my-1">
				가입일 :
				<fmt:formatDate value="${member.regDate}" pattern="yyyy-MM-dd" />
			</div>
			<div class="my-1">
				수정일 :
				<fmt:formatDate value="${member.updateDate}" pattern="yyyy-MM-dd" />
			</div>
		</div>
	</div>
	<hr />

	<div class="text-center">
		<a href="edit" class="btn btn-primary text-white"> <i
			class="fas fa-edit"></i> 수정
		</a>
	</div>
</body>
</html>