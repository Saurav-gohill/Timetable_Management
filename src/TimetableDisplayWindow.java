import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class TimetableDisplayWindow extends JFrame {
    public TimetableDisplayWindow(Map<String, String[][]> timetable) {
        setTitle("Generated Timetable");
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] timeSlots = {"8:50-9:40", "9:40-10:30", "10:30-11:20", "11:20-12:10",
                "12:10-1:00", "1:00-1:50", "1:50-2:40", "2:40-3:30", "3:30-4:20"};

        for (String day : days) {
            JPanel dayPanel = new JPanel(new BorderLayout());

            // Column headers
            String[] columnNames = {"Time Slot", "Class", "Faculty", "Room"};
            String[][] data = new String[timeSlots.length][4];

            for (int i = 0; i < timeSlots.length; i++) {
                data[i][0] = timeSlots[i];
                if (timetable.get(day)[i] != null) {
                    data[i][1] = timetable.get(day)[i][0]; // Class
                    data[i][2] = timetable.get(day)[i][1]; // Faculty
                    data[i][3] = timetable.get(day)[i][2]; // Room
                } else {
                    data[i][1] = "Free";
                    data[i][2] = "";
                    data[i][3] = "";
                }
            }

            JTable table = new JTable(data, columnNames);
            table.setRowHeight(30);
            table.setFont(new Font("Arial", Font.PLAIN, 14));

            JScrollPane scrollPane = new JScrollPane(table);
            dayPanel.add(scrollPane, BorderLayout.CENTER);

            tabbedPane.addTab(day, dayPanel);
        }

        add(tabbedPane);
    }
}