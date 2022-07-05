package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.dtos.JobListingDto;

public interface JobService {

	DataResult<List<JobListingDto>> getAll();
	
	DataResult<List<JobListingDto>> getAll(int pageNo, int pageSize);
	
	DataResult<List<JobListingDto>> getAllSortedByDeadline();

	DataResult<JobListingDto> getByJobTitle_Status(String status);

	DataResult<List<JobListingDto>> getByCity_CityId(int cityId);

	DataResult<List<JobListingDto>> getByEmployer_UserId(int userId);

	DataResult<List<JobListingDto>> getByCity_CityIdAndEmployer_UserId(int cityId, int userId);

	DataResult<List<JobListingDto>> getByJobTitle_StatusContains(String status);
	
	Result update(Job job);
	
	DataResult<Job> getById(int id);
}
