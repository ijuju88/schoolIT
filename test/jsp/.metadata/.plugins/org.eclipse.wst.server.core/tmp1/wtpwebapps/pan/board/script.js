function writeSave(){
		if (!$('#username').val()) {
			alert("작성자 이름을 넣어 주세요.");
			$('#username').focus();
			return false;
		}
		if (!$('#password').val()) {
			alert("비번을 입력해주세요.");
			$('#password').focus();
			return false;
		}
		
		if (!$('#title').val()) {
			alert("제목을 입력해주세요.");
			$('#title').focus();
			return false;
		}

		if(frm.content.value==""){
			  alert("내용을 입력해주세요");
			  frm.content.focus();
			  return false;
			}
	
	if(frm.file_name.value=="" || frm.file_name.value == null){
		frm.file_chk.value = "00";
	}else{
		frm.file_chk.value = "01";
	} 
	
	return true;
	
}






