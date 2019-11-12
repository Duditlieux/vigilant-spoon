/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tduditli
 */
public class CodeEntity {

    private String m_discount_code;
    private float m_rate;

    public CodeEntity(String discount_code, float rate) {
        m_discount_code = discount_code;
        m_rate = rate;
    }

    public String getDiscount_code() {
        return m_discount_code;
    }

    public void setDiscount_code(String discount_code) {
        m_discount_code = discount_code;
    }

    public float getRate() {
        return m_rate;
    }

    public void setRate(float rate) {
        m_rate = rate;
    }
}
