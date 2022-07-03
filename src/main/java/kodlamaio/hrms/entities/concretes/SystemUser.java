package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "system_users")
@EqualsAndHashCode(callSuper = false)
public class SystemUser extends User {

	@Column(name = "firstName", nullable = false, unique = false)
	private String firstName;

	@Column(name = "lastName", nullable = false, unique = false)
	private String lastName;
}
