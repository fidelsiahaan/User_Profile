package com.example.user_profile;

public class FoodItem {

    // data members
    int carbGrams;
    int proteinGrams;
    int fatGrams;
    String Name;
    FoodItem(){ // constructor
        carbGrams = 0;
        proteinGrams = 0;
        fatGrams = 0;
    }
    // methods compute fat calories, protein calories, carb calories for use in a meal
    // constructor 2 sets values
   FoodItem(int carbG, int proteinG, int fatG, String Name1){
        carbGrams = carbG;
        proteinGrams = proteinG;
        fatGrams = fatG;
        Name = Name1;
   }
    int compute_fat_calories(){
        int return_val = 9 * fatGrams;
        return return_val;

    }
    int compute_carb_calories(){
        int return_val = 4 * carbGrams;
        return return_val;

    }
    int compute_protein_calories(){
        int return_val = 4 * proteinGrams;
        return return_val;

    }
} // end class definition
