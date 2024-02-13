package org.assessment.bean;

import org.beanio.annotation.Field;

public class Body {
    @Field(at = 20, length = 14)
    private String referenceNo;

    @Field(at = 40, length = 16)
    private String amount;

    public Body(String referenceNo, String amount) {
        this.referenceNo = referenceNo;
        this.amount = amount;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
