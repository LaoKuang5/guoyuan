
package cn.edu.glut.log;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private static interface Singleton {
		final ConnectionFactory INSTANCE = new ConnectionFactory();
	}

	private final DataSource dataSource;

	private ConnectionFactory() {
		// 数据源
		Properties p = new Properties();
		ComboPooledDataSource dataSource = null;
		try {
			dataSource= new ComboPooledDataSource();
			p.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			dataSource.setDriverClass(p.getProperty("jdbc.driver"));
			dataSource.setJdbcUrl(p.getProperty("jdbc.url"));
			dataSource.setUser(p.getProperty("jdbc.uid"));
			dataSource.setPassword(p.getProperty("jdbc.pwd"));
			dataSource.setInitialPoolSize(6);
			dataSource.setMaxPoolSize(15);
			dataSource.setMaxIdleTime(60);
			
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.dataSource = dataSource;
	}

	public static Connection getDatabaseConnection() throws SQLException {
		return Singleton.INSTANCE.dataSource.getConnection();
	}
}