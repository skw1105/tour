<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>

<script type="text/javascript">

$(function(){
	$('#delete-panel').deletePanel({
		triger: '.delete';
		//url: 'delete/${member.userId}', // <- 올바른가? 고정적인 url을 쓰면 안된다. 런타임 때 바뀌는 부분이므로
		url: 'delete/{user-id}',
		multiple: '[name=check-item]:checked',
		moveUrl: 'list?page=${param.page}'
	});
	
	// 전체 체크 하기
	$('#check-all').change(function(e){
		$('[name=check-item]').prop('checked', this.checked);
	});
	
	// 개별 체크박스가 체크 해제되면 전체 체크박스도 해제
	$('[name=check-item]').change(function(e){
		$('#check-all').prop('checked', false);
	});
	
	// 체크 항목 삭제 버튼 처리
	$('.check-delete').click(function(e){
		var items = $('[name=check-item]:checked');
		items.each(function(){
			var userId = $(this).val();
		});
	});
});

</script>

<h2 class="my-5 text-primary">
	<i class="fas fa-users"></i> 회원 목록
</h2>
<div class="text-right">
	<a href="create?page=${pi.page}"><i class="fas fa-user-plus"></i>
		추가</a> (총 : ${pi.totalCount} 명)
</div>

<table class="table table-striped table-hover">
	<tr>
		<th>No</th>
		<th>사용자 ID</th>
		<th>이름</th>
		<th>email</th>
		<th>전화번호</th>
		<th>등록일</th>
		<th>수정</th>
	</tr>
	<c:forEach var="member" items="${pi.list}" varStatus="status">
		<tr>
			<td>${pi.totalCount-((pi.page-1)*10)- status.index}</td>
			<td>
				<a href="view/${member.userId}?page=${pi.page}">
					${member.userId} <iot:newToday test="${member.regDate}" />
				</a>
			</td>
			<td>${member.name}</td>
			<td>${member.email}</td>
			<td>${member.phone}</td>
			<td>
				<fmt:formatDate value="${member.regDate}" pattern="yyyy-MM-dd" />
			</td>
			<td class="text-right">
				<a href="edit/${member.userId}?page=${pi.page}"
					class="btn btn-danger btn-sm edit"
					data-user-id="${member.userId}">수정</a>
				<a href="delete/${member.userId}?page=${pi.page}"
					class="btn btn-danger btn-sm delete"
					data-user-id="${member.userId}">삭제</a>
			</td>
		</tr>
	</c:forEach>
</table>

<iot:pagination pageInfo="${pi}"/>