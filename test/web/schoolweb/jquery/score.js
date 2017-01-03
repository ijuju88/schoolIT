var studentArr=new Array();
var $na="";
var $n1=0;
var $n2=0;
var $n3=0;
var $n4=0;
var $total=0,$average=0,$dep=" ", $rank=0;


$(function () {
	$('body').stop(true).hide().fadeTo(1000,1);
	$('#snum1').css("backgroundColor","yellow");
	$('#snum2').css("backgroundColor","yellow");
	$('#snum3').css("backgroundColor","yellow");
	$('#snum4').css("backgroundColor","yellow");

  function main(sName, snum1, snum2, snum3, snum4){
  	studentArr.push(new Student(sName, snum1, snum2, snum3, snum4));
  	Setprint();
  }

  $('#fn').click(function (){
  	var $textse=  $('#sName').val().length;
  	//alert($textse);
  	if($textse!=0)
  	{main();}
  	else{alert("!!");}
  });

  $('#sam').click(function (){
  	sample_date();
  	main();
  });



  $("input[name='chkradio']").click(function() {

		//alert($(this).val());
		var no=$(this).val()
		if(no=="sno")	
		{
			//학번만 반대로함
			studentArr.sort ( function (a, b){ return a.$na - b.$na; 	});	 
			Setprint();
			$('table tr td:nth-child(2)').css("color","#FF0000");
		}
		else if(no=="kor")	
		{
			//alert(no);   
			studentArr.sort ( function (a, b){ return b.$n1 - a.$n1; 	});	 
			Setprint();
			$('table tr td:nth-child(3)').css("color","#FF0000");
		}
		else if(no=="eng")	
		{
			//alert(no);
			studentArr.sort ( function (a, b){ return b.$n2 - a.$n2; 	});	
			Setprint();
			$('table tr td:nth-child(4)').css("color","#FF0000");
		}
		else if(no=="mat")	
		{
			//alert(no);
			studentArr.sort ( function (a, b){ return b.$n3 - a.$n3; 	});	
			Setprint();
			$('table tr td:nth-child(5)').css("color","#FF0000");
		}
		else if(no=="sco")	
		{
			//alert(no);
			studentArr.sort ( function (a, b){ return b.$n4 - a.$n4; });	
			Setprint();
			$('table tr td:nth-child(6)').css("color","#FF0000");
		}
		else if(no=="tot")	
		{
			//alert(no);
			studentArr.sort ( function (a, b){ return b.total() - a.total(); });	
			Setprint();
			$('table tr td:nth-child(7)').css("color","#FF0000");
		}
		else if(no=="avg")	
		{
			//alert(no);
			studentArr.sort ( function (a, b){ return b.average() - a.average(); 	});	
			Setprint();
			$('table tr td:nth-child(8)').css("color","#FF0000");
		}

		

	});

});

function Student(na, n1, n2, n3, n4){
	this.$na=$("#sName").val();
	this.$n1=parseInt($("#snum1").val());
	this.$n2=parseInt($("#snum2").val());
	this.$n3=parseInt($("#snum3").val());
	this.$n4=parseInt($("#snum4").val());

// 	//합계구하기
this.total=function(){return this.$n1+this.$n2+this.$n3+this.$n4; };
// 	//평균구하기
this.average=function(){return this.total()/4; };
	//alert(this.avg());
// 	//등급구하기

this.dep=function(){
	if(this.average()>=90){return "A";}
	else if(this.average()>=80){return "B";}
	else if(this.average()>=70){return "C";}
	else{return "F";}		
};


}

//배열로 저장해서 테이블에 넣어보기
function Setprint(){
	str="<tr>";
	str+="<th>순위</th><th>학번</th><th>국어</th><th>영어</th><th>수학</th><th>과학</th><th>총점</th><th>평균</th><th>등급</th>";
	str+="</tr>";
	for (var i = 0; i < studentArr.length; i++) {
		studentArr[i].$rank=1;
		for (var j = 0; j < studentArr.length; j++) {
			if(studentArr[i].total()<studentArr[j].total())
				{studentArr[i].$rank++;}
		}
	}
	for(var i in studentArr){
		str+="<tr>";
		str+="<td>"+studentArr[i].$rank+ "</td>";
		str+="<td>"+studentArr[i].$na+ "</td>";
		str+="<td>"+studentArr[i].$n1+ "</td>";
		str+="<td>"+studentArr[i].$n2+ "</td>";
		str+="<td>"+studentArr[i].$n3+ "</td>";
		str+="<td>"+studentArr[i].$n4+ "</td>";
		str+="<td>"+studentArr[i].total()+ "</td>";
		str+="<td>"+studentArr[i].average()+ "</td>";
		str+="<td>"+studentArr[i].dep()+ "</td>";
		str+="</tr>";
	}

	//id=tem 인 부분에 출력하려고 함!
	var $tem= $("#tem");
	$tem.html(str);
	$('table th')
	.css("backgroundColor","#000A35")
	.css("color","#fff");
	$('table tr:odd').css("backgroundColor","#fff")
	.css("text-align","center");        
  	$('table tr:even').css("backgroundColor","#E0E0E0")
  	.css("text-align","center");   

}
function sample_date(){
	var num=Math.floor((Math.random()*99)+1);
	this.na="2016"+num;
	this.n1=Math.floor((Math.random()*100)+1);
	this.n2=Math.floor((Math.random()*100)+1);
	this.n3=Math.floor((Math.random()*100)+1);
	this.n4=Math.floor((Math.random()*100)+1);

	var se1=$('#sName').val(na);
	var se2=$('#snum1').val(n1);
	var se3=$('#snum2').val(n2);
	var se4=$('#snum3').val(n3);
	var se5=$('#snum4').val(n4);
}