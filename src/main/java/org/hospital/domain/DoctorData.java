package org.hospital.domain;

public class DoctorData {
	
	private Integer did;
	private String DName;
	private String DGender;
	private int DAge;
	private String DAddress;
	private String Designation;
	private long DPhn;
	private Integer pid;
	public DoctorData(Integer did, String dName, String dGender, int dAge, String dAddress, String designation, long dPhn,
			Integer pid) {
		super();
		this.did = did;
		this.DName = dName;
		this.DGender = dGender;
		this.DAge = dAge;
		this.DAddress = dAddress;
		this.Designation = designation;
		this.DPhn = dPhn;
		this.pid = pid;
	}
	public DoctorData() {
		// TODO Auto-generated constructor stub
	}
	public DoctorData(String dName, String dGender, int dAge, String dAddress, String designation, long dPhn, Integer pid) {
		// TODO Auto-generated constructor stub
		this.DName = dName;
		this.DGender = dGender;
		this.DAge = dAge;
		this.DAddress = dAddress;
		this.Designation = designation;
		this.DPhn = dPhn;
		this.pid = pid;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDName() {
		return DName;
	}
	public void setDName(String dName) {
		DName = dName;
	}
	public String getDGender() {
		return DGender;
	}
	public void setDGender(String dGender) {
		DGender = dGender;
	}
	public int getDAge() {
		return DAge;
	}
	public void setDAge(int dAge) {
		DAge = dAge;
	}
	public String getDAddress() {
		return DAddress;
	}
	public void setDAddress(String dAddress) {
		DAddress = dAddress;
	}
	
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public long getDPhn() {
		return DPhn;
	}
	public void setDPhn(long dPhn) {
		DPhn = dPhn;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "DoctorData [did=" + did + ", DName=" + DName + ", DGender=" + DGender + ", DAge=" + DAge + ", DAddress="
				+ DAddress + ", Designation=" + Designation + ", DPhn=" + DPhn + ", pid=" + pid + "]";
	}

	

}
