package Model;

public class settingReportinfo {
	private int monthreport_id;
	private int customer_num;
	private int item_num;
	private int stock_num;
	private int van_num;
	private int patnter_num;
	private int emp_num;
	private int serviceprovider_num;
	private double sallary_emp;
	private double sallary_supplier;
	private double warehouse_cost;
	private int order_num;
	private double order_cost;
	private int emergency_order;
	private int orderfrom_here;
	private double emergency_cost;
	private double hire_cost;
	private String month;
	private String status;

	public settingReportinfo(int monthreport_id, int customer_num, int item_num, int stock_num, int van_num,
			int patnter_num, int emp_num, int serviceprovider_num, double sallary_emp, double sallary_supplier,
			double warehouse_cost, int order_num, double order_cost, int emergency_order, int orderfrom_here,
			double emergency_cost, double hire_cost, String month, String status) {
		this.monthreport_id = monthreport_id;
		this.customer_num = customer_num;
		this.item_num = item_num;
		this.stock_num = stock_num;
		this.van_num = van_num;
		this.patnter_num = patnter_num;
		this.emp_num = emp_num;
		this.serviceprovider_num = serviceprovider_num;
		this.sallary_emp = sallary_emp;
		this.sallary_supplier = sallary_supplier;
		this.warehouse_cost = warehouse_cost;
		this.order_num = order_num;
		this.order_cost = order_cost;
		this.emergency_order = emergency_order;
		this.orderfrom_here = orderfrom_here;
		this.emergency_cost = emergency_cost;
		this.hire_cost = hire_cost;
		this.month = month;
		this.status = status;

	}

	public int getMonthreport_id() {
		return monthreport_id;
	}

	public void setMonthreport_id(int monthreport_id) {
		this.monthreport_id = monthreport_id;
	}

	public int getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}

	public int getItem_num() {
		return item_num;
	}

	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}

	public int getStock_num() {
		return stock_num;
	}

	public void setStock_num(int stock_num) {
		this.stock_num = stock_num;
	}

	public int getVan_num() {
		return van_num;
	}

	public void setVan_num(int van_num) {
		this.van_num = van_num;
	}

	public int getPatnter_num() {
		return patnter_num;
	}

	public void setPatnter_num(int patnter_num) {
		this.patnter_num = patnter_num;
	}

	public int getEmp_num() {
		return emp_num;
	}

	public void setEmp_num(int emp_num) {
		this.emp_num = emp_num;
	}

	public int getServiceprovider_num() {
		return serviceprovider_num;
	}

	public void setServiceprovider_num(int serviceprovider_num) {
		this.serviceprovider_num = serviceprovider_num;
	}

	public double getSallary_emp() {
		return sallary_emp;
	}

	public void setSallary_emp(double sallary_emp) {
		this.sallary_emp = sallary_emp;
	}

	public double getSallary_supplier() {
		return sallary_supplier;
	}

	public void setSallary_supplier(double sallary_supplier) {
		this.sallary_supplier = sallary_supplier;
	}

	public double getWarehouse_cost() {
		return warehouse_cost;
	}

	public void setWarehouse_cost(double warehouse_cost) {
		this.warehouse_cost = warehouse_cost;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public double getOrder_cost() {
		return order_cost;
	}

	public void setOrder_cost(double order_cost) {
		this.order_cost = order_cost;
	}

	public int getEmergency_order() {
		return emergency_order;
	}

	public void setEmergency_order(int emergency_order) {
		this.emergency_order = emergency_order;
	}

	public int getOrderfrom_here() {
		return orderfrom_here;
	}

	public void setOrderfrom_here(int orderfrom_here) {
		this.orderfrom_here = orderfrom_here;
	}

	public double getEmergency_cost() {
		return emergency_cost;
	}

	public void setEmergency_cost(double emergency_cost) {
		this.emergency_cost = emergency_cost;
	}

	public double getHire_cost() {
		return hire_cost;
	}

	public void setHire_cost(double hire_cost) {
		this.hire_cost = hire_cost;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
