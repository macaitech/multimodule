/**
 * 
 */
package com.macaitech.biz.multimodule.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macaitech.biz.multimodule.api.TestUserServiceInterface;
import com.macaitech.biz.multimodule.common.model.TestUser;
import com.macaitech.biz.multimodule.service.TestUserService;
import com.macaitech.multimodule.base.model.RestResult;
import com.macaitech.multimodule.base.rest.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author yuhui.tang
 *
 */
@RestController
@RequestMapping("/test/user")
@Api("测试服务接口")
public class StreamUserRest extends BaseController implements TestUserServiceInterface{
	
	@Autowired
	private TestUserService TestUserService;
	/**
	 * 获取用户列表
	 * @param commandData
	 * @return
	 */
	@ApiOperation("获取用户列表")
    @GetMapping("/list")
    public RestResult<List<TestUser>> getUserList() {
		List<TestUser> userList =  this.TestUserService.queryAllUsers();
		RestResult<List<TestUser>> result = new RestResult<>();
		result.setData(userList);
		return result;
	}
}
