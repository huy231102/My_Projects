/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Category;
import entity.Log;
import entity.Product;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trinh
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE172180";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category_HE172180";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLast() {
        String query = "select top 1 * from Product_HE172180\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE172180 where cateID = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Product getProductByID(String id) {
        String query = "select * from Product_HE172180 where id = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Product> getProductByName(String txt) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE172180 where [name] like ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+txt+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public int get1ProductByName(String txt) {
        String query = "select * from Product_HE172180 where [name] like ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+txt+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public Account login(String user, String pass) {
        String query = "select * from Account_HE172180 where [user] = ? and [pass] = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from Account_HE172180 where [user] = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void signup(String user, String pass) {
        String query = "insert into Account_HE172180 where values(?,?,0,0) ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public List<Product> getProductBySellID(int id) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE172180 where sell_ID = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void deleteProduct(String pid) {
        String query = "delete from Product_HE172180 where id = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void insertProduct(String name, String image, String price, String title, String description, String category, int sid) {
        String query = "insert Product_HE172180 (name,image,price,title,description,cateID,sell_ID) values (?,?,?,?,?,?,?) ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void editProduct(String name, String image, String price, String title, String description, String category, String id) {
        String query = "update Product_HE172180 set name=?, image=?, price=?, title=?, description=?, cateID=? where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, id);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void deleteProductBySellID(int id) {
        String query = "delete from Product_HE172180 where sell_ID = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account_HE172180";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void deleteAccount(String aid) {
        String query = "delete from Account_HE172180 where uID = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, aid);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public Account getAccountByID(String id) {
        String query = "select * from Account_HE172180 where uID = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void editAccount(String user, String pass, String isSell, String isAdmin, String id) {
        String query = "update Account_HE172180 set [user]=?, [pass]=?, [isSell]=?, [isAdmin]=? where [uID] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, isSell);
            ps.setString(4, isAdmin);
            ps.setString(5, id);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void deleteAllAccount() {
        String query = "delete from Account_HE172180";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void insertAccount(String user, String pass, String isSell, String isAdmin) {
        String query = "insert into Account_HE172180 ([user],[pass],[isSell],[isAdmin]) values (?,?,?,?) ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, isSell);
            ps.setString(4, isAdmin);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public List<Log> getAllLogByAccountId(String accountId) {
        List<Log> list = new ArrayList<>();
        String query = "select * from Log_HE172180 where accountId=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Log(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDate(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    public void deleteAllLogByAccountId(String accountId) {
        String query = "delete from Log_HE172180 where accountId=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountId);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void insertLog(String accountId, String productId, String amount, String address, String number, Date date) {
        String query = "insert into Log_HE172180 ([accountId],[productId],[amount],[address],[number],[date]) values (?,?,?,?,?,?) ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountId);
            ps.setString(2, productId);
            ps.setString(3, amount);
            ps.setString(4, address);
            ps.setString(5, number);
            ps.setDate(6, date);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void editLog(String accountId, String productId, String amount, String address, String number, Date date, String logId) {
        String query = "update Log_HE172180 set [accountId]=?, [productId]=?, [amount]=?, [address]=?, [number]=?, [date]=? where [logId] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, accountId);
            ps.setString(2, productId);
            ps.setString(3, amount);
            ps.setString(4, address);
            ps.setString(5, number);
            ps.setDate(6, date);
            ps.setString(7, logId);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void deleteLog(String logId) {
        String query = "delete from Log_HE172180 where logId = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, logId);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public Log getLogByID(String logId) {
        String query = "select * from Log_HE172180 where logId = ? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, logId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Log(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDate(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
    public List<Log> SearchLog(String sql, String txt, int size) {
        List<Log> d= new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            for(int i=1;i<=size;i++){
                ps.setString(i,txt);
            }
            rs = ps.executeQuery();
            while (rs.next()) {                
                d.add(new Log(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getDate(7)));
            }
        } catch (Exception e) {
            
        }
        return d;
    }
    
    public void changePass(int uID, String pass) {
        String query = "update Account_HE172180 set [pass]=? where [uID] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setInt(2, uID);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        List<Product> list = dao.getAllProduct();
//        List<Category> listC = dao.getAllCategory();
//
//        for (Category o : listC) {
//            System.out.println(o);
//        }
//    }

}
