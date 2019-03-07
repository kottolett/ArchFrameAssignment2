package no.oslomet.oblig2_s315278.service;

import no.oslomet.oblig2_s315278.model.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> getAllOrders();
    Orders getOrder(Long id);
    void addOrder(Orders order);
    void deleteOrder(Long id);
}
