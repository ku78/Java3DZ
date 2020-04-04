package lesson1.z3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private float weightBox;
    private List<T> fruitList;

    private int count;
    public Box() {
        this.fruitList = new ArrayList<>();
    }
    public void add(T fruit){
        fruitList.add(fruit);
        count = count + 1;
        weightBox =  count * fruit.getWeightFruit();
    }
    public float getWeight(T fruit){
     return weightBox;
    }
    public boolean compare(Box box){
        if(box instanceof Box){
          if(box.weightBox == this.weightBox)  {
              System.out.println("Вес коробок одинаковый");
              return true;
          }//end if
          else {
              System.out.println("Коробки разные."+" Вес первой = "+this.weightBox+" Вес второй = "+box.weightBox);
              return false;}//end else
    }return false;//end if Box
}//end compare
    public void changesBox(Box<T> box){
        box.fruitList.addAll(this.fruitList);
        box.count = this.count;
        box.weightBox = this.weightBox;
        this.fruitList.clear();
        this.count = 0;
        this.weightBox = 0;

    }
    public void info() {
        System.out.println("Количество фруктов в коробке: " + count + " ед. Общий вес: " + weightBox + " кг.");
    }

}
