package com.binance.client.model.enums;

/**
 * @author xingyu
 */
public enum SymbolState {

    /**
     * ONLINE, OFFLINE, SUSPEND.
     */
    ONLINE("online"),
    OFFLINE("offline"),
    SUSPEND("suspend");
    private final String state;

    SymbolState(String state) {
        this.state = state;
    }

    public static SymbolState find(String state) {
        for (SymbolState st : SymbolState.values()) {
            if (st.getState().equals(state)) {
                return st;
            }
        }
        return null;
    }

    public String getState() {
        return state;
    }

}
