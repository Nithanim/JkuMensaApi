package me.nithanim.mensaapi;

import java.util.List;
import me.nithanim.mensaapi.util.Objects;

public class Menu {
    private final Type type;
    private final String subtype;
    private final List<Meal> meals;
    private final int price;
    private final int oehBonus;
    private final String date;
    private final boolean isVegetarian;
    
    public Menu(Type type, String subtype, List<Meal> meals, int price, int oehBonus, String date, boolean isVegetarian) {
        this.type = type;
        this.subtype = subtype;
        this.meals = meals;
        this.price = price;
        this.oehBonus = oehBonus;
        this.date = date;
        this.isVegetarian = isVegetarian;
    }

    /**
     * Gson and any other deserialization libraries may
     * use or need it to create a object.
     */
    private Menu() {
        this.type = null;
        this.subtype = null;
        this.meals = null;
        this.price = 0;
        this.oehBonus = 0;
        this.date = null;
        this.isVegetarian = false;
    }
    
    public Type getType() {
        return type;
    }

    /**
     * The subtype applies for Choice only for now and can conatin:
     * Grill/Snack/...
     * 
     * @return The subtype of the menu
     */
    public String getSubtype() {
        return subtype;
    }

    /**
     * Returns the meals in this menu.
     * For classic, it will contain the parts (soup, main, dessert).
     * For choice it will return the meals of every subtype.
     * 
     * @return 
     * @see #getSubtype()
     */
    public List<Meal> getMeals() {
        return meals;
    }
    
    /**
     * This gets the price of the complete menu for classic but will
     * be -1 for Choice, since there are individual meal prices only.
     * 
     * @return Price of the meal,
     * -1 if it has none on purpose or
     * -2 if not found or unable to parse
     * @see Meal
     */
    public int getPrice() {
        return price;
    }

    public int getOehBonus() {
        return oehBonus;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        sb.append(type).append('|');
        sb.append(subtype).append('|');
        sb.append('<');
        for(Meal meal : meals) {
            sb.append(meal).append('|');
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append('>').append('|');
        sb.append(price).append('|');
        sb.append(date).append('|');
        sb.append(isVegetarian);
        sb.append('>');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 97 * hash + (this.subtype != null ? this.subtype.hashCode() : 0);
        hash = 97 * hash + (this.meals != null ? this.meals.hashCode() : 0);
        hash = 97 * hash + this.price;
        hash = 97 * hash + this.oehBonus;
        hash = 97 * hash + (this.date != null ? this.date.hashCode() : 0);
        hash = 97 * hash + (this.isVegetarian ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || Menu.class != obj.getClass()) {
            return false;
        }
        Menu other = (Menu) obj;
        return this.type == other.type
                && Objects.equals(this.subtype, other.subtype)
                && Objects.equals(this.meals, other.meals)
                && this.price == other.price
                && this.oehBonus == other.oehBonus
                && Objects.equals(this.date, other.date)
                && this.isVegetarian == other.isVegetarian;
    }
}
