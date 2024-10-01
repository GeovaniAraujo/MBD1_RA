import Model.Commands;
import Model.Save;
import Model.Scene;
import Repository.SaveDAO;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Commands.help();

        System.out.println();

        Save save = SaveDAO.load();

        Scene.executionScene(save.getScene().getIdScene(),save.getIdSave());
        
    }
}