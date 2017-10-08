<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	
	<s:if test="resultClass == NULL">
		<form action="memberJoin.action" method="post" enctype="multipart/form-data">
	</s:if>
	<s:hidden name="userReq" value="memberWrite" />
	
	
		아이디 :	<input type="text" name="mem_id"><br> 
		비밀번호 :	<input type="text" name="mem_pwd"><br> 
		이름	:	<input type="text" name="mem_name"><br> 
		연락처 :	<input type="text" name="mem_phone"><br>
		이미지 : 	<s:file name="upload" theme="simple" />
		<s:if test="resultClass.img != NULL">
		&nbsp; * <s:property value="resultClass.img" /> 
		파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
		</s:if> <br>
		메모 :	<input type="text" name="memo"><br>
		<input type="submit" name="submit">
		
	
	</form>
	
