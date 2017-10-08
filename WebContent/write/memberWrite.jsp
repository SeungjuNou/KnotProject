<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	
	<s:if test="resultClass == NULL">
		<form action="memberJoin.action" method="post" >
	</s:if>
	
	<s:else>
		<form action="memberModifyForm.action" method="post" >
			<s:hidden name="mem_no" value="%{resultClass.mem_no}" />
	</s:else>
	
		mem_id : <input type="text" name="mem_id"><br> 
		mem_pwd : <input type="text" name="mem_pwd"><br> 
		mem_name : <input type="text" name="mem_name"><br> 
		mem_phone : <input type="text" name="mem_phone"><br>

		<input type="submit" name="submit">
	
	
	</form>
	
