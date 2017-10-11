<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<ul>
		<h2>지역 카테고리 관리</h2>
	</ul>
		
		<form action="admin_areaCatWrite.action" method="post"> 

			<s:hidden name="userReq" value="areaCat" />
			<s:hidden name="no" value="%{resultClass.no}"/>
		
			<s:if test="resultClass != NULL">   
				<s:hidden name="modifyReq" value="modifyReq"/> 
			</s:if>

		
			<ul> 
				<li>
					이름 : <s:textfield name="name" theme="simple" value="%{resultClass.name}" />
				</li>
				
				<li>
					지역 코드 : <s:textfield name="cat_code" theme="simple" value="%{resultClass.cat_code}" />
				</li>
			</ul>

	 
			<input name="submit" type="submit" value="작성완료" class="inputb">

		</form>

			