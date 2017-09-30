<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <ul>
		<li>
			<h2>FAQ 게시판</h2>
		</li>
      
      <li>번호: <s:property value="resultClass.faq_no" /> </li>
      <li>제목: <s:property value="resultClass.faq_subject" /> </li>
      <li>내용: <s:property value="resultClass.faq_content" /> </li>
  </ul>
       <%-- 
	        <s:url id="modifyURL" action="modifyForm" >
				<s:param name="no">
					<s:property value="no" />
				</s:param>
	        </s:url>
					
	        <s:url id="deleteURL" action="deleteAction" >
				<s:param name="no">
					<s:property value="no" /> 
				</s:param>
	        </s:url> --%>
	<%-- 			
	<input name="list" type="button" value="수정" class="inputb" onClick="javascript:open_win_noresizable('checkForm.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />','modify')">
					<!-- 프로퍼티는 리절트클래스에있는 글번호를 가져오는거 , 글번호와 현재페이지와 모디파이를 전달 -->
	<input name="list" type="button" value="삭제" class="inputb" onClick="javascript:open_win_noresizable('checkForm.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />','delete')">
					
	<input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='listAction.action?currentPage=<s:property value="currentPage" />'"> --%>

 