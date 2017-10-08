<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 
  <h2>1:1문의</h2>
     <ul>
      <s:iterator value="list" status="stat">
		
		<s:url id="viewURL" action="admin_qnaView">
			<s:param name="no">
				<s:property value="no"/>
				
			</s:param>
			<s:param name="currentPage">
				<s:property value="currentPage" />
			</s:param>
		</s:url>
		
     
      	<li>
      	<s:property value="no" />
      	<s:property value="mem_id" />
      	<s:a href="%{viewURL}"><s:property value="mem_name" /></s:a>
      	<s:property value="name" />
      	<s:property value="content" />
      	<s:property value="answer" />
      	<s:property value="todate" />
      	<s:property value="img" />
      	<s:property value="answer_check" />
      	</li>

  
           
      </s:iterator>
    </ul>
    
    <s:if test="list.size() <= 0">
    	등록된 게시물이 없습니다.
    </s:if>
<%-- <s:property value="pagingHtml" escape="false" /> --%>

<input type="button" name="write" value="글쓰기" class="inputb"
		onclick="javascript:location.href='admin_qnaForm.action?qna_no=<s:property value="resultClass.qna_no" />&currentPage=<s:property value="currentPage" />'">
	

