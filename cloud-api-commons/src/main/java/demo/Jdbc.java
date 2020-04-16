package demo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/16 17:26
 */
public class Jdbc {
    @Test
    public void test() throws Exception {
        String url = "jdbc:mysql://localhost:3306/cloud";
        String name = "root";
        String password = "root1234";
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection(url, name, password);
        System.out.println(conn);
    }
}
