package pojo;

import java.util.List;

public class Orders {
    private List<Detail> orders;

    public List<Detail> getOrders() {
        return orders;
    }
    public void setOrders(List<Detail> orderDetailList) {
        this.orders = orderDetailList;
    }
}