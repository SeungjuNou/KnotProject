<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<ul>
		<h2>자주묻는게시판</h2>
	</ul>
		
		<form action="admin_mainCatWrite.action" method="post" enctype="multipart/form-data"> 

			<s:hidden name="userReq" value="mainCatWrite" />
			<s:hidden name="no" value="%{resultClass.no}"/>
		
			<s:if test="resultClass != NULL">   
				<s:hidden name="modifyReq" value="modifyReq"/> 
				<s:hidden name="img" value="%{resultClass.img}" />
			</s:if>

		
			<ul> 
				<li>이름 : <s:textfield name="name" theme="simple" value="%{resultClass.name}" /></li>
				<li>
					아이콘 : <s:file name="upload" theme="simple" />
					<s:if test="resultClass.img != NULL">
						&nbsp; * <s:property value="resultClass.img" /> 파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
					</s:if>
				</li>
	
			</ul>

	 
			<input name="submit" type="submit" value="작성완료" class="inputb">

		</form>

			