<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


  
	 <s:if test="resultClass == NULL"> 
		<form action="admin_qnaWrite.action" method="post" enctype="multipart/form-data" onsubmit="return validation();">
		<s:hidden name="qna_check" theme="simple" value="%{resultClass.qna_check}"  /> 	
 	</s:if> 
		
	<%-- <s:else>
		
		<form action="modifyAction.action" method="post" enctype="multipart/form-data">
		  <s:hidden name="qna_no" value="%{resultClass.qna_no}" />
		  <s:hidden name="currentPage" value="%{currentPage}" />
		  <s:hidden name="old_file" value="%{resultClass.qna_savimg}" />
	</s:else> --%>
		<ul>	
			<li>
            	아이디 <s:textfield name="qna_mem_id" theme="simple" value="%{resultClass.qna_mem_id}" maxlength="20"/> <br>
      
			이름 <s:textfield name="qna_name" theme="simple" value="%{resultClass.qna_name}"  maxlength="50"/> <br>
            	
            	제목 <s:textfield name="qna_subject" theme="simple" value="%{resultClass.qna_subject}"  maxlength="50"/><br>
          	
            	내용 <s:textarea name="qna_content" theme="simple" value="%{resultClass.qna_content}"  /><br>
            	
            	응답 <s:textarea name="qna_answer" theme="simple" value="%{resultClass.qna_answer}"  /><br>
            </li>	
         </ul>	
          <%--   <s:file name="upload" theme="simple"/>
     
            <s:if test="resultClass.qna_img != NULL">&nbsp; * <s:property value="resultClass.qna_img" /> 
			</s:if>
			 --%>
			<input type="submit" value="제출" />
		</form>
        
       