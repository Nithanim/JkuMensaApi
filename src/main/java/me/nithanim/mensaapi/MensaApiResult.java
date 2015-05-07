package me.nithanim.mensaapi;

import java.util.List;

public class MensaApiResult {
    private boolean success;
    private String cause;
    private List<Menu> menus;

    public MensaApiResult() {
    }

    public MensaApiResult(boolean success, String cause, List<Menu> menus) {
        this.success = success;
        this.cause = cause;
        this.menus = menus;
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

    public List<Menu> getMenus() {
        return menus;
    }
}
