import Model.Commands;
import Model.Item;
import Model.Scene;
import Repository.ItemDAO;
import Repository.SceneDAO;

import javax.xml.transform.Source;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Commands.help();
        boolean straightOn = false;

        String cmd = sc.nextLine();
        String[] arrayCmd = cmd.split(" ");

        if (Commands.validacao(arrayCmd)&&arrayCmd[0].equalsIgnoreCase("start")){
            Commands.start();
            straightOn = true;
        }

        cmd = sc.nextLine();

//        if (){
//
//        }

    }
}
