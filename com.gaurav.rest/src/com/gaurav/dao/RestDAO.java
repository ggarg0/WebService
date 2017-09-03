package com.gaurav.dao;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

public class RestDAO {

	private static DataSource dataObj = null;
	private static Context context = null;
	
	private static DataSource DatabaseConn() throws Exception
	{
		if (dataObj != null)
		{
			return dataObj;
		}
		try
		{
			if (context == null)
			{
				context = new InitialContext();
			}
			dataObj = (DataSource) context.lookup("hr");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dataObj;
	}
	
    protected static Connection oraclePcPartsConnection() {
        Connection conn = null;
        try {
                conn = DatabaseConn().getConnection();
                return conn;
        } 
        catch (Exception e) {
                e.printStackTrace();
        }
        return conn;
}
}
