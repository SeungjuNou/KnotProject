<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<form action="admin_itemWrite.action" method="post" enctype="multipart/form-data">
	

	<s:hidden name="userReq" value="item" />
	<s:hidden name="no" value="%{resultClass.no}"/>
	<s:hidden name="sal_id" value="%{sessionScope.mem_id}"/>
	<s:hidden name="sal_name" value="%{sessionScope.mem_name}"/>

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
    			<s:select name="cat_no" list="list" listKey="no" listValue="name"  value="%{resultClass.cat_no}"  >
    			</s:select>
		</li>
		<li>
			AREA_CAT_NO 	:	
			<s:select name="area_cat_no" list="list3" listKey="no" listValue="name"  value="%{resultClass.area_cat_no}"  >
    			</s:select>
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
	
