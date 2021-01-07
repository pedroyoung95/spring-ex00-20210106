package org.zerock.persistence;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "c##mydbms";
		String password = "admin";
//		String url ="jdbc:oracle:thin:@db202101040921_high?TNS_ADMIN=/home/opc/wallet";
//		String user = "admin";
//		String password = "ATPdatabase95";
		//오라클 클라우드를 사용하려면 이클립스 myProject1dml web.xml에 있는 
		//url, user, password를 작성하면 됨		
		
		try(Connection con = DriverManager.getConnection(url, user, password);) {
			assertNotNull(con);
		} catch (Exception e) {
			fail(e.getMessage());
			log.info(e);
		}
	}

}
