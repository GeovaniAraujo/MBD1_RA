package Model;

import Repository.InvetoryDAO;
import Repository.ItemDAO;
import Repository.SaveDAO;

import javax.xml.transform.Source;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Commands {

    static Scanner sc = new Scanner(System.in);

    public static boolean correctCmd(String cmd, int idScene) throws SQLException {
        boolean bool = false;

        List<Item> nextSceneItems = ItemDAO.findItemByNextScene(idScene);

        for (int i = 0; i < nextSceneItems.size(); i++) {

            if (cmd.equalsIgnoreCase(nextSceneItems.get(i).getCorrectCmd())) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    public static boolean use(String[] cmd, int idScene, int idSave) throws SQLException {

        List<Item> items = ItemDAO.findItemByNextScene(idScene);
        List<Item> carregavel = new ArrayList<>();

        boolean bool = true;

        for(int i =0; i<items.size(); i++){
            if (items.get(i).getIdScene()!=null){
                carregavel.add(items.get(i));
            }
        }
        for (Item iten : carregavel) {
            if (cmd[1].equalsIgnoreCase(iten.getNameItem())&&!InvetoryDAO.findItemInventory(idSave, iten.getIdItem())){
                System.out.println("Item não está no inventário.");
                bool = false;
                break;
            }
        }

        return bool;
    }

    public static boolean useWith(String[] cmd, int idScene, int idSave) throws SQLException {
        boolean bool = false;
        if (idScene!=3){
            System.out.println("Tenta outra coisa.");
            return bool;
        }
        for(int i=0; i<cmd.length;i++) {
            if (i==1||i==3) {
                bool = InvetoryDAO.findItemInventory(idSave, ItemDAO.selectNameItems(cmd[i]));

                if (!bool){
                    System.out.println("Este item não esta no inventário.");
                    break;
                }
            }
        }
        return bool;
    }

    public static void get(int idItem, int idSave) throws SQLException {
        if (InvetoryDAO.addItem(idItem, idSave)) {//me pareceu gambiarra!
            System.out.println("Item adicionado ao inventário.");
            System.out.println(ItemDAO.findItemById(idItem).getResultItem());
        }
    }

    public static void help() {
        System.out.println("Cmd help - Um text game é um tipo de jogo eletrônico onde a interação é realizada por meio de texto. O jogador lê descrições e responde com comandos escritos para avançar na narrativa. Os comandos são:");
        System.out.println("HELP – Apresentara um texto de ajuda com a ideia do textgame e seus comandos;");
        System.out.println("GET [item] - Pega o item da cena e adiciona ao seu inventário;");
        System.out.println("USE [item] - Se possível, utilizará o item do inventário;");
        System.out.println("USE [item] WITH [item]– Combinara dois itens gerando um novo;");
        System.out.println("CHECK [item] - Vê uma descrição do item se o mesmo estiver no seu inventário;");
        System.out.println("INVENTORY - Mostra os itens no inventário;");
        System.out.println("RESTART - Reinicia seu jogo desde a cena 1, apagando os itens do inventário;");
        System.out.println("SAVE - Salva o jogo;");
        System.out.println("LOAD - Carrega um jogo.");
        System.out.println("*Itens interativos são marcados em CAIXA ALTA/CAPSLOCK.");
        System.out.println("*(+ITEM) item adicionado ao inventário.");
        System.out.println("*(-ITEM) item retirado do inventário.");
    }

    public static List<String> validacaoItemCena(int idScene) throws SQLException {
        List<String> nomes = new ArrayList<>();

        List<Item> sceneItems = ItemDAO.findItemByScene(idScene);

        for (int i = 0; i < sceneItems.size(); i++) {
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
        String[] cmdValido = {"get", "use", "help", "inventory", "save","check","restart","load"};
        String[] arrayCmd = cmd.split(" ");

        List<String> sceneItems = validacaoItemCena(idScene);

        boolean bool = false;

        while (!bool) {
            if (!correctCmd(cmd, idScene)&&!cmd.equalsIgnoreCase("restart")&&!cmd.equalsIgnoreCase("load")) {
                bool = true;
                for (int j = 0; j < cmdValido.length; j++) {
                    if (arrayCmd[0].equalsIgnoreCase(cmdValido[j])) {
                        cmd = cmdValido[j];
                        break;
                    } else {
                        cmd = "erro";
                    }
                }

                if (cmd.equalsIgnoreCase("help")) {
                    help();
                    bool = false;
                } else if (cmd.equalsIgnoreCase("inventory")) {
                    InvetoryDAO.searchInventory(idSave);
                    bool = false;
                } else if (cmd.equalsIgnoreCase("save")) {
                    SaveDAO.saveGame(idSave, idScene);
                    System.out.println("Jogo salvo.");
                    bool = false;
                } else if (cmd.equalsIgnoreCase("check") && arrayCmd.length > 1&&validacaoItem(arrayCmd)!=null) {
                    InvetoryDAO.checkItem(validacaoItem(arrayCmd), idSave);
                    bool = false;
                } else if (arrayCmd[0].equalsIgnoreCase("use")&&arrayCmd.length==4&&arrayCmd[2].equalsIgnoreCase("with")){
                    boolean bool2 = useWith(arrayCmd, idScene, idSave);
                    if (bool2){
                        System.out.println("Chris, utilizando todas as habilidades que aprendeu assistindo TV, dá uma de MacGyver e cria um MANGUAL caseiro, colocando a pedra dentro da meia.(+MANGUAL)");
                        sceneItems.remove("PEDRA");
                        ItemDAO.mangual(idSave);
                    }
                    bool = false;
                }else if (cmd.equalsIgnoreCase("get") && arrayCmd.length > 1) {
                    boolean bool2 = false;

                    for (int i = 0; i < sceneItems.size(); i++) {
                        if (sceneItems.get(i).equalsIgnoreCase(arrayCmd[1])) {
                            get(validacaoItem(arrayCmd),idSave);
                            bool2 = true;
                            break;
                        }
                    }
                    if (!bool2) {
                        System.out.println("Item inválido.");
                    }
                    bool = false;
                } else {
                    System.out.println("Tenta outra coisa.");
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


