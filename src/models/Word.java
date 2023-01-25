package models;

public class Word {

    String data;

    public Word(String data){
        this.data = data;
    }

    public int letterCounter(){
        return data.length();
    }

    @Override
    public String toString() {
        return data;
    }
}
