<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul>
		<li>
			<h2>NOTICE</h2>
		</li>

		<li>	
			NO			: 
			<s:property value="resultClass.no" />		 
		</li>
		<li>
			order_date		: 
			<s:property value="resultClass.order_date" />	 
		</li>
		<li>
			NAME		: 
			<s:property value="resultClass.re_mem_name" />	 
		</li>
		<li>
			PRICE		: 
			<s:property value="resultClass.re_price" /> 
		</li>
		<li>
			ORDER_DTL		: 
			<s:property value="resultClass.order_dtl" /> 
		</li>
</ul>


	

	<input type="button" name="list" value="삭제" class="inputb" onclick="javascript:location.href='admin_orderDelete.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />&userReq=order';">

	
	<input type="button" name="list" value="목록" class="inputb" onclick="javascript:location.href='admin_order.action?currentPage=<s:property value="currentPage" />&userReq=order';">

		