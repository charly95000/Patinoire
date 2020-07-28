package org.eclipse.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MyDataSourceFactory {
	public static DataSource getMySQLDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		MysqlDataSource mysqlDataSource = null;
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);
			mysqlDataSource = new MysqlDataSource();
			mysqlDataSource.setURL(props.getProperty("url"));
			mysqlDataSource.setUser(props.getProperty("username"));
			mysqlDataSource.setPassword(props.getProperty("password"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDataSource;
	}
	
}
