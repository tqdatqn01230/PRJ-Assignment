/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.cart;

/**
 *
 * @author Dell
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dattq.book.BookDTO;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class CartDTO {
    Map <String, BookDTO> cart;
    
    public CartDTO(Map <String,BookDTO>cart) {
        this.cart= cart;
    }

    public CartDTO() {
    }

    public Map<String, BookDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }
    public void addcart(BookDTO book){
        String ID=book.getBookID();
        boolean check=false;
        if (cart==null)  cart=new HashMap<String,BookDTO>();
        if (cart.containsKey(ID)){
            int quantity= cart.get(ID).getQuantity()+1;
            book.setQuantity(quantity);
        }
        cart.put(ID, book);
    }
    public void editCart(BookDTO book){
        String bookID=book.getBookID();
        cart.put(bookID, book);
    }
    public void delete(String bookID){
        if (cart==null) return;
        cart.remove(bookID);
    }
}