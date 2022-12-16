/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//define package
package model;

/**
 *
 * @author MADD
 */
//define class
public class Product
{
    //define variables
    private String id;
    private String name;
    private Double price;
    private Double discount;
    private Double total;

    //define method
    public String getId()
    {
        //define return method
        return id;
    }

    //define method
    public void setId(String id)
    {
        //define value
        this.id = id;
    }

    //define method
    public String getName()
    {
        //define return method
        return name;
    }

    //define method
    public void setName(String name)
    {
        //define value
        this.name = name;
    }

    //define method
    public Double getPrice()
    {
        //define return method
        return price;
    }

    //define method
    public void setPrice(Double price)
    {
        //define value
        this.price = price;
    }

    //define method
    public Double getDiscount()
    {
        //define return method
        return discount;
    }

    //define method
    public void setDiscount(Double discount)
    {
        //define value
        this.discount = discount;
    }

    //define method
    public Double getTotal()
    {
        //define return method
        return total;
    }

    //define method
    public void setTotal(Double total)
    {
        //define value
        this.total = total;
    }
}