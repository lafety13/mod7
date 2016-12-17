package task3;

import task1.Currency;
import task1.Order;
import task1.User;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    private static long userId = 0;
    private static long orderId = 0;

    public static void main(String[] args) {
        User user1 = new User(userId++, "Vadim", "Kozak", "Kiev", 10000);
        User user2 = new User(userId++, "Ivan", "Petrov", "Kiev", 50000);
        User user3 = new User(userId++, "Ivan", "Ivanov", "Kiev", 1000);
        User user4 = new User(userId++, "Anna", "tree", "Kiev", 300);
        User user5 = new User(userId++, "Igor", "Ivanov", "Kiev", 500);

        Order order1 = new Order(orderId++, 1000, Currency.USD, "Item", "qwerty", user1);
        Order order2 = new Order(orderId++, 1500, Currency.UAN, "Item", "qwerty", user2);
        Order order3 = new Order(orderId++, 1500, Currency.UAN, "Item", "qwerty", user3);
        Order order4 = new Order(orderId++, 1500, Currency.UAN, "Item", "qwerty", user4);
        Order order5 = new Order(orderId++, 1500, Currency.UAN, "Item", "qwerty", user4);
        Order order6 = new Order(orderId++, 1500, Currency.UAN, "Item", "qwerty", user4);

        Set<Order> treeSet = new TreeSet<>();

        treeSet.add(order1);
        treeSet.add(order2);
        treeSet.add(order3);
        treeSet.add(order4);
        treeSet.add(order5);
        treeSet.add(order6);

        // check if set contain Order where User’s lastName is - “Petrov”
        treeSet.stream()
                .filter(order -> order.getUser().getLastName().contains("Petrov"))
                .forEach(System.out::println);

        //print Order with largest price using only one set method - get
        System.out.println(treeSet.stream().max((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) return 1;
            if (o1.getPrice() == o2.getPrice()) return 0;
            return -1;
        }).get());

        // delete orders where currency is USD using Iterator
        Iterator<Order> iterator = treeSet.iterator();

        while (iterator.hasNext()){
            if (iterator.next().getCurrency() == Currency.USD) {
                iterator.remove();
            }
        }
        System.out.println();
        treeSet.forEach(System.out::println);

    }
}
