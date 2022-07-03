package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "jobs")
public class Job {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "jobTitleId", nullable = false, unique = false)
	private int jobTitleId;

	@Column(name = "requiredExperience", nullable = false, unique = false)
	private int requiredExperience;

	@Column(name = "description", nullable = false, unique = false)
	private String description;
}
