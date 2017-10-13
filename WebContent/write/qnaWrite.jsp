<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>QNA</h2>

<c:if test="${sessionScope.mem_lev eq 3}">
<form action="admin_qnaWrite.action" method="post" enctype="multipart/form-data" >
</c:if>

<c:if test="${sessionScope.mem_lev le 2}">
<form action="admin_qnaWrite.action" method="post" enctype="multipart/form-data" >
</c:if>
	
	<s:hidden name="userReq" value="qna" />
	<s:hidden name="no" value="%{resultClass.no}"/>

	<s:if test="resultClass != NULL">    
		<s:hidden name="modifyReq" value="modifyReq"/> 
		<s:hidden name="img" value="%{resultClass.img}" /> 
	</s:if>

	<ul>
		<li>
			회원아이디<s:textfield name="mem_id" theme="simple" value="%{resultClass.mem_id}" />
		</li>
		<li>
			작성자<s:textfield name="mem_name" theme="simple" value="%{resultClass.mem_name}" />
		</li>
		<li>
			제목<s:textarea name="name" theme="simple" value="%{resultClass.name}" />
		</li>
		<li>
			내용<s:textarea name="content" theme="simple" value="%{resultClass.content}" />
		</li>
		<c:if test="${sessionScope.mem_lev eq 3}">
		<li>
			답변<s:textarea name="answer" theme="simple" value="%{resultClass.answer}" />
		</li>
		</c:if>
		<li>
			첨부파일<s:file name="upload" theme="simple" />
		</li>
		<li>
			<s:if test="resultClass.img != NULL">&nbsp; * <s:property value="resultClass.img" /> 파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.</s:if>		
		</li>
	
	</ul>
	
	<input name="submit" type="submit" value="작성완료" class="inputb">

</form>
