import Model.Commands;
import Model.Item;
import Model.Save;
import Model.Scene;
import Repository.InvetoryDAO;
import Repository.ItemDAO;
import Repository.SaveDAO;
import Repository.SceneDAO;

import javax.xml.transform.Source;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Commands.help();

        String cmd = sc.nextLine();
        String[] arrayCmd = cmd.split(" ");

        Commands.validacao(arrayCmd);
//
//        System.out.println(SaveDAO.newGame());
//
//        Commands.validacao(arrayCmd);


//        if (Commands.validacao(arrayCmd)&&arrayCmd[0].equalsIgnoreCase("start")){
//            Commands.start();
//        }

//        cmd = sc.nextLine();

//        if (){
//
//        }

    }
}
