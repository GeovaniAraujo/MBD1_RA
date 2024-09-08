import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] cmdValido = {"get","use","help","inventory","save","start"};
        String cmd = sc.nextLine();
        String[] arrayCmd = cmd.split(" ");//separa o comando recebido em strings

        boolean v = false;//validação


        if (arrayCmd.length<=2) {//se tiver apenas uma palavra
            for (String s : cmdValido) {
                if (arrayCmd[0].equalsIgnoreCase(s)) {//valida se o 1º comando esta ok
                    v = true;
                    break;
                }
             }
        } else if (arrayCmd.length==4){//se for = a 4
            if (arrayCmd[0].equalsIgnoreCase("use")){//se o 1º for use
                if (arrayCmd[2].equals("with")){//se a 3ª palavra do comando for = a "with"
                    v = true;
                }
            }
        }
        if (!v){
                    System.out.println("Comando inválido.");
        }
    }
}
