<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
 
//     아이디와 비밀번호가 맞지 않을 경우 가입버튼 비활성화를 위한 변수설정
    var idCheck = 0;
    var pwdCheck = 0;
    //아이디 체크하여 가입버튼 비활성화, 중복확인.
    function checkId() {
        var inputed = $('.mem_id').val();
        $.ajax({
            data : {
                mem_id : inputed
            },
            url : "idCheckAction.action",
            success : function(data) {
                if(data=='1') {
                    $(".signupbtn").prop("disabled", true);
                    $(".signupbtn").css("background-color", "#aaaaaa");
                    $("#checkaa").css("background-color", "#FFCECE");
                } else if (data == '0') {
                    $("#checkaa").css("background-color", "#B0F6AC");
                } else if (inputed=="" &&data == '1') {
                    $(".signupbtn").prop("disabled", true);
                    $(".signupbtn").css("background-color", "#aaaaaa");
                    $("#checkaa").css("background-color", "#FFCECE");
                } 
            }
        });
    }


</script>


	
	
	<form action="memberJoin.action" method="post" enctype="multipart/form-data">
	

	<s:hidden name="userReq" value="member" />
	<s:hidden name="no" value="%{resultClass.no}"/>

	<s:if test="resultClass != NULL">   
		<s:hidden name="modifyReq" value="modifyReq"/> 
		<s:hidden name="img" value="%{resultClass.img}" /> 
	</s:if>

	<ul>
		<li>
			아이디 	:	
			<s:textfield name="mem_id" theme="simple" value="%{resultClass.mem_id}" required class="id" oninput="checkId()" id="checkaa" />
		</li>
		<li>
			패스워드 	:	
			<s:password name="mem_pwd" theme="simple"/>
		</li>
		<li>
			패스워드 확인 	:	
			<s:textfield theme="simple" value="%{resultClass.mem_id}" />
		</li>
		<li>
			이름  	:	
			<s:textfield name="mem_name" theme="simple" value="%{resultClass.mem_name}" />
		</li>
		<li>
			연락처 	:	
			<s:textfield name="mem_phone" theme="simple" value="%{resultClass.mem_phone}" />
		</li>
		<li>
			프로필	: 	
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
	
