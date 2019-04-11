package Model;

public class RegineEmployeeinfo {
	private int regine_id;
	private int re_id;
	private String re_firstname;
	private String re_lastname;
	private String re_designation;
	private String re_address;
	private String re_contactno;
	private String re_worktype;
	private String re_employeetype;
	private String re_dateregine;
	private String re_reason;
	private String re_join;

	public RegineEmployeeinfo(int regine_id,int re_id, String re_firsname, String re_lastname, String re_designation,
			String re_address, String re_contactno, String re_worktype, String re_employeetype, String re_dateregine,
			String re_reason,String re_join) {
		this.regine_id=regine_id;
		this.re_id = re_id;
		this.re_firstname = re_firsname;
		this.re_lastname = re_lastname;
		this.re_designation = re_designation;
		this.re_address = re_address;
		this.re_contactno = re_contactno;
		this.re_worktype = re_worktype;
		this.re_employeetype = re_employeetype;
		this.re_dateregine = re_dateregine;
		this.re_reason = re_reason;
		this.re_join=re_join;
	}

	public int getRegine_id() {
		return regine_id;
	}

	public void setRegine_id(int regine_id) {
		this.regine_id = regine_id;
	}

	public String getRe_join() {
		return re_join;
	}

	public void setRe_join(String re_join) {
		this.re_join = re_join;
	}

	public int getRe_id() {
		return re_id;
	}

	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}

	public String getRe_firstname() {
		return re_firstname;
	}

	public void setRe_firstname(String re_firstname) {
		this.re_firstname = re_firstname;
	}

	public String getRe_lastname() {
		return re_lastname;
	}

	public void setRe_lastname(String re_lastname) {
		this.re_lastname = re_lastname;
	}

	public String getRe_designation() {
		return re_designation;
	}

	public void setRe_designation(String re_designation) {
		this.re_designation = re_designation;
	}

	public String getRe_address() {
		return re_address;
	}

	public void setRe_address(String re_address) {
		this.re_address = re_address;
	}

	public String getRe_contactno() {
		return re_contactno;
	}

	public void setRe_contactno(String re_contactno) {
		this.re_contactno = re_contactno;
	}

	public String getRe_worktype() {
		return re_worktype;
	}

	public void setRe_worktype(String re_worktype) {
		this.re_worktype = re_worktype;
	}

	public String getRe_employeetype() {
		return re_employeetype;
	}

	public void setRe_employeetype(String re_employeetype) {
		this.re_employeetype = re_employeetype;
	}

	public String getRe_dateregine() {
		return re_dateregine;
	}

	public void setRe_dateregine(String re_dateregine) {
		this.re_dateregine = re_dateregine;
	}

	public String getRe_reason() {
		return re_reason;
	}

	public void setRe_reason(String re_reason) {
		this.re_reason = re_reason;
	}

}
