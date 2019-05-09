/**
 * 
 */
package com.macaitech.biz.multimodule.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macaitech.multimodule.base.exception.CustomException;
import com.macaitech.multimodule.base.exception.GlobalErrorCode;
import com.macaitech.multimodule.base.model.RestResult;

import feign.FeignException;


/**
 * @author yuhui.tang
 * Rest层全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 自定义错误
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = CustomException.class)
	@ResponseBody
	public RestResult<Object> baseErrorHandler(CustomException e) throws Exception {
		this.logger.error(e.getMessage(), e);
		
		RestResult<Object> result = new RestResult<>();
		result.setMessage(e.getMessage());
		result.setStatus(e.getCode());
		return result;
	}
    
	/**
	 * Exception错误封装
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public RestResult<Object> exceptionErrorHandler(Exception e) throws Exception {
		this.logger.error(e.getMessage(), e);
		
		RestResult<Object> result = new RestResult<>();
		if(e instanceof FeignException) {//404 先返回
			FeignException feignException = (FeignException) e;
			if(feignException.status() == 404) {
				result.setStatus(GlobalErrorCode.NOT_FOUND.getCode());
				result.setMessage(GlobalErrorCode.NOT_FOUND.getMessage());
				return result;
			}
		}
		result.setStatus(GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode());
		result.setMessage(GlobalErrorCode.INTERNAL_SERVER_ERROR.getMessage());
		return result;
	}
}
