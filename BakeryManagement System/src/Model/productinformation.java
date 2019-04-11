package Model;



public class productinformation {
	private int proudctno;
	private String productname;
	private String subproductname;
	private String subproductcatagory;
	private String bakery;
	private String des_pack;
	private String des_weight;
	private String status;
	private String date;

    public productinformation(int proudctno, String productname, String subproductname, String subproductcatagory,
			String bakery, String des_pack, String des_weight, String status, String date) {
		this.proudctno = proudctno;
		this.productname = productname;
		this.subproductname = subproductname;
		this.subproductcatagory = subproductcatagory;
		this.bakery = bakery;
		this.des_pack = des_pack;
		this.des_weight = des_weight;
		this.status = status;
		this.date = date;

	}

	public int getProudctno() {
		return proudctno;
	}

	public void setProudctno(int proudctno) {
		this.proudctno = proudctno;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getSubproductname() {
		return subproductname;
	}

	public void setSubproductname(String subproductname) {
		this.subproductname = subproductname;
	}

	public String getSubproductcatagory() {
		return subproductcatagory;
	}

	public void setSubproductcatagory(String subproductcatagory) {
		this.subproductcatagory = subproductcatagory;
	}

	public String getBakery() {
		return bakery;
	}

	public void setBakery(String bakery) {
		this.bakery = bakery;
	}

	public String getDes_pack() {
		return des_pack;
	}

	public void setDes_pack(String des_pack) {
		this.des_pack = des_pack;
	}

	public String getDes_weight() {
		return des_weight;
	}

	public void setDes_weight(String des_weight) {
		this.des_weight = des_weight;
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
