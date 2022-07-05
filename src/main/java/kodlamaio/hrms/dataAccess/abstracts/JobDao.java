package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{

	Job getByJobTitle_StatusAndActivity(String status,boolean activity);
	
	List<Job> getByActivity(boolean activity);

	List<Job> getByCity_CityIdAndActivity(int cityId, boolean activity);
	
	List<Job> getByEmployer_UserIdAndActivity(int userId, boolean activity);

	List<Job> getByCity_CityIdAndEmployer_UserIdAndActivity(int cityId, int userId, boolean activity);
	
	List<Job> getByJobTitle_StatusContainsAndActivity(String status, boolean activity);

}
