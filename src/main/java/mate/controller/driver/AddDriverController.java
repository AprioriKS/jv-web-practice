package mate.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.model.Car;
import mate.model.Driver;
import mate.model.Manufacturer;
import mate.service.CarService;
import mate.service.DriverService;
import mate.service.ManufacturerService;

@WebServlet(urlPatterns = "/add_driver")
public class AddDriverController extends HttpServlet{
        public static final Injector injector = Injector.getInstance("mate");
        private final DriverService driveService =
            (DriverService) injector.getInstance(DriverService.class);

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            req.getRequestDispatcher("/WEB-INF/views/driver/add.jsp").forward(req, resp);
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        Driver driver = new Driver();
        driver.setName(req.getParameter("driverName"));
        driver.setLicenseNumber(req.getParameter("licenseNumber"));
        driveService.create(driver);
        resp.sendRedirect(req.getContextPath() + "/all_drivers");
    }
}