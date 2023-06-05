package dev.lpa;

import java.util.*;

public class Test {

    public static void main(String[] args) {


        List<Grocery> list = new ArrayList<>();

        list.add(new Grocery("Milk", 1.5));
        list.add(new Grocery("Cheese", 10.5));
        list.add(new Grocery("Milk", 0.5));
        list.add(new Grocery("Soda", 9.5));
        list.add(new Grocery("Milk Eco", 3.5));

        Collections.sort(list);
        for (Grocery grocery : list) {
            System.out.println(grocery);
        }

        ShoppingList<String> sList = new ShoppingList<>("String List");
        sList.addItem("PC");
        sList.addItem("Mouse");
        sList.addItem("Whiteboard");
        System.out.println(sList.addItem("Desk"));
        System.out.println(sList.addItem("Desk"));

        System.out.println(sList.getList());
        System.out.println(sList.getItem("PC"));
        System.out.println(sList.getItem("Mac"));

        List<String> stringList = sList.getList();
        Collections.sort(stringList);
        System.out.println(stringList);

        System.out.println("=====================");

        Grocery juice = new Grocery("Juice", 3.5);
        Grocery cheese = new Grocery("Cheese", 9.5);
        Grocery milk = new Grocery("Milk", 1.5);
        Grocery milk1 = new Grocery("Milk", 2.5);
        Grocery milk2 = new Grocery("Milk", 0.5);
        Grocery bread = new Grocery("Bread", 3.5);

        ShoppingList<Grocery> shoppingList = new ShoppingList<>("Ica List");
        shoppingList.addItem(juice);
        shoppingList.addItem(cheese);
        shoppingList.addItem(milk);
        shoppingList.addItem(milk1);
        shoppingList.addItem(milk2);
        System.out.println(shoppingList.addItem(bread));
        System.out.println(shoppingList.addItem(bread));

        System.out.println(shoppingList.getList());

        System.out.println(shoppingList.getItem(milk));
        System.out.println(shoppingList.getItem(new Grocery("Cheese", 19.95)));
        System.out.println(shoppingList.getItem(new Grocery("Milk", 1.5)));

        // Sorted list with the Comparable interface defined within the class Grocery
        List<Grocery> groceryList = shoppingList.getList();
        Collections.sort(groceryList);
        System.out.println(groceryList);


        // Trying out the Comparator interface with a specific order; Ascending order of Grocery name length
        Comparator<Grocery> groceryLengthComp = new GroceryNameLengthSorter();
        Collections.sort(groceryList, groceryLengthComp);
        for (Grocery grocery : groceryList) {
            System.out.println(grocery.getName());
        }

    }
}

class GroceryNameLengthSorter implements Comparator<Grocery> {

    @Override
    public int compare(Grocery item1, Grocery item2) {
        int item1Length = item1.getName().length();
        int item2Length = item2.getName().length();

        return Integer.compare(item1Length, item2Length);
    }
}

class ShoppingList<T>{

    private String companyName;
    private List<T> list;

    public ShoppingList(String companyName) {
        this.companyName = companyName;
        list = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<T> getList() {
        return list;
    }


    public boolean addItem(T item) {
        if (!list.contains(item)) {
            return list.add(item);
        }
        return false;
    }

    public boolean removeItem(T item) {
        if (list.contains(item)) {
            list.remove(item);
            return true;
        }
        return false;
    }

    private int findItem(T item) {
        if (list.contains(item)) {
            return list.indexOf(item);
        }
        return -1;
    }

    public T getItem(T item) {
        if (findItem(item) >= 0) {
            return list.get(findItem(item));
        }
        return null;
    }
}
