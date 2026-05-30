package pojo;

import java.util.List;

public class Orders {
	
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	private List<OrderDetail> orderDetail;


}
