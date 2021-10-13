package sql;

import User.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class UserSql {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /*
    * login method
    * @param loginUser
    * @return user
    * */
    public User login(User loginUser){
        try{
            String sql = "select * from usertable where username=? and password=?";
            User user = template.queryForObject(sql,
                        new BeanPropertyRowMapper<User>(User.class),
                        loginUser.getUsername(),
                        loginUser.getPassword()
                    );
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
