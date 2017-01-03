package MyBean;

public class Util
{
	
	public static String nullChk(String str){
		return nullChk(str,"");
	}
	public static String nullChk(String str, String newStr){
		if(str==null)
			return newStr;
		else
			return str;
	}
};  

