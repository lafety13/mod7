package task2;

import task1.Currency;
import task1.Order;
import task1.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    private static long userId = 0;
    private static long orderId = 0;

    public static void main(String[] args) {
        User user1 = new User(userId++, "Vadim", "Kozak", "Kiev", 10000);
        User user2 = new User(userId++, "Ivan", "Petriv", "Kiev", 50000);
        User user3 = new User(userId++, "Ivan", "Ivanov", "Kiev", 1000);
        User user4 = new User(userId++, "Anna", "tree", "a", 300);
        User user5 = new User(userId++, "Igor", "Ivanov", "Kiev", 500);

        Order order1 = new Order(orderId++, 1000, Currency.UAN, "b", "qwerty", user1);
        Order order2 = new Order(orderId++, 1500, Currency.UAN, "B", "qwerty", user2);
        Order order3 = new Order(orderId++, 500, Currency.USD, "A", "qwerty", user3);
        Order order4 = new Order(orderId++, 500, Currency.UAN, "a", "qwerty", user4);

        List<Order> listOrder = new ArrayList<>();
        listOrder.add(order1);
        listOrder.add(order3);
        listOrder.add(order4);
        listOrder.add(order2);

        //sort list by Order price in decrease order
        System.out.println("sort list by Order price in decrease order");
        listOrder.sort(Comparator.reverseOrder());
        listOrder.forEach(System.out::println);
        System.out.println();

        //sort list by Order price in increase order AND User city
        System.out.println("sort list by Order price in increase order AND User city");
        listOrder.sort(Comparator.comparing(Order::getPrice)
                .thenComparing((o1, o2) -> o1.getUser().getCity().compareTo(o2.getUser().getCity())));
        listOrder.forEach(System.out::println);
        System.out.println();

        //sort list by Order itemName AND ShopIdentificator AND User city
        System.out.println("sort list by Order itemName AND ShopIdentificator AND User city");
        listOrder.sort(Comparator.comparing(Order::getItemName)
                .thenComparing(Order::getShopIdentificator)
                .thenComparing((o1, o2) -> o1.getUser().getCity().compareTo(o2.getUser().getCity())));
        listOrder.forEach(System.out::println);
        System.out.println();

        //Дополнительное задание
        //group by price
        Map<Currency, List<Order>> groupByCurrency =
                listOrder.stream().collect(Collectors.groupingBy(Order::getCurrency));

        groupByCurrency.forEach((currency, orders) -> {
            System.out.println("Currency " + currency );
            orders.forEach(System.out::println);
        });
        System.out.println();

        //delete duplicates from the list
        listOrder.stream().distinct().forEach(System.out::println);
        System.out.println();

        //delete items where price less than 1500
        listOrder.removeIf(order -> order.getPrice() < 1500);
        listOrder.forEach(System.out::println);
        System.out.println();

        //separate list for as many lists as many unique cities are in User
        Map<String, List<Order>> groupByCity = listOrder.stream()
                .collect(Collectors.groupingBy(o -> o.getUser().getCity()));
        groupByCity.forEach((s, orders) -> {
            System.out.println("City " + s );
            orders.forEach(System.out::println);
        });



    }
}
