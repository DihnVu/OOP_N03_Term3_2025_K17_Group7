package LoginRegisterView;

import Controller.LibrarianRegisterController;
import dao.LibrarianDao;
import model.Librarian;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterLibrarianView extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField jtfusername;
    public JTextField jtfLibraianID;
    public JTextField jtfCardID;
    public JPasswordField jtfPassword;

    public RegisterLibrarianView() {
        this.init();
        this.setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 321, 402);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Register Librarian");

        ActionListener ac = new LibrarianRegisterController(this);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel jtfRegisterTitle = new JLabel("Register");
        jtfRegisterTitle.setFont(new Font("Gadugi", Font.BOLD, 20));
        jtfRegisterTitle.setBounds(107, 25, 84, 39);
        contentPane.add(jtfRegisterTitle);

        jtfusername = new JTextField();
        jtfusername.setBounds(152, 87, 145, 31);
        contentPane.add(jtfusername);
        jtfusername.setColumns(10);

        jtfLibraianID = new JTextField();
        jtfLibraianID.setBounds(152, 187, 145, 31);
        contentPane.add(jtfLibraianID);
        jtfLibraianID.setColumns(10);

        jtfCardID = new JTextField();
        jtfCardID.setBounds(152, 234, 145, 34);
        contentPane.add(jtfCardID);
        jtfCardID.setColumns(10);

        jtfPassword = new JPasswordField();
        jtfPassword.setBounds(152, 135, 145, 31);
        contentPane.add(jtfPassword);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSignUp.setBounds(20, 314, 89, 23);
        btnSignUp.addActionListener(ac);
        contentPane.add(btnSignUp);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 75, 132, 204);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\22_104877.png"));
        lblNewLabel_1.setBounds(10, 11, 112, 37);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblNewLabel_4 = new JLabel("CardID");
        lblNewLabel_4.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\finance_chart_business_id_management_icon_263075.png"));
        lblNewLabel_4.setBounds(10, 161, 112, 32);
        panel.add(lblNewLabel_4);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblNewLabel_3 = new JLabel("LibraianID");
        lblNewLabel_3.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\11_104884.png"));
        lblNewLabel_3.setBounds(10, 115, 112, 35);
        panel.add(lblNewLabel_3);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setIcon(new ImageIcon("D:\\Academic\\lap-trinh\\Project\\IdeaProject\\library_management_Project\\Image\\40_104848.png"));
        lblNewLabel_2.setBounds(10, 59, 112, 35);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnNewButton = new JButton("Back");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBounds(170, 315, 89, 23);
        btnNewButton.addActionListener(ac);
        contentPane.add(btnNewButton);

    }

    public void ThucHienDangKyLibrarian() {
        String username = jtfusername.getText();
        String password = new String(jtfPassword.getPassword());
        int librarianID;

        try {
            librarianID = Integer.parseInt(jtfLibraianID.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Libraian ID phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra các trường không được để trống
        if (username.isEmpty() || password.isEmpty() || jtfLibraianID.getText().isEmpty() || jtfCardID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Các trường thông tin không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra Librarian ID trước khi tiếp tục
        LibrarianDao librarianDao = new LibrarianDao();

        if (librarianDao.selectById(librarianID) != null) {
            JOptionPane.showMessageDialog(null, "librarianID đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Librarian condition = librarianDao.selectByIdMana(librarianID);

        if (condition == null || condition.getEmployeeCard().isEmpty()) {
            JOptionPane.showMessageDialog(null, "không tìm thấy librarianID hoặc employeeCard", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!condition.getEmployeeCard().equals(jtfCardID.getText())) {
            JOptionPane.showMessageDialog(null, "Mã thẻ không khớp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tạo đối tượng Librarian mới và thêm vào cơ sở dữ liệu
        Librarian librarian1 = new Librarian(username, password, librarianID);
        if (librarianDao.insert(librarian1)) {
            JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi đăng ký!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void ThucHienQuayLai() {
        this.dispose();
        new LoginLibrarianView();
    }
}
