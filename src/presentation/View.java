package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import domain.*;
import domain.model.HoaDon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class View extends JFrame {
    private HoaDonService hoaDonService;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton findButton;
    private JButton sumButton;
    private JButton avgButton;

    private JTextField idTextField;
    private JTextField dateTextField;
    private JTextField nameTextField;
    private JTextField idroomTextField;
    private JTextField unitpriceTextField;
    private JTextField priceTextField;

    public View() {
        // Set up JFrame
        setTitle("Hotel Managers");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create JTable to display student list
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Date");
        tableModel.addColumn("Name");
        tableModel.addColumn("ID Room");
        tableModel.addColumn("Unit Price");
        tableModel.addColumn("Price");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Tạo JPanel có thông tin khách hàng và các tác vụ
        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
        idTextField = new JTextField();
        dateTextField = new JTextField();
        nameTextField = new JTextField();
        idroomTextField = new JTextField();
        unitpriceTextField = new JTextField();
        priceTextField = new JTextField();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        findButton = new JButton("Find");
        sumButton = new JButton("Sum");
        avgButton = new JButton("Average");

        inputPanel.add(new JLabel("ID: "));
        inputPanel.add(idTextField);
        inputPanel.add(new JLabel("Date: "));
        inputPanel.add(dateTextField);
        inputPanel.add(new JLabel("Name: "));
        inputPanel.add(nameTextField);
        inputPanel.add(new JLabel("ID Room: "));
        inputPanel.add(idroomTextField);
        inputPanel.add(new JLabel("Unit Price: "));
        inputPanel.add(idroomTextField);
        inputPanel.add(new JLabel("Price: "));
        inputPanel.add(priceTextField);

        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);
        inputPanel.add(findButton);
        inputPanel.add(sumButton);
        inputPanel.add(avgButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addHoaDon();
            }
        });
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editHoaDon();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteHoaDon();
            }
        });
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findStudent();
            }
        });

        // Load initial student list
         loadHoaDonList();
    }

    // Method to add a student
    private void addHoaDon() {
        int id = Integer.parseInt(idTextField.getText());
        String date = dateTextField.getText();
        String name = nameTextField.getText();
        int idroom = Integer.parseInt(idroomTextField.getText());
        int unitprice = Integer.parseInt(unitpriceTextField.getText());
        

        // Calculate the average mark using the formula provided
        double price = 4.0;

        HoaDon hoaDon = new HoaDon(id, date, name, idroom, unitprice, price);
        hoaDonService.addHoaDon(hoaDon);

        clearFields();
        loadHoaDonList();
    }

    // Method to edit a student
    private void editHoaDon() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to edit.");
            return;
        }

        int id = Integer.parseInt(idTextField.getText());
        String date = dateTextField.getText();
        String name = nameTextField.getText();
        int idroom = Integer.parseInt(idroomTextField.getText());
        int unitprice = Integer.parseInt(unitpriceTextField.getText());
        

        // Calculate the average mark using the formula provided
        double price = 4.0;

        HoaDon hoaDon = new HoaDon(id, date, name, idroom, unitprice, price);
        hoaDonService.editHoaDon(hoaDon);

        clearFields();
        loadHoaDonList();
    }

    // Method to delete a student
    private void deleteHoaDon() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to delete.");
            return;
        }

        int id = (int) tableModel.getValueAt(row, 0);
        hoaDonService.deleteHoaDon(id);

        clearFields();
        loadHoaDonList();
    }

    // Method to find a student
    private void findStudent() {
        int id = Integer.parseInt(idTextField.getText());
        HoaDon hoaDon = hoaDonService.getHoaDonById(id);

        if (hoaDon != null) {
            dateTextField.setText(hoaDon.getNgayHoaDon());
            nameTextField.setText(hoaDon.getTenKhachHang());
            idroomTextField.setText(String.valueOf(hoaDon.getTenKhachHang()));
            unitpriceTextField.setText(String.valueOf(hoaDon.getMaPhong()));
        } else {
            JOptionPane.showMessageDialog(this, "Student not found.");
            clearFields();
        }
    }

    // Method to load the student list into the JTable
    private void loadHoaDonList() {
        List<HoaDon> hoaDons = hoaDonService.getAllHoaDon();
        tableModel.setRowCount(0); // Clear previous data
        for (HoaDon hoaDon : hoaDons) {
            Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getNgayHoaDon(), hoaDon.getTenKhachHang(),
                    hoaDon.getMaPhong(), hoaDon.getDonGia(), hoaDon.getCssMark()};
            tableModel.addRow(rowData);
        }
    }

    // Method to clear input fields
    private void clearFields() {
        idTextField.setText("");
        dateTextField.setText("");
        nameTextField.setText("");
        idTextField.setText("");
        unitpriceTextField.setText("");
    }

}
