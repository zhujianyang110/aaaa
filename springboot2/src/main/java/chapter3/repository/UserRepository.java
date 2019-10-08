package chapter3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chapter3.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * 
	 * @Title: findUserByUsername
	 * @Description: 根据用户名查找用户信息
	 * @author: 朱建阳
	 * @date: 2019年7月13日 下午4:57:19
	 * @param username
	 * @return
	 * @return: User
	 * @since: 版本v1.0
	 */
	User findUserByUsername(String username);
}
