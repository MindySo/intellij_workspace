package kr.co.jhta.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class ConnectionManager {
    // JDBC : Connection
    // MyBatis : SqlSession

    static SqlSessionFactory factory;

    static {
//      Resources.getResourceAsReader("파일의 위치");
        try {
            Reader r = Resources.getResourceAsReader("sqlMapConfig.xml");

            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(r);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }// static block end
}// class end
