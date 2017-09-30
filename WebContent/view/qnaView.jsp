<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	
				<h2>Q&A</h2>
	<ul>
		
	<li>회원번호<s:property value="resultClass.qna_no" /></li>
	<li>아이디<s:property value="resultClass.qna_mem_id" /></li>
	<li>이름<s:property value="resultClass.qna_name" /></li>
	<li>내용<s:property value="resultClass.qna_content" /></li>
	<li>등록날짜<s:property value="resultClass.qna_date" /></li>
		<s:hidden name="qna_check" theme="simple" value="%{resultClass.qna_check}"  /> 	
		<s:hidden name="currentPage" value="%{currentPage}" />
		
	</ul>
		<%-- 첨부파일<s:url id="download" action="qnaFileDownloadAction">
          		<s:param name="qna_no">
					<s:property value="qna_no" />
				</s:param>
          	</s:url>
					
          <s:a href="%{download}"><s:property value="resultClass.qna_img" /></s:a> 
         
         --%>
	        <%-- <s:url id="modifyURL" action="modifyForm" >
				<s:param name="qna_no">
					<s:property value="qna_no" />
				</s:param>
	        </s:url>
					
	        <s:url id="deleteURL" action="deleteAction" >
				<s:param name="qna_no">
					<s:property value="qna_ no" />
				</s:param>
	        </s:url>
		 --%>
	
	<%-- <input type="button" name="modify" value="수정" class="inputb"
		onclick="javascript:location.href='modifyForm.action?qna_no=<s:property value="resultClass.qna_no" />&currentPage=<s:property value="currentPage" />'">--%>
	 <input type="button" name="list" value="목록" class="inputb"
		onclick="javascript:location.href='admin_qnaList.action?currentPage=<s:property value="currentPage" />'">
	 <input type="button" name="delete" value="삭제" class="inputb"
		onclick="javascript:location.href='QnaDeleteAction.action?qna_no=<s:property value="resultClass.qna_no" />&currentPage=<s:property value="currentPage" />'">
 
