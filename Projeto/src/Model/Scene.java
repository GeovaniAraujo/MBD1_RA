package Model;

import Repository.InvetoryDAO;
import Repository.ItemDAO;
import Repository.SaveDAO;
import Repository.SceneDAO;


import java.sql.SQLException;
import java.util.Scanner;

public class Scene {
    private Integer idScene;
    private String titleScene;
    private String dcScene;


    public Scene(Integer idScene, String titleScene, String dcScene) {
        this.idScene = idScene;
        this.titleScene = titleScene;
        this.dcScene = dcScene;
    }
    static Scanner sc = new Scanner(System.in);


    public static void executionScene(int idScene, int idSave) throws SQLException {
        String cmd = "";

        while(idScene<=5) {
            if (idScene == 1) {
                cmd = scene1(idSave, idScene);
                idScene++;
            } else if (idScene == 2){
                cmd = scene2(idSave, idScene);
                idScene++;
            } else if (idScene == 3){
                cmd = scene3(idSave,idScene);
                idScene++;
            } else if (idScene==4){
                cmd = scene4(idSave,idScene);
                idScene++;
            } else if (idScene==5) {
                scene5(idSave,idScene);
                idScene++;
            } else {
                System.out.println("THE END");
                idScene = 1;
                InvetoryDAO.clearInventory(idSave);
            }
            if (cmd.equalsIgnoreCase("restart")){
                idScene=1;
                InvetoryDAO.clearInventory(idSave);
            } else if (cmd.equalsIgnoreCase("load")){
                Save save = SaveDAO.load();
                idScene=save.getScene().getIdScene();
                idSave=save.getIdSave();
            }
        }
    }

    public static void scene5(int idSave, int idScene) throws SQLException {
        Scene scene = SceneDAO.findSceneById(idScene);
        System.out.println(scene.getTitleScene());
        System.out.println(scene.getDcScene());

        ItemDAO.update9MM1();

        String cmd = sc.nextLine();
        Commands.validacao(cmd, idScene, idSave);

        System.out.println("Chris saca sua arma, aponta para Caruso, bala na agulha e dedo no gatilho quando... *BANG BANG BANG* Chris cai no chão. Para a sorte de Caruso um policial passava pela rua no exato momento. Moral da história: a vingança nunca é plena, mata a alma e a envenena.");
        System.out.println("THE END");
        SaveDAO.saveGame(idSave, 1);
        InvetoryDAO.clearInventory(idSave);
    }

    public static String scene4(int idSave, int idScene) throws SQLException {
        Scene scene = SceneDAO.findSceneById(idScene);
        System.out.println(scene.getTitleScene());
        System.out.println(scene.getDcScene());

        ItemDAO.update9MM2();

        String cmd = sc.nextLine();
        cmd = Commands.validacao(cmd, idScene, idSave);

        InvetoryDAO.addItem(8,idSave);
        InvetoryDAO.deleteItem(11,idSave);

        return cmd;
    }

    public static String scene3(int idSave, int idScene) throws SQLException {
        Scene scene = SceneDAO.findSceneById(idScene);
        System.out.println(scene.getTitleScene());
        System.out.println(scene.getDcScene());

        ItemDAO.updatePedra2();

        String cmd = sc.nextLine();
        cmd = Commands.validacao(cmd, idScene, idSave);

        while((cmd.equalsIgnoreCase("use taco")&&!InvetoryDAO.findItemInventory(idSave,1))
                ||(cmd.equalsIgnoreCase("use meia")&&!InvetoryDAO.findItemInventory(idSave,2))
                ||(cmd.equalsIgnoreCase("use pedra")&&!InvetoryDAO.findItemInventory(idSave,6))
                ||(cmd.equalsIgnoreCase("use mangual")&&!InvetoryDAO.findItemInventory(idSave,7))){
            System.out.println("Este item não está no inventário.");
            cmd = sc.nextLine();
            cmd = Commands.validacao(cmd, idScene, idSave);
        }

        while (!cmd.equalsIgnoreCase("restart")&&!cmd.equalsIgnoreCase("load")) {
            if (cmd.equalsIgnoreCase("use taco") && InvetoryDAO.findItemInventory(idSave, 1)) {
                System.out.println(ItemDAO.findItemById(1).getResultItem());
                InvetoryDAO.deleteItem(1,idSave);
                InvetoryDAO.addItem(11,idSave);
                break;
            } else if (cmd.equalsIgnoreCase("use meia") && InvetoryDAO.findItemInventory(idSave, 2)) {
                System.out.println(ItemDAO.findItemById(2).getResultItem());
                System.out.println("GAME OVER");
                cmd = "restart";
            } else if (cmd.equalsIgnoreCase("use mangual")&& InvetoryDAO.findItemInventory(idSave, 7)) {
                System.out.println(ItemDAO.findItemById(7).getResultItem());
                InvetoryDAO.deleteItem(7,idSave);
                InvetoryDAO.addItem(11,idSave);
                break;
            } else if (cmd.equalsIgnoreCase("use pedra") && InvetoryDAO.findItemInventory(idSave, 6)) {
                ItemDAO.updatePedra1();
                System.out.println(ItemDAO.findItemById(6).getResultItem());
                System.out.println("GAME OVER");
                cmd = "restart";
            }
        }

        return cmd;
    }

    public static String scene2(int idSave, int idScene) throws SQLException {
        Scene scene = SceneDAO.findSceneById(idScene);
        System.out.println(scene.getTitleScene());
        System.out.println(scene.getDcScene());

        String cmd = sc.nextLine();
        cmd = Commands.validacao(cmd, idScene, idSave);

        if (cmd.equalsIgnoreCase("get corda")){
            System.out.println(ItemDAO.findItemById(4).getResultItem());
            System.out.println("GAME OVER");
            cmd = "restart";
        }
        ItemDAO.updateTacoMeiaScene2();
        return cmd;
    }

    public static String scene1(int idSave, int idScene) throws SQLException {

        ItemDAO.updateTacoMeiaScene1();

        Scene scene = SceneDAO.findSceneById(idScene);
        System.out.println(scene.getTitleScene());
        System.out.println(scene.getDcScene());

        String cmd = sc.nextLine();
        cmd = Commands.validacao(cmd, idScene, idSave);
        while (cmd.equalsIgnoreCase("use porta") && !InvetoryDAO.findItemInventory(idSave, 1) && !InvetoryDAO.findItemInventory(idSave, 2)) {
            System.out.println("Pegue algum item.");
            cmd = sc.nextLine();
            cmd = Commands.validacao(cmd, idScene, idSave);
        }
        return cmd;
    }

    public Integer getIdScene() {
        return idScene;
    }

    public void setIdScene(Integer idScene) {
        this.idScene = idScene;
    }

    public String getTitleScene() {
        return titleScene;
    }

    public void setTitleScene(String titleScene) {
        this.titleScene = titleScene;
    }

    public String getDcScene() {
        return dcScene;
    }

    public void setDcScene(String dcScene) {
        this.dcScene = dcScene;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "idScne=" + idScene +
                ", titleScene='" + titleScene + '\'' +
                ", dcScene='" + dcScene + '\'' +
                '}';
    }
}
