package Model;

public class Receivedproductinfo {

	private int receiveId;
	private int product_no;
	private String product_name;
	private String sub_productname;
	private String catagory;
	private String Expiredate;
	private int quantity;
	private double price;
	private double sellingprice;
	private String submitdate;
	private double total;

	public Receivedproductinfo(int receiveId, int product_no, String product_name, String sub_productname,
			String catagory, String Expiredate, int quantity, double price, double sellingprice, String submitdate,
			double total) {
		this.receiveId = receiveId;
		this.product_no = product_no;
		this.product_name = product_name;
		this.sub_productname = sub_productname;
		this.catagory = catagory;
		this.Expiredate = Expiredate;
		this.quantity = quantity;
		this.price = price;
		this.sellingprice = sellingprice;
		this.submitdate = submitdate;
		this.total = total;

	}

	public int getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getSub_productname() {
		return sub_productname;
	}

	public void setSub_productname(String sub_productname) {
		this.sub_productname = sub_productname;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getExpiredate() {
		return Expiredate;
	}

	public void setExpiredate(String expiredate) {
		Expiredate = expiredate;
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

	public double getSellingprice() {
		return sellingprice;
	}

	public void setSellingprice(double sellingprice) {
		this.sellingprice = sellingprice;
	}

	public String getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(String submitdate) {
		this.submitdate = submitdate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}