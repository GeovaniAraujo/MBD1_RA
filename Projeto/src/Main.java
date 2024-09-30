import Model.Commands;
import Model.Save;
import Model.Scene;
import Repository.SaveDAO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String cmd;
        Commands.help();

        System.out.println();

        Save save = SaveDAO.load();

        Scene.executionScene(save.getScene().getIdScene(),save.getIdSave());

        cmd = sc.nextLine();






    }
}