<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<ul>
		<h2>메인 카테고리 관리</h2>
	</ul>
	
		<html>
			<body>
				<script type="text/javascript">
				      function check_onclick() {
				      var f = document.memberInfo;
				     
				   if(f.name.value == ""){
				            alert("이름을 입력해주십시오.");
				             return false;
				   }
				   else if(f.img.value == ""){
				         	alert("아이콘을 입력해주십시오.");
				          	return false;
				   }
				   else {
				   alert("작성완료 되었습니다.")
				   f.submit();
				   }  
				   return true;
				}
				   
				</script> 
		
		<form name="memberInfo" action="admin_mainCatWrite.action" method="post" enctype="multipart/form-data" onsubmit="return check_onclick();">

			<s:hidden name="userReq" value="mainCat" />
			<s:hidden name="no" value="%{resultClass.no}"/>
		
			<s:if test="resultClass != NULL">   
				<s:hidden name="modifyReq" value="modifyReq"/> 
				<s:hidden name="img" value="%{resultClass.img}" />
			</s:if>

			
			<ul> 
				<c:if test="${sessionScope.mem_lev eq 3}">
				<li>이름 : <s:textfield name="name" theme="simple" value="%{resultClass.name}" /></li>
				<li>
					아이콘 : <s:file name="upload" theme="simple" />
					<s:if test="resultClass.img != NULL">
						&nbsp; * <s:property value="resultClass.img" /> 파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
					</s:if>
				
				</li>
			</c:if>
				
	
			</ul>

	 			
				<input name="submit" type="submit" value="작성완료" class="inputb">
				
		</form>
	</body>
</html>
			