package Data;
import Utils.SQLClass;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Member {
    public static String firstName ,    lastName,    phone ,    email ,    dateOfBirth ,    password ;

    public Member( int i ) throws SQLException {
        ResultSet memberData = SQLClass.select(i);
        while (memberData.next()) {
            this.firstName = memberData.getString("firstName");
            this.lastName =memberData.getString("lastName");
            this.phone = memberData.getString("phone");
            this.email = memberData.getString("email");
            this.dateOfBirth = memberData.getString("dateOfBirth");
            this.password = memberData.getString("password");
        }
    }

   }
