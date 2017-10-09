<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<form action="itemWrite.action" method="post" enctype="multipart/form-data">
	

	<s:hidden name="userReq" value="itemWrite" />
	<s:hidden name="no" value="%{resultClass.no}"/>

	<s:if test="resultClass != NULL">   
		<s:hidden name="modifyReq" value="modifyReq"/> 
		<s:hidden name="img" value="%{resultClass.img}" /> 
	</s:if>

	<ul>
		<li>
			NAME 			:	
			<s:textfield name="name" theme="simple" value="%{resultClass.name}" />
		</li>
		<li>
			PRICE  			:	
			<s:textfield name="price" theme="simple" value="%{resultClass.price}" />
		</li>
		<li>
			CAT_NO 			:	
			<s:textfield name="cat_no" theme="simple" value="%{resultClass.cat_no}" />
		</li>
		<li>
			AREA_CAT_NO 	:	
			<s:textfield name="area_cat_no" theme="simple" value="%{resultClass.area_cat_no}" />
		</li>
		<li>
			ITEM_SUM 		:	
			<s:textfield name="item_sum" theme="simple" value="%{resultClass.item_sum}" />
		</li>
		<li>
			ITEM_DETAIL 	:	
			<s:textfield name="item_detail" theme="simple" value="%{resultClass.item_detail}" />
		</li>
		<li>
			IMG				: 	
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
	
