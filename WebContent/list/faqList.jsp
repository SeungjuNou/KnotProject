<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<ul>
		<li>
			<h2>FAQ 게시판</h2>
		</li>
		
		<s:iterator value="list" status="stat">
			<!-- iterator는 모든값을 받아와서 반복해서출력 -->
			
			<s:url id="faqViewURL" action="faqView">
				<li>번호 제목</li>
				<s:param name="faq_no">
					<s:property value="faq_no" />
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage" />
				</s:param>
			</s:url>
	
			
				<li>
					<s:property value="faq_no" />
					<s:a href="%{faqViewURL}"> 
						<s:property value="faq_subject" />
					</s:a>
				</li>
	
		</s:iterator>
	</ul>
	

	<s:if test="list.size() <= 0">
			등록된 게시물이 없습니다.
	</s:if>

	<s:property value="pagingHtml" escape="false" />
	
		
		