package Model;

public class EmployeeInformation {
	private int id;
	private String frist_name;
	private String last_name;
	private String destion;
	private String address;
	private String contact_no;
	private String work_type;
	private String emp_type;
	private String date_ofjoin;

	public EmployeeInformation(int id, String first_name, String last_name, String destion, String address,
			String contact_no, String work_type, String emp_type, String date_ofjoin) {
		this.id = id;
		this.frist_name = first_name;
		this.last_name = last_name;
		this.destion = destion;
		this.address = address;
		this.contact_no = contact_no;
		this.work_type = work_type;
		this.emp_type = emp_type;
		this.date_ofjoin = date_ofjoin;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrist_name() {
		return frist_name;
	}

	public void setFrist_name(String frist_name) {
		this.frist_name = frist_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDestion() {
		return destion;
	}

	public void setDestion(String destion) {
		this.destion = destion;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getWork_type() {
		return work_type;
	}

	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	public String getDate_ofjoin() {
		return date_ofjoin;
	}

	public void setDate_ofjoin(String date_ofjoin) {
		this.date_ofjoin = date_ofjoin;
	}

}
