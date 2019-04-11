package Model;

public class TrakingInformation {
	private int trackid;
	private String username;
	private String issuename;
	private String createddate;
	private String status;

	public TrakingInformation(int trackid, String username, String issuename, String createddate, String status) {
		this.trackid = trackid;
		this.username = username;
		this.issuename = issuename;
		this.createddate = createddate;
		this.status = status;

	}

	public int getTrackid() {
		return trackid;
	}

	public void setTrackid(int trackid) {
		this.trackid = trackid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIssuename() {
		return issuename;
	}

	public void setIssuename(String issuename) {
		this.issuename = issuename;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

}
