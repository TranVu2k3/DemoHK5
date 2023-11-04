package pesistence;

import java.util.List;
import domain.model.HoaDon;

public interface HoaDonDAO {
    void addHoaDon(HoaDon hoaDon);
    void editHoaDon(HoaDon hoaDon);
    void deleteHoaDon(int id);
    HoaDon getHoaDonById(int id);
    List<HoaDon> getAllHoaDon();
}
