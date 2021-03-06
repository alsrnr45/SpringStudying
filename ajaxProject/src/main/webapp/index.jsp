<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery 라이브러리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1> Spring에서의 ajax 사용법</h1>
	
	<h3> 1. 요청시 두개의 값 전달 후 응답 결과 받아보기</h3>
	이름 : <input type="text" id="name"> <br>
	나이 : <input type="number" id="age"> <br>
	<button id="btn1">전송</button>
	
	<div id="result1"></div>
	
	<script>
		$(function(){
			/*
			#btn1이 동적으로 만들어진 요소일때는 $(id).click(function(){}) 또는 $(id).on("click", function(){}) 이런 이벤트 안먹힘
			즉, 직접 해당 id출력하여 이벤트 하면 이벤트 안됨
			
			$("#btn1").click(function(){	
			})
			or
			$("#btn1").on("click", function(){})
			
			*/
			$(document).on("click", "#btn1", function(){ // 해당 요소가 동적으로 만들어진 요소라면 다음과 같은 방식으로 이벤트 연결해야됨
				//console.log("클릭됨");
				$.ajax({
					url:"ajax1.do",
					data:{
						name:$("#name").val(),
						age:$("#age").val()
					},
					type:"post",
					success:function(data){
						$("#result1").html(data);
					}, error:function(){
						console.log("ajax 통신 실패!");
					}
				});
			})
		})
	</script>
	
	<h3> 2. 조회된 한 회원 객체를 응답받아서 출력해보기 </h3>
	조회활 회원 번호 : <input type="number" id="userNo">
	<button onclick="ajaxTest2();">조회</button>
	
	<div id="result2"></div>
	
	<script>
		function ajaxTest2(){
			$.ajax({
				url:"ajax2.do",
				data:{userNo:$("#userNo").val()},
				success:function(obj){
					// console.log(obj);
					var value = "<ul>"
								+ "<li>이름 : " + obj.userName + "</li>"
								+ "<li>나이 : " + obj.age + "</li>"
								+ "<li>아이디 : " + obj.userId + "</li>"
								+ "</ul>";
								
					$("#result2").html(value);			
								
				}, error:function(){
					console.log("ajax 통신 실패");
				}
			});
		}
	</script>
	
	<h3> 3. 조회된 회원들의 리스트 응답받기 </h3>
	<button onclick="ajaxTest3();">회원 전체 조회</button>
	
	<br><br>
	<table border="1" id="tableList">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	
	<script>
		function ajaxTest3(){
			$.ajax({
				url:"ajax3.do",
				success:function(list){
					// 배열로 받아왔으니 배열에서 하나하나 빼옵시당
					
					var value= "";
					/*
					for(var i in list){
						value += "<tr>"
						         + "<td>" + list[i].userId + "</td>"
						         + "<td>" + list[i].userName + "</td>"
						         + "<td>" + list[i].age + "</td>"
						         + "<td>" + list[i].email + "</td>"
						         + "</tr>";
					}
					*/
					
					$.each(list, function(i, obj){ // i- 인덱스, obj(객체값)
						value += "<tr>"
						         + "<td>" + obj.userId + "</td>"
						         + "<td>" + obj.userName + "</td>"
						         + "<td>" + obj.age + "</td>"
						         + "<td>" + obj.email + "</td>"
						         + "</tr>";
					});
					
					$("#tableList tbody").html(value);
				}, error:function(){
					console.log("ajax톻신 실패");
				}
			})
		}
	</script>
</body>
</html>