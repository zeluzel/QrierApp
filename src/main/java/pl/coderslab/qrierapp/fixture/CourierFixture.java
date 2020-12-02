package pl.coderslab.qrierapp.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.qrierapp.entity.Courier;
import pl.coderslab.qrierapp.service.CourierService;

import java.util.List;

@Component
public class CourierFixture {

    private final CourierService courierService;

    private final List<Courier> couriers = List.of(
            new Courier(null, "Paweł", "Znamirowski", "Żelu", "123123", false, null),
            new Courier(null, "Judyta", "Zelisko", "Dżudi", "123312312", false, null),
            new Courier(null, "Krystian", "Jakubek", "Tajger", "123123", true, null),
            new Courier(null, "Michał", "Hejne", "Majkel", "654321", false, null),
            new Courier(null, "Maciek", "Pokorowski", "Maciek", "654321", false, null)
    );

    @Autowired
    public CourierFixture(CourierService courierService) {
        this.courierService = courierService;
    }

    public void loadIntoDb() {
        for (Courier courier : couriers) {
            courierService.save(courier);
        }
    }

}
