package kodlamaio.hrms.business.concretes;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.dtos.JobListingDto;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;

	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<JobListingDto>> getAll() {

		var listingDtos = mapJobList(this.jobDao.getByActivity(true));
		return new SuccessDataResult<List<JobListingDto>>(listingDtos, "Jobs were listed successfully");
	}

	@Override
	public DataResult<JobListingDto> getByJobTitle_Status(String status) {

		var listingDto = mapJob(this.jobDao.getByJobTitle_StatusAndActivity(status, true));
		return new SuccessDataResult<JobListingDto>(listingDto,
				"Job was listed successfully");
	}

	@Override
	public DataResult<List<JobListingDto>> getByCity_CityId(int cityId) {

		var listingDtos = mapJobList(this.jobDao.getByCity_CityIdAndActivity(cityId, true));
		return new SuccessDataResult<List<JobListingDto>>(listingDtos,
				"Jobs were listed successfully");
	}

	@Override
	public DataResult<List<JobListingDto>> getByEmployer_UserId(int userId) {

		var listingDtos = mapJobList(this.jobDao.getByEmployer_UserIdAndActivity(userId, true));
		return new SuccessDataResult<List<JobListingDto>>(listingDtos,
				"Jobs were listed successfully");
	}

	@Override
	public DataResult<List<JobListingDto>> getByCity_CityIdAndEmployer_UserId(int cityId, int userId) {

		var listingDtos = mapJobList(this.jobDao.getByCity_CityIdAndEmployer_UserIdAndActivity(cityId, userId, true));
		return new SuccessDataResult<List<JobListingDto>>(listingDtos,
				"Jobs were listed successfully");
	}

	@Override
	public DataResult<List<JobListingDto>> getByJobTitle_StatusContains(String status) {

		var listingDtos = mapJobList(this.jobDao.getByJobTitle_StatusContainsAndActivity(status, true));
		return new SuccessDataResult<List<JobListingDto>>(listingDtos,
				"Jobs were listed successfully");
	}

	@Override
	public DataResult<List<JobListingDto>> getAll(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		var listingDtos = mapJobList(this.jobDao.findAll(pageable).getContent());
		return new SuccessDataResult<List<JobListingDto>>(listingDtos,
				"Jobs were listed successfully with pagable way");
	}

	@Override
	public DataResult<List<JobListingDto>> getAllSortedByDeadline() {

		Sort sort = Sort.by(Direction.DESC, "deadline");
		var listingDtos = mapJobList(this.jobDao.findAll(sort));
		return new SuccessDataResult<List<JobListingDto>>(listingDtos, "Jobs were listed successfully with sorted way");
	}

	@Override
	public Result update(Job job) {

		if (job != null) {
			this.jobDao.save(job);
			return new SuccessResult("Job was updated successfully");
		}

		return new ErrorResult("Job couldnt find");
	}

	@Override
	public DataResult<Job> getById(int id) {

		var job = this.jobDao.getReferenceById(id);

		return job == null ? new ErrorDataResult<Job>("There is no job with this id") : new SuccessDataResult<Job>(job);
	}

	private List<JobListingDto> mapJobList(List<Job> jobs) {

		List<JobListingDto> jobListingDtos = null;

		if (jobs != null) {
			jobListingDtos = new LinkedList<JobListingDto>();

			for (Job job : jobs) {
				jobListingDtos.add(mapJob(job));
			}
		}
		return jobListingDtos;

	}
	
	private JobListingDto mapJob(Job job) {

		JobListingDto jobListingDto = null;

		if (job != null) {
			jobListingDto =  new JobListingDto(job.getEmployer().getCompanyName(),
					job.getJobTitle().getStatus(), job.getVacantPosition(), job.getCity().getName(),
					job.getDeadline(), job.getPublishDate());

		}
		return jobListingDto;

	}
}
