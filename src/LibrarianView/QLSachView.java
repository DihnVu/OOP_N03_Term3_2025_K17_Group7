import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class QLSachView extends JFrame {
    private JTextField tfMaSach, tfTenSach, tfTheLoai, tfTacGia, tfNamXB, tfSoLuong, tfTimKiem;
    private JButton btnLuu, btnCapNhat, btnXoa, btnTim, btnHuyTim;
    private JTable table;
    private DefaultTableModel tableModel;

    private ArrayList<Sach> danhSach = new ArrayList<>();

    public QLSachView() {
        setTitle("Quản lý đầu sách");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        // Panel nhập thông tin
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông tin sách"));

        tfMaSach = new JTextField();
        tfTenSach = new JTextField();
        tfTheLoai = new JTextField();
        tfTacGia = new JTextField();
        tfNamXB = new JTextField();
        tfSoLuong = new JTextField();

        inputPanel.add(new JLabel("Mã sách:"));
        inputPanel.add(tfMaSach);
        inputPanel.add(new JLabel("Tên sách:"));
        inputPanel.add(tfTenSach);
        inputPanel.add(new JLabel("Thể loại:"));
        inputPanel.add(tfTheLoai);
        inputPanel.add(new JLabel("Tác giả:"));
        inputPanel.add(tfTacGia);
        inputPanel.add(new JLabel("Năm xuất bản:"));
        inputPanel.add(tfNamXB);
        inputPanel.add(new JLabel("Số lượng:"));
        inputPanel.add(tfSoLuong);

        add(inputPanel, BorderLayout.NORTH);

        // Panel nút chức năng
        JPanel btnPanel = new JPanel();
        btnLuu = new JButton("Lưu");
        btnCapNhat = new JButton("Cập nhật");
        btnXoa = new JButton("Xóa");

        btnPanel.add(btnLuu);
        btnPanel.add(btnCapNhat);
        btnPanel.add(btnXoa);

        add(btnPanel, BorderLayout.CENTER);

        // Panel tìm kiếm
        JPanel searchPanel = new JPanel();
        tfTimKiem = new JTextField(15);
        btnTim = new JButton("Tìm");
        btnHuyTim = new JButton("Hủy Tìm");

        searchPanel.add(new JLabel("Nhập mã sách:"));
        searchPanel.add(tfTimKiem);
        searchPanel.add(btnTim);
        searchPanel.add(btnHuyTim);

        add(searchPanel, BorderLayout.SOUTH);

        // Bảng hiển thị
        tableModel = new DefaultTableModel(new Object[]{"Mã", "Tên", "Thể Loại", "Tác Giả", "Năm XB", "Số lượng"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.EAST);

        // Sự kiện nút
        btnLuu.addActionListener(e -> themSach());
        btnCapNhat.addActionListener(e -> capNhatSach());
        btnXoa.addActionListener(e -> xoaSach());
        btnTim.addActionListener(e -> timKiemSach());
        btnHuyTim.addActionListener(e -> loadTable());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    tfMaSach.setText(tableModel.getValueAt(row, 0).toString());
                    tfTenSach.setText(tableModel.getValueAt(row, 1).toString());
                    tfTheLoai.setText(tableModel.getValueAt(row, 2).toString());
                    tfTacGia.setText(tableModel.getValueAt(row, 3).toString());
                    tfNamXB.setText(tableModel.getValueAt(row, 4).toString());
                    tfSoLuong.setText(tableModel.getValueAt(row, 5).toString());
                }
            }
        });
    }

    private void themSach() {
        String ma = tfMaSach.getText();
        if (getSachByMa(ma) != null) {
            JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại!");
            return;
        }
        danhSach.add(new Sach(
                ma,
                tfTenSach.getText(),
                tfTheLoai.getText(),
                tfTacGia.getText(),
                tfNamXB.getText(),
                Integer.parseInt(tfSoLuong.getText())
        ));
        loadTable();
    }

    private void capNhatSach() {
        String ma = tfMaSach.getText();
        Sach s = getSachByMa(ma);
        if (s != null) {
            s.setTen(tfTenSach.getText());
            s.setTheLoai(tfTheLoai.getText());
            s.setTacGia(tfTacGia.getText());
            s.setNamXB(tfNamXB.getText());
            s.setSoLuong(Integer.parseInt(tfSoLuong.getText()));
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sách để cập nhật!");
        }
    }

    private void xoaSach() {
        String ma = tfMaSach.getText();
        Sach s = getSachByMa(ma);
        if (s != null) {
            danhSach.remove(s);
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sách để xóa!");
        }
    }

    private void timKiemSach() {
        String ma = tfTimKiem.getText().trim();
        tableModel.setRowCount(0);
        for (Sach s : danhSach) {
            if (s.getMa().equalsIgnoreCase(ma)) {
                tableModel.addRow(new Object[]{
                        s.getMa(), s.getTen(), s.getTheLoai(),
                        s.getTacGia(), s.getNamXB(), s.getSoLuong()
                });
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Không tìm thấy sách!");
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        for (Sach s : danhSach) {
            tableModel.addRow(new Object[]{
                    s.getMa(), s.getTen(), s.getTheLoai(),
                    s.getTacGia(), s.getNamXB(), s.getSoLuong()
            });
        }
    }

    private Sach getSachByMa(String ma) {
        for (Sach s : danhSach) {
            if (s.getMa().equalsIgnoreCase(ma)) return s;
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QLSachView().setVisible(true));
    }
}

class Sach {
    private String ma, ten, theLoai, tacGia, namXB;
    private int soLuong;

    public Sach(String ma, String ten, String theLoai, String tacGia, String namXB, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.namXB = namXB;
        this.soLuong = soLuong;
    }

    public String getMa() { return ma; }
    public String getTen() { return ten; }
    public String getTheLoai() { return theLoai; }
    public String getTacGia() { return tacGia; }
    public String getNamXB() { return namXB; }
    public int getSoLuong() { return soLuong; }

    public void setTen(String ten) { this.ten = ten; }
    public void setTheLoai(String theLoai) { this.theLoai = theLoai; }
    public void setTacGia(String tacGia) { this.tacGia = tacGia; }
    public void setNamXB(String namXB) { this.namXB = namXB; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
}
