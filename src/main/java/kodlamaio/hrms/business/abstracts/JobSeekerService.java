package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerEmailValidationDto;
import kodlamaio.hrms.entities.dtos.JobSeekerSignUpDto;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();

	Result add(JobSeekerSignUpDto jobSeekerSignUpDto);

	DataResult<JobSeeker> findByNationalIdIs(String nationalId);

	Result validateEmail(JobSeekerEmailValidationDto jobSeekerEmailValidationDto);
}
