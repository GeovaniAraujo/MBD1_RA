package Model;

import Repository.InvetoryDAO;
import Repository.SceneDAO;

import java.sql.SQLException;

public class Commands {

    public static void nextScene(int idScene) throws SQLException {
        Scene newScene = SceneDAO.findSceneById(idScene);
        System.out.println(newScene.getTitleScene());
        System.out.println(newScene.getDcScene());
    }

    public static void get(int idItem) throws SQLException {
        InvetoryDAO.addItem(idItem);
        System.out.println("Item adicionado ao inventário.");
    }

    public static void use(int idItem){

    }

    public static void start() throws SQLException {
        Scene scene1 = SceneDAO.findSceneById(0);
        System.out.println(scene1.getTitleScene());
        System.out.println(scene1.getDcScene());
    }

    public static void help(){
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

    public static void saveGame(){

    }


    public static void validacao(String[] arrayCmd) throws SQLException {
        String[] cmdValido = {"get", "use", "help", "inventory", "save", "start"};
        String cmd = null;
        for (int i = 0; i < arrayCmd.length; i++) {
            for (int j = 0; j < cmdValido.length; j++) {
                if (arrayCmd[i].equalsIgnoreCase(cmdValido[j])) {
                    cmd = cmdValido[j];
                    break;
                }
            }
        }

        String[] itensValidos = {"TACO","MEIA","CORDA","CAMINHÃO","PEDRA","MANGUAL","9MM",".45","DOSE"};
        String item = "";
        Integer items = null;
        for (int i = 0; i < arrayCmd.length; i++) {
            if(arrayCmd.length>1&&i==1||i==3){
                for (int j = 0; j < itensValidos.length; j++) {
                    if (arrayCmd[i].equalsIgnoreCase(itensValidos[j])) {
                        item = itensValidos[j];
                        break;
                    }else{
                        item = "0";
                    }
                }
            }
        }

        if(item.equalsIgnoreCase("TACO")){
            items=1;
        } else if (item.equalsIgnoreCase("MEIA")){
            items=2;
        }else if (item.equalsIgnoreCase("CORDA")){
            items=4;
        }else if (item.equalsIgnoreCase("CAMINHÃO")){
            items=5;
        }else if (item.equalsIgnoreCase("PEDRA")){
            items=6;
        }else if (item.equalsIgnoreCase("MANGUAL")){
            items=7;
        }else if (item.equalsIgnoreCase("9MM")){
            items=8;
        }else if (item.equalsIgnoreCase(".45")){
            items=9;
        }else if (item.equalsIgnoreCase("DOSE")){
            items=10;
        } else if(item.equals("0")){
            System.out.println("Item inválido");
        }

        if (cmd=="start"){
            Commands.start();
        } else if(cmd=="help"){
            Commands.help();
        } else if (cmd=="inventory") {
            InvetoryDAO.searchInventory();
        } else if(cmd=="get"){
            Commands.get(items);
        } else if (cmd=="use") {

        } else {
            System.out.println("Não entendi");
        }
    }
}

//    public static Boolean validacao(String[] arrayCmd){
//        String[] cmdValido = {"get","use","help","inventory","save","start"};
//        boolean validacao = false;                                  //validação
//        if (arrayCmd.length==1) {                                   //se for um comando start,help,inventory,save
//            for (String s : cmdValido) {
//                if (arrayCmd[0].equalsIgnoreCase(s)){              //valida se o 1º comando esta ok
//                    validacao = true;                               //comando validado
//                    break;
//                }
//            }
//        }else if (arrayCmd.length==2){
//            for (String s : cmdValido) {
//                if (arrayCmd[0].equalsIgnoreCase(cmdValido[0]) || arrayCmd[0].equalsIgnoreCase(cmdValido[1])) {              //valida se o 1º comando esta ok
//                    validacao = true;                               //comando validado
//                    break;
//                }
//            }
//        } else if (arrayCmd.length==4){                             //se o tamanho for igual a 4
//            if (arrayCmd[0].equalsIgnoreCase("use")){   //se o 1º for use
//                if (arrayCmd[2].equals("with")){                   //se a 3ª palavra do comando for igual a "with"
//                    validacao = true;
//                }
//            }
//        }
//        if (!validacao){
//            System.out.println("Comando inválido.");
//        }
//        return validacao;
//    }

//    public static void  validacao2(String[] arrayCmd){
//        String[] cmdValido = {"get","use","help","inventory","save","start"};
//        if (arrayCmd[0].equalsIgnoreCase("get")){
//
//        } else if(arrayCmd[0].equalsIgnoreCase("use")){
//
//        }
//    }

