<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="myPage_orderWrite.action" method="post">
	
	<s:hidden name="userReq" value="order" />
	<s:hidden name="re_item" value="%{resultClass.name}"/>
	<s:hidden name="re_price" value="%{resultClass.price}"/>
	<s:hidden name="re_cat_no" value="%{resultClass.cat_no}"/>
	<s:hidden name="re_sal_id" value="%{resultClass.sal_id}"/>
	<input type="hidden" name="re_mem_name" value="${sessionScope.mem_name}"> 

	<ul>
		<li>
			예약 상품 		:	
			<s:property value="resultClass.name" />
		</li>
		<li>
			예약자 성함 	:	
			${sessionScope.mem_name}
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
	
