package Model;

public class OrderInformation {
	private int orderid;
	private int shopid;
	private String shopname;
	private int serviceid;
	private String servicename;
	private int productid;
	private String product;
	private int quantity;
	private double price;
	private int discount;
	private double totalamount;
	private double paidamount;
	private String monthid;
	private String status;
	private String date;

	public OrderInformation(int orderid, int shopid, String shopname, int serviceid, String servicename, int productid,
			String product, int quantity, double price, int discount, double totalamount, double paidamount,
			String monthid, String status, String date) {

		this.orderid = orderid;
		this.shopid = shopid;
		this.shopname = shopname;
		this.serviceid = serviceid;
		this.servicename = servicename;
		this.productid = productid;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.totalamount = totalamount;
		this.paidamount = paidamount;
		this.monthid = monthid;
		this.status = status;
		this.date = date;

	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public double getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(double paidamount) {
		this.paidamount = paidamount;
	}

	public String getMonthid() {
		return monthid;
	}

	public void setMonthid(String monthid) {
		this.monthid = monthid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
