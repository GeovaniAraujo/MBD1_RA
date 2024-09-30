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
        String sql = "UPDATE item SET item_result = 'Com taco de baseball em mãos, agora Chris era implacável.' WHERE id_item = 1";
        String sql2 = "UPDATE item SET item_result = 'Não sei o quão ameaçadoras eram as meias na década de 80 no Brooklyn, mas ok... Com certeza, elas ajudariam em sua vingança.' WHERE id_item = 2";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(sql);
        PreparedStatement stmt2 = conn.prepareStatement(sql2);
        stmt.executeUpdate();
        stmt2.executeUpdate();
    }
}

