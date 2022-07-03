package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "job_seekers")
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User {

	@Column(name = "firstName", nullable = false, unique = false)
	private String firstName;

	@Column(name = "lastName", nullable = false, unique = false)
	private String lastName;

	@Column(name = "phoneNumber", nullable = false, unique = false)
	private String phoneNumber;

	@Column(name = "nationalId", nullable = false, unique = true)
	private String nationalId;

	@Column(name = "birthYear", nullable = false, unique = false)
	private short birthYear;

	@Column(name = "emailVerification", nullable = false, unique = false)
	private boolean isEmailValid;

}
