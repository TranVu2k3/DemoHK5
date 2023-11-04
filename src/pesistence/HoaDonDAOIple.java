package pesistence;

import java.util.List;

import domain.model.HoaDon;

public class HoaDonDAOIple implements HoaDonDAO {
    private HoaDonGateway hoaDonGateway;

    public HoaDonDAOIple(HoaDonGateway hoaDonGateway) {
        this.hoaDonGateway = hoaDonGateway;
    }

    @Override
    public void addHoaDon(HoaDon hoaDon) {
        hoaDonGateway.addHoaDon(hoaDon);
    }

    @Override
    public void editHoaDon(HoaDon hoaDon) {
        hoaDonGateway.editHoaDon(hoaDon);
    }

    @Override
    public void deleteHoaDon(int id) {
        hoaDonGateway.deleteHoaDon(id);
    }

    @Override
    public HoaDon getHoaDonById(int id) {
        return hoaDonGateway.getHoaDonById(id);
    }

    @Override
    public List<HoaDon> getAllHoaDon() {
        return hoaDonGateway.getAllHoaDon();
    }
}
