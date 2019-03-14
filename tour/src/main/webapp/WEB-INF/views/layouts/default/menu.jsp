<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="${contextPath}/"> <i
		class="fas fa-globe-americas"></i> Travel.com
	</a>
	<button class="navbar-toggler" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-list-ul"></i> 여행목록
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-hotel"></i> 숙박지
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${contextPath}/board/list"> <i class="fas fa-calendar-alt"></i>
					게시판
			</a></li>
		</ul>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-user-plus"></i> 회원가입
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-sign-in-alt"></i> 로그인
			</a></li>
		</ul>
	</div>
</nav>