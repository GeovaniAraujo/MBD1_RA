package Model;

import java.util.Arrays;

public class Inventory {
    private Save save;
    private Item item;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "save=" + save +
                ", item=" + item +
                '}';
    }
}
