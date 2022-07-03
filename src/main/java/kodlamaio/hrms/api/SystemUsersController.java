package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/systemusers")
public class SystemUsersController {

	private SystemUserService systemUserService;

	@Autowired
	public SystemUsersController(SystemUserService service) {
		super();
		this.systemUserService = service;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemUser>> getAll() {
		return systemUserService.getAll();
	}
	
	@GetMapping("/validateEmp/{email}")
	public Result confirmEmployer(@RequestParam(required = true, defaultValue = "", value="email") String email) {
		return this.systemUserService.confirmEmployer(email);
	}

}
