function checkNotEmpty(field){
	if(field.value.length==0){
	alert("필드가 비어있네요!");
	field.focus();
	return false;
	}
	return true;
}
