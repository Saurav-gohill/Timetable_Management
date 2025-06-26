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
                {"8:50 - 9:50", "", "", "", "", ""},
                {"9:50- 10:50", "", "", "", "", ""},
                {"10:50-11:50", "", "", "", "", ""},
                {"11:50-12:45", "", "", "", "", ""},
                {"12:45- 1:40", "", "", "", "", ""},
                {"1:40 - 2:35", "", "", "", "", ""},
                {"2:35 - 3:30", "", "", "", "", ""},
                {"3:30 - 4:20", "", "", "", "", ""}
        };



        JTable timetableTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(timetableTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}