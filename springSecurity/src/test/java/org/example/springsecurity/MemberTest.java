package org.example.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
/* 환경설정파일을 가져오게 해줌*/
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                        "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MemberTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //tbl_member 테이블 데이터 추가
    @Test
    public void testInsertMemeber() {
        String sql = "insert into tbl_member(userid, userpw, username) values(?,?,?)";
        for (int i = 0; i < 100; i++) {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = dataSource.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(2, passwordEncoder.encode("pw" + i));  //비밀번호(비밀번호 암호화시켜줌)
                if (i < 80) {
                    ps.setString(1, "user" + i);
                    ps.setString(3, "일반사용자" + i);
                } else if (i < 90) {
                    ps.setString(1, "manager" + i);
                    ps.setString(3, "운영자" + i);
                } else {
                    ps.setString(1, "admin" + i);
                    ps.setString(3, "관리자" + i);
                }
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

    //tbl_member_auth 테이블 데이터 추가(권한)
    @Test
    public void testInsertAuth() {
        String sql = "insert into tbl_member_auth(userid, auth) values(?,?)";
        for (int i = 0; i < 100; i++) {
            Connection conn = null;
            PreparedStatement ps = null;

            try {
                conn = dataSource.getConnection();
                ps = conn.prepareStatement(sql);
                if (i < 80) {
                    ps.setString(1, "user" + i);
                    ps.setString(2, "ROLE_USER");
                } else if (i < 90) {
                    ps.setString(1, "manager" + i);
                    ps.setString(2, "ROLE_MANAGER");
                } else {
                    ps.setString(1, "admin" + i);
                    ps.setString(2, "ROLE_ADMIN");
                }
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}