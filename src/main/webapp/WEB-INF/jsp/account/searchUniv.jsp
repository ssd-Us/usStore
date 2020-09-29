<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학교 찾기</title>
<script>
	function buttonClick(){
		alert(" 대학교 선택함 ");
		var radio_count = document.getElementsByName("univName").length;

		for(var i = 0; i < radio_check; i++){
			if(document.getElementsByName("fruit")[i].checked == true)
		}
		
		
		alert(check)
		
	}
	
</script>
</head>
<body>
	<form action="api/university.do" method="post">
	    <div>
	      <label>지역</label> 
	      <select id="region" name="region">
	      	<option value="선택하세요">선택하세요</option>
	      	<option value="서울특별시">서울특별시</option>
	      	<option value="부산광역시">부산광역시</option>
	      	<option value="인천광역시">인천광역시</option>
	      	<option value="대전광역시">대전광역시</option>
	      	<option value="대구광역시">대구광역시</option>
	      	<option value="울산광역시">울산광역시</option>
	      	<option value="광주광역시">광주광역시</option>
	      	<option value="경기도">경기도</option>
	      	<option value="강원도">강원도</option>
	      	<option value="충청북도">충청북도</option>
	      	<option value="충청남도">충청남도</option>
	        <option value="전라북도">전라북도</option>
	        <option value="전라남도">전라남도</option>
	      	<option value="경상북도">경상북도</option>
	      	<option value="경상남도">경상남도</option>	      	
	      	<option value="제주특별자치도">제주도</option>
	      </select>
	    </div>
	    <div>
	      <label>대학교 찾기</label>
	      <input name="univName" type="text" />
	    </div>
	     <div>
	      <label>찾기 결과</label>
			 <table>
			 <tr>
                  <th style="padding-left:20px">학교</th>
             </tr>
             <tbody>   
                  <c:forEach var="result" items="${results}">         
	                  <tr style="height:20px;">
		                  <td style="padding-left:20px">
		                      ${result}&nbsp; <input type="radio" name="univName" value=${result}>
		                        <!-- 학교이름 옆에 라디오버튼하나 만들어서 하나 체크또는 다시 검색할 수 있도록 로직 구성  -->
		                   </td>
	                  </tr>
                  </c:forEach>
            </tbody>
        	</table>
	    </div>
	    
	    <button type="submit">찾기</button>
	    
	    <!--라디오버튼 선택을 해서 확인버튼을 누르면 대학교확정해서 칸에 이름 넣어주기  -->
	    <input type="button" name="confirm" onclick="buttonClick();" value="확인"/> 
	    
	    <input type="button" name="exit" value="닫기"/>
	     
	    <!-- 
	    	univName으로 컨트롤러에서 대학교를 찾아준 다음에 그 결과를 
	    	다시 result 박스안에다가  보여주고 제대로 result값이 들어올 때만 확인 버튼을누를수있게 보여준다. 
	        요청 : region과 univName -> 응답 : result에다가 대학 이름보여준다 
	     -->
	</form>

</body>
</html>