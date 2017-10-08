<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<h2>QNA</h2>

	<s:if test="resultClass == NULL">
		<form action="admin_qnaWrite.action" method="post" enctype="multipart/form-data" >
	</s:if>
	
	<s:hidden name="userReq" value="qnaWrite" />

<ul>
	<li>회원아이디<s:textfield name="mem_id" theme="simple" value="%{resultClass.mem_id}" />
	<li>작성자<s:textfield name="mem_name" theme="simple" value="%{resultClass.mem_name}" />
	<li>제목<s:textarea name="name" theme="simple" value="%{resultClass.name}" />
	<li>내용<s:textarea name="content" theme="simple" value="%{resultClass.content}" />
	<li>답변<s:textarea name="answer" theme="simple" value="%{resultClass.answer}" />
	<li>첨부파일<s:file name="upload" theme="simple" />

	
	<s:if test="resultClass.img != NULL">&nbsp; * <s:property value="resultClass.img" /> 파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.</s:if>
</ul>
<input name="submit" type="submit" value="작성완료" class="inputb">
<input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='admin_qnaList.action?currentPage=<s:property value="currentPage" />'">
</form>
