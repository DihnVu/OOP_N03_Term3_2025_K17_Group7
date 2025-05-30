import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GiaoDienMuonTra extends JFrame {
    private JTextField tfMaPhieu, tfMaSV, tfTenSV, tfMaSach, tfTenSach, tfNgayMuon, tfNgayTra, tfTimKiem;
    private JButton btnThem, btnXoa, btnSua, btnLuu, btnTimKiem;
    private JTable table;
    private DefaultTableModel model;

    public GiaoDienMuonTra(){
        setTitle("Giao Dien Muon Tra Sach");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelInput = new JPanel(new GridLayout(4, 4, 10, 10))
        panelInput.setBorder(BorderFactory.createTitledBorder("Thong Tin Muon Sach"))
        tfMaPhieu = new JTextField();
        tfMaSV = new JTextField();
        tfTenSV = new JTextField();
        tfMaSach = new JTextField();
        tfNgayMuon = new JTextField();
        tfNgayTra = new JTextField();
        tfTimKiem = new JTextField();

        panelInput.add(new JLabel("Ma Phieu Muon:"));
        panelInput.add(tfMaPhieu);
        panelInput.add(new JLabel("Ma SV:"));
        panelInput.add(tfMaSV);
        panelInput.add(new JLabel("Ten SV:"));
        panelInput.add(tfTenSV);
        panelInput.add(new JLabel("Ma Sach:"));
        panelInput.add(tfMaSach);
        panelInput.add(new JLabel("Ten Sach:"));
        panelInput.add(tfTenSach);
        panelInput.add(new JLabel("Ngay Muon:"));
        panelInput.add(tfNgayMuon);
        panelInput.add(new JLabel("Ngay Tra:"));
        panelInput.add(tfNgayTra);

        JPanel panelButtons = new JPanel(new FlowLayout());
        btnThem = new JButton("Them");
        btnXoa = new JButton("Xoa");
        btnSua = new JButton("Sua");
        btnLuu = new JButton("Luu");
        btnTimKiem = new JButton("");
        panelButtons.add(btnThem);
        panelButtons.add(btnXoa);
        panelButtons.add(btnSua);
        panelButtons.add(btnLuu);
        panelButtons.add(new JLabel("Tim Kiem"));
        panelButtons.add(tfTimKiem);
        panelButtons.add(btnTimKiem);

        String[] columsNames = {
            "Ma Phieu","Ma SV","Ten SV","Ma Sach","Ten Sach","Ngay Muon","Ngay Tra"
        };
        model = new DefaultTableModel(columsNames, 0);
        table = new JLabel(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panelInput, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        btnThem.addActionListener(e-> {
            String[] rowData = {
                tfMaPhieu.getText(),
                tfMaSv.getText(),
                tfTenSV.getText(),
                tfMaSach.getText(),
                tfTenSach.getText(),
                tfNgayMuon.getText(),
                tfNgayTra.getText(),
            };
            model.addRow(rowData);
            clearFields();
        });
    }
    private void clearFields(){
        tfMaPhieu.setText("");
        tfMaSV.setText("");
        tfTenSV.setText("");
        tfMaSach.setText("");
        tfTenSach.setText("");
        tfNgayMuon.setText("");
        tfNgayTra.setText("");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GiaoDienMuonTra().setVisible(true);
        });
    }
}
