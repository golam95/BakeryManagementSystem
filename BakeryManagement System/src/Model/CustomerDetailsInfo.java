package Model;

public class CustomerDetailsInfo {
	private String firstname;
	private String lastname;
	private String NIC;
	private String shopno;
	private String shopname;
	private String sex;
	private String email;
	private String streetname;
	private String city;
	private String date;

	public CustomerDetailsInfo(String firstname, String lastname, String NIC, String shopno, String shopname,
			String sex, String email, String streetname, String city, String date) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.NIC = NIC;
		this.shopno = shopno;
		this.shopname = shopname;
		this.sex = sex;
		this.email = email;
		this.streetname = streetname;
		this.city = city;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getShopno() {
		return shopno;
	}

	public void setShopno(String shopno) {
		this.shopno = shopno;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
