import java.util.Arrays;
import java.util.Comparator;

/**
 * Клас для представлення інформації про одяг.
 */
class Clothing {
    private String type;
    private String brand;
    private double price;
    private String size;
    private String color;

    /**
     * Конструктор класу Clothing.
     *
     * @param type  Тип одягу (наприклад, сорочка, штани).
     * @param brand Бренд одягу.
     * @param price Ціна одягу.
     * @param size  Розмір одягу.
     * @param color Колір одягу.
     */
    public Clothing(String type, String brand, double price, String size, String color) {
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.size = size;
        this.color = color;
    }

    // Геттери для доступу до полів
    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    // Метод для порівняння двох об'єктів Clothing
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Clothing clothing = (Clothing) obj;
        return Double.compare(clothing.price, price) == 0 &&
                type.equals(clothing.type) &&
                brand.equals(clothing.brand) &&
                size.equals(clothing.size) &&
                color.equals(clothing.color);
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

/**
 * Клас Main для демонстрації роботи з масивом об'єктів класу Clothing.
 */
public class Main {

    public static void main(String[] args) {
        // Ініціалізація масиву об'єктів класу Clothing
        Clothing[] clothingArray = {
                new Clothing("Shirt", "Nike", 49.99, "M", "Blue"),
                new Clothing("Pants", "Adidas", 79.99, "L", "Black"),
                new Clothing("Jacket", "Puma", 120.0, "XL", "Green"),
                new Clothing("T-shirt", "Reebok", 29.99, "S", "White"),
                new Clothing("Shoes", "Nike", 99.99, "42", "Red")
        };

        // Виведення початкового масиву
        System.out.println("Original array:");
        printArray(clothingArray);

        // Сортування за ціною за зростанням, а за брендом за спаданням
        Arrays.sort(clothingArray, Comparator
                .comparingDouble(Clothing::getPrice) // Сортування за ціною
                .thenComparing(Comparator.comparing(Clothing::getBrand).reversed())); // Сортування за брендом

        System.out.println("\nSorted array (price ascending, brand descending):");
        printArray(clothingArray);

        // Заданий об'єкт для пошуку
        Clothing target = new Clothing("Pants", "Adidas", 79.99, "L", "Black");

        // Пошук об'єкта в масиві
        int index = findClothing(clothingArray, target);
        if (index != -1) {
            System.out.println("\nFound matching clothing: " + clothingArray[index]);
        } else {
            System.out.println("\nNo matching clothing found.");
        }
    }

    /**
     * Виведення масиву об'єктів Clothing.
     *
     * @param array Масив для виведення.
     */
    private static void printArray(Clothing[] array) {
        for (Clothing clothing : array) {
            System.out.println(clothing);
        }
    }

    /**
     * Пошук об'єкта Clothing у масиві.
     *
     * @param array Масив для пошуку.
     * @param target Заданий об'єкт для пошуку.
     * @return Індекс знайденого об'єкта або -1, якщо об'єкт не знайдено.
     */
    private static int findClothing(Clothing[] array, Clothing target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
