package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.ClassBean;
import com.itheima.domain.ClassTeaBean;
import com.itheima.domain.Student;
import com.itheima.domain.UserBean;

/**
 * 这是针对学生表的数据访问 
 * @author xiaomi
 *
 */
public interface StudentDao {
	
	int PAGE_SIZE = 10; //一页显示多少条记录
	
	/**
	 * 查询当页的学生数据
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<Student> findStudentByPage(int currentPage) throws SQLException ;
	
	/**
	 * 查询所有学生
	 * @return  List<Student>
	 */
	List<Student> findAll()  throws SQLException ;
	
	/**
	 * 根据ID查询单个学生对象
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	Student findStudentById(int sid)  throws SQLException ;

	/**
	 * 模糊查询， 根据姓名或者根据性别，或者两者兼有。 
	 * @param sname
	 * @param sgender
	 * @return 集合
	 * @throws SQLException
	 */
	List<Student> searchStudent(String sname, String sgender)  throws SQLException ;

	/**
	 * 添加学生
	 * @param student 需要添加到数据库的学生对象
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException ;
	
	/**
	 * 根据id删除学生
	 * @param sid
	 * @throws SQLException
	 */
	void delete(int sid) throws SQLException ;
	
	/**
	 * 更新学生信息
	 * @param student 需要更新的学生数据
	 * @throws SQLException
	 */
	void update(Student student)throws SQLException ;
	
	
	/**
	 * 查询总的学生记录数
	 * @return
	 * @throws SQLException
	 */
	int findCount()throws SQLException ;




	/**
	 * 用于检测用户名是否存在
	 * @param username
	 * @return true : 存在 ，false : 不存在
	 */
	boolean checkUserName(String username) throws SQLException;
	/**
	 * 用户登录
	 *
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	UserBean login(UserBean user) throws SQLException;

	/**
	 * 更新学生成绩信息
	 * @param student 需要更新的学生数据
	 * @throws SQLException
	 */
	void updateCard(Student student)throws SQLException ;

	/**
	 * 学生登录查询自己的成绩
	 * @param sname
	 * @return
	 * @throws SQLException
	 */
	List<ClassBean> searchClass(String sname)  throws SQLException ;

	/**
	 * 老师课程
	 * @return
	 * @throws SQLException
	 */
	List<ClassTeaBean> ClassAll()  throws SQLException ;

	void updateTeaClass(ClassTeaBean classTeaBean) throws SQLException;
}
