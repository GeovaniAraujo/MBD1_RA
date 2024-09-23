package Model;

public class Save {
    private int idSave;
    private Scene scene;

    public int getIdSave() {
        return idSave;
    }

    public void setIdSave(int idSave) {
        this.idSave = idSave;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public String toString() {
        return "Save{" +
                "idSave=" + idSave +
                ", scene=" + scene +
                '}';
    }
}
