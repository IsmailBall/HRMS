package kodlamaio.hrms.dataAccess.concretes;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

	JobSeeker findByNationalIdIs(String nationalId);
	JobSeeker findByEmailAndPassword(String email, String password);
}