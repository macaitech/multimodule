/**
 * 
 */
package com.macaitech.biz.multimodule.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macaitech.biz.multimodule.common.model.TestUser;
import com.macaitech.biz.multimodule.dao.TestUserDao;

/**
 * @author yuhui.tang
 *
 */
@Service
@Transactional
public class TestUserService extends ServiceImpl<TestUserDao,TestUser> {
	/**
	 * 
	 * @param userParam
	 * @return
	 */
	public List<TestUser> queryAllUsers() {
		List<TestUser> userList = baseMapper.queryAll();
		return userList;
	}
}
