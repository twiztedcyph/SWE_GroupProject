/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cypher
 */
public class MemberBean implements Serializable {

    private int id;
    private String userName, password, firstName, lastName, emailAddress, accessType;
    private Date dateOfBirth;
    private ArrayList<GoalBean> goalList;

    public MemberBean() {
    }

    public MemberBean(ResultSet rs) throws SQLException {
        while (rs.next()) {
            this.id = rs.getInt("id");
            this.userName = rs.getString("user_name");
            this.password = rs.getString("password");
            this.firstName = rs.getString("first_name");
            this.lastName = rs.getString("last_name");
            this.emailAddress = rs.getString("email_address");
            this.accessType = rs.getString("access_type");
            this.dateOfBirth = rs.getDate("date_of_birth");
        }
    }

    public MemberBean(String userName, String password, String firstName, String lastName, String emailAddress, String accessType, Date dateOfBirth) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.accessType = accessType;
        this.dateOfBirth = dateOfBirth;
    }

    public void persist() throws SQLException {
        misc.DbConnect dbConnect = new misc.DbConnect();

        Connection myCon = dbConnect.getCon();

        PreparedStatement ps = myCon.prepareStatement("INSERT INTO member "
                + "(user_name, password, first_name, last_name, email_address, "
                + "date_of_birth, access_type) values(?, ?, ?, ?, ?, ?, ?)");

        ps.setString(1, userName);
        ps.setString(2, password);
        ps.setString(3, firstName);
        ps.setString(4, lastName);
        ps.setString(5, emailAddress);
        ps.setDate(6, dateOfBirth);
        ps.setString(7, accessType);

        ps.executeUpdate();
        myCon.close();
    }

    public static MemberBean retrieveOne(String username) throws SQLException
    {
        misc.DbConnect dbConnect = new misc.DbConnect();

        PreparedStatement ps;
        try (Connection myCon = dbConnect.getCon()) {
            ps = myCon.prepareStatement("Select * from member where user_name = ?");
            ps.setString(1, username);
            return new MemberBean(ps.executeQuery());
        }
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void changePassword(String newPassword) throws SQLException {
        misc.DbConnect dbConnect = new misc.DbConnect();
        Connection myCon = dbConnect.getCon();
        PreparedStatement ps = myCon.prepareStatement("UPDATE member SET password=? WHERE user_name = ?");
        ps.setString(1, newPassword);
        ps.setString(2, userName);
        ps.executeUpdate();
        myCon.close();
    }

    public void changeEmail(String newEmail) throws SQLException {
        misc.DbConnect dbConnect = new misc.DbConnect();
        Connection myCon = dbConnect.getCon();
        PreparedStatement ps = myCon.prepareStatement("UPDATE member SET email_address=? WHERE user_name = ?");
        ps.setString(1, newEmail);
        ps.setString(2, userName);
        ps.executeUpdate();
        myCon.close();
    }

    public ArrayList<GoalBean> getGoalList() throws SQLException {
        goalList = new ArrayList<>();

        misc.DbConnect databaseConnection = new misc.DbConnect();

        ResultSet rs = databaseConnection.runQuery("SELECT * FROM goal WHERE submitter = " + id + ";");

        while (rs.next()) {
            GoalBean goal = new GoalBean(rs);
            goalList.add(goal);
        }
        for (GoalBean goal : goalList) {
            System.out.println(goal);
        }
        return goalList;
    }

    public ArrayList<GoalBean> getGoalsInProgress() throws SQLException {
        goalList = new ArrayList<>();

        misc.DbConnect databaseConnection = new misc.DbConnect();

        ResultSet rs = databaseConnection.runQuery("SELECT * FROM goal WHERE submitter = " + id + ";");

        ArrayList<GoalBean> indexGoals = new ArrayList<>();

        while (rs.next()) {
            GoalBean goal = new GoalBean(rs);
            goalList.add(goal);
        }
        
        Calendar calLocal = new GregorianCalendar();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String localDateFormatted = dateFormatter.format(calLocal.getTime());
        java.sql.Date localDate = java.sql.Date.valueOf(localDateFormatted);

        for (GoalBean tempGoal : goalList) {

            int dateDifference = tempGoal.getGoalEndDate().compareTo(localDate);
            
            if (tempGoal.getGoalProgress() < 100 && dateDifference >= 0) {
                
                indexGoals.add(tempGoal);
            }
        }
        
        return indexGoals;
    }
}
