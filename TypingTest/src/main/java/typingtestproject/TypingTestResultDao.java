package typingtestproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypingTestResultDao {

    public static void save(TypingTestResult typingTestResult) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/typing_test", "root", "123456");
            stmt = conn.prepareStatement("INSERT INTO typing_test_results (user_id, typing_speed) VALUES (?, ?)");
            stmt.setString(1, typingTestResult.getUserId());
            stmt.setDouble(2, typingTestResult.getTypingSpeed());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<TypingTestResult> getTopScores(int limit) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TypingTestResult> results = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/typing_test", "root", "password");
            stmt = conn.prepareStatement("SELECT user_id, typing_speed FROM typing_test_results ORDER BY typing_speed DESC LIMIT ?");
            stmt.setInt(1, limit);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String userId = rs.getString("user_id");
                double typingSpeed = rs.getDouble("typing_speed");
                results.add(new TypingTestResult(userId, typingSpeed));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}