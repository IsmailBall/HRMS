package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.BusinessGenericRules;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.externalServices.PersonNationalIdCheck;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.concretes.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerEmailValidationDto;
import kodlamaio.hrms.entities.dtos.JobSeekerSignUpDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private PersonNationalIdCheck personNationalIdCheck;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, PersonNationalIdCheck personNationalIdCheck) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.personNationalIdCheck = personNationalIdCheck;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),
				"Job Seekers were listed successfully");
	}

	@Override
	public Result add(JobSeekerSignUpDto jobSeekerSignUpDto) {

		if (!validateJobSeeker(jobSeekerSignUpDto))
			return new ErrorResult("Adding was failed");

		JobSeeker jobSeeker = mapJobSeeker(jobSeekerSignUpDto);

		if (this.personNationalIdCheck.checkPersonIsValid(jobSeeker)
				&& BusinessGenericRules.isEmailUnique(jobSeeker, this.jobSeekerDao) && isNationalIdUnique(jobSeeker)) {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Job Seeker was added successfully");
		}

		return new ErrorResult("Adding was failed");

	}

	@Override
	public DataResult<JobSeeker> findByNationalIdIs(String nationalId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByNationalIdIs(nationalId));
	}

	@Override
	public Result validateEmail(JobSeekerEmailValidationDto jobSeekerEmailValidationDto) {

		var jobSeeker = this.jobSeekerDao.findByEmailAndPassword(jobSeekerEmailValidationDto.getEmail(),
				jobSeekerEmailValidationDto.getPassword());

		if (jobSeeker != null && !jobSeeker.isEmailValid()) {
			jobSeeker.setEmailValid(true);
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Your confirmation has been accepted");
		} else if (jobSeeker != null && jobSeeker.isEmailValid()) {
			return new SuccessResult("Your accaount has already been confirmed!");
		}

		return new ErrorResult("User could not found!");
	}

	private boolean validateJobSeeker(JobSeekerSignUpDto jobSeekerSignUpDto) {

		if (jobSeekerSignUpDto != null && jobSeekerSignUpDto.getPassword() != null
				&& jobSeekerSignUpDto.getPasswordAgain() != null) {
			return jobSeekerSignUpDto.getPassword().equals(jobSeekerSignUpDto.getPasswordAgain());
		}

		return false;
	}

	private JobSeeker mapJobSeeker(JobSeekerSignUpDto jobSeekerSignUpDto) {
		JobSeeker jobSeeker = new JobSeeker();

		jobSeeker.setBirthYear(jobSeekerSignUpDto.getBirthYear());
		jobSeeker.setEmail(jobSeekerSignUpDto.getEmail());
		jobSeeker.setPassword(jobSeekerSignUpDto.getPassword());
		jobSeeker.setFirstName(jobSeekerSignUpDto.getFirstName());
		jobSeeker.setLastName(jobSeekerSignUpDto.getLastName());
		jobSeeker.setNationalId(jobSeekerSignUpDto.getNationalId());
		jobSeeker.setPhoneNumber(jobSeekerSignUpDto.getPhoneNumber());

		return jobSeeker;

	}

	private boolean isNationalIdUnique(JobSeeker jobSeeker) {
		return !this.jobSeekerDao.findAll().stream().anyMatch(x -> x.getNationalId().equals(jobSeeker.getNationalId()));
	}

}
