<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
      function check_onclick() {
            var f = document.memberInfo;
   
       if(f.name.value == ""){
               	 alert("상품 이름을 입력해주십시오.");
                 return false;
		}
       else if(f.price.value == ""){
             	alert("상품 가격을 입력해주십시오.");
              	return false;
		}
       else if(f.item_sum.value == ""){
                alert("요약을 입력해주십시오.");
                return false;
		}
       else if(f.item_detail.value == ""){
                alert("항목세부정보를 입력해주십시오.");
                return false;
		}
       else if(f.upload.value == ""){
           alert("사진을 등록해주세요.");
           return false;
		}

   else {
   alert("등록되었습니다.")
   f.submit();
   }  
   return true;
}

</script> 
<c:if test="${sessionScope.mem_lev eq 3}">
	<form name="memberInfo" action="admin_itemWrite.action" enctype="multipart/form-data" method="post" onsubmit="return check_onclick();">
</c:if> 

<c:if test="${sessionScpoe.mem_lev le 3}">
	<form name="memberInfo" action="other_itemWrite.action" enctype="multipart/form-data" method="post" onsubmit="return check_onclick();">
</c:if>
	

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
			상품 이름 			:	
			<s:textfield name="name" theme="simple" value="%{resultClass.name}" />
		</li>
		<li>
			상품 가격			:	
			<s:textfield name="price" theme="simple" value="%{resultClass.price}" />
		</li>
		<li>

			카테고리 번호 		:	
    			<s:select name="cat_no" list="list" listKey="no" listValue="name"  value="%{resultClass.cat_no}"  >
    			</s:select>
		</li>
		<li>
			지역카테고리 번호	:	
			<s:select name="area_cat_no" list="list3" listKey="no" listValue="name"  value="%{resultClass.area_cat_no}"  >
    			</s:select>
		</li>
		<li>
			요약 				:	
			<s:textfield name="item_sum" theme="simple" value="%{resultClass.item_sum}" />
		</li>
		<li>
			항목세부정보 		:	
			<s:textarea name="item_detail" theme="simple" value="%{resultClass.item_detail}" />
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