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
