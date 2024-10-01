package Repository;

import Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public static List<Item> findItemByScene(int id) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "SELECT * FROM item WHERE id_scene = ?";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Item item;
        List<Item> listItem = new ArrayList<>();

        while (rs.next()) {
            item = new Item(
            rs.getInt("id_item"),
            rs.getString("name_item"),
            rs.getString("item_result"),
            rs.getString("correct_cmd"),
            SceneDAO.findSceneById(id),
            rs.getInt("id_next_scene"));
            listItem.add(item);
        }
        return listItem;
    }

    public static Item findItemById(int id) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "SELECT * FROM item WHERE id_item = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Item item = null;

        if (rs.next()) {
            item = new Item(
            rs.getInt("id_item"),
            rs.getString("name_item"),
            rs.getString("item_result"),
            rs.getString("correct_cmd"),
            SceneDAO.findSceneById(id),
            rs.getInt("id_next_scene"));
        }

        return item;
    }

    public static List<Item> findItemByNextScene(int id) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "SELECT * FROM item WHERE id_next_scene = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id+1);
        ResultSet rs = stmt.executeQuery();

        Item item;
        List<Item> listItem = new ArrayList<>();

        while (rs.next()) {
            try {
                item = new Item(
                        rs.getInt("id_item"),
                        rs.getString("name_item"),
                        rs.getString("item_result"),
                        rs.getString("correct_cmd"),
                        SceneDAO.findSceneById(rs.getInt("id_scene")),
                        rs.getInt("id_next_scene"));
            } catch (Exception e){
                item = new Item(
                        rs.getInt("id_item"),
                        rs.getString("name_item"),
                        rs.getString("item_result"),
                        rs.getString("correct_cmd"),
                        rs.getInt("id_next_scene"));
            }
            listItem.add(item);
        }
        return listItem;
    }

    public static int selectNameItems(String cmd) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "SELECT id_item FROM item WHERE name_item like ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,"%"+cmd+"%");
        ResultSet rs = stmt.executeQuery();
        int item = 0;
        if(rs.next()){
            item = rs.getInt("id_item");
        }
        return item;
    }

    public static void updateTacoMeiaScene2() throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "UPDATE item SET item_result = 'Chris empunha o taco e parte pra cima de Perigo. Após muita luta, consegue nocautea-lo quebrando o taco em sua cabeça (-TACO). Agora ele tinha todos os US$300,00 que Perigo carregava (+DINHEIRO).' WHERE id_item = 1";
        String sql2 = "UPDATE item SET item_result = 'Chris enrola a meia na mão cai no soco com Perigo. Infelizmente ele ainda é mais fraco e perde a luta.' WHERE id_item = 2;";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(sql);
        PreparedStatement stmt2 = conn.prepareStatement(sql2);
        stmt.executeUpdate();
        stmt2.executeUpdate();
    }

    public static void updateTacoMeiaScene1() throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "UPDATE item SET item_result = 'Com taco de baseball em mãos, agora Chris era implacável.(+TACO)' WHERE id_item = 1";
        String sql2 = "UPDATE item SET item_result = 'Não sei o quão ameaçadoras eram as meias na década de 80 no Brooklyn, mas ok... Com certeza, elas ajudariam em sua vingança.(+MEIA)' WHERE id_item = 2";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(sql);
        PreparedStatement stmt2 = conn.prepareStatement(sql2);
        stmt.executeUpdate();
        stmt2.executeUpdate();
    }

    public static void updatePedra1() throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "UPDATE item SET item_result = 'Chris tenta jogar a pedra em Perigo, porém erra miseravelmente e leva um coro.' WHERE id_item = 6";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }

    public static void updatePedra2() throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "UPDATE item SET item_result = 'Chris, enfurecido, pega a maldita pedra. O que será que ele irá com ela?(+PEDRA)', id_scene = 3 WHERE id_item = 6";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }

    public static void update9MM1() throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "UPDATE item SET correct_cmd = 'USE 9MM', id_next_scene = 6 WHERE id_item = 8;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }

    public static void update9MM2() throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "update item set correct_cmd = 'GET 9MM', id_next_scene = 5 where id_item = 8;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }

    public static void mangual(int idSave) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "DELETE FROM inventory WHERE id_save = ? AND id_item_i = 2";
        String sql2 = "DELETE FROM inventory WHERE id_save = ? AND id_item_i = 6";
        String sql3 = "INSERT INTO inventory VALUES (?,7)";
        String sql4 = "UPDATE item SET id_scene = null WHERE id_item = 6";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idSave);
        PreparedStatement stmt2 = conn.prepareStatement(sql2);
        stmt2.setInt(1, idSave);
        PreparedStatement stmt3 = conn.prepareStatement(sql3);
        stmt3.setInt(1, idSave);
        PreparedStatement stmt4 = conn.prepareStatement(sql4);
        stmt.executeUpdate();
        stmt2.executeUpdate();
        stmt3.executeUpdate();
        stmt4.executeUpdate();
    }
}

