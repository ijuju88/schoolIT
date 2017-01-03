function productCheck(){
	if(document.frm.name.value.length==0){
		alert("상품명없음");
		frm.name.focus();
		return false;
	}
	if(document.frm.price.value.length==0){
		alert("가격없음");
		frm.price.focus();
		return false;
	}
	if(isNaN(document.frm.price.value)){
		alert("숫자가 아니야 ㅠㅠ");
		frm.price.focus();
		return false;
	}
	
}