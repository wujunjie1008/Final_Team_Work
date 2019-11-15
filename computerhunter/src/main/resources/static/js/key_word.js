var num = 0;
var a = "无";

function nclear(){
	document.getElementById("keyword1").innerText = a;
	document.getElementById("keyword2").innerText = a;
	document.getElementById("keyword3").innerText = a;
	num = 0;
}

function addkey(key_button){
	var ak = document.getElementById(key_button).innerText;
	if(num == 0)
	{
		
		document.getElementById("keyword1").innerText = ak;
		num ++;
	}
	else if(num == 1)
	{
		document.getElementById("keyword2").innerText = ak;
		num ++;
	}
	else if(num == 2)
	{
		document.getElementById("keyword3").innerText = ak;
		num ++;
	}
	if(num > 2)
	{
		num = 0;
	}
}

