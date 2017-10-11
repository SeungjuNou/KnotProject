<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	
	
<form action="admin_orderWrite.action" method="post">
	

	<s:hidden name="userReq" value="order" />
	<s:hidden name="re_item" value="상품명"/>
	<s:hidden name="re_cat_no" value="1"/>
	<s:hidden name="re_price" value="2000"/>
	<s:hidden name="re_sal_id" value="판매자 id"/>

	<ul>
		<li>
			예약 상품 		:	
			<s:property value="테스트임니답...." />
		</li>
		<li>
			예약자 성함 	:	
			<s:textfield name="re_mem_name"  theme="simple" />
		</li>
		<li>
			가격 			:	
			<s:property value="resultClass.price" />
		</li>
		<li>
			요청사항 	 	:	
			<s:textfield name="order_dtl" theme="simple" />
		</li>
	</ul>
		
	<input type="submit" name="submit">
		
</form>
	
