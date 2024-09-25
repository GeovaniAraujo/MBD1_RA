import Model.Commands;
import Repository.InvetoryDAO;

import java.sql.SQLException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Commands.help();

        int idScene = 0;

        String cmd = sc.nextLine();

        while(!cmd.equalsIgnoreCase("start")){
            System.out.println("Comando inválido.");
            cmd = sc.nextLine();
        }

        Commands.validacao(cmd,idScene);
        //Cena 0


        while (!cmd.equalsIgnoreCase("use porta")) { //se o comando que vir não for "use porta" ele n entra no djanho do while
            cmd = sc.nextLine();
            cmd=Commands.validacao(cmd,idScene);
            while (cmd.equalsIgnoreCase("use porta")&&!InvetoryDAO.findItemInventory(1)&&!InvetoryDAO.findItemInventory(2)){
                System.out.println("Pegue algum item.");
                cmd = sc.nextLine();
                cmd=Commands.validacao(cmd,idScene);
            }
        }
        idScene=Commands.nextScene(idScene);

        

        cmd = sc.nextLine();




        Commands.validacao(cmd,idScene);


//        Commands.getCorrectCmd(cenaAtual);

//
//        cmd = sc.nextLine();
//        while(!cmd.equalsIgnoreCase("use porta")){
//            System.out.println("Comando inválido.");
//            cmd = sc.nextLine();
//        }

//        while(arrayCmd[0].equalsIgnoreCase("inventory")||arrayCmd[0].equalsIgnoreCase("help")||arrayCmd[0].equalsIgnoreCase("save")){
//            Commands.validacao(arrayCmd,cenaAtual);
//            cmd = sc.nextLine();
//            arrayCmd = cmd.split(" ");
//        }


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

    }
}