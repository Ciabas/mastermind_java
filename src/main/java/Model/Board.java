package Model;


public class Board {

    private Order playerOrder;
    private Order rightOrder;
    private Difficulty difficulty;
    private Countdown countdown;
    private Score score;
    private String username; 


    public Order getPlayerOrder() {
        return playerOrder;
    }

    public void setPlayerOrder(Order playerOrder) {
        this.playerOrder = playerOrder;
    }
    
    public String getUsername() {
        return username;
    }

    public Order getRightOrder() {
        return rightOrder;
    }

    public void setRightOrder(Order rightOrder) {
        this.rightOrder = rightOrder;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Countdown getCountdown() {
        return countdown;
    }

    public void setCountdown(Countdown countdown) {
        this.countdown = countdown;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Board(int columnSize, int difficultyInt, String username){
        this.playerOrder = new Order();
        this.rightOrder = new Order();
        this.difficulty = new Difficulty();
        this.countdown = new Countdown();
        this.score = new Score();
        this.username = username;
        setColumnSizeToAll(columnSize, difficultyInt);
    }

    private void setColumnSizeToAll(int columnSize, int difficultyInt){
        playerOrder.setColumnsNumber(columnSize);
        rightOrder.setColumnsNumber(columnSize);
        switch(difficultyInt){
            case 1: difficulty.easy(columnSize); break;
            case 2: difficulty.normal(columnSize); break;
            case 3: difficulty.hard(columnSize); break;
        }
    }
}
