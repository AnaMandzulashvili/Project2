package Utils;
import io.qameta.allure.Step;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class SQLClass {

    @Step("Connect to data base ")
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")) {
            Properties pros = new Properties();
            pros.load(f);
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            // პაროლი მაქვს შეცვლილი , თავად მოითხოვა ცვლილება  A12345 ესაა
            String password = pros.getProperty("password");
            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            if (conn == null)
                conn.close();}
        return conn;
    }


    @Step("Insert member and  commit.method runs With AutoCommitFalse mood  ")
    public static void insertMemberWithCommit( String firstName, String lastName, String phone, String email, String dateOfBirth, String password) {
        ResultSet rs = null;
        String sql = " insert into [users].[dbo].[users]\n" +
                "(id,firstName,lastName,phone)\n" +
                "  values(?,?,?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            conn.setAutoCommit(false);

            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, phone);
            pstmt.setString(5,email);
            pstmt.setString(6,dateOfBirth);
            pstmt.setString(7,password);
            pstmt.executeQuery();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try { if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Step("Select particular row from DB")
    public static  ResultSet select(int id) {
        String sql = "SELECT * FROM [users].[dbo].[users] where id=" + id;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            Connection conn = getConnection();
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  return resultSet ;
    }

 }

