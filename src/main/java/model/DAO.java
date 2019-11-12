/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author tduditli
 */
public class DAO {

    protected final DataSource myDataSource;

    public DAO(DataSource dataSource) {
        this.myDataSource = dataSource;
    }

    public int deleteDiscountCode(String code) throws Exception {
        String sql = "delete from disount_code where discount_code = ?";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, code);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("erreur").log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public int addDiscountCode(String code, float taux) throws Exception {
        String sql = "insert into discount_code values (?,?)";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, code);
            stmt.setFloat(2, taux);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("erreur").log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public CodeEntity getDiscount_Code(String discount_code) throws Exception {
        CodeEntity result = null;

        String sql = "select * from discount_code where discount_code = ?";
        try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, discount_code);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) { 
                    float taux = rs.getFloat("RATE");
                    result = new CodeEntity(discount_code, taux);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger("erreur").log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
        return result;
    }
}
