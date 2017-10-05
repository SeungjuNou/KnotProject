<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 
  <h2>1:1문의</h2>
     <ul>
      <s:iterator value="list" status="stat">
		
		<s:url id="viewURL" action="admin_qnaView">
			<s:param name="qna_no">
				<s:property value="qna_no"/>
				
			</s:param>
			<s:param name="currentPage">
				<s:property value="currentPage" />
			</s:param>
		</s:url>
		
     
      	<li>
      	<s:property value="qna_no" />
      	<s:property value="qna_id" />
      	<s:a href="%{viewURL}"><s:property value="qna_name" /></s:a>
      	<s:property value="qna_date" />
      	</li>

  
           
      </s:iterator>
    </ul>
    
    <s:if test="list.size() <= 0">
    	등록된 게시물이 없습니다.
    </s:if>
<%-- <s:property value="pagingHtml" escape="false" /> --%>

<input type="button" name="write" value="글쓰기" class="inputb"
		onclick="javascript:location.href='admin_qnaForm.action?qna_no=<s:property value="resultClass.qna_no" />&currentPage=<s:property value="currentPage" />'">
	

