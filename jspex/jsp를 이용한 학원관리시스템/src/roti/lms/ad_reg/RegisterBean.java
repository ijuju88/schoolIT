package roti.lms.ad_reg;

public class RegisterBean {
	private String rg_id;
	private int sub_no;
	private String rg_start;
	private String rg_end;
	private int classroom;
	private int charge;
	public String getRg_id() {
		return rg_id;
	}
	public void setRg_id(String rg_id) {
		this.rg_id = rg_id;
	}
	public int getSub_no() {
		return sub_no;
	}
	public void setSub_no(int sub_no) {
		this.sub_no = sub_no;
	}
	public String getRg_start() {
		return rg_start;
	}
	public void setRg_start(String rg_start) {
		this.rg_start = rg_start;
	}
	public String getRg_end() {
		return rg_end;
	}
	public void setRg_end(String rg_end) {
		this.rg_end = rg_end;
	}
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	
}