package com.amaresh.examples.stg;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by apatta2 on 2/23/16.
 */
@Entity
@Table(name = "MY_TABLE_NAME")
public class OrderStg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_NO")
    private String orderNo;

    @Column(name = "CREATETS")
    private Date createTs;

    @Column(name = "MODIFYTS")
    private Date modifyTs;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public Date getModifyTs() {
        return modifyTs;
    }

    public void setModifyTs(Date modifyTs) {
        this.modifyTs = modifyTs;
    }
}
