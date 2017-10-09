<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <ul>
		<li>
			<h2>QNA</h2>
		</li>
      
      	<li>	NO				: <s:property value="resultClass.no" /> 			</li>
      	<li>	MEM_ID			: <s:property value="resultClass.mem_id" /> 		</li>
      	<li>	MEM_NAME		: <s:property value="resultClass.mem_name" /> 		</li>
		<li>	NAME			: <s:property value="resultClass.name" /> 			</li>
		<li>	CONTENT			: <s:property value="resultClass.content" /> 		</li>
      	<li>	ANSWER			: <s:property value="resultClass.answer" /> 		</li>
      	<li>	TODATE			: <s:property value="resultClass.todate" /> 		</li>
		<li>	IMG				: <s:property value="resultClass.img" /> 			</li>
		<li>	ANSWER_CHECK 	: <s:property value="resultClass.answer_check" /> 	</li>
  </ul>
