package Model;

public class Remployeeinformation {
	private int id_re;
	private String fristre_name;
	private String lastre_name;
	private String destionre;
	private String address_re;
	private String contactre_no;
	private String workre_type;
	private String empre_type;
	private String emp_re;
	private String emp_reason;
    public Remployeeinformation(int id_re, String fristre_name, String lastre_name, String destionre, String address_re,
			String contactre_no, String workre_type, String empre_type, String emp_re, String emp_reason) {
		this.id_re = id_re;
		this.fristre_name = fristre_name;
		this.lastre_name = lastre_name;
		this.destionre = destionre;
		this.address_re = address_re;
		this.contactre_no = contactre_no;
		this.workre_type = workre_type;
		this.empre_type = empre_type;
		this.emp_re = emp_re;
		this.emp_reason = emp_reason;

	}

	public int getId_re() {
		return id_re;
	}

	public void setId_re(int id_re) {
		this.id_re = id_re;
	}

	public String getFristre_name() {
		return fristre_name;
	}

	public void setFristre_name(String fristre_name) {
		this.fristre_name = fristre_name;
	}

	public String getLastre_name() {
		return lastre_name;
	}

	public void setLastre_name(String lastre_name) {
		this.lastre_name = lastre_name;
	}

	public String getDestionre() {
		return destionre;
	}

	public void setDestionre(String destionre) {
		this.destionre = destionre;
	}

	public String getAddress_re() {
		return address_re;
	}

	public void setAddress_re(String address_re) {
		this.address_re = address_re;
	}

	public String getContactre_no() {
		return contactre_no;
	}

	public void setContactre_no(String contactre_no) {
		this.contactre_no = contactre_no;
	}

	public String getWorkre_type() {
		return workre_type;
	}

	public void setWorkre_type(String workre_type) {
		this.workre_type = workre_type;
	}

	public String getEmpre_type() {
		return empre_type;
	}

	public void setEmpre_type(String empre_type) {
		this.empre_type = empre_type;
	}

	public String getEmp_re() {
		return emp_re;
	}

	public void setEmp_re(String emp_re) {
		this.emp_re = emp_re;
	}

	public String getEmp_reason() {
		return emp_reason;
	}

	public void setEmp_reason(String emp_reason) {
		this.emp_reason = emp_reason;
	}

}
