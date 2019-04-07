package com.arise.hibernateProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class AVRValidator {

	public static List<Error> validate(BaseRequest req){
		 //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //It validates bean instances
        Validator validator = factory.getValidator();
        //Validate bean
        Set<ConstraintViolation<BaseRequest>> constraintViolations = validator.validate(req);
 
		List<Error> errorLst = new ArrayList<>();
		// Show errors
		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<BaseRequest> violation : constraintViolations) {
				Error err = new Error();
				err.setMsg(violation.getMessage());
				errorLst.add(err);
			}
		}
		return errorLst;
	}
}
