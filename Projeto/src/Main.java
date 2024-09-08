import Model.Scene;
import Repository.SceneDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Scene scene1 = SceneDAO.findSceneById(0);
            System.out.println(scene1.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String[] cmdValido = {"get","use","help","inventory","save","start"};
        String cmd = sc.nextLine();
        String[] arrayCmd = cmd.split(" ");                   //separa o comando recebido em strings

        boolean validacao = false;                                  //validação

        if (arrayCmd.length<=2) {                                   //se o tamanho for menor/igual a 2
            for (String s : cmdValido) {
                if (arrayCmd[0].equalsIgnoreCase(s)) {              //valida se o 1º comando esta ok
                    validacao = true;                               //comando validado
                    break;
                }
             }
        } else if (arrayCmd.length==4){                             //se o tamanho for igual a 4
            if (arrayCmd[0].equalsIgnoreCase("use")){   //se o 1º for use
                if (arrayCmd[2].equals("with")){                   //se a 3ª palavra do comando for igual a "with"
                    validacao = true;
                }
            }
        }
        if (!validacao){
                    System.out.println("Comando inválido.");
        }
    }
}
