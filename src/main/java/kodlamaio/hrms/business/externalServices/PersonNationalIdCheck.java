package kodlamaio.hrms.business.externalServices;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface PersonNationalIdCheck {

	Result checkPersonIsValid(JobSeeker jobSeeker);
}
