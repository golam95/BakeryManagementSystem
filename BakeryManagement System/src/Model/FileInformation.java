package Model;

public class FileInformation {
	private int fileid;
	private String filename;

	public FileInformation(int fileid, String filename) {
		this.fileid = fileid;
		this.filename = filename;

	}

	public int getFileid() {
		return fileid;
	}

	public void setFileid(int fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
