function boardCheck(){
	if(document.frm.name.value.length==0){
		alert("작성자가 안적혀있어요 --;");
		return false;
	}
	if(document.frm.pass.value.length==0){
		alert("비번가 안적혀있어요 --;");
		return false;
	}
	if(document.frm.title.value.length==0){
		alert("제목이 안적혀있어요 --;");
		return false;
	}
	return true;
}

function open_win(url, name){
	window.open(url, name, "whdth=500, height=230");
}

function passCheck(){
	if(document.frm.pass.value.length==0){
		alert("비번가 안적혀있어요 --;");
		return false;
	}
	return true;
}


function replyCheck(){
	if(document.frm.name.value.length==0){
		alert("작성자가 안적혀있어요 --;");
		return false;
	}
	if(document.frm.pass.value.length==0){
		alert("비번가 안적혀있어요 --;");
		return false;
	}
	if(document.frm.content.value.length==0){
		alert("댓글이 안적혀있어요 --;");
		return false;
	}
	return true;
}