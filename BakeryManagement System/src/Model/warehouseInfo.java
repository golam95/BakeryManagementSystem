package Model;

public class warehouseInfo {
	private String month;
	private String year;
	private String date;
	private double amount;
	private String decription;
	private String status;

	public warehouseInfo(String month, String year, String date, double amount, String decription, String status) {
		this.month = month;
		this.year = year;
		this.date = date;
		this.amount = amount;
		this.decription = decription;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

}
