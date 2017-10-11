<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Knot</title>
<link rel="stylesheet" href="css/main_header.css?ver=0" type="text/css">
<link rel="stylesheet" href="css/footer.css?ver=0" type="text/css">
<style type="text/css">

	html, body {
	height: 100%; 
	width: 100%;
	margin: 0 auto;
	padding: 0;
}

.main, .main_layout {
	height: 100%;
	width: 100%;
	margin: 0;
	padding: 0;
}

.main_layout li {
	float: left;
	list-style: none;
}

.content {
	width: 100%;
	height: 1000px;	
	background-color: gray;
}

.bodyForm {
	width: 80%;
	height: auto;
	margin: 50px auto;
}


#footer {
	display: none;
}


</style>
</head>
<body>
	
	<div class="main">
		<ul class="main_layout">
			<li class="head">
				<tiles:insertAttribute name="header" />
			</li>
			<li class="content">
				<div class="bodyForm">
					<tiles:insertAttribute name="body" />
				</div>
			</li>
			<li class="foot">
				<tiles:insertAttribute name="footer" />		
			</li>
		</ul>
	</div>

<script src="js/jquery-1.10.1.min.js"></script>
<script src="js/idangerous.swiper-2.1.min.js"></script>
<script>
var mySwiper = new Swiper('.swiper-container', {
	pagination : '.pagination',
	loop : true,
	grabCursor : true,
	paginationClickable : true
})

$('.arrow-left').on('click', function (e) {
	e.preventDefault()
	mySwiper.swipePrev()
});

$('.arrow-right').on('click', function (e) {
	e.preventDefault();
	mySwiper.swipeNext();
})
</script>

</body>
</html>