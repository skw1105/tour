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
				<i class="fas fa-user-cog"></i> 회원 정보 수정
			</h2>
			<form:form modelAttribute="member">
				<form:hidden path="userId" />
				<div class="form-group">
					<label for="userId">사용자 ID </label>
					<p class="form-control-static">${member.userId}</p>
				</div>
				<div class="form-group">
					<label for="password">비밀번호</label>
					<form:password path="password" class="form-control" />
					<form:errors path="password" element="div" cssClass="error" />
				</div>
				<div class="form-group">
					<form:hidden path="name" class="form-control" />
					<label for="name">이름</label>
					<p class="form-control-static">${member.name}</p>
				</div>
				<div class="form-group">
					<label for="userLevel">사용자 레벨</label>
					<form:select path="userLevel" class="form-control" />
				</div>
				<div class="form-group">
					<label for="email">email</label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" element="div" cssClass="error" />
				</div>
				<div class="form-group">
					<label for="phone">전화번호</label>
					<form:input path="phone" class="form-control" />
				</div>
				<div class="form-group">
					<label for="address">주소</label>
					<form:input path="address" class="form-control" />
					<form:errors path="address" element="div" cssClass="error" />
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary ok">
						<i class="fas fa-check"></i> 완료
					</button>
					<a href="../view/${member.userId}?page=${param.page}"
						class="btn btn-primary back"> <i class="fas fa-undo"></i> 돌아가기
					</a>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>