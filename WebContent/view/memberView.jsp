<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul>
		<li>
			<h2>MEMBER</h2>
		</li>
      
      	<li>	MEM_ID		: <s:property value="resultClass.mem_id" /> 	</li>
     	<li>	MEM_PWD		: <s:property value="resultClass.mem_pwd" /> 	</li>
     	<li>	MEM_NAME		: <s:property value="resultClass.mem_name" /> 	</li>
     	<li>	MEM_PHONE	: <s:property value="resultClass.mem_phone" /> 	</li>
     	<li>	IMG			: <s:property value="resultClass.img" /> 		</li>
     	<c:if test="${sessionScope.mem_lev eq 3}">
     		<li>	MEMO			: <s:property value="resultClass.memo" /> 	</li>
     	</c:if>
     	<li>	MEM_LEV		: <s:property value="resultClass.mem_lev" /> 	</li>
</ul>

		