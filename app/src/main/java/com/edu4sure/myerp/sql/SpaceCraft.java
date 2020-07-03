package com.edu4sure.myerp.sql;

public class SpaceCraft
{
    private String order_id, customer_id, order_date, status, comments, shipped_date, shipper_id;
    public String getOrderId()
    {
        return order_id;
    }
    public void setOrder_id(String order_id)
    {
        this.order_id = order_id;
    }
    public String getCustomer_id()
    {
        return customer_id;
    }
    public void setCustomer_id(String customer_id)
    {
        this.customer_id = customer_id;
    }
    public String getOrder_date()
    {
        return order_date;
    }
    public void setOrder_date(String order_date)
    {
        this.order_date = order_date;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status =  status;
    }
}
