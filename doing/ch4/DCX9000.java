package ch4;


import javax.swing.text.Document;

interface PaperShredder {
    void shred(Document d);
    void shredAll (Document [] d);
}

abstract class DeluxeModel
        implements PaperShredder {
    public int count = 0;

    public int count() { return count;}
    public void shredAll (Document [] d) {
        for (int i = 0; i < d.length; i += 1) {
            shred (d[i]);
        }
    }

    public abstract void connectToWifi();
}

public class DCX9000 extends DeluxeModel {
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    @Override
    public void shred(Document d) {

    }

    @Override
    public void connectToWifi() {

    }
}