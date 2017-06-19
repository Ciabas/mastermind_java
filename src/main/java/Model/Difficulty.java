package Model;


public class Difficulty {

    private int columnSize;
    private int time;
    private int attempts;

    public int getColumnsNumber() {
        return columnSize;
    }

    public int getTime() {
        return time;
    }

    public int getAttempts() {
        return attempts;
    }

    public Difficulty(){}

    public void easy(int columnNumber){
        this.columnSize = columnNumber;
        this.time = columnNumber*40;
        this.attempts = 8;
    }

    public void normal(int columnNumber){
        this.columnSize = columnNumber;
        this.time = columnNumber*30;
        this.attempts = 7;
    }

    public void hard(int columnNumber){
        this.columnSize = columnNumber;
        this.time = columnNumber*20;
        this.attempts = 6;
    }
}
