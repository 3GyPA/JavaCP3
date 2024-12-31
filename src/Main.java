import java.util.Arrays;
import java.util.Comparator;

/**
 * Represents a piece of clothing with various properties.
 *
 * <p>This class encapsulates the details of a clothing item, including
 * its type, brand, price, size, and color. It provides methods for
 * accessing these details, comparing clothing objects, and formatting
 * them for display.</p>
 *
 * <p><strong>Note:</strong> This implementation assumes all input values
 * are valid and does not perform extensive validation.</p>
 */
class Clothing {
    private String type;
    private String brand;
    private double price;
    private String size;
    private String color;

    /**
     * Створює об'єкт Clothing із заданими властивостями.
     *
     * @param type тип одягу (наприклад, «Сорочка», «Штани»).
     * @param brand - бренд одягу.
     * @param price ціна одягу в доларах США.
     * @param size розмір одягу (наприклад, «M», «L»).
     * @param color колір одягу.
     * @throws NullPointerException, якщо будь-який з рядкових параметрів дорівнює нулю.
     * @throws IllegalArgumentException, якщо ціна від'ємна.
     */
    public Clothing(String type, String brand, double price, String size, String color) {
        if (type == null || brand == null || size == null || color == null) {
            throw new NullPointerException("Parameters cannot be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.size = size;
        this.color = color;
    }

    /**
     * Повертає тип одягу.
     */
    public String getType() {
        return type;
    }

    /**
     * Повертає бренд одягу.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Повертає ціну одежі.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає розміри одягу.
     */
    public String getSize() {
        return size;
    }

    /**
     * Повертає колір одягу.
     */
    public String getColor() {
        return color;
    }

    /**
     * Порівнює цей об'єкт одягу із заданим об'єктом.
     *
     <p>Два об'єкти одягу вважаються рівними, якщо всі їхні властивості
     * ( type, brand, price, size, and color ) є однаковими.</p>
     *
     * @param obj об'єкт для порівняння.
     * @return true, якщо об'єкти рівні; false у протилежному випадку.
     */
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

    /**
     * Повертає рядкове представлення об'єкту одягу.
     *
     * @return відформатований рядок, що описує одяг.
     */
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
 * Демонструє використання класу Clothing та операції над масивами об'єктів Clothing.
 *
 * <p>Цей клас містить головний метод, який створює масив об'єктів класу Clothing,
 * сортує масив за певними критеріями та здійснює пошук певного об'єкту в масиві.</p>
 *
 * <p>Sorting criteria:</p>
 * <ul>
 * <li>Price (ascending).</li>
 * <li>Brand (descending).</li>
 * </ul>
 *
 * <p><strong>Note:</strong> Метод main також обробляє потенційні винятки під час виконання.</p>
 */
public class Main {

    public static void main(String[] args) {
        try {
            Clothing[] clothingArray = {
                    new Clothing("Shirt", "Nike", 49.99, "M", "Blue"),
                    new Clothing("Pants", "Adidas", 79.99, "L", "Black"),
                    new Clothing("Jacket", "Puma", 120.0, "XL", "Green"),
                    new Clothing("T-shirt", "Reebok", 29.99, "S", "White"),
                    new Clothing("Shoes", "Nike", 99.99, "42", "Red")
            };

            System.out.println("Original array:");
            printArray(clothingArray);

            Arrays.sort(clothingArray, Comparator
                    .comparingDouble(Clothing::getPrice)
                    .thenComparing(Comparator.comparing(Clothing::getBrand).reversed()));

            System.out.println("\nSorted array (price ascending, brand descending):");
            printArray(clothingArray);

            Clothing target = new Clothing("Pants", "Adidas", 79.99, "L", "Black");
            int index = findClothing(clothingArray, target);

            if (index != -1) {
                System.out.println("\nFound matching clothing: " + clothingArray[index]);
            } else {
                System.out.println("\nNo matching clothing found.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static void printArray(Clothing[] array) {
        for (Clothing clothing : array) {
            System.out.println(clothing);
        }
    }

    private static int findClothing(Clothing[] array, Clothing target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
