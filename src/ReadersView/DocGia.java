public class DocGia{
    private String maDocGia;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;

    public DocGia(String maDocGia, String hoTen, String diaChi, String soDienThoai){
        this.maDocGia = maDocGia;
        this.hoTen = hoTen;
        this.diaChi =diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getMaDocGia() {
        return maDocGia;
    }
    public void setMaDocGia(String maDocGia){
        this.maDocGia = maDocGia;
    }
    public String getHoTen (){return hoTen;}
    public void setHoTen(String hoTen){this.hoTen = hoTen;}
    public String getDiaChi(){return diaChi;}
    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }
    public String getSoDienThoai(){ return soDienThoai; }
    public void setSoDienThoai(String soDienThoai){
        this.soDienThoai = soDienThoai;
    }
}
