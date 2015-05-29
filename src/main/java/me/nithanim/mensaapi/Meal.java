package me.nithanim.mensaapi;

import me.nithanim.mensaapi.util.Objects;

public class Meal {
    private final String desc;
    private final int price;

    public Meal(String desc, int price) {
        this.desc = desc;
        this.price = price;
    }

    /**
     * Gson and any other deserialization libraries may
     * use or need it to create a object.
     */
    private Meal() {
        this.desc = null;
        this.price = 0;
    }
    
    
    /**
     * Returns the text that describes the meal.
     * 
     * @return The text describing the meal
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This gets the price of an individual meal. Does not work for
     * Classic since there is only one price for the complete menu.
     * 
     * @return Price of the meal,
     * -1 if there is none intentionally and
     * -2 if there was an error parsing it
     * @see Menu
     */
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return '<' + desc + '|' + price + '>';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.desc != null ? this.desc.hashCode() : 0);
        hash = 89 * hash + this.price;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || Meal.class != obj.getClass()) {
            return false;
        }
        Meal other = (Meal) obj;
        return Objects.equals(this.desc, other.desc)
                && this.price == other.price;
    }
}
