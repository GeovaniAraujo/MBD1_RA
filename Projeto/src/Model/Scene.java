package Model;

import Repository.InvetoryDAO;
import Repository.ItemDAO;
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
        while(idScene<5) {
            if (idScene == 1) {
                Commands.start();
                cmd = Scene.scene1(idSave, idScene);
                idScene = Commands.nextScene(idScene);
            } else if (idScene == 2){

            }
        }
    }

    public static void scene2(int idSave, int idScene) throws SQLException {
        Scene scene1 = SceneDAO.findSceneById(idScene);
        System.out.println(scene1.getTitleScene());
        System.out.println(scene1.getDcScene());

        String cmd = sc.nextLine();
        cmd = Commands.validacao(cmd, idScene, idSave);
        while (!cmd.equalsIgnoreCase("use caminhão")||!cmd.equalsIgnoreCase("get corda")) {
            cmd = sc.nextLine();
            cmd=Commands.validacao(cmd,idScene,idSave);
        }
    }

    public static String scene1(int idSave, int idScene) throws SQLException {
        Scene scene = SceneDAO.findSceneById(idScene);
        System.out.println(scene.getTitleScene());
        System.out.println(scene.getDcScene());

        String cmd;
        cmd = sc.nextLine();
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

    public void setIdScene(Integer idScne) {
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
