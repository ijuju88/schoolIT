/* JDK version : JDK1.70_51
 날짜 : 2014년 05월 21일 
 핵심기술 : Getter,Setter 사용
 기능: 각 항목에 해당 하는 변수 선언  */
package roti.lms.ad_stu.db;



public class StudentBean {
	private String st_id;
	private String st_pass;
	private String st_name;
	private int birth;
	private String addr;
	private String st_hp;
	private String st_ehp;
	private String gender;
	private String rdate;
	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public String getSt_pass() {
		return st_pass;
	}
	public void setSt_pass(String st_pass) {
		this.st_pass = st_pass;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSt_hp() {
		return st_hp;
	}
	public void setSt_hp(String st_hp) {
		this.st_hp = st_hp;
	}
	public String getSt_ehp() {
		return st_ehp;
	}
	public void setSt_ehp(String st_ehp) {
		this.st_ehp = st_ehp;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}	

}
