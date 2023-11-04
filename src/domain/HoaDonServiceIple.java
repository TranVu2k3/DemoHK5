package domain;

import java.util.List;

import domain.model.HoaDon;
import pesistence.*;

public class HoaDonServiceIple implements HoaDonService {
    private HoaDonDAO hoaDonDAO;

    public HoaDonServiceIple() {
        // Initialize the StudentDAO (Data Access Layer)
        hoaDonDAO = new HoaDonDAOIple(new HoaDonJdbcGateway());
    }

    @Override
    public void addHoaDon(HoaDon hoaDon) {
        hoaDonDAO.addHoaDon(hoaDon);
    }

    @Override
    public void editHoaDon(HoaDon hoaDon) {
        hoaDonDAO.editHoaDon(hoaDon);
    }

    @Override
    public void deleteHoaDon(int id) {
        hoaDonDAO.deleteHoaDon(id);
    }

    @Override
    public HoaDon getHoaDonById(int id) {
        return hoaDonDAO.getHoaDonById(id);
    }

    @Override
    public List<HoaDon> getAllHoaDon() {
        return hoaDonDAO.getAllHoaDon();
    }
}
