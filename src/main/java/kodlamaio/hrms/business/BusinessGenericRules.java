package kodlamaio.hrms.business;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.abstracts.User;

public class BusinessGenericRules {

	public  static <T extends User> boolean isEmailUnique(T user, JpaRepository<T, Integer> jpaRepository) {
		return !jpaRepository.findAll().stream().anyMatch(x -> x.getEmail().equals(user.getEmail()));
	}
}
