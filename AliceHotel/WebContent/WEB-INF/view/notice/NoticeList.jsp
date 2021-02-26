<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="Bootstrap 3 Website Template" />

<!-- Stylesheets
    ============================================= -->
<link rel="icon" type="image/png" sizes="16x16"
	href="<c:url value='/resources/images/favicon/favicon-16x16.png' />">
<link rel="icon" type="image/png" sizes="32x32"
	href="<c:url value='/resources/images/favicon/favicon-32x32.png'/>">
<link
	href="http://fonts.googleapis.com/css?family=PT+Sans:300,400,500,600,700"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/dark.css'/>"
	type="text/css" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/font-icons.css'/>" type="text/css" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/animate.css'/>" type="text/css" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/magnific-popup.css'/>"
	type="text/css" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/responsive.css'/>" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="https://unpkg.com/vue-airbnb-style-datepicker@latest/dist/vue-airbnb-style-datepicker.min.css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!--[if lt IE 9]>
       <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->

<!-- External JavaScripts
    ============================================= -->
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/plugins.js'/>"></script>

<!-- Document Title
    ============================================= -->
<title>Ailce Hotel | Notice</title>
<!-- <script language="JavaScript" src="script.js"></script> -->

<style>
form {
	margin: 0 auto;
	width: 400px;
}

table {
	margin: 0 auto;
	width: 1300px;
	border-top: 1px solid black;
	border-collapse: collapse;
}

hr {
	margin: 0 auto;
	width: 1100px;
}

th, td {
	border-bottom: 1px solid black;
	padding: 18px;
	text-align: center;
}
</style>
</head>

