<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>NOTICE</h2>

<form action="admin_noticeWrite.action" method="post" enctype="multipart/form-data" >

	
	<s:hidden name="userReq" value="notice" />
	<s:hidden name="no" value="%{resultClass.no}"/>

	<s:if test="resultClass != NULL">    
		<s:hidden name="modifyReq" value="modifyReq"/> 
	</s:if>

	<ul>
		
		<li>
			제목<s:textarea name="name" theme="simple" value="%{resultClass.name}" />
		</li>
		
		<li>
			내용<s:textarea name="content" theme="simple" value="%{resultClass.content}" />
		</li>
	</ul>
	
	<input name="submit" type="submit" value="작성완료" class="inputb">

</form>