package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerEmailValidationDto;
import kodlamaio.hrms.entities.dtos.EmployerSignUpDto;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return employerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody EmployerSignUpDto employerSignUpDto) {
		return this.employerService.add(employerSignUpDto);
	}

	@PostMapping("/validation")
	public Result validateEmail(@RequestBody EmployerEmailValidationDto emailValidationDto) {
		return this.employerService.validateEmail(emailValidationDto);
	}

	@GetMapping("/setActivityOfJob/{jobId}")
	Result setActivityOfJob(@RequestParam(value = "jobId", required = true) int jobId) {
		return this.employerService.setActivityOfJob(jobId);
	}

}
