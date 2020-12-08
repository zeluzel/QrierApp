package pl.coderslab.qrierapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.qrierapp.entity.Courier;
import pl.coderslab.qrierapp.entity.Order;
import pl.coderslab.qrierapp.entity.OrderStatus;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.status <> pl.coderslab.qrierapp.entity.OrderStatus.FINISHED")
    List<Order> findActiveOrders();

    @Query("select o from Order o where o.courier = :courier " +
            "and o.status <> pl.coderslab.qrierapp.entity.OrderStatus.FINISHED")
    List<Order> findActiveOrdersForCourier(@Param("courier") Courier courier);

    @Query("select o from Order o where o.courier = :courier " +
            "and o.status = pl.coderslab.qrierapp.entity.OrderStatus.FINISHED")
    List<Order> findFinishedOrdersForCourier(Courier courier);

    List<Order> getOrdersByStatus(OrderStatus orderStatus);
}
