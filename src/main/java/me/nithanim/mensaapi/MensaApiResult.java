package me.nithanim.mensaapi;

import java.util.List;
import java.util.Map;
import me.nithanim.mensaapi.util.Objects;

public class MensaApiResult {
    private boolean success;
    private String cause;
    private Map<Type, List<Menu>> result;

    public MensaApiResult() {
    }

    public MensaApiResult(boolean success, String cause, Map<Type, List<Menu>> result) {
        this.success = success;
        this.cause = cause;
        this.result = result;
    }
    
    public boolean isSuccessful() {
        return success;
    }
    
    /**
     * Returns a cause for failure if {@link #isSuccessful()}
     * returns false.
     * 
     * @return 
     */
    public String getCause() {
        return cause;
    }

    public Map<Type, List<Menu>> getResult() {
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.success ? 1 : 0);
        hash = 41 * hash + (this.cause != null ? this.cause.hashCode() : 0);
        hash = 41 * hash + (this.result != null ? this.result.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || Meal.class != obj.getClass()) {
            return false;
        }
        MensaApiResult other = (MensaApiResult) obj;
        return this.success == other.success
                && Objects.equals(this.cause, other.cause)
                && Objects.equals(this.result, other.result);
    }
}
