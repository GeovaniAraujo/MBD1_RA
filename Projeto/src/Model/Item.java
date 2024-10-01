package Model;

public class Item {
    private Integer idItem;
    private String nameItem;
    private String itemResult;
    private String correctCmd;
    private Scene idScene;
    private Integer idNextScene;

    public Item(Integer idItem, String nameItem, String itemResult, String correctCmd, Scene idScene, Integer idNextScene) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.itemResult = itemResult;
        this.correctCmd = correctCmd;
        this.idScene = idScene;
        this.idNextScene = idNextScene;
    }

    public Item(Integer idItem, String nameItem, String itemResult, String correctCmd, Integer idNextScene){
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.itemResult = itemResult;
        this.correctCmd = correctCmd;
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

    public String getResultItem() {
        return itemResult;
    }

    public void setResultItem(String resultItem) {
        this.itemResult= resultItem;
    }

    public String getCorrectCmd() {
        return correctCmd;
    }

    public void setCorrectCmd(String correctCmd) {
        this.correctCmd = correctCmd;
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
                ", resultItem='" + itemResult + '\'' +
                ", correctCmd='" + correctCmd + '\'' +
                ", idScene=" + idScene +
                ", idNextScene=" + idNextScene +
                '}';
    }
}
