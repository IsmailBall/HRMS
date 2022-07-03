package kodlamaio.hrms.business.utilities.genericBusinessRules;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.abstracts.User;

public class BusinessGenericRules {

	public  static <T extends User> Result isEmailUnique(T user, JpaRepository<T, Integer> jpaRepository) {
		return jpaRepository.findAll().stream().anyMatch(x -> x.getEmail().equals(user.getEmail())) ? 
				new ErrorResult("Email is not unique") :
				new SuccessResult("Email is unique");
	}
}
