package Repository;

import Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public static List<Item> findItemByScene(Integer id) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "SELECT * FROM item WHERE idScene = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Item item;
        List<Item> listItem = new ArrayList<>();

        while(rs.next()){
            item = new Item();
            item.setIdItem(rs.getInt("idItem"));
            item.setNameItem(rs.getString("nameItem"));
            item.setPositiveResult(rs.getString("positiveResult"));
            item.setNegativeResult(rs.getString("negativeResult"));
            item.setCorrectCmd(rs.getString("correctCommand"));
            item.setGot(rs.getBoolean("got"));
            item.setIdScene(SceneDAO.findSceneById(id));
            listItem.add(item);
        }
        return listItem;
    }

    public static void addItem(int id) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "INSERT INTO inventory VALUES (?,)";
        PreparedStatement stmt = conn.prepareStatement();
    }
}
