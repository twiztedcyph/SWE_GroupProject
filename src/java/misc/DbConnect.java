/*
 * Computer Systems 2 Coursework.
 */
package misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * All database connections are made here.
 * 
 * @author Ashley Moore (6304397)
 * @author Ian Weeks (6204848)
 * @version 1
 */
public class DbConnect
{
    private final int PORT = 5432;
    private String database, username, password;
    private Connection myCon;
    
    /**
     * Default constructor. Database name, username 
     * and password are set to default values here.
     */
    public DbConnect()
    {
        this.database = "healthTracker";
        this.username = "postgres";
        this.password = "deathrow";
        myCon = null;
    }
    
    /**
     * Constructor with manual database name, username and password.
     * 
     * @param database
     * @param username
     * @param password 
     */
    public DbConnect(String database, String username, String password)
    {
        this.database = database;
        this.username = username;
        this.password = password;
        myCon = null;
    }
    
    /**
     * Performs a database update.
     * 
     * @param update SQL instructions for the update.
     * @return Returns true if no error. False otherwise.
     */
    public boolean runUpdate(String update)
    {
        boolean worked = true;
        myCon = getCon();
        try
        {
            PreparedStatement updateStatement = myCon.prepareStatement(update);
            updateStatement.executeUpdate();
            myCon.close();
        } catch (SQLException sqle)
        {
            worked = false;
            System.err.println("Error: runUpdate failed. " + sqle);
        }
        
        return worked;
    }
    
    public boolean runUpdate(String update, byte[] image)
    {
        boolean worked = true;
        myCon = getCon();
        try
        {
            PreparedStatement updateStatement = myCon.prepareStatement(update);
            updateStatement.setBytes(1, image);
            updateStatement.executeUpdate();
            myCon.close();
        } catch (SQLException sqle)
        {
            worked = false;
            System.err.println("Error: runUpdate failed. " + sqle);
        }
        
        return worked;
    }
    
    /**
     * Performs a query on the database and returns the results in a ResultSet.
     * 
     * @param query SQL instructions for the query.
     * @return A result set of the query.
     */
    public ResultSet runQuery(String query)
    {
        ResultSet myRs = null;
        myCon = getCon();
        try
        {
            PreparedStatement updateStatement = myCon.prepareStatement(query, 
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            myRs = updateStatement.executeQuery();
            myCon.close();
        } catch (SQLException sqle)
        {
            System.err.println("Error: runQuery failed. " + sqle);
        }
        return myRs;
    }
    
    public ResultSet runSecQuery(PreparedStatement updateStatement)
    {
        ResultSet myRs = null;
        myCon = getCon();
        try
        {
            myRs = updateStatement.executeQuery();
            myCon.close();
        } catch (SQLException sqle)
        {
            System.err.println("Error: runQuery failed. " + sqle);
        }
        return myRs;
    }
    
    public Connection getCon()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe)
        {
            System.err.println("Error: Class.forName. " + cnfe);
        }
        
        try
        {
            return DriverManager.getConnection("jdbc:postgresql:"+database, username, password);
        } catch (SQLException sqle)
        {
            System.err.println("Error: Database connection. " + sqle);
            return null;
        }
    }
    
    public boolean runSecUpdate(String update)
    {
        boolean worked = true;
        myCon = getCon();
        try
        {
            PreparedStatement updateStatement = myCon.prepareStatement(update);
            updateStatement.executeUpdate();
            myCon.close();
        } catch (SQLException sqle)
        {
            worked = false;
            System.err.println("Error: runUpdate failed. " + sqle);
        }
        
        return worked;
    }
}
