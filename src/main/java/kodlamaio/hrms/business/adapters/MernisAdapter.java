package kodlamaio.hrms.business.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.externalServices.PersonNationalIdCheck;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class MernisAdapter implements PersonNationalIdCheck {

	@Override
	public Result checkPersonIsValid(JobSeeker jobSeeker) {
		
		if(jobSeeker.getNationalId().length() != 11)
			return new ErrorResult("Less or more character for national id");
		
		if(jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty() || jobSeeker.getBirthYear() > 2020)
			return new ErrorResult("Missing user information") ;
		
		return new SuccessResult("The nationalId is valid");
		
	}

}
