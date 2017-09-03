package com.gaurav.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;

import com.gaurav.dao.RestDAO;

@Path("/v1/status")
public class V1_status extends RestDAO{

	private static final String API_version="01.00";
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle()
	{
		return "<p>Java webservice</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion()
	{
		return "<p>Java webservice</p>"+API_version;
	}
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception 
	{
		
		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;
		
		try {
			conn =  RestDAO.oraclePcPartsConnection();
			query= conn.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') DATETIME " +
                                        "from sys.dual");
			ResultSet rs = query.executeQuery();
			
			while (rs.next())
			{
				myString=rs.getString(1);
			}
			query.close();
			returnString= "<p>Database status</p> " + 
			"<p> database time : " + myString + "</p>";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (conn != null)
				conn.close();
		}
				return returnString;
	}
	
	
}
