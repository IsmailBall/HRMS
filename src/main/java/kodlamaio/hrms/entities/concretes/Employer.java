package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "employers")
@EqualsAndHashCode(callSuper = false)
public class Employer extends User {

	@Column(name = "companyName", nullable = false, unique = false)
	private String companyName;

	@Column(name = "webSite", nullable = false, unique = false)
	private String webSite;

	@Column(name = "phoneNumber", nullable = false, unique = false)
	private String phoneNumber;

	@Column(name = "emailVerification", nullable = false, unique = false)
	private boolean isEmailValid;
	
	@Column(name = "hrmsVerification", nullable = false, unique = false)
	private boolean isHrmsValid;
}
