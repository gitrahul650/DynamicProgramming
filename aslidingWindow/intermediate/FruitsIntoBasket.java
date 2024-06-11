package aslidingWindow.intermediate;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    //Given an array of characters where each character represents a fruit tree,
    // you are given two baskets, and your goal is to put maximum number of fruits in
    // each basket.
//The only restriction is that each basket can have only one type of fruit.
//You can start with any tree, but once you have started you can’t skip a tree.
//You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
//Write a function to return the maximum number of fruits in both the baskets.
//Example 1:     Input: Fruit=['A', 'B', 'C', 'A', 'C']     Output: 3
//Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
//Example 2:     Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']     Output: 5
//Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.

    //Please try to solve by using brute force
    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'A', 'C'};
        int result = totalFruits(arr);
        System.out.println("Max Fruits: " + result);
    }

    public static int totalFruits(char[] fruits) {
        int maxFruits = 0;
        int left = 0;
        Map<Character, Integer> fruitCounts = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            char currentFruit = fruits[right];
            fruitCounts.put(currentFruit, fruitCounts.getOrDefault(currentFruit, 0) + 1);

            while (fruitCounts.size() > 2) {
                char leftFruit = fruits[left];
                fruitCounts.put(leftFruit, fruitCounts.get(leftFruit) - 1);
                if (fruitCounts.get(leftFruit) == 0) {
                    fruitCounts.remove(leftFruit);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    public static int totalFruits1(char[] fruits) {
        int maxFruits = 0;

        for (int i = 0; i < fruits.length; i++) {
            for (int j = i + 1; j < fruits.length; j++) {
                char fruit1 = fruits[i];
                char fruit2 = fruits[j];

                int fruitsInFirstBasket = 0;
                int fruitsInSecondBasket = 0;
                boolean firstBasketFilled = false;

                for (char fruit : fruits) {
                    if (fruit == fruit1 || fruit == fruit2) {
                        if (fruit == fruit1) {
                            fruitsInFirstBasket++;
                        } else if (fruit == fruit2) {
                            fruitsInSecondBasket++;
                        }
                    } else {
                        if (!firstBasketFilled) {
                            firstBasketFilled = true;
                        } else {
                            break;
                        }
                    }
                }

                int totalFruitsInBaskets = fruitsInFirstBasket + fruitsInSecondBasket;
                maxFruits = Math.max(maxFruits, totalFruitsInBaskets);
            }
        }

        return maxFruits;
    }







}
