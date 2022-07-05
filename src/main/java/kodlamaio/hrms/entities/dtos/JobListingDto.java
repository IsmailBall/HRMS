package kodlamaio.hrms.entities.dtos;

import java.util.Date;

public class JobListingDto {
	private String companyName;
	private String jobStatu;
	private int vacantPositonNumber;
	private String city;
	private Date publishDate;
	private Date deadline;

	public JobListingDto(String companyName, String jobStatu, int vacantPositonNumber, String city, Date publishDate,
			Date deadline) {
		super();
		this.companyName = companyName;
		this.jobStatu = jobStatu;
		this.vacantPositonNumber = vacantPositonNumber;
		this.city = city;
		this.publishDate = publishDate;
		this.deadline = deadline;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobStatu() {
		return jobStatu;
	}

	public void setJobStatu(String jobStatu) {
		this.jobStatu = jobStatu;
	}

	public int getVacantPositonNumber() {
		return vacantPositonNumber;
	}

	public void setVacantPositonNumber(int vacantPositonNumber) {
		this.vacantPositonNumber = vacantPositonNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

}
