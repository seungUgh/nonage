package nonageshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nonageshop.dao.CustomSQLException;
import nonageshop.dao.ProductDao;
import nonageshop.dto.Product;

public class ProductDaoImpl implements ProductDao {
	private static final ProductDaoImpl instance = new ProductDaoImpl();
	private Connection con;
	
	public void setCon(Connection con) {
		this.con = con;
	}

	public ProductDaoImpl() {
	}

	public static ProductDaoImpl getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Product> listNewProduct() {
		 String sql = "SELECT NO, NAME, SALEPRICE, IMAGE FROM NEW_PRO_VIEW";
	        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                ArrayList<Product> list = new ArrayList<>();
	                do {
	                    list.add(getNewBestProduct(rs));
	                } while (rs.next());
	                return list;
	            }
	        } catch (SQLException e) {
	            throw new CustomSQLException(e);
	        }
	        return null;
	    }

	    private Product getNewBestProduct(ResultSet rs) throws SQLException {
	        int no = rs.getInt("NO");
	        String name = rs.getString("NAME");
	        int salePrice = rs.getInt("SALEPRICE");
	        String image = rs.getString("IMAGE");
	        return new Product(no, name, salePrice, image);
	    }

	@Override
	public ArrayList<Product> listBestProduct() {
		String sql = "SELECT NO, name, saleprice, image FROM best_pro_view";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				ArrayList<Product> list = new ArrayList<Product>();
				do {
					list.add(getNewBestProduct(rs));
				}while(rs.next());
				return list;
			}
		}catch(SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}


	@Override
	public Product getProduct(int no) {
		String sql = "SELECT NO, NAME, KIND, PRICE, SALEPRICE, MARGIN, CONTENT, IMAGE, DEL_YN, BEST_YN, REG_DATE FROM PRODUCT WHERE NO =?";
		  try (PreparedStatement pstmt = con.prepareStatement(sql)){
	            pstmt.setInt(1, no);
	            try(ResultSet rs = pstmt.executeQuery()){
	                if (rs.next()) {
	                    return getProduct(rs);
	                }
	            }
	        } catch (SQLException e) {
	            throw new CustomSQLException(e);
	        }
	        return null;
	    }

	private Product getProduct(ResultSet rs) throws SQLException {
		Product product = getNewBestProduct(rs);
		product.setKind(rs.getString("KIND"));
		product.setPrice(rs.getInt("PRICE"));
		product.setMargin(rs.getInt("MARGIN"));
		product.setContent(rs.getString("CONTENT"));
		product.setDelYn(rs.getString("DEL_YN"));
		product.setBestYn(rs.getString("BEST_YN"));
		product.setRegDate(rs.getDate("REG_DATE"));
        return product;
    }

	@Override
	public ArrayList<Product> listKindProduct(String kind) {
	 String sql = "SELECT NO, NAME, KIND, PRICE, SALEPRICE, MARGIN, CONTENT, IMAGE, DEL_YN, BEST_YN, REG_DATE FROM PRODUCT WHERE KIND =?";
	 try (PreparedStatement pstmt = con.prepareStatement(sql)){
         pstmt.setString(1, kind);
         try(ResultSet rs = pstmt.executeQuery()){
        	   if (rs.next()) {
                   ArrayList<Product> list = new ArrayList<>();
                   do {
                       list.add(getProduct(rs));
                   } while (rs.next());
                   return list;
               }
           }
       } catch (SQLException e) {
           throw new CustomSQLException(e);
       }
       return null;
   }
}
