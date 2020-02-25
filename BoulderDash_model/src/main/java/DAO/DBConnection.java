package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DBConnection.
 *
 * @author Group7
 */

public class DBConnection {

	/** The connection. */
	private Connection					connection;
	
	/** The url. */
	private String							url = "jdbc:mysql://localhost/jpublankproject?useSSL=false&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

	/** The login. */
	private String							login = "root";

	/** The password. */
	private String							password = "bonsoir";
	
	/** The password. */
	private CallableStatement							statement;
	
	
	
	/**
	 * Instantiates a new DB connection.
	 */
	
	
	public DBConnection() {
     	this.open();
     }


	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	
	 public boolean open() {
	        try {
	        	try {
	    			Class.forName("com.mysql.cj.jdbc.Driver");
	    		} catch (ClassNotFoundException e) {
	    			e.printStackTrace();
	    		}
	            this.connection = DriverManager.getConnection(url,login,password);
	            return true;  
	        } catch (final SQLException exception) {
	            exception.printStackTrace();
	            return false;
	        }      
	    }
	 
	 public boolean close() {
	     try {
			this.statement.close();
			this.connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	    }

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}


/**
 * Gets the statement.
 *
 * @return the statement
 */
public CallableStatement getStatement() {
    return this.statement;
}

/**
 * Sets the statement.
 *
 * @param statement
 *            the new statement
 */
public void setStatement(final CallableStatement statement) {
    this.statement = statement;
}
}