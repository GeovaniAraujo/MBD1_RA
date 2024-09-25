package Repository;

import java.sql.*;

public class InvetoryDAO {
    public static boolean addItem(int idItem) throws SQLException {
        Connection conn = MySql.getConnection();

        String sql = "SELECT id_item_i FROM inventory WHERE id_item_i = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idItem);
        ResultSet rs = stmt.executeQuery();

        boolean bool = false;

        if (rs.next()) {
            System.out.println("Item já está no inventário.");
        } else {
            String sql2 = "INSERT INTO inventory VALUES (0,?)";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, idItem);
            stmt2.executeUpdate();
            bool = true;
        }

        return bool;
    }

    public static void searchInventory() throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "SELECT id_item_i FROM inventory";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        boolean bool = false;
        System.out.println("Itens do inventário:");
        while(rs.next()){
            System.out.println(ItemDAO.findItemById(rs.getInt("id_item_i")).getNameItem());
            bool = true;
        }
        if (!bool){
            System.out.println("Sem itens no inventário.");
        }
    }

    public static boolean findItemInventory(int idItem) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "SELECT id_item_i FROM inventory WHERE id_item_i = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idItem);
        ResultSet rs = stmt.executeQuery();

        boolean bool = false;
        if (rs.next()){
            bool = true;
        }
        return bool;
    }


}
