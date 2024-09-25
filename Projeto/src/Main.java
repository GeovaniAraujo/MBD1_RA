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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Commands.help();

        int cenaAtual = 0;

        String cmd = sc.nextLine();

        while(!cmd.equalsIgnoreCase("start")){
            System.out.println("Comando inválido.");
            cmd = sc.nextLine();
        }

        String[] arrayCmd = cmd.split(" ");
        Commands.validacao(arrayCmd,cenaAtual);
        //Cena 0

        cmd = sc.nextLine();
        arrayCmd = cmd.split(" ");

        while(arrayCmd[0].equalsIgnoreCase("inventory")||arrayCmd[0].equalsIgnoreCase("help")||arrayCmd[0].equalsIgnoreCase("save")){
            Commands.validacao(arrayCmd,cenaAtual);
            cmd = sc.nextLine();
            arrayCmd = cmd.split(" ");
        }

        Commands.validacao(arrayCmd,cenaAtual);




//        List<Item> listaItem = ItemDAO.findItemByScene(0);
//        for(int i=0; i<listaItem.size(); i++){
//            boolean  bool = false;
//            if (arrayCmd[0].equalsIgnoreCase("get")){
//                for(int j=0; j<listaItem.size(); j++) {
//                    if (arrayCmd[1].equalsIgnoreCase(listaItem.get(j).getNameItem())) {
//                        bool = true;
//                        break;
//                    }
//                }
//                if(!bool) {
//                    System.out.println("Tenta outra coisa");
//                    cmd = sc.nextLine();
//                    arrayCmd = cmd.split(" ");
//                }
//            } else {
//
//            }
//
//        }

        cmd = sc.nextLine();
        arrayCmd = cmd.split(" ");

        if (cmd.equalsIgnoreCase("use porta")){

        }


        Commands.validacao(arrayCmd,cenaAtual);


//        Commands.getCorrectCmd(cenaAtual);

//
//        cmd = sc.nextLine();
//        while(!cmd.equalsIgnoreCase("use porta")){
//            System.out.println("Comando inválido.");
//            cmd = sc.nextLine();
//        }




    }
}