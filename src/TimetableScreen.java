import javax.swing.*;
import java.awt.*;

public class TimetableScreen extends JFrame {
    public TimetableScreen() {
        setTitle("Timetable");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[][] data = {
                {"8:50-9:40", "", "", "", "", ""},
                {"9:40-10:30", "", "", "", "", ""},
                {"10:30-11:20", "", "", "", "", ""},
                {"11:20-12:10", "", "", "", "", ""},
                {"12:10-1:00", "", "", "", "", ""},
                {"1:00-1:50", "", "", "", "", ""},
                {"1:50-2:40", "", "", "", "", ""},
                {"2:40-3:30", "", "", "", "", ""},
                {"3:30-4:20", "", "", "", "", ""}
        };

        JTable timetableTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(timetableTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}