<body class="stretched">

	<!-- Document Wrapper
    ============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Header
        ============================================= -->
		<header id="header" class="full-header">

			<div id="header-wrap">

				<div class="container clearfix">

					<div id="primary-menu-trigger">
						<i class="icon-reorder"></i>
					</div>

					<!-- Logo
                    ============================================= -->
					<div id="logo">
						<a href="<c:url value='/'/>" class="standard-logo"
							data-dark-logo="<c:url value='/resources/images/logo/mainlogo.png'/>"><img
							src="<c:url value='/resources/images/logo/mainlogo.png'/>"
							alt="Chocolat Logo"></a> <a href="<c:url value='/'/>"
							class="retina-logo"
							data-dark-logo="<c:url value='/resources/images/logo/mainlogo.png' />"><img
							src="<c:url value='/resources/images/logo/mainlogo.png'/>"
							alt="Chocolat Logo"></a>
					</div>

					<!-- Primary Navigation
                    ============================================= -->
					<nav id="primary-menu">

						<ul class="">
							<li class="current"><a
								href="<c:url value="/hotel-About-Us"/>"><div>호텔소개</div></a>
								<ul>
									<li><a href="<c:url value="/hotel-About-Us"/>"><div>호텔소개</div></a></li>
									<li><a href="<c:url value="/Location"/>"><div>호텔위치</div></a></li>
									<li><a href="<c:url value='/notice/NoticeList'/>"><div>공지사항</div></a></li>
								</ul></li>
							<li><a href="#" onclick="return false;"><div>객실</div></a>
								<ul>
									<li><a href="<c:url value="/deluxe-1"/>"><div>디럭스</div></a>
										<ul>
											<li><a href="<c:url value="/deluxe-1"/>"><div>디럭스
														더블</div></a></li>
											<li><a href="<c:url value="/deluxe-2"/>"><div>디럭스
														트윈</div></a></li>

										</ul></li>
									<li><a href="<c:url value="/suite-1"/>"><div>스위트</div></a>
										<ul>
											<li><a href="<c:url value="/suite-1"/>"><div>패밀리
														스위트</div></a></li>
											<li><a href="<c:url value="/suite-2"/>"><div>그랜드
														스위트</div></a></li>

										</ul></li>
								</ul></li>
							<li><a href="<c:url value="/dining-1"/>"><div>다이닝</div></a>
								<ul>
									<li><a href="<c:url value="/dining-1"/>"><div>파노라마
												(올 데이 다이닝)</div></a></li>
								</ul></li>
							<li><a href="#" onclick="return false;"><div>부대시설</div></a>
								<ul>
									<li><a href="<c:url value="/menu-item"/>"><div>사계절
												온수풀 해온</div></a></li>
									<li><a href="<c:url value="/menu-item2"/>"><div>해온
												루프탑 테라스</div></a></li>
									<li><a href="<c:url value="/menu-item3"/>"><div>프라이빗
												카바나</div></a></li>
								</ul></li>
							<li><a href="<c:url value="/contact-1"/>"><div>고객의
										소리</div></a></li>
							<c:choose>
								<c:when test="${userId ne null}">
									<li><a href="<c:url value='/reservation/r'/>"><div>예약하기</div></a></li>
									<li><a
										href="<c:url value='/reservation/ReservationSelect'/>"><div>예약조회
												및 취소</div></a></li>
								</c:when>
								<c:otherwise>
									<li><a href="<c:url value='/member/LoginLogOut'/>"><div>예약하기</div></a></li>
									<li><a href="<c:url value='/member/LoginLogOut'/>"><div>예약조회
												및 취소</div></a></li>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${userId eq null}">
									<li><a href="<c:url value ='/member/LoginLogOut'/>"><div>로그인</div></a>
										<ul>
											<li><a href="<c:url value ='/member/LoginLogOut'/>"><div>로그인</div></a></li>
											<li><a href="<c:url value='/member/MemberInsert'/>"><div>회원가입</div></a></li>
										</ul></li>
								</c:when>
								<c:otherwise>
									<li><a href="<c:url value='/member/Logout'/>"><div>로그아웃</div></a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</nav>
					<!-- #primary-menu end -->
				</div>
			</div>

		</header>
		<!-- #header end -->

		<!-- Page Title
        ============================================= -->
		<section id="page-title" class="page-title-parallax"
			style="background-image: url('<c:url value="/resources/images/logo/room.PNG"/>'); padding: 120px 0;"
			data-stellar-background-ratio="0.3">

			<div class="container clearfix">
				<FONT SIZE="6" COLOR="white">Ailce Hotel | 공지사항 </span></FONT>
				<ol class="breadcrumb">
				</ol>
			</div>
			<br>
		</section>
		<!-- #page-title end -->


		<br>

		<form action="<c:url value='/notice/NoticeList'/>">


			<c:if test="${userId eq 'admin'}">
				<button type="button" class="well well-sm"
					onclick="location.href='<c:url value='/notice/NoticeWrite'/>'"
					value="글 작성" style="border-radius: 10px;">글 작성</button>
			</c:if>

			<select name="Search" class="btn btn-secondary">
				<option value="SearchSearch"
					<c:out value="${Search eq 'SearchSearch' ? 'selected':''}"/>>
					글번호</option>
				<option value="TitleSearch"
					<c:out value="${Search eq 'TitleSearch' ? 'selected' : ''}"/>>제목</option>
				<option value="ContentSearch"
					<c:out value="${Search eq 'ContentSearch' ? 'selected' : ''}"/>>내용</option>
			</select> <input type="text" class="well well-sm" name="Searchtext"
				id="Searchtext" size="30" placeholder="검색을 통해 찾아보세요"
				value="<c:out value="${Searchtext}"/>">&nbsp;

			<button value="검색" class="well well-sm">검색</button>
		</form>
		<br>

		<!-- ---------------------------------------------------------------------------------------------------- -->
		<!-- 게시글 없을때  -->

		<script>
		$(document).on('click', 'a[href="#"]', function(e){
			e.preventDefault();
		});
		</script>
		<table>
			<tr>
				<th>NO</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<c:forEach items="${NoticeList}" var="NoticeList">
				<tr>
					<td><c:out value="${NoticeList.id}" /></td>
					<td><a
						href="<c:url value='/notice/NoticeContent?id=${NoticeList.id}'/>">
							<c:out value="${NoticeList.title}" />
					</a></td>
					<td><fmt:formatDate value="${NoticeList.date}"
							pattern="yyyy-MM-dd" /></td>
					<td><c:out value="${NoticeList.count}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<script>
		
		//이전 버튼 이벤트
		function fn_prev(page, range, rangeSize) {
				var page = ((range - 2) * rangeSize) + 1;
				var range = range - 1;		
				var url = "${pageContext.request.contextPath}/notice/NoticeList";
				url +="?page=" + page;
				url +="&range=" + range;
				location.href = url;
			}
		
		  //페이지 번호 클릭
			function fn_pagination(page, range, rangeSize, searchType, keyword) {
				var url = "${pageContext.request.contextPath}/notice/NoticeList";
				url +="?page=" + page;
				url +="&range=" + range;
				location.href = url;	
			}

			//다음 버튼 이벤트
			function fn_next(page, range, rangeSize) {
				var page = parseInt((range * rangeSize)) + 1;
				var range = parseInt(range) + 1;
				var url = "${pageContext.request.contextPath}/notice/NoticeList";
				url +="?page=" + page;
				url +="&range=" + range;
				location.href = url;
			}	
	 </script>
		<div style="text-align: center;">
			<ul class="pagination">
				<c:if test="${pagination.prev}">
					<li class="page-item"><a href="#"
						onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Prev</a>
					</li>
				</c:if>
				<c:forEach begin="${pagination.startPage}"
					end="${pagination.endPage}" var="idx">
					<li class="page-item"<c:out value="${pagination.page == idx ? 'active' : ''}"/>" ><a
						class="page-link" href="#"
						onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')">
							${idx}&nbsp &nbsp </a></li>
				</c:forEach>

				<c:if test="${pagination.next}">
					<a class="page-link" href="#"
						onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a>
				</c:if>
			</ul>
		</div>
		<!-- #content end -->

		<!-- Footer
        ============================================= -->
			<footer id="footer" class="footer">

				<div class="container">

					<!-- Footer Widgets
                ============================================= -->
					<div class="footer-widgets-wrap clearfix">

						<div class="col_two_third">

							<div class="widget clearfix" style="padding-left: 84px;">

								<h3>
									(주)엘리스 호텔 <span>02-1544-1111</span>
								</h3>
								<p>63535, 제주특별자치도 서귀포시 중문관광로 72번길, 엘리스 호텔</p>

								<div class="widget subscribe-widget clearfix">
									<h5>
										Email : AilceHotel@AilceHotel.co.kr
										<div id="widget-subscribe-form-result"
											data-notify-type="success" data-notify-msg=""></div>
										<form id="widget-subscribe-form"
											action="include/subscribe.php" role="form" method="post"
											class="nobottommargin"></form>
										<script type="text/javascript">
                                        $("#widget-subscribe-form").validate({
                                            submitHandler: function(form) {
                                                $(form).find('.input-group-addon').find('.icon-email2').removeClass('icon-email2').addClass('icon-line-loader icon-spin');
                                                $(form).ajaxSubmit({
                                                    target: '#widget-subscribe-form-result',
                                                    success: function() {
                                                        $(form).find('.input-group-addon').find('.icon-line-loader').removeClass('icon-line-loader icon-spin').addClass('icon-email2');
                                                        $('#widget-subscribe-form').find('.form-control').val('');
                                                        $('#widget-subscribe-form-result').attr('data-notify-msg', $('#widget-subscribe-form-result').html()).html('');
                                                        IGNITE.widget.notifications($('#widget-subscribe-form-result'));
                                                    }
                                                });
                                            }
                                        });
                                    </script>
								</div>
								<div class="col_half col_last">
									<div class="widget clearfix" style="top: 10px;">

										<div class="hidden-xs hidden-sm">
											<div class="clear" style="padding-top: 10px;"></div>
										</div>

										<div class="col-md-6 bottommargin-sm">

											<div class="widget_links clearfix">
												<ul>
													<li><a href="<c:url value='/'/>"><div>메인</div></a></li>
													<li><a href="<c:url value='/notice/NoticeList'/>"><div>공지사항</div></a></li>
													<li><a href="<c:url value="/hotel-About-Us"/>"><div>호텔소개</div></a></li>
													<li><a href="<c:url value="/Location"/>"><div>호텔위치</div></a></li>
													<li><a href="<c:url value="/contact-1"/>"><div>고객의
																소리</div></a></li>
												</ul>
											</div>
										</div>

										<div class="col-md-6 bottommargin-sm col_last">

											<div class="widget_links clearfix">
												<ul>
													<li><a href="<c:url value="/deluxe-1"/>"><div>객실
																- 디럭스</div></a></li>
													<li><a href="<c:url value="/suite-1"/>"><div>객실
																- 스위트</div></a></li>
													<li><a href="<c:url value="/dining-1"/>"><div>다이닝</div></a></li>
													<li><a href="<c:url value='/reservation/r'/>"><div>예약하기</div></a></li>
													<li><a
														href="<c:url value='/reservation/ReservationSelect'/>"><div>예약조회
																및 취소</div></a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col_one_third col_last">

							<div class="widget clearfix">
								<div class="fancy-title title-border">
									<h4>Hours</h4>
								</div>
								<ul class="nobottommargin nobullets">
									<li><strong>호텔서비스</strong><br>00:00 ~ 24:00</li>
									<br>
									<li><strong>객실예약(주중)</strong><br>09:00 ~ 18:00</li>
									<br>
									<li>업무시간 외에는<br> 온라인 예약을 이용해주시기 바랍니다.
									</li>
								</ul>
							</div>

							<div class="widget clearfix">
								<div class="fancy-title title-border">
									<h4>Address</h4>
								</div>

								<ul class="nobottommargin nobullets">
									<li>63535, 제주특별자치도</li>
									<li>서귀포시 중문관광로 72번길, 엘리스 호텔</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- .footer-widgets-wrap end -->

				</div>

				<!-- Copyrights
            ============================================= -->
				<div id="copyrights">
					<div class="container clearfix">

						<div class="col_half">
							 <img
								src="<c:url value='/resources/images/logo/footer-logo-large.png' />"
								alt="" class="footer-logo retina-logo"> Copyright &copy;
							2021 Ailce Hotel . All Rights Reserved.
						</div>

						<div class="col_half col_last tright">
							<div class="copyrights-menu copyright-links fright clearfix">
								<a href="<c:url value='/notice/NoticeList'/>">공지사항</a> <a
									href="<c:url value="/hotel-About-Us"/>">호텔소개</a> <a
									href="<c:url value="/deluxe-1"/>">객실</a> <a
									href="<c:url value='/reservation/ReservationSelect'/>">예약조회
									및 취소</a> <a href="<c:url value="/contact-1"/>">고객의 소리</a>
							</div>
							<div class="fright clearfix">
								<a href="https://www.facebook.com/"
									class="social-icon si-small si-borderless nobottommargin si-facebook">
									<i class="icon-facebook"></i> <i class="icon-facebook"></i>
								</a> <a href="https://twitter.com/explore"
									class="social-icon si-small si-borderless nobottommargin si-twitter">
									<i class="icon-twitter"></i> <i class="icon-twitter"></i>
								</a> <a href="https://github.com/park002"
									class="social-icon si-small si-borderless nobottommargin si-github">
									<i class="icon-github"></i> <i class="icon-github"></i>
								</a> <a href="https://www.yahoo.com/"
									class="social-icon si-small si-borderless nobottommargin si-yahoo">
									<i class="icon-yahoo"></i> <i class="icon-yahoo"></i>
								</a>
							</div>
						</div>

					</div>

				</div>
				<!-- #copyrights end -->

			</footer>
			<!-- #footer end -->

		</div>
		<!-- #wrapper end -->

		<!-- Go To Top
    ============================================= -->
		<div id="gotoTop" class="icon-angle-up"></div>

		<!-- Footer Scripts
    ============================================= -->
		<script type="text/javascript"
			src="<c:url value='/resources/js/functions.js'/>"></script>
</body>
</html>