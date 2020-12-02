package pl.coderslab.qrierapp.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoadFixtures {

    private final CourierFixture courierFixture;
    private final AddressFixture addressFixture;
    private final ClientFixture clientFixture;
    private final OrderFixture orderFixture;

    @Autowired
    public LoadFixtures(CourierFixture courierFixture,
                        AddressFixture addressFixture,
                        ClientFixture clientFixture,
                        OrderFixture orderFixture) {
        this.courierFixture = courierFixture;
        this.addressFixture = addressFixture;
        this.clientFixture = clientFixture;
        this.orderFixture = orderFixture;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        courierFixture.loadIntoDb();
        addressFixture.loadIntoDb();
        clientFixture.loadIntoDb();
        orderFixture.loadIntoDB();
    }

}
