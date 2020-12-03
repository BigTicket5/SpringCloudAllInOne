package order.mapper;


import order.entity.Order;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper {

    @Insert({"insert into citi_order(prod_id, custm_id, status, crt_time) values(#{productId},#{customerId},#{status},#{createTime,jdbyType=TIMESTAMP})"})
    @Options(useGeneratedKeys = true, keyProperty = "orderId")
    String createOrder(Order order);

    @Select("select order_id,prod_id,custm_id,status,crt_time,finish_time from citi_order where order_id =#{orderId}")
    Order getOrderById(@Param("orderId") long orderId);
}
