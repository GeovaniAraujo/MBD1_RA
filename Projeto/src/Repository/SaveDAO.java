package Repository;

import Model.Save;

import java.sql.*;

public class SaveDAO {

    public static void saveGame(int idSave,int idScene) throws SQLException {
        Connection conn = MySql.getConnection();
        String sql = "UPDATE save SET id_scene = ? where id_save = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,idScene);
        stmt.setInt(2,idSave);
        stmt.executeUpdate();
    }

    public static Save load() throws SQLException {
        int idSave = Save.validacaoLoad();
        Connection conn = MySql.getConnection();
        String sql = "SELECT id_scene FROM save WHERE id_save = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idSave);
        ResultSet rs = stmt.executeQuery();

        Save save = null;
        if(rs.next()){
            save = new Save(
            idSave,
            SceneDAO.findSceneById(rs.getInt("id_scene")));
        }
        return save;
    }
}