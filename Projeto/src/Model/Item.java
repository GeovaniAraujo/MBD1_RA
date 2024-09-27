package Model;

public class Item {
    private Integer idItem;
    private String nameItem;
    private String positiveResult;
    private String negativeResult;
    private String correctCmd;
    private boolean got;
    private Scene idScene;
    private Integer idNextScene;

    public Item(Integer idItem, String nameItem, String positiveResult, String negativeResult, String correctCmd, boolean got, Scene idScene, Integer idNextScene) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.positiveResult = positiveResult;
        this.negativeResult = negativeResult;
        this.correctCmd = correctCmd;
        this.got = got;
        this.idScene = idScene;
        this.idNextScene = idNextScene;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getPositiveResult() {
        return positiveResult;
    }

    public void setPositiveResult(String positiveResult) {
        this.positiveResult = positiveResult;
    }

    public String getNegativeResult() {
        return negativeResult;
    }

    public void setNegativeResult(String negativeResult) {
        this.negativeResult = negativeResult;
    }

    public String getCorrectCmd() {
        return correctCmd;
    }

    public void setCorrectCmd(String correctCmd) {
        this.correctCmd = correctCmd;
    }

    public boolean isGot() {
        return got;
    }

    public void setGot(boolean got) {
        this.got = got;
    }

    public Scene getIdScene() {
        return idScene;
    }

    public void setIdScene(Scene idScene) {
        this.idScene = idScene;
    }

    public Integer getIdNextScene() {
        return idNextScene;
    }

    public void setIdNextScene(Integer idNextScene) {
        this.idNextScene = idNextScene;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", nameItem='" + nameItem + '\'' +
                ", positiveResult='" + positiveResult + '\'' +
                ", negativeResult='" + negativeResult + '\'' +
                ", correctCmd='" + correctCmd + '\'' +
                ", got=" + got +
                ", idScene=" + idScene +
                ", idNextScene=" + idNextScene +
                '}';
    }
}
