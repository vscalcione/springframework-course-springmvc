package it.springframework.springmvc.enums;

public enum OrderStatus {
    NEW (1, "new"),
    ALLOCATED(2, "allocated"),
    SHIPPED(3, "shipped");

    private Integer id;
    private String orderState;

    OrderStatus(Integer id, String orderState) {
        this.id = id;
        this.orderState = orderState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
}

