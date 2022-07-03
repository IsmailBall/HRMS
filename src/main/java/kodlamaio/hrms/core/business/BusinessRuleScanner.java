package kodlamaio.hrms.core.business;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BusinessRuleScanner {

	public static Result scanRules(Result... results) {
		for (Result result : results) {
			if(!result.isSuccess())
				return result;
		}
		return new SuccessResult("All rules were run successfully and there is no problem.");
	}
}
