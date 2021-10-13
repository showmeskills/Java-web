package test;

import User.User;
import org.junit.Test;
import sql.UserSql;

public class UserTest {
    @Test
    public void testLogin(){
        User user = new User();
        user.setUsername("terry");
        user.setPassword("123456");
        UserSql userSql = new UserSql();
        User loginUser = userSql.login(user);
        System.out.println(loginUser);
    }
}
