package Model;

public class SupplierAttendanceInfo {
	private int supplier_id;
	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getEmployee_type() {
		return employee_type;
	}

	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}

	public int getPresent() {
		return present;
	}

	public void setPresent(int present) {
		this.present = present;
	}

	public int getAbsant() {
		return absant;
	}

	public void setAbsant(int absant) {
		this.absant = absant;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public int getHoliday() {
		return holiday;
	}

	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}

	public int getSick() {
		return sick;
	}

	public void setSick(int sick) {
		this.sick = sick;
	}

	public int getOthers() {
		return others;
	}

	public void setOthers(int others) {
		this.others = others;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getYearmonthstatus() {
		return yearmonthstatus;
	}

	public void setYearmonthstatus(String yearmonthstatus) {
		this.yearmonthstatus = yearmonthstatus;
	}

	private String supplier_name;
	private String employee_type;
	private int present;
	private int absant;
	private int late;
	private int holiday;
	private int sick;
	private int others;
	private String status;
	private String createdate;
	private String datetime;
	private String yearmonthstatus;
	private int retrive_id;

	public SupplierAttendanceInfo(int supplier_id, String supplier_name, String employee_type, int present,
			int absant, int late, int holiday, int sick, int others, String status, String createdate, String datetime,
			String yearmonthstatus,int retrive_id) {
		this.supplier_id = supplier_id;
		this.supplier_name = supplier_name;
		this.employee_type = employee_type;
		this.present = present;
		this.absant = absant;
		this.late = late;
		this.holiday = holiday;
		this.sick = sick;
		this.others = others;
		this.status = status;
		this.createdate = createdate;
		this.datetime = datetime;
		this.yearmonthstatus = yearmonthstatus;
		this.retrive_id=retrive_id;
	}

	public int getRetrive_id() {
		return retrive_id;
	}

	public void setRetrive_id(int retrive_id) {
		this.retrive_id = retrive_id;
	}

}
