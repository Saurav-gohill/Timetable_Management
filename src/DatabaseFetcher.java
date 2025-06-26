import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFetcher {

    // Fetch all faculty data from the database
    public static List<String[]> fetchFaculty() {
        List<String[]> facultyList = new ArrayList<>();
        String sql = "SELECT * FROM Faculty";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String facultyId = rs.getString("faculty_id");
                String facultyName = rs.getString("faculty_name");
                String subjects = rs.getString("subjects");
                facultyList.add(new String[]{facultyId, facultyName, subjects});
            }
        } catch (SQLException e) {
            System.out.println("Error fetching faculty data: " + e.getMessage());
        }

        return facultyList;
    }

    // Fetch all rooms data from the database
    public static List<String[]> fetchRooms() {
        List<String[]> roomsList = new ArrayList<>();
        String sql = "SELECT * FROM Rooms";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String roomId = rs.getString("room_id");
                String roomName = rs.getString("room_name");
                String capacity = rs.getString("capacity");
                roomsList.add(new String[]{roomId, roomName, capacity});
            }
        } catch (SQLException e) {
            System.out.println("Error fetching rooms data: " + e.getMessage());
        }

        return roomsList;
    }

    // Fetch all classes data from the database
    public static List<String[]> fetchClasses() {
        List<String[]> classesList = new ArrayList<>();
        String sql = "SELECT * FROM Classes";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String classId = rs.getString("class_id");
                String className = rs.getString("class_name");
                String subjects = rs.getString("subjects");
                classesList.add(new String[]{classId, className, subjects});
            }
        } catch (SQLException e) {
            System.out.println("Error fetching classes data: " + e.getMessage());
        }

        return classesList;
    }
}