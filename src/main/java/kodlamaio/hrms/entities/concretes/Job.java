package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobId")
	private int jobId;

	@Column(name = "description", nullable = false, unique = false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "jobTitleId", nullable = false)
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name = "cityId", nullable = false)
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private Employer employer;
	
	@Column(name = "vacantPosition", nullable = false)
	private int vacantPosition;
	
	@Column(name = "deadline", nullable = true)
	private Date deadline;
	
	@Column(name = "publishDate", nullable = true)
	private Date publishDate;
	
	@Column(name = "minSalary", nullable = false)
	@Value("${min.salary:0}")
	private double minSalary;
	
	@Column(name = "maxSalary", nullable = false)
	@Value("${max.salary:0}")
	private double maxSalary;
	
	@Column(name = "activity", nullable = false)
	@Value("${activity:true}")
	private boolean activity;
}
