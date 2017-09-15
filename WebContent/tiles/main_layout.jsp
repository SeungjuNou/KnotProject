<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/maincss.css" type="text/css">
<style type="text/css">
	.main {
	margin: 0px;
	padding: 0px;
	border: 0px;
	overflow: auto;
	list-style-type: none;
}

.main_layout {
	list-style: none;
	
}
	
</style>
</head>
<body>
	
	<div class="main">
		<ul class="main_layout">
			<li>
				<tiles:insertAttribute name="header" />
			</li>
			<li>
				<tiles:insertAttribute name="body" />
			</li>
			<li>
				<tiles:insertAttribute name="footer" />		
			</li>
		</ul>
	</div>
</body>
</html>