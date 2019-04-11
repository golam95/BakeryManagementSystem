package Model;

public class yearlyReporInfo {
	private int yearId;
	private double totalcost_emp;
	private double totalcost_serviceprovider;
	private double totalcost_warehouse;
	private int numberof_order;
	private double total_ordercost;
	private int num_emergencey_order;
	private int num_orderhere;
	private double toalcost_emergencyorder;
	private double totalcost_here;
	private String date;
	private String year;

	public yearlyReporInfo(int yearId, double totalcost_emp, double totalcost_serviceprovider,
			double totalcost_warehouse, int numberof_order, double total_ordercost, int num_emergencey_order,
			int num_orderhere, double toalcost_emergencyorder, double totalcost_here, String date,String year) {

		this.yearId = yearId;
		this.totalcost_emp = totalcost_emp;
		this.totalcost_serviceprovider = totalcost_serviceprovider;
		this.totalcost_warehouse = totalcost_warehouse;
		this.numberof_order = numberof_order;
		this.total_ordercost = total_ordercost;
		this.num_emergencey_order = num_emergencey_order;
		this.num_orderhere = num_orderhere;
		this.toalcost_emergencyorder = toalcost_emergencyorder;
		this.totalcost_here = totalcost_here;
		this.date = date;
		this.year = year;
		

	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public double getTotalcost_emp() {
		return totalcost_emp;
	}

	public void setTotalcost_emp(double totalcost_emp) {
		this.totalcost_emp = totalcost_emp;
	}

	public double getTotalcost_serviceprovider() {
		return totalcost_serviceprovider;
	}

	public void setTotalcost_serviceprovider(double totalcost_serviceprovider) {
		this.totalcost_serviceprovider = totalcost_serviceprovider;
	}

	public double getTotalcost_warehouse() {
		return totalcost_warehouse;
	}

	public void setTotalcost_warehouse(double totalcost_warehouse) {
		this.totalcost_warehouse = totalcost_warehouse;
	}

	public int getNumberof_order() {
		return numberof_order;
	}

	public void setNumberof_order(int numberof_order) {
		this.numberof_order = numberof_order;
	}

	public double getTotal_ordercost() {
		return total_ordercost;
	}

	public void setTotal_ordercost(double total_ordercost) {
		this.total_ordercost = total_ordercost;
	}

	public int getNum_emergencey_order() {
		return num_emergencey_order;
	}

	public void setNum_emergencey_order(int num_emergencey_order) {
		this.num_emergencey_order = num_emergencey_order;
	}

	public int getNum_orderhere() {
		return num_orderhere;
	}

	public void setNum_orderhere(int num_orderhere) {
		this.num_orderhere = num_orderhere;
	}

	public double getToalcost_emergencyorder() {
		return toalcost_emergencyorder;
	}

	public void setToalcost_emergencyorder(double toalcost_emergencyorder) {
		this.toalcost_emergencyorder = toalcost_emergencyorder;
	}

	public double getTotalcost_here() {
		return totalcost_here;
	}

	public void setTotalcost_here(double totalcost_here) {
		this.totalcost_here = totalcost_here;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
