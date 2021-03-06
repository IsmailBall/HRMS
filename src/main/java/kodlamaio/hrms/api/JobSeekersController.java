package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerEmailValidationDto;
import kodlamaio.hrms.entities.dtos.JobSeekerSignUpDto;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerSignUpDto jobSeekerSignUpDto)
	{
		return this.jobSeekerService.add(jobSeekerSignUpDto);
	}
	
	@GetMapping("/getall/{nationalId}")
	public DataResult<JobSeeker> findByNationalIdIs(@RequestParam(required = true, defaultValue = "", value="nationalId") String nationalId) {
		return this.jobSeekerService.findByNationalIdIs(nationalId);
	}
	
	@PostMapping("/validation")
	public Result validateEmail(@RequestBody JobSeekerEmailValidationDto jobSeekerEmailValidationDto)
	{
		return this.jobSeekerService.validateEmail(jobSeekerEmailValidationDto);
	}

}
