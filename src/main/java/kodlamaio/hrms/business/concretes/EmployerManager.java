package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.BusinessGenericRules;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.concretes.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerEmailValidationDto;
import kodlamaio.hrms.entities.dtos.EmployerSignUpDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers were listed successfully");
	}

	@Override
	public Result add(EmployerSignUpDto employerSignUpDto) {

		if (!validateEmployer(employerSignUpDto))
			return new ErrorResult("Adding was failed");

		var employer = mapEmployer(employerSignUpDto);

		if (checkDomainValid(employer) && BusinessGenericRules.isEmailUnique(employer, this.employerDao)) {
			this.employerDao.save(employer);
			return new SuccessResult("Employer was added successfully");
		}
		return new ErrorResult("Adding was failed");

	}

	@Override
	public Result validateEmail(EmployerEmailValidationDto employerEmailValidationDto) {

		var employer = this.employerDao.findByEmailAndPassword(employerEmailValidationDto.getEmail(),
				employerEmailValidationDto.getPassword());

		if (employer != null && !employer.isEmailValid()) {
			employer.setEmailValid(true);
			this.employerDao.save(employer);
			return new SuccessResult("Your confirmation has been accepted");
		} else if (employer != null && employer.isEmailValid()) {
			return new SuccessResult("Your accaount has already been confirmed!");
		}

		return new ErrorResult("User could not found!");
	}

	@Override
	public DataResult<Employer> findByEmail(String email) {

		var employer = this.employerDao.findByEmail(email);
		return employer == null ? new ErrorDataResult<Employer>("Employer could not found")
				: new SuccessDataResult<Employer>(employer, "Employer was found successfully");
	}
	
	@Override
	public Result update(Employer employer) {
		if(employer != null)
		{
			this.employerDao.save(employer);
			return new SuccessResult("Employer updated successfully");
		}
		return new ErrorResult("Updating was failed");
	}

	private boolean checkDomainValid(Employer employer) {

		String domainInspection = (employer.getWebSite().split("\\."))[1];
		return employer.getEmail().contains(domainInspection);
	}

	private boolean validateEmployer(EmployerSignUpDto employerSignUpDto) {

		if (employerSignUpDto != null && employerSignUpDto.getPassword() != null
				&& employerSignUpDto.getPasswordAgain() != null) {
			return employerSignUpDto.getPassword().equals(employerSignUpDto.getPasswordAgain());
		}

		return false;
	}

	private Employer mapEmployer(EmployerSignUpDto employerSignUpDto) {

		Employer employer = null;

		if (employerSignUpDto != null) {
			employer = new Employer();
			employer.setCompanyName(employerSignUpDto.getCompanyName());
			employer.setEmail(employerSignUpDto.getEmail());
			employer.setPassword(employerSignUpDto.getPassword());
			employer.setPhoneNumber(employerSignUpDto.getPhoneNumber());
			employer.setWebSite(employerSignUpDto.getWebSite());
		}

		return employer;
	}

}
