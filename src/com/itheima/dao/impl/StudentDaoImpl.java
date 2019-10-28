package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.domain.ClassBean;
import com.itheima.domain.ClassTeaBean;
import com.itheima.domain.UserBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.dao.StudentDao;
import com.itheima.domain.Student;
import com.itheima.util.JDBCUtil02;
import com.itheima.util.TextUtils;

/**
 * 这是StudentDao的实现。 针对前面定义的规范，做出具体的实现。
 * @author xiaomi
 */
public class StudentDaoImpl implements StudentDao {


	/**
	 * 查询所有学生
	 * @throws SQLException 
	 */
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu", new BeanListHandler<Student>(Student.class));
	}

	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		runner.update("insert into stu (sno,sname,gender,phone,birthday,cs,grade) values(?,?,?,?,?,?,?)" ,
				student.getSno(),
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getCs(),
				student.getGrade()
				);
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("delete from stu where sid=?" ,sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu where sid = ?", new BeanHandler<Student>(Student.class) ,sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update stu set sno=? , sname=? , gender=? , phone=? , birthday=? , cs=? , grade=? where sid = ?",
				student.getSno(),
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getCs(),
				student.getGrade(),
				student.getSid());
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		System.out.println("现在要执行模糊查询了，收到的name ="+sname + "==genser=="+sgender);
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		//String sql = "select * from stu where sname=? or sgender=?";
		
		/*
		 * 这里要分析一下：
		 * 	如果只有姓名 ，select * from stu where sname like ? ;
		 * 	如果只有性别 ， select * from stu where gender = ?
		 * 
		 * 如果两个都有 select * from stu where sname like ? and gender=?
		 * 
		 * 如果两个都没有就查询所有。
		 * 
		 */
		String sql = "select * from stu where 1=1 ";
		List<String> list = new ArrayList<String> ();
				
		//判断有没有姓名， 如果有，就组拼到sql语句里面
		if(!TextUtils.isEmpty(sname)){
			sql = sql + "  and sname like ?";
			list.add("%"+sname+"%");
		}
		
		//判断有没有性别，有的话，就组拼到sql语句里面。
		if(!TextUtils.isEmpty(sgender)){
			sql = sql + " and gender = ?";
			list.add(sgender);
		}
		
		
		return runner.query(sql , new BeanListHandler<Student>(Student.class) ,list.toArray() );
		
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		//第一个问号，代表一页返回多少条记录  ， 第二个问号， 跳过前面的多少条记录。
		//5 0 --- 第一页 (1-1)*5
		//5 5  --- 第二页 (2-1)*5
		//5 10  --- 第三页
		return runner.query("select * from stu limit ? offset ?", 
				new BeanListHandler<Student>(Student.class) , PAGE_SIZE , (currentPage-1)*PAGE_SIZE);
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		//用于处理 平均值 、 总的个数。 
		Long  result = (Long) runner.query("SELECT COUNT(*) FROM stu" , new ScalarHandler() );
		return result.intValue();
	}


	@Override
	public boolean checkUserName(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select count(*) from users where username = ?";
		//runner.query(sql, new ScalarHandler(), username);
		Long result = (Long) runner.query(sql, new  ScalarHandler(), username);
		return result > 0 ;
	}

	@Override
	public UserBean login(UserBean user) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from users where username = ? and password = ? ";
		UserBean query = runner.query(sql, new BeanHandler<UserBean>(UserBean.class),user.getUsername(),user.getPassword());
		return query;
	}



	@Override
	public void updateCard(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update stu set sno=? , sname=? , ch=? , en=? , math=? , physics=? , chemistry=? where sid = ?",
				student.getSno(),
				student.getSname(),
				student.getCh(),
				student.getEn(),
				student.getMath(),
				student.getPhysics(),
				student.getChemistry(),
				student.getSid());
	}


	@Override
	public List<ClassBean> searchClass(String sname) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "SELECT * FROM `class` where sno=?";
		return runner.query(sql,new BeanListHandler<ClassBean>(ClassBean.class),sname);
	}

	@Override
	public List<ClassTeaBean> ClassAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "SELECT * FROM `myclass` ";
		return runner.query(sql,new BeanListHandler<ClassTeaBean>(ClassTeaBean.class));
	}

	@Override
	public void updateTeaClass(ClassTeaBean classTeaBean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "update  `myclass` set yi=? , er=? , san=? , si=? , wu=? where id=?";
		runner.update(sql,
				classTeaBean.getYi(),
				classTeaBean.getEr(),
				classTeaBean.getSan(),
				classTeaBean.getSi(),
				classTeaBean.getWu());
	}
}
