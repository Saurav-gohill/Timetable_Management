//import javax.swing.*;
//import java.awt.*;
//import java.util.Map;
//
//public class TimetableEditorWindow extends JFrame {
//    private Map<String, Map<String, String[]>> timetable;
//
//    public TimetableEditorWindow(Map<String, Map<String, String[]>> timetable) {
//        this.timetable = timetable;
//        setTitle("Timetable Editor");
//        setSize(1200, 700);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        initUI();
//    }
//
//    private void initUI() {
//        JTabbedPane tabbedPane = new JTabbedPane();
//        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
//
//        for (String day : days) {
//            tabbedPane.addTab(day, createEditableDayPanel(day));
//        }
//
//        JButton saveButton = new JButton("Save Changes");
//        saveButton.addActionListener(e -> saveChanges());
//
//        JPanel mainPanel = new JPanel(new BorderLayout());
//        mainPanel.add(tabbedPane, BorderLayout.CENTER);
//        mainPanel.add(saveButton, BorderLayout.SOUTH);
//
//        add(mainPanel);
//    }
//
//    private JPanel createEditableDayPanel(String day) {
//        JPanel panel = new JPanel(new BorderLayout());
//
//        // Create editable table model
//        String[] columnNames = {"Time Slot", "Class", "Faculty", "Room", "Actions"};
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return column > 0 && column < 4; // Only Class, Faculty, Room are editable
//            }
//        };
//
//        // Populate with data
//        Map<String, String[]> daySchedule = timetable.get(day);
//        String[] timeSlots = {"8:50-9:40", "9:40-10:30", "10:30-11:20", "11:20-12:10",
//                "12:10-1:00", "1:00-1:50", "1:50-2:40", "2:40-3:30", "3:30-4:20"};
//
//        for (String slot : timeSlots) {
//            String[] details = daySchedule.get(slot);
//            Object[] row = new Object[5];
//            row[0] = slot;
//
//            if (details != null && details.length >= 3) {
//                row[1] = details[0]; // Class
//                row[2] = details[1]; // Faculty
//                row[3] = details[2]; // Room
//            } else {
//                row[1] = "";
//                row[2] = "";
//                row[3] = "";
//            }
//
//            row[4] = "Edit";
//            model.addRow(row);
//        }
//
//        JTable table = new JTable(model);
//        table.setRowHeight(30);
//
//        // Add combo box editors for Class, Faculty, Room
//        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JComboBox<>(getClassList())));
//        table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JComboBox<>(getFacultyList())));
//        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JComboBox<>(getRoomList())));
//
//        JScrollPane scrollPane = new JScrollPane(table);
//        panel.add(scrollPane, BorderLayout.CENTER);
//
//        return panel;
//    }
//
//    private String[] getClassList() {
//        // Fetch from database
//        return new String[]{"Class A", "Class B", "Class C"}; // Placeholder
//    }
//
//    private String[] getFacultyList() {
//        // Fetch from database
//        return new String[]{"Teacher 1", "Teacher 2", "Teacher 3"}; // Placeholder
//    }
//
//    private String[] getRoomList() {
//        // Fetch from database
//        return new String[]{"Room 101", "Room 102", "Lab 1"}; // Placeholder
//    }
//
//    private void saveChanges() {
//        // Implement save to database
//        JOptionPane.showMessageDialog(this, "Changes saved successfully!");
//        this.dispose();
//    }
//}