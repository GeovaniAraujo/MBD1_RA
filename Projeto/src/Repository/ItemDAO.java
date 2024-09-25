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
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Item item;
        List<Item> listItem = new ArrayList<>();

        while (rs.next()) {
            item = new Item();
            item.setIdItem(rs.getInt("id_item"));
            item.setNameItem(rs.getString("name_item"));
            item.setPositiveResult(rs.getString("positive_result"));
            item.setNegativeResult(rs.getString("negative_result"));
            item.setCorrectCmd(rs.getString("correct_cmd"));
            item.setGot(rs.getBoolean("got"));
            item.setIdScene(SceneDAO.findSceneById(id));
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

        Item item = new Item();

        if (rs.next()) {
            item.setIdItem(rs.getInt("id_item"));
            item.setNameItem(rs.getString("name_item"));
            item.setPositiveResult(rs.getString("positive_result"));
            item.setNegativeResult(rs.getString("negative_result"));
            item.setCorrectCmd(rs.getString("correct_cmd"));
            item.setGot(rs.getBoolean("got"));
            item.setIdScene(SceneDAO.findSceneById(id));
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
            item = new Item();
            item.setIdItem(rs.getInt("id_item"));
            item.setNameItem(rs.getString("name_item"));
            item.setPositiveResult(rs.getString("positive_result"));
            item.setNegativeResult(rs.getString("negative_result"));
            item.setCorrectCmd(rs.getString("correct_cmd"));
            item.setGot(rs.getBoolean("got"));
            item.setIdScene(SceneDAO.findSceneById(id));
            listItem.add(item);
        }
        return listItem;
    }
}

