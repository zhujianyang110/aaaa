package chapter3.repository;

import java.util.List;

import chapter3.entity.User;

public interface UserMapper {

	/**
	 * 
	 * @Title: save
	 * @Description: 新增用户
	 * @author: 朱建阳
	 * @date: 2019年7月15日 下午6:27:56
	 * @param user
	 * @return
	 * @return: int
	 * @since: 版本v1.0
	 */
	int save(User user);
	
	/**
	 * 
	 * @Title: update
	 * @Description: 编辑用户信息
	 * @author: 朱建阳
	 * @date: 2019年7月15日 下午6:28:35
	 * @param user
	 * @return
	 * @return: int
	 * @since: 版本v1.0
	 */
	int update(User user);
	
	/**
	 * 
	 * @Title: deleteById
	 * @Description: 根据id删除
	 * @author: 朱建阳
	 * @date: 2019年7月15日 下午6:29:06
	 * @param id
	 * @return
	 * @return: int
	 * @since: 版本v1.0
	 */
	int deleteById(int id);
	
	/**
	 * 
	 * @Title: selectById
	 * @Description: 根据id查询
	 * @author: 朱建阳
	 * @date: 2019年7月15日 下午6:31:30
	 * @param id
	 * @return
	 * @return: User
	 * @since: 版本v1.0
	 */
	User selectById(int id);
	
	/**
	 * 
	 * @Title: selectAll
	 * @Description: 查询所有用户信息
	 * @author: 朱建阳
	 * @date: 2019年7月15日 下午6:32:05
	 * @return
	 * @return: List<User>
	 * @since: 版本v1.0
	 */
	List<User> selectAll();
}
