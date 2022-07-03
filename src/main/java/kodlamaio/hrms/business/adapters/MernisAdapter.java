package kodlamaio.hrms.business.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.externalServices.PersonNationalIdCheck;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class MernisAdapter implements PersonNationalIdCheck {

	@Override
	public boolean checkPersonIsValid(JobSeeker jobSeeker) {
		
		if(jobSeeker.getNationalId().length() != 11)
			return false;
		
		if(jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty() || jobSeeker.getBirthYear() > 2020)
			return false;
		
		return true;
		
	}

}
