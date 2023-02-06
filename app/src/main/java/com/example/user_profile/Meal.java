package com.example.user_profile;

public class Meal {
    FoodItem Item1 = new FoodItem(0,28,22,"Steak - 4 oz");
    FoodItem Item2 =  new FoodItem(1,12,10,"Eggs large - 2");
    FoodItem Item3 = new FoodItem(6,17,1,"Greek Yogurt - 8 fl oz");
    FoodItem Item4 = new FoodItem(26,2,0,"Orange Juice - 8 fl oz");;

    int totalFatCalMeal;
    int totalCarbCalMeal;
    int totalProteinCalMeal;
    int totalCalMeal;
    Meal(){
         totalFatCalMeal = 0;
         totalCarbCalMeal = 0;
         totalProteinCalMeal = 0;
         totalCalMeal = 0;

    }
    int computeTotalFatCalMeal(){
        totalFatCalMeal = Item1.compute_fat_calories() + Item2.compute_fat_calories() + Item3.compute_fat_calories() + Item4.compute_fat_calories();
        return totalFatCalMeal;
    }

    int computeTotalCarbCalMeal(){
        totalCarbCalMeal = Item1.compute_fat_calories() + Item2.compute_carb_calories() + Item3.compute_carb_calories() + Item4.compute_carb_calories();
        return totalCarbCalMeal;
    }

    int computeTotalProteinCalMeal(){
        totalProteinCalMeal = Item1.compute_protein_calories() + Item2.compute_protein_calories() + Item3.compute_protein_calories() + Item4.compute_protein_calories();
        return totalProteinCalMeal;
    }

    int computeTotalCalories(){
        totalCalMeal = totalFatCalMeal + totalProteinCalMeal + totalCarbCalMeal;
        return totalCalMeal;
    }
}
