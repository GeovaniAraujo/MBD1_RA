package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Save {
    private int idSave;
    private Scene scene;

    public Save(int idSave, Scene scene) {
        this.idSave = idSave;
        this.scene = scene;
    }

    public static int validacaoLoad(){
        Scanner sc = new Scanner(System.in);
        int[] saves = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Selecione um save (1,2,3,4,5,6,7,8,9,10).");
        int idSave = 0;
        boolean bool = false;

        do {
            try {
                idSave = sc.nextInt();
                for (int save : saves) {
                    if (idSave == save) {
                        bool = true;
                        break;
                    }
                }
                if (!bool){
                    System.out.println("Save inválido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Selecione um save (1,2,3,4,5,6,7,8,9,10).");
                sc.next();
            }
        }while(!bool);
        return idSave;
    }

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
