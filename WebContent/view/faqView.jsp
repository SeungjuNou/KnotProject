<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <ul>
		<li>
			<h2>FAQ 게시판</h2>
		</li>
      
      <li>번호: <s:property value="resultClass.no" /> </li>
      <li>제목: <s:property value="resultClass.name" /> </li>
      <li>내용: <s:property value="resultClass.content" /> </li>

  </ul>
