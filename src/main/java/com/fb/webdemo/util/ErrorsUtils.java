package com.fb.webdemo.util;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import com.fb.webdemo.common.exception.BusinessException;

public class ErrorsUtils {

	/**
	 * 有错则抛出
	 * @param errors
	 */
	public static void throwErrors(Errors errors) {
		if (errors.hasErrors()) {
			List<ObjectError> errorList = errors.getAllErrors();
			String errorContent = "";
			for (ObjectError oe : errorList) {
				errorContent += oe.getDefaultMessage();
			}
			throw new BusinessException(errorContent);
		}
	}
}
