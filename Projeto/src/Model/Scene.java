package Model;

import Repository.InvetoryDAO;

import java.sql.SQLException;
import java.util.List;
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

    public static void reset(){

    }

    public static void scene1(int idSave) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int idScene = 1;
        System.out.println("Digite start");
        String cmd = sc.nextLine();
        while(!cmd.equalsIgnoreCase("start")){
            System.out.println("Comando inválido.");
            cmd = sc.nextLine();
        }
        Commands.validacao(cmd,idScene,idSave);
        while (!cmd.equalsIgnoreCase("use porta")) {
            cmd = sc.nextLine();
            cmd=Commands.validacao(cmd,idScene,idSave);
            while (cmd.equalsIgnoreCase("use porta")&&!InvetoryDAO.findItemInventory(idSave,1)&&!InvetoryDAO.findItemInventory(idSave,2)){
                System.out.println("Pegue algum item.");
                cmd = sc.nextLine();
                cmd=Commands.validacao(cmd,idScene,idSave);
            }
        }

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
