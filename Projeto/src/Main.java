import Model.Commands;
import Model.Save;
import Model.Scene;
import Repository.SaveDAO;

import java.sql.SQLException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String cmd;
        Commands.help();

        Save save = SaveDAO.load();

        int idScene = save.getScene().getIdScene();
        int idSave= save.getIdSave();

        Scene.scene1(idSave);

        idScene=Commands.nextScene(idScene);

        SaveDAO.saveGame(idSave,idScene);

        cmd = sc.nextLine();

        Commands.validacao(cmd,idScene,idSave);




    }
}