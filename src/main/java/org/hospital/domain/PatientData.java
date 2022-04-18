package org.hospital.domain;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class PatientData {

	private Integer  pid;
	@NotNull(message="should not be empty")
	@Size(min=3, message="should not be empty")
	private String firstName;
	@NotNull(message="should not be empty")
	private String lastName;
	@NotNull(message="should not be empty")
	private String gender;
	private Integer age;
	private Long phn;
	private String address;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfJoin;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfDischarge;

	public PatientData(Integer pid, String firstName, String lastName, String gender, Integer age, Long phn, String address,
			Date dateOfJoin, Date dateOfDischarge) {
		super();
		this.pid = pid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.phn = phn;
		this.address = address;
		this.dateOfJoin = dateOfJoin;
		this.dateOfDischarge = dateOfDischarge;

	}

	public PatientData() {

	}

	public PatientData(String firstName, String lastName, String gender, int age, Long phn, String address,
			Date dateOfJoin, Date dateOfDischarge) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.phn = phn;
		this.address = address;
		this.dateOfJoin = dateOfJoin;
		this.dateOfDischarge = dateOfDischarge;
	}

	public Integer getpid() {
		return pid;
	}

	public void setpid(Integer pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String string) {
		this.gender = string;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getPhn() {
		return phn;
	}

	public void setPhn(Long phn) {
		this.phn = phn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public Date getDateOfDischarge() {
		return dateOfDischarge;
	}

	public void setDateOfDischarge(Date dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	@Override
	public String toString() {
		return "PatientData [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", phn=" + phn + ", address=" + address + ", dateOfJoin=" + dateOfJoin
				+ ", dateOfDischarge=" + dateOfDischarge + "]";
	}

	

}
