package pl.coderslab.qrierapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.qrierapp.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.status <> pl.coderslab.qrierapp.entity.OrderStatus.FINISHED")
    List<Order> findActiveOrders();
}
