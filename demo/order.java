package com.learnspringboot.learnspring.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class order {
    @JsonProperty("c-name")
    private String customerName;
    @JsonProperty("p-name")
    private String productName;
    @JsonProperty("q")
    private int quantity;

    // public void setquantity(int quantity){
    //     this.quantity=quantity;
    // }
    // public int getquantity(){
    //     return this.quantity;
    // }
    @Override
    public String toString(){
        return "Order{\n" + "Customer Name: "+customerName+"\nProduct Name: "+productName+"\nQuantity: "+quantity+"\n}";
    }
}
