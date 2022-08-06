import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1 - Добавить товар в список покупок;");
            System.out.println("2 - Показать итоговый список покупок;");
            System.out.println("3 - Удалить товар из списка покупок;");
            System.out.println("4 - Найти товар в списке покупок по названию.");

            String command = scanner.nextLine();
            int commandInt = Integer.parseInt(command);

            switch (commandInt) {
                case 1:
                    System.out.println("Какую покупку хотите добавить? Введите название товара.");
                    String itemAdd = scanner.nextLine();
                    list.add(itemAdd);
                    System.out.println("Итого в списке покупок: " + list.size());
                    break;
                case 2:
                    System.out.println("Список покупок:");
                    for (String itemAdded : list) {
                        System.out.println((list.indexOf(itemAdded) + 1) + ". " + itemAdded);
                    }
                    break;
                case 3:
                    System.out.println("Список покупок:");
                    for (String item : list) {
                        System.out.println((list.indexOf(item) + 1) + ". " + item);
                    }
                    System.out.println("Какой товар хотите удалить? Введите номер или название.");
                    String itemDelete = scanner.nextLine();
                    try {
                        int itemDelInt = Integer.parseInt(itemDelete) - 1;
                        System.out.println("Покупка " + "'" + list.get(itemDelInt) + "'" + " удалена, список покупок:");
                        list.remove(itemDelInt);
                        for (String itemRemain : list) {
                            System.out.println((list.indexOf(itemRemain) + 1) + ". " + itemRemain);
                        }
                        continue;
                    } catch (NumberFormatException e) {
                        if (list.contains(itemDelete)) {
                            list.remove(itemDelete);
                            System.out.println("Покупка " + "'" + itemDelete + "'" + " удалена, список покупок:");
                            for (String itemRemain : list) {
                                System.out.println((list.indexOf(itemRemain) + 1) + ". " + itemRemain);
                            }
                        } else {
                            System.out.println("Товар не найден в списке покупок!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    String query = scanner.nextLine();
                    String queryLower = query.toLowerCase();
                    System.out.println("По Вашему запросу найдено: ");
                    for (int c = 0; c < list.size(); c++) {
                        String item = list.get(c);
                        String itemLower = item.toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println((c + 1) + ". " + item);
                        }
                    }
            }
        }
    }
}