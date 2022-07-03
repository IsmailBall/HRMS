package kodlamaio.hrms.dataAccess.concretes;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Employer findByEmailAndPassword(String email, String password);
	Employer findByEmail(String email);
}
