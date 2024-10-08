package Repository;

import Model.Scene;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SceneDAO {                                                         //SceneDAO(DataAccessObject ou Objeto de Acesso a Dados)
    public static Scene findSceneById(Integer id) throws SQLException {         //Método para achar a cena do sql pelo id
        Connection conn = MySql.getConnection();                                //Conexão com o mysql
        String sql = "SELECT * FROM scene WHERE id_scene = ?";                   //Commando do mysql("?" será substituído pelo id)
        PreparedStatement stmt = conn.prepareStatement(sql);                    //Método da classe Connection para preparar a pesquisa mysql
        stmt.setInt(1, id);                                        //Id setado
        ResultSet rs = stmt.executeQuery();                                     //ResultSet é um hash map que vai receber informações de coluna e valor
                                                                                //.executeQuery, método para executar a pesquisa
        Scene scene = null;

        if (rs.next()){                                                         //.next é um método de ResultSet para "contar" as linhas que retornaram da pesquisa feita no mysql(retorna true ou false)
            scene = new Scene(
            rs.getInt("id_scene"),                                   //.getInt método utilizado para pegar o inteiro da coluna "idScene"
            rs.getString("title_scene"),                                 //.getString pega uma String ao invés de um inteiro
            rs.getString("dc_scene"));
        }
        return scene;                                                           //Caso não entre na condição do if, retornará a cena nula.
    }
}
