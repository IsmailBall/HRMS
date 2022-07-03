package kodlamaio.hrms.business.externalServices;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface PersonNationalIdCheck {

	boolean checkPersonIsValid(JobSeeker jobSeeker);
}
