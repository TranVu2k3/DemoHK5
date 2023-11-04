package domain.model;

public class HoaDonTheoGio extends HoaDon{
    private int soGioThue;

    public HoaDonTheoGio(int maHoaDon, String ngayHoaDon, String tenKhachHang, String maPhong, int donGia,
            int soGioThue) {
        super(maHoaDon, ngayHoaDon, tenKhachHang, maPhong, donGia);
        this.soGioThue = soGioThue;
    }

    public int getSoNgayThue() {
        return soGioThue;
    }

    public void setSoGioThue(int soGioThue) {
        this.soGioThue = soGioThue;
    }
  
    private int tinhSoGioThue(){
        int time = this.soGioThue;

        if(this.soGioThue > 24 && this.soGioThue < 30)
            time = 24;
        
        return time;
    }

    @Override
    public double thanhTien() {
        return tinhSoGioThue() * this.donGia;
    }
    
}
