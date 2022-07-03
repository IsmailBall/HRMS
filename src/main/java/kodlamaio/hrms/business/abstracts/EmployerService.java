package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerEmailValidationDto;
import kodlamaio.hrms.entities.dtos.EmployerSignUpDto;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(EmployerSignUpDto employerSignUpDto);
	Result validateEmail(EmployerEmailValidationDto employerEmailValidationDto);
	DataResult<Employer> findByEmail(String email);
	Result update(Employer employer);
	
}
