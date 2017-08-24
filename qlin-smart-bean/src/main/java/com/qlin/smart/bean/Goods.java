package com.qlin.smart.bean;

import java.util.Date;

public class Goods extends BaseBean {
    private String intnlCode;
    private String name;
    private String remark;
    private Date productDate;

    public String getIntnlCode() {
        return intnlCode;
    }

    public void setIntnlCode(String intnlCode) {
        this.intnlCode = intnlCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }
}
