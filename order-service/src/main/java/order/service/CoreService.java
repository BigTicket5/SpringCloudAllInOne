package order.service;

import order.entity.Order;
import order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreService {

    @Autowired
    private OrderMapper orderMapper;

    public boolean createNewOrder(Order order) throws Exception{
        String id = orderMapper.createOrder(order);
        return id.isEmpty();
    }
}
