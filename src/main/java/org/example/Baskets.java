package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Baskets implements Serializable {
    private static final long serialVersionUID = 1L;

    private String[] things;
    private int[] prices;
    private int[] quantities;

    public String[] getThings() {
        return things;
    }

    public int[] getPrices() {
        return prices;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public Baskets() {

    }

    public Baskets(String[] things, int[] prices) {
        this.things = things;
        this.prices = prices;
        this.quantities = new int[things.length];
    }

    public void addToCart(int productNum, int amount) {
        quantities[productNum] += amount;

    }

    public void printCart() {
        int totalPrice = 0;
        System.out.println("Список покупок:");
        for (int i = 0; i < things.length; i++) {
            if (quantities[i] > 0) {
                int currentPrice = prices[i] * quantities[i];
                totalPrice += currentPrice;
                System.out.printf("%15s%4d р/шт%4d шт%6d p%n", things[i], prices[i], quantities[i], currentPrice);

            }
        }
        System.out.printf("Итого: %dp", totalPrice);

    }

    public void saveTxt(File textFile) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(textFile)) {
            out.println(String.join("", things));
            out.println(String.join("", Arrays.toString(Arrays.stream(prices).mapToObj(String::valueOf).toArray(String[]::new))));
            out.println(String.join("", Arrays.toString(Arrays.stream(quantities).mapToObj(String::valueOf).toArray(String[]::new))));


        }

    }

    public static Baskets loadFromTxtFile(File textFile) {
        Baskets basket = new Baskets();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile))) {
            String goodsStr = bufferedReader.readLine();
            String pricesStr = bufferedReader.readLine();
            String quantitiesStr = bufferedReader.readLine();

            basket.things = goodsStr.split(" ");
            basket.prices = Arrays.stream(pricesStr.split(""))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
            basket.quantities = Arrays.stream(quantitiesStr.split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return basket;

    }

    public void saveBin(File file) {
        try (ObjectOutputStream ag = new ObjectOutputStream(new FileOutputStream(file))) {
            ag.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Baskets loadfromBinfile(File file) {
        Baskets basket = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            basket = (Baskets) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return basket;
    }

    public void saveJSON(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(this);
            writer.print(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Baskets loadfromJsonfile(File file) {
        Baskets basket = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);

            }
            Gson gson = new Gson();
            basket = gson.fromJson(builder.toString(), Baskets.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return basket;
    }

}
