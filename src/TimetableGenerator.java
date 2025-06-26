import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

public class TimetableGenerator {
    public static void generateAndShowTimetable() {
        try (Connection conn = Database.connect()) {
            // Fetch all necessary data
            List<String[]> classes = DatabaseFetcher.fetchClasses();
            List<String[]> faculty = DatabaseFetcher.fetchFaculty();
            List<String[]> rooms = DatabaseFetcher.fetchRooms();

            // Generate timetable (simple algorithm)
            Map<String, String[][]> timetable = generateTimetable(classes, faculty, rooms);

            // Display in new window
            new TimetableDisplayWindow(timetable).setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error generating timetable: " + e.getMessage());
        }
    }

    private static Map<String, String[][]> generateTimetable(List<String[]> classes,
                                                             List<String[]> faculty,
                                                             List<String[]> rooms) {
        // Simple timetable generation algorithm
        // This is a placeholder - you should implement your actual algorithm here

        Map<String, String[][]> timetable = new HashMap<>();
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] timeSlots = {"8:50-9:40", "9:40-10:30", "10:30-11:20", "11:20-12:10",
                "12:10-1:00", "1:00-1:50", "1:50-2:40", "2:40-3:30", "3:30-4:20"};

        // Initialize empty timetable
        for (String day : days) {
            String[][] daySchedule = new String[timeSlots.length][3]; // time slot -> [class, faculty, room]
            timetable.put(day, daySchedule);
        }

        // Simple assignment (replace with your actual algorithm)
        Random rand = new Random();
        for (String[] cls : classes) {
            String day = days[rand.nextInt(days.length)];
            int timeSlot = rand.nextInt(timeSlots.length);

            String[] facultyMember = faculty.get(rand.nextInt(faculty.size()));
            String[] room = rooms.get(rand.nextInt(rooms.size()));

            timetable.get(day)[timeSlot][0] = cls[1]; // Class name
            timetable.get(day)[timeSlot][1] = facultyMember[1]; // Faculty name
            timetable.get(day)[timeSlot][2] = room[1]; // Room name
        }

        return timetable;
    }
}