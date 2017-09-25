<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




  <h2>회원리스트</h2>
      <s:iterator value="list" status="stat">

      <ul>
      	<li><s:property value="mem_num" /> <s:property value="mem_id" /> <s:property value="mem_name" /> <s:property value="mem_date" /></li>
      </ul>
           
      </s:iterator>

<s:property value="pagingHtml" escape="false" />


 