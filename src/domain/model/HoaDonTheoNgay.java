package domain.model;

public class HoaDonTheoNgay extends HoaDon{
    private int soNgayThue;

    public HoaDonTheoNgay(int maHoaDon, String ngayHoaDon, String tenKhachHang, String maPhong, int donGia,
            int soNgayThue) {
        super(maHoaDon, ngayHoaDon, tenKhachHang, maPhong, donGia);
        this.soNgayThue = soNgayThue;
    }

    public int getSoNgayThue() {
        return soNgayThue;
    }

    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }

    @Override
    public double thanhTien() {
        double s = this.soNgayThue * this.donGia;

        if( this.soNgayThue > 7)
            s +=  (this.soNgayThue - 7 ) * this.donGia * 0.2 ;

        return s;
    }
    
}
