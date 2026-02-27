package lld.orderunknown.factory;

import lld.orderunknown.models.*;
import lld.orderunknown.strategy.PaymentStrategy;

import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}