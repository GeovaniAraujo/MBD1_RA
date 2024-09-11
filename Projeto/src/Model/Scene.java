package Model;

import java.util.List;

public class Scene {
    private Integer idScene;
    private String titleScene;
    private String dcScene;

    public Integer getIdScne() {
        return idScene;
    }

    public void setIdScne(Integer idScne) {
        this.idScene = idScne;
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
