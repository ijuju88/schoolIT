function checkLength(elem, min, max){
	var s=elem.value;

	if (s.length >=min && s.length<=max)
	{return true}
	else{
		alert(min + " 문자와 " + max + " 문자 사이로 입력해주세요!");
		elem.focus();
        return false;
	}
}