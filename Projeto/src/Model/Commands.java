package Model;

import Repository.InvetoryDAO;
import Repository.ItemDAO;
import Repository.SceneDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Commands {

    public static boolean correctCmd(String cmd, int cenaAtual) throws SQLException {
        ArrayList<String> cmdsCorretos = new ArrayList<>();
        boolean bool = false;
        for (int i = 0; i < ItemDAO.findItemByScene(cenaAtual).size(); i++) {
            if(i>0&&cmdsCorretos.size()==i){
                break;
            }
            cmdsCorretos.add(ItemDAO.findItemByNextScene(cenaAtual).get(i).getCorrectCmd());
            if (cmd.equalsIgnoreCase(cmdsCorretos.get(i))) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    public static int nextScene(int idScene) throws SQLException {
        idScene = idScene + 1;
        Scene scene1 = SceneDAO.findSceneById(idScene);
        System.out.println(scene1.getTitleScene());
        System.out.println(scene1.getDcScene());
        return idScene;
    }

    public static void get(int idItem, int idSave) throws SQLException {
        if (InvetoryDAO.addItem(idItem, idSave)) {//me pareceu gambiarra!
            System.out.println("Item adicionado ao inventário.");
            System.out.println(ItemDAO.findItemById(idItem).getPositiveResult());
        }
    }

    public static void start() throws SQLException {
        Scene scene1 = SceneDAO.findSceneById(1);
        System.out.println(scene1.getTitleScene());
        System.out.println(scene1.getDcScene());
    }

    public static void help() {
        System.out.println("Cmd help - Um text game é um tipo de jogo eletrônico onde a interação é realizada por meio de texto. O jogador lê descrições e responde com comandos escritos para avançar na narrativa. Os comandos são:");
        System.out.println("HELP – Apresentara um texto de ajuda com a ideia do textgame e seus comandos;");
        System.out.println("GET [item]– Pega o item da cena e adiciona ao seu inventário;");
        System.out.println("USE [item]-Se possível, utilizará o item do inventário;");
        System.out.println("USE [item] WITH [item]– Combinara dois itens gerando um novo.");
        System.out.println("INVENTORY – Mostra os itens no inventário;");
        System.out.println("SAVE – Salva o jogo;");
        System.out.println("*Itens interativos são marcados em CAIXA ALTA/CAPSLOCK.");
        System.out.println("*(+ITEM) item adicionado ao inventário.");
        System.out.println("*(-ITEM) item retirado do inventário.");
    }

    public static ArrayList<String> validacaoItemCena(int idScene) throws SQLException {
        ArrayList<String> nomes = new ArrayList<>();
        for (int i = 0; i < ItemDAO.findItemByScene(idScene).size(); i++) {
            nomes.add(ItemDAO.findItemByScene(idScene).get(i).getNameItem());
        }
        return nomes;
    }

    public static Integer validacaoItem(String[] arrayCmd) {
        String[] itensValidos = {"TACO", "MEIA", "CORDA", "CAMINHÃO", "PEDRA", "MANGUAL", "9MM", ".45", "DOSE"};
        String item = "";
        Integer items = null;
        for (int i = 0; i < arrayCmd.length; i++) {
            if (arrayCmd.length > 1 && i == 1 || i == 3) {
                for (int j = 0; j < itensValidos.length; j++) {
                    if (arrayCmd[i].equalsIgnoreCase(itensValidos[j])) {
                        item = itensValidos[j];
                        break;
                    } else {
                        item = "0";
                    }
                }
            }
        }

        if (item.equalsIgnoreCase("TACO")) {
            items = 1;
        } else if (item.equalsIgnoreCase("MEIA")) {
            items = 2;
        } else if (item.equalsIgnoreCase("CORDA")) {
            items = 4;
        } else if (item.equalsIgnoreCase("CAMINHÃO")) {
            items = 5;
        } else if (item.equalsIgnoreCase("PEDRA")) {
            items = 6;
        } else if (item.equalsIgnoreCase("MANGUAL")) {
            items = 7;
        } else if (item.equalsIgnoreCase("9MM")) {
            items = 8;
        } else if (item.equalsIgnoreCase(".45")) {
            items = 9;
        } else if (item.equalsIgnoreCase("DOSE")) {
            items = 10;
        } else if (item.equals("0")) {
            System.out.println("Item inválido");
        }
        return items;
    }

    public static String validacao(String cmd, int idScene, int idSave) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String[] cmdValido = {"get", "use", "help", "inventory", "save", "start"};
        String[] arrayCmd = cmd.split(" ");


        boolean bool = false;

        while (!bool) {
            if (!correctCmd(cmd, idScene)) {
                bool = true;
                for (int j = 0; j < cmdValido.length; j++) {
                    if (arrayCmd[0].equalsIgnoreCase(cmdValido[j])) {
                        cmd = cmdValido[j];
                        break;
                    } else {
                        cmd = "erro";
                    }
                }


                if (cmd.equalsIgnoreCase("start")) {
                    Commands.start();
                } else if (cmd.equalsIgnoreCase("help")) {
                    Commands.help();
                    bool = false;
                } else if (cmd.equalsIgnoreCase("inventory")) {
                    InvetoryDAO.searchInventoryInnerJoin(idSave);
                    bool = false;
                } else if (cmd.equalsIgnoreCase("get") && arrayCmd.length > 1) {
                    boolean bool2 = false;
                    for (int i = 0; i < validacaoItemCena(idScene).size(); i++) {
                        if (validacaoItemCena(idScene).get(i).equalsIgnoreCase(arrayCmd[1])) {
                            Commands.get(validacaoItem(arrayCmd),idSave);
                            bool2 = true;

                            break;
                        }
                    }
                    if (!bool2) {
                        System.out.println("Item inválido.");

                    }
                    bool = false;
                } else {
                    System.out.println("Não entendi...");
                    bool = false;
                }
                if (!bool) {
                    cmd = sc.nextLine();
                    arrayCmd = cmd.split(" ");
                }
            } else {
                bool = true;

            }
        }
        return cmd;
    }
}


