<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A</title>
</head>
<body>
	<h2>Q&A</h2>
<ul>
<li>회원번호아이디이름내용답변등록날짜이미지체크</li>
</ul>
<ul>
  <s:iterator value="list" status="stat">
		<s:url id="viewURL" action="qna_view">
			<s:param name="qna_no"><s:property value="qna_no" /></s:param>
			<s:param name="currentPage"><s:property value="currentPage" /></s:param>
		</s:url>
		
	<li><s:property value="qna_no" />
		<s:property value="qna_mem_id" />
		<s:property value="qna_name" />
		<s:property value="qna_subject" />
		<s:a href="%{viewURL}"><s:property value="qna_content" /></s:a>
		<s:property value="qna_answer" />
		<s:property value="qna_date" />
		<s:property value="qna_img" />
		<s:property value="qna_check" />
	</li>
  </s:iterator>	
		
	
</ul>
			
	<s:if test="list.size() <= 0">
			등록된 게시물이 없습니다.
	</s:if>
<s:property value="pagingHtml" escape="false" />
		<form action="qna_list.action" method="post">
			<s:textfield name="find" theme="simple" value="" cssStyle="width:100px" maxlength="20" />
			<input type="submit" name="findSubmit" value="검색" class="inputb">
		</form>
		
<input type="button" value="글쓰기" class="inputb" onClick="javascript:location.href='qnaWriteForm.action?&currentPage=<s:property value="currentPage" />';"></li>

</body>
</html>