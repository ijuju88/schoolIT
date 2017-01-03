/**
 * 
 */
var status=true;
$(document).ready(function(){
	$("#checkId").click(function(){
		 if($("#id").val()){
			//아이디를 입력하고 [ID중복확인]버튼을 클릭한 경우
			var query = {id:$("#id").val()};
		    $.ajax({
		    	type:"post",//요청방식
		    	url:"confirmId.jsp",//요청페이지
		    	data:query,//파라미터
		    	success:function(data){//요청페이지 처리에 성공시
		    		if(data == 1){//사용할 수 없는 아이디
		    			alert("사용할 수 없는 아이디");
		    	    	$("#id").val("");
		    	     }else if(data == -1)//사용할 수 있는 아이디
		    	  	    alert("사용할 수 있는 아이디");
		 	    }
		    });
		  }else{//아이디를 입력하지 않고 [ID중복확인]버튼을 클릭한 경우
			  alert("사용할 아이디를 입력");
			  $("#id").focus();
		  }
		});
	
	
});