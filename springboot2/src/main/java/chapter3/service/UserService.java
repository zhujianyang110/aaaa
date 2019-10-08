package chapter3.service;

import java.util.List;

import chapter3.entity.User;


public interface UserService {

	/**
	 * 
	 * @Title: saveUser
	 * @Description: 添加用户信息
	 * @author: 朱建阳
	 * @date: 2019年7月15日 上午9:35:01
	 * @param user
	 * @return
	 * @return: User
	 * @since: 版本v1.0
	 */
	User saveUser(User user);
	
	/**
	 * 
	 * @Title: updateUser
	 * @Description: 更新用户信息
	 * @author: 朱建阳
	 * @date: 2019年7月15日 上午9:35:32
	 * @param user
	 * @return
	 * @return: User
	 * @since: 版本v1.0
	 */
	User updateUser(User user);
	
	/**
	 * 
	 * @Title: getById
	 * @Description: 根据id获取用户
	 * @author: 朱建阳
	 * @date: 2019年7月15日 上午9:36:58
	 * @param id
	 * @return
	 * @return: User
	 * @since: 版本v1.0
	 */
	User getById(Long id);
	
	/**
	 * 
	 * @Title: getByUserName
	 * @Description: 根据名称获取用户
	 * @author: 朱建阳
	 * @date: 2019年7月15日 上午9:39:29
	 * @return
	 * @return: User
	 * @since: 版本v1.0
	 */
	User getByUserName(String username);
	
	/**
	 * 
	 * @Title: queryAll
	 * @Description: 查询所有用户
	 * @author: 朱建阳
	 * @date: 2019年7月15日 上午9:40:11
	 * @return
	 * @return: List<User>
	 * @since: 版本v1.0
	 */
	List<User> queryAll();
	
	/**
	 * 
	 * @Title: deleteById
	 * @Description: 根据id删除用户信息
	 * @author: 朱建阳
	 * @date: 2019年7月15日 上午9:40:49
	 * 
	 * @return: void
	 * @since: 版本v1.0
	 */
	void deleteById(Long id);
}

