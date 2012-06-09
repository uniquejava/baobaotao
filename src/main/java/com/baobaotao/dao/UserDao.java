package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getMatchCount(String userName, String password) {
		String sql = "select count(*) from t_user where user_name =? and password=?";
		return jdbcTemplate.queryForInt(sql, userName, password);
	}
	
	public User findUserByUserName(String userName){
		String sql = "select user_id,user_name,credits from t_user where user_name=?";
		final User user = new User();
		jdbcTemplate.query(sql, new Object[]{userName}, new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setCredits(rs.getInt("credits"));
			}
			
		});
		return user;
		
	}
	
	public void updateLoginInfo(User user){
		String sql = "update t_user set last_visit=?,last_ip=?,credits=? where user_id=?";
		jdbcTemplate.update(sql, user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId());
	}
}
