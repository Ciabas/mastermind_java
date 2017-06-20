package Model;


import java.awt.Color;
import java.security.SecureRandom;

public class Order {
    private int columnSize;
    private final Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.YELLOW, Color.PINK};
    private Color[] order;

    public int getColumnsNumber() {
        return columnSize;
    }

    public void setColumnsNumber(int columnsNumber) {
        this.columnSize = columnsNumber;
    }

    public Color[] getOrder() {
        return order;
    }

    public void setOrder(Color[] order) {
        this.order = order;
    }

    public Color[] getColors() {
        return colors;
    }

    public Order(){}

    public Order(int columnsNumber, Color[] order){
        this.columnSize = columnsNumber;
        this.order = order;
    }

    public Order(int columnsNumber){
        this.columnSize = columnsNumber;
        this.order = randomColorsNoReps(columnsNumber);
    }

    public Color[] randomColorsNoReps(int columnsNumber){
        Color[] colorNotUsed = this.colors.clone();
        Color[] colorRandomized = new Color[columnsNumber];
        int random ;
        SecureRandom rand;
        rand = new SecureRandom();
        for(int i = 0; i < columnsNumber; i++){
            do {
                random = rand.nextInt(colorNotUsed.length);
            } while (colorNotUsed[random] == null);
            System.out.println("Dodalem: " + colorNotUsed[random].toString());
            colorRandomized[i] = colorNotUsed[random];
            colorNotUsed[random] = null;
        }
        return colorRandomized;
    }

    public boolean compareWith(Color[] comparingOrder){
        for (int i = 0; i < order.length; i++){
            if (!order[i].equals(comparingOrder[i])){
                return false;
            }
        }
        return true;
    }

    public int checkColors(Order comparingOrder, Order rightOrder){
        int counter = 0;
        for (Color c : comparingOrder.getOrder()){
            for (Color r : rightOrder.getOrder()){
                if (r.equals(c))counter++;
            }
        }
        return counter;
    }

    public boolean[] checkSpots(Order comparingOrder, Order rightOrder){
        boolean[] result = new boolean[comparingOrder.getOrder().length];
        for (int i = 0; i < comparingOrder.getOrder().length; i++){
            result[i] = comparingOrder.getOrder()[i].equals(rightOrder.getOrder()[i]);
        }
        return result;
    }

    public boolean areColorsUnique(){
        for (int i = 0; i < order.length; i++){
            for (int j = i + 1; j < order.length; j++){
                if (order[i] == order[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
