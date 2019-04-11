package Model;

public class AttendanceYearlyInfo {
	private int yearid;
	private int employeeid;
	private String employeename;
	private String employeetype;
	private int present;
	private int absant;
	private int sick;
	private int late;
	private int holiday;
	private int others;
	private String year;
	private String createdatetime;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private String date;

	public AttendanceYearlyInfo(int yearid, int employeeid, String employeename, String employeetype, int present,
			int absant, int sick, int late, int holiday, int others, String year, String createdatetime, String date) {

		this.yearid = yearid;
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.employeetype = employeetype;
		this.present = present;
		this.absant = absant;
		this.sick = sick;
		this.late = late;
		this.holiday = holiday;
		this.others = others;
		this.year = year;
		this.createdatetime = createdatetime;
		this.date = date;

	}

	public int getYearid() {
		return yearid;
	}

	public void setYearid(int yearid) {
		this.yearid = yearid;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeetype() {
		return employeetype;
	}

	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
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

	public int getSick() {
		return sick;
	}

	public void setSick(int sick) {
		this.sick = sick;
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

	public int getOthers() {
		return others;
	}

	public void setOthers(int others) {
		this.others = others;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(String createdatetime) {
		this.createdatetime = createdatetime;
	}

}
