package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.dtos.JobListingDto;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobListingDto>> getAll(){
		return this.jobService.getAll();
	}
	
	@GetMapping("/getByJobTitleStatus/{status}")
	public DataResult<JobListingDto> getByJobTitle_Status(@RequestParam(required = true, defaultValue = "", value="status") String status){
		return this.jobService.getByJobTitle_Status(status);
	}

	@GetMapping("/getByCityCityId/{cityId}")
	public DataResult<List<JobListingDto>> getByCity_CityId(@RequestParam(required = true, value="cityId") int cityId){
		return this.jobService.getByCity_CityId(cityId);
	}

	@GetMapping("/getByEmployerUserId/{userId}")
	public DataResult<List<JobListingDto>> getByEmployer_UserId(@RequestParam(required = true, value="userId") int userId){
		return this.jobService.getByEmployer_UserId(userId);
	}

	@GetMapping("/getByCity_CityIdAndEmployerUserId/{cityId}//{userId}")
	public DataResult<List<JobListingDto>> getByCity_CityIdAndEmployer_UserId(@RequestParam(required = true, value="cityId") int cityId,
			@RequestParam(required = true, value="userId") int userId){
		return this.jobService.getByCity_CityIdAndEmployer_UserId(cityId, userId);
	}

	@GetMapping("/getByJobTitleStatusContains/{status}")
	public DataResult<List<JobListingDto>> getByJobTitle_StatusContains(@RequestParam(required = true, defaultValue = "", value="status") String status){
		return this.jobService.getByJobTitle_StatusContains(status);
	}
	
	@GetMapping("/getAllPagable")
	public DataResult<List<JobListingDto>> getAll(int pageNo, int pageSize){
		return this.jobService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getAllSortedByDeadline")
	public DataResult<List<JobListingDto>> getAllSortedByDeadline(){
		return this.jobService.getAllSortedByDeadline();
	}
}
