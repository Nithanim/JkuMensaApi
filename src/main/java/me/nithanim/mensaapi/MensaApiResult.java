package me.nithanim.mensaapi;

import java.util.List;
import java.util.Map;

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
}
