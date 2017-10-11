<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul>
		<li>
			<h2>ITEM</h2>
		</li>
      
     	<li>	NO				: <s:property value="resultClass.no" /> 			</li>
      	<li>	NAME			: <s:property value="resultClass.name" /> 			</li>
      	<li>	PRICE			: <s:property value="resultClass.price" /> 			</li>
      	<li>	CAT_NO			: <s:property value="resultClass.cat_no" /> 		</li>
      	<li>	AREA_CAT_NO		: <s:property value="resultClass.area_cat_no" />	</li>
      	<li>	ITEM_SUM		: <s:property value="resultClass.item_sum" /> 		</li>
      	<li>	ITEM_DETAIL		: <s:property value="resultClass.item_detail" /> 	</li>
      	<li>	IMG				: <s:property value="resultClass.img" /> 			</li>
      	<li>	ITEM_READHIT	: <s:property value="resultClass.item_readhit" /> 	</li>
      	<li>	SAL_ID			: <s:property value="resultClass.sal_id" /> 		</li>
      	<li>	SAL_NAME		: <s:property value="resultClass.sal_name" /> 		</li>
      	<li>	RE_DATE			: <s:property value="resultClass.re_date" /> 		</li>
      

</ul>


    <input type="button" name="list" value="삭제" class="inputb" onclick="javascript:location.href='admin_itemDelete.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />&userReq=item';">

    
    <input type="button" name="list" value="목록" class="inputb" onclick="javascript:location.href='admin_item.action?currentPage=<s:property value="currentPage" />&userReq=item';">
