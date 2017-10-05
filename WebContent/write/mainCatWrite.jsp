<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<h2>카테고리</h2>

	<s:if test="resultClass == NULL">
		<form action="admin_mainCatWrite.action" method="post"
			enctype="multipart/form-data" onsubmit="return validation();">
	</s:if>

	<s:else>
		<form action="admin_mainCatModify.action" method="post"
			enctype="multipart/form-data">
			<s:hidden name="cat_no" value="%{resultClass.cat_no}" />
			<s:hidden name="currentPage" value="%{currentPage}" />
			<s:hidden name="old_file" value="%{resultClass.cat_img}" />
	</s:else>

	<s:textfield name="cat_name" theme="simple" value="%{resultClass.cat_name}"/>
	<s:file name="upload" theme="simple" />

	<s:if test="resultClass.cat_img != NULL">&nbsp; * <s:property value="resultClass.cat_img" /> 파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.</s:if>

<ul>
	<li><input name="submit" type="submit" value="작성완료" class="inputb"></li>
	<li><input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='mainCat_list.action?currentPage=<s:property value="currentPage" />'"></li>
</ul>
	
	</form>