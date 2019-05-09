/**
 * 
 */
package com.macaitech.biz.multimodule.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macaitech.biz.multimodule.common.model.TestUser;

/**
 * @author yuhui.tang
 *
 */
public interface TestUserDao extends BaseMapper<TestUser> {
	public List<TestUser> queryAll();
}
