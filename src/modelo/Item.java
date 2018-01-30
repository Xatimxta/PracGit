/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author RenzoHypeBeast
 */
public class Item {
    
    private String name;
    private double price;
    private double saleprice;
    private String type;
    private String style;

    public Item(String name, double price, double saleprice, String type, String style) {
        this.name = name;
        this.price = price;
        this.saleprice = saleprice;
        this.type = type;
        this.style = style;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item() {
        
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", price=" + price + ", saleprice=" + saleprice + ", type=" + type + ", style=" + style + '}';
    }
    
    
}
