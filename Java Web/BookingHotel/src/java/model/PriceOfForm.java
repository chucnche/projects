/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class PriceOfForm {
    private String pid;
    private KindOfRoom kindor;
    private FormOfRent formor;
    private int price;

    public PriceOfForm() {
    }

    public PriceOfForm(String pid, KindOfRoom kindor, FormOfRent formor, int price) {
        this.pid = pid;
        this.kindor = kindor;
        this.formor = formor;
        this.price = price;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public KindOfRoom getKindor() {
        return kindor;
    }

    public void setKindor(KindOfRoom kindor) {
        this.kindor = kindor;
    }

    public FormOfRent getFormor() {
        return formor;
    }

    public void setFormor(FormOfRent formor) {
        this.formor = formor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
