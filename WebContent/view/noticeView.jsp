<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul>
		<li>
			<h2>NOTICE</h2>
		</li>

		<li>	NO			: <s:property value="resultClass.no" />		 </li>
		<li>	TODATE		: <s:property value="resultClass.todate" />	 </li>
		<li>	NAME		: <s:property value="resultClass.name" />	 </li>
		<li>	CONTENT		: <s:property value="resultClass.content" /> </li>
</ul>
