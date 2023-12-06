/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import dao.*;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author HUY
 */
public class Order {
    private List<Cart> carts= new ArrayList<>();
    DAO d= new DAO();
    
    public Order(){
        
    }
    
    public List<Cart> getCarts() {
        return carts;
    }
    
    private Cart getCartById(int id){
        try {
            for(Cart i: carts){
                if(i.getProductId()==id){
                    return i;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void addCart(Cart t){
        if(getCartById(t.getProductId())!=null){
            Cart m= getCartById(t.getProductId());
            m.setAmount(m.getAmount()+t.getAmount());
        }else
            carts.add(t);
    }
    
    public void addAmount(int id){
        if(getCartById(id)!=null){
            Cart m= getCartById(id);
            m.setAmount(m.getAmount()+1);
        }
    }
    
    public void subAmount(int id){
        if(getCartById(id)!=null){
            Cart m= getCartById(id);
            m.setAmount(m.getAmount()-1);
        }
    }
    
    public void removeCart(int id){
        if(getCartById(id)!=null){
            carts.remove(getCartById(id));
        }
    }
    
    public double getTotalMoney(){
        double t=0;
        for(Cart i: carts){
            Product a= d.getProductByID(i.getProductId()+"");
            t+=(i.getAmount()*a.getPrice());
        }
        return t;
    }
    
    public Order(String txt){
        try {
            if(txt!=null && txt.length()!=0){
                String[] s=txt.split("_");
                for(String i: s){
                    String[] n= i.split(":");
                    int id=Integer.parseInt(n[0]);
                    int amount=Integer.parseInt(n[1]);
                    Cart t= new Cart(0, id, amount);
                    addCart(t);
                }
            }
        } catch (NumberFormatException e) {
        }
    }
    
    public Cart setAccountId(int accountId){
        for(Cart i: carts){
            i.setAccountId(accountId);
        }
        return null;
    }
}
