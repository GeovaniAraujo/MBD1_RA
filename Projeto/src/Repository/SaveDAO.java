package Repository;

import Model.Save;
import Model.Scene;

import java.sql.*;

public class SaveDAO {

    public static Save saveGame(int idScene) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "UPDATE save SET id_scene = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idScene);
        ResultSet rs = stmt.executeQuery();
        Save save = new Save();
        save.setIdSave(4);
        save.setScene(SceneDAO.findSceneById(idScene));
        return save;
    }

    public static Save newGame() throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "INSERT INTO save(id_scene) VALUES (0)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        Save save = new Save();
        if(rs.next()){
            save.setIdSave(rs.getInt(1));
            save.setScene(SceneDAO.findSceneById(0));
        }
        return save;
    }
}
