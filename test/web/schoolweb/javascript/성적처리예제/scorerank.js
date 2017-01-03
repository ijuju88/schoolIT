 //이름, 성적1, 성적2, 총점, 평균, 등급 변수 지정하기
var na=" ", n1=0, n2=0,total=0,average=0,dep=" ", rank=0;
var s=new Array(); 
//본함수 실행부분
function main(sName, snum1, snum2){
	s.push(new Student(sName, snum1, snum2));
	Setprint();
}


//값불려오기
function Student(na, n1, n2){
 this.na=document.getElementById("sName").value;
 this.n1=parseInt(document.getElementById("snum1").value);
 this.n2=parseInt(document.getElementById("snum2").value);
 //alert(this.n1);
 
 //합계구하기
 this.total=function(){return this.n1+this.n2;};
 
 //평균구하기
 this.average=function(){return this.total()/2; };
 //alert(this.avg());
 //등급구하기
 
 this.dep=function(){
	if(this.average()>=90){return "A";}
	else if(this.average()>=80){return "B";}
	else if(this.average()>=70){return "C";}
	else{return "F";}  
};

}
//배열로 저장해서 테이블에 넣어보기
function Setprint(){
 var str="<table>";
 str+="<tr>";
 str+="<td>학생명</td><td>국어</td><td>수학</td><td>총점</td><td>평균</td><td>등급</td><td>순위</td>";
 str+="</tr>";


 for (var i = 0; i < s.length; i++) {
	s[i].rank=1;
	for (var j = 0; j < s.length; j++) {
	 if(s[i].total()<s[j].total())
		{s[i].rank++;}
}
}
for(var i in s){
	str+="<tr>";
	str+="<td>"+s[i].na+ "</td>";
	str+="<td>"+s[i].n1+ "</td>";
	str+="<td>"+s[i].n2+ "</td>";
	str+="<td>"+s[i].total()+ "</td>";
	str+="<td>"+s[i].average()+ "</td>";
	str+="<td>"+s[i].dep()+ "</td>";
	str+="<td>"+s[i].rank+ "</td>";}

 tem.innerHTML=str;//id=tem 인 부분에 출력하려고 함!
}

function sample_date(){
 var num=Math.floor((Math.random()*100)+1);
 this.na="ID"+num;
 this.n1=Math.floor((Math.random()*100)+1);
 this.n2=Math.floor((Math.random()*100)+1);
 
 frm.sName.value=na;
 frm.snum1.value=n1;
 frm.snum2.value=n2;
 main(na, n1, n2);
}