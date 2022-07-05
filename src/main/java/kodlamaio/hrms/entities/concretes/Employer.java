package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobs"})
@Data
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
	
	@OneToMany(mappedBy = "employer")
	private List<Job> jobs;
}
