import java.sql.*;

public class DocGiaDAO {
    private Connection conn;

    public DocGiaDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thu_vien", "root", "matkhau");
    }

    public void themDocGia(DocGia dg) throws SQLException {
        String sql = "INSERT INTO docgia(maDocGia, hoTen, diaChi, soDienThoai) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dg.getMaDocGia());
        stmt.setString(2, dg.getHoTen());
        stmt.setString(3, dg.getDiaChi());
        stmt.setString(4, dg.getSoDienThoai());
        stmt.executeUpdate();
    }

    public void xoaDocGia(String maDocGia) throws SQLException {
        String sql = "DELETE FROM docgia WHERE maDocGia = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, maDocGia);
        stmt.executeUpdate();
    }

    public void capNhatDocGia(DocGia dg) throws SQLException {
        String sql = "UPDATE docgia SET hoTen=?, diaChi=?, soDienThoai=? WHERE maDocGia=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dg.getHoTen());
        stmt.setString(2, dg.getDiaChi());
        stmt.setString(3, dg.getSoDienThoai());
        stmt.setString(4, dg.getMaDocGia());
        stmt.executeUpdate();
    }
}


btnLuu.addActionListener(new addActionListener(){
    public void actionPerformed(ActionEvent e){
        try{
            String ma = txtMaDocGia.getText();
            String ten = txtHoTen.getText();
            String diaChi = txtDiaChi.getText();
            String sdt = txtSoDienThoai.getText();

            DocGia docGia = new DocGia(ma, ten, diaChi, sdt);
            DocGiaDao dao = new DocGiaDao();
            dao.themDocGia(docGia);
            
            JOptionPane.showMessageDialog(null, "thêm độc giả thành công!");
        }  catch( Exception ex) {
            JOptionPane.showMessageDialog(null, "lỗi: "+ ex.getMessage());
        }
    } 
});
