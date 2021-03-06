<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        table *{margin:5px;}
        table{width:100%;}
</style>
</head>
<body>
    <!-- 이쪽에 메뉴바 포함 할꺼임 -->
    <jsp:include page="../common/header.jsp"/>

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>게시글 상세보기</h2>
            <br>
            
            <!-- 로그인후 상태일 경우만 보여지는 글쓰기 버튼-->
            <a class="btn btn-secondary" style="float:right" href="list.bo">목록으로</a>
            <br><br>
            <table id="contentArea" align="center" class="table">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3">${b.boardTitle}</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${b.boardWriter}</td>
                    <th>작성일</th>
                    <td>${b.createDate }</td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
                        <c:choose>
                        	<c:when test="${ !empty b.originName }">
                        		<a href="${ b.changeName }" download="${b.originName}">${b.originName}</a>
                        	</c:when>
                        	<c:otherwise>
                        		첨부파일이 없습니다.
                        	</c:otherwise>
                        </c:choose>
                        
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td colspan="4"><p style="height:150px">${b.boardContent}</p></td>
                </tr>
            </table>
            <br>
			<c:if test="${ loginUser.userId eq b.boardWriter }">
	            <div align="center">
	                <!-- 수정하기, 삭제하기 버튼은 이글이 본인글일 경우만 보여져야됨 -->
	                <a class="btn btn-primary" onclick="postFormSubmit(1)">수정하기</a>
	                <a class="btn btn-danger" onclick="postFormSubmit(2)">삭제하기</a>
	                <!-- "delete.bo?bno=${b.boardNo }" 이런 방식은 get방식으로 url에 노출 : 보안적으로 부족함
	                     post 방식으로 바꾸기  -->
	            </div><br><br>
	            <form id="postForm" action="" method="post">
	            	<input type="hidden" name="bno" value="${ b.boardNo }">
	            	<input type="hidden" name="filePath" value="${ b.changeName }">
	            	<!-- 첨부파일 O : "파일경로" / 첨부파일 존재X : "" -->
	            </form>
	            
	            <script>
	            	function postFormSubmit(num){
	            		if(num == 1){ // 수정하기 클릭
	            			$("#postForm").attr("action", "updateForm.bo").submit();
	            		} else{ // 삭제하기 클릭
	            			$("#postForm").attr("action", "delete.bo").submit();
	            			// id가 postForm의 action요소를 delete.bo로 바꾸고 submit() 시키겠다.
	            		}
	            	}
	            </script>
            </c:if>

            <!-- 댓글 기능은 나중에 ajax 배우고 접목시킬예정! 우선은 화면구현만 해놓음 -->
            <table id="replyArea" class="table" align="center">
                <thead>
                    <tr>

                        <c:choose>
                        	<c:when test="${ empty loginUser }">
                            	<th colspan="2">
                        			<textarea class="form-control" name="" id="content" cols="55" rows="2" style="resize:none; width:100%" readonly>로그인한 사용자만 가능한 서비스입니다. 로그인 후 이용해주세요.</textarea>
                        		</th>
                        		<th style="vertical-align: middle"><button class="btn btn-secondary" disabled>등록하기</button></th>
                            </c:when>
                            <c:otherwise>
                            	<th colspan="2">
	                        		<textarea class="form-control" name="replyContent" id="content" cols="55" rows="2" style="resize:none; width:100%"></textarea>
	                        	</th>
	                        	<th style="vertical-align: middle"><button class="btn btn-secondary" onclick="addReply();">등록하기</button></th>
	                        </c:otherwise>
                        </c:choose>
                        
                    </tr>
                    <tr>
                       <td colspan="3">댓글 (<span id="rcount"></span>) </td> 
                    </tr>
                </thead>
                <tbody>
                
                </tbody>
            </table>
        </div>
        <br><br>
    </div>
    
    <script>
    	$(function(){
    		selectReplyList();
    		
    		
    	})
    	
    	function addReply(){
    		if($("#content").val().trim().length != 0){ // 댓글 작성 되었을 경우, trim()공백 제거했을 경우
        		$.ajax({
        			url:"rinsert.bo",
        			data:{// key값(필드명) : jsp에 기술되어있는 값 
        			      refBoardNo:${b.boardNo},
        				  replyWriter:'${loginUser.userId}',
        				  replyContent:$("#content").val()
        			},
        			success:function(status){
        				if(status == "success"){
        					$("#content").val("");
        					selectReplyList(); // 갱신된 리스트 다시 호출-> 그래서 일부러 메소드 밑에 배치한것
        				}
        			},error:function(){
        				console.log("댓글 작성용 ajax 통신 실패");
        			}
        		})
    		} else{ // 댓글 작성 안되었을 경우
    			alertify.alert("댓글의 내용을 작성해야 합니다");
    		}
    	}
    	
    	function selectReplyList(){
    		$.ajax({
    			url:"rlist.bo",
    			data:{bno:${b.boardNo}}, // 번호(숫자)라서 "" 안하는것
    			success:function(list){	
    				var value =""
					$.each(list, function(i, obj){ // i- 인덱스, obj(객체값)
						value += "<tr>"
						         + "<td>" + obj.replyWriter + "</td>"
						         + "<td>" + obj.replyContent + "</td>"
						         + "<td>" + obj.createDate + "</td>"
						         + "</tr>";
					})
					
					$("#replyArea tbody").html(value);
    				$("#rcount").text(list.length);
    			}, error:function(){
    				console.log("댓글 리스트 조회용 ajax 실패!");
    			}
    		})
    	}
    </script>

    <!-- 이쪽에 푸터바 포함할꺼임 -->
    <jsp:include page="../common/footer.jsp"/>
    
</body>
</html>