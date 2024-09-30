package Repository;

import java.sql.*;

public class InvetoryDAO {
    public static boolean addItem(int idItem, int idSave) throws SQLException {
        Connection conn = MySql.getConnection();

        String sql = "SELECT id_item_i FROM inventory WHERE id_item_i = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idItem);
        ResultSet rs = stmt.executeQuery();

        boolean bool = false;

        if (rs.next()) {
            System.out.println("Item já está no inventário.");
        } else {
            String sql2 = "INSERT INTO inventory VALUES (?,?)";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1,idSave);
            stmt2.setInt(2, idItem);
            stmt2.executeUpdate();
            bool = true;
        }

        return bool;
    }

    public static void searchInventory(int idSave) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "SELECT name_item FROM item i\n" +
                "INNER JOIN inventory inv ON i.id_item = inv.id_item_i\n" +
                "WHERE id_save = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idSave);
        ResultSet rs = stmt.executeQuery();


        boolean bool = false;
        while(rs.next()){
            System.out.println(rs.getString("name_item"));
            bool = true;
        }
        if (!bool){
            System.out.println("Sem itens no inventário.");
        }
    }

    public static boolean findItemInventory(int idSave, int idItem) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "SELECT id_item_i FROM inventory WHERE id_save = ? and id_item_i = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idSave);
        stmt.setInt(2, idItem);
        ResultSet rs = stmt.executeQuery();

        return rs.next();
    }

    public static void checkItem(int idItem, int idSave) throws SQLException {
        Connection conn = MySql.getConnection();

        String sql = "SELECT id_item_i FROM inventory WHERE id_item_i = ? AND id_save = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idItem);
        stmt.setInt(2, idSave);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String sql2 = "SELECT dc_item FROM item i INNER JOIN inventory inv ON inv.id_item_i = i.id_item WHERE id_item_i = ?";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1,idItem);
            ResultSet rs2 = stmt2.executeQuery();
            rs2.next();
            System.out.println(rs2.getString("dc_item"));
        } else {
            System.out.println("Este item não está no inventário.");
        }
    }

    public static void clearInventory(int idSave) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "DELETE FROM inventory WHERE id_save = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,idSave);
        stmt.executeUpdate();
    }


}
