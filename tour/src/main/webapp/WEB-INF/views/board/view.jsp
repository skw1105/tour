<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<script>

	function deleteBoard(boardId, password) {
		$.ajax({
			url : `../delete/\${boardId}?password=\${password}`,
			type : 'delete',
			dataType : 'json', // 서버가 리턴해야하는 데이터 타입
			cache : false,
			success : function(data) {
				if(data.result == 'success') {
					location = '../list';
				} else {
					alert(data.result);
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log(`\${statusText} - \${xhr.status} , \$errorThrown`);
			}
		});
	}

	$(function() {
		// 목록으로 가기 버튼
		$('.back').click(function() {
			location = '../list?page=' + ${param.page};
		});

		// 삭제 버튼
		$('.delete').click(function() {
			$(".password-panel").show();
		});

		// 취소 버튼
		$('.cancel').click(function() {
			$(':password').val('');
			$('.password-panel').hide();
		});

		// 삭제 진행 버튼
		$('.password-panel').submit(function(e) {
			e.preventDefault();
			var result = confirm("삭제할까요?");
			if (result) {
				// ajax로 삭제
				deleteBoard(${board.boardId}, $(':password').val());
			}
		});
	});
</script>


</head>
<body>
	<div class="container">
		<h2 class="my-5">
			<i class="fas fa-file-alt"></i> ${board.title}
		</h2>
		<div style="overflow: hidden">
			<div class="float-left">작성자 : ${board.writer}, 조회수 :
				${board.readCnt}</div>
			<div class="float-right">
				수정일 :
				<fmt:formatDate value="${board.updateDate}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</div>
		</div>
		<hr />
		${board.content}
		<hr />
		<form class="my-3 password-panel" style="display: none">
			비밀번호 : <input type="password" name="password" required>
			<button type="submit" class="btn btn-primary btn-sm">
				<i class="fas fa-times"></i> 삭제
			</button>
			<button type="button" class="btn btn-primary btn-sm cancel">
				<i class="fas fa-undo"></i> 취소
			</button>
		</form>
		<div class="text-center">
			<a href="../edit/${board.boardId}?page=${param.page}"
				class="btn btn-primary ok text-white"> <i class="fas fa-edit"></i>
				수정
			</a>
			<button class="btn btn-danger delete">
				<i class="fas fa-trash"></i> 삭제
			</button>
			<button type="button" class="btn btn-primary back">
				<i class="fas fa-undo"></i> 목록
			</button>
		</div>
	</div>
	<!-- end of div.container -->
</body>
</html>