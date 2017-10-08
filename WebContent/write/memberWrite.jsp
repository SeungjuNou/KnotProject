<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	
	
	<form action="memberJoin.action" method="post" enctype="multipart/form-data">
	

	<s:hidden name="userReq" value="memberWrite" />
	<s:hidden name="no" value="%{resultClass.no}"/>

	<s:if test="resultClass != NULL">   
		<s:hidden name="modifyReq" value="modifyReq"/> 
		<s:hidden name="img" value="%{resultClass.img}" /> 
	</s:if>

	<ul>
		<li>
			아이디 	:	
			<s:textfield name="mem_id" theme="simple" value="%{resultClass.mem_id}" />
		</li>
		<li>
			패스워드 	:	
			<s:password name="mem_pwd"  value="%{resultClass.mem_pwd}" />
		</li>
		<li>
			패스워드	:	
			<s:textfield theme="simple" value="%{resultClass.mem_id}" />
		</li>
		<li>
			이름  	:	
			<s:textfield name="mem_name" theme="simple" value="%{resultClass.mem_name}" />
		</li>
		<li>
			연락처 	:	
			<s:textfield name="mem_phone" theme="simple" value="%{resultClass.mem_phone}" />
		</li>
		<li>
			프로필	: 	
		</li>
		<li>
			<s:file name="upload" theme="simple" />
			<s:if test="resultClass.img != NULL">
				<s:property value="resultClass.img" /> 
			</s:if> 
		</li>
	</ul>
		
		<input type="submit" name="submit">
		
	
	</form>
	
