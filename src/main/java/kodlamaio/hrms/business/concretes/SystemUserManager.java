package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.SystemUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.concretes.SystemUserDao;
import kodlamaio.hrms.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService{

	private SystemUserDao systemUserDao;
	private EmployerService employerService;
	
	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao, EmployerService employerService) {
		super();
		this.systemUserDao = systemUserDao;
		this.employerService = employerService;
	}

	@Override
	public DataResult<List<SystemUser>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<SystemUser>>(this.systemUserDao.findAll(),"System users were listed successfully");
	}

	@Override
	public Result add(SystemUser systemUser) {
		systemUserDao.save(systemUser);
		return new SuccessResult("System user was added successfully");
	}

	@Override
	public Result confirmEmployer(String email) {

		var result = this.employerService.findByEmail(email);
		
		if(result.isSuccess())
		{
			result.getData().setHrmsValid(true);
			this.employerService.update(result.getData());
			return new SuccessResult("Account was confirmed!");
		}
		
		return new ErrorResult("An error occured during transaction. Try again later!\n" + result.getMessage()); 
		
	}

	
}
