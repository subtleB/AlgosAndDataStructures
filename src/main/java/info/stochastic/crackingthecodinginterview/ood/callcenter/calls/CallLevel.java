package main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls;

public enum CallLevel {
    RESPONDENT, MANAGER, DIRECTOR;

    public CallLevel nextLevel() {
        switch (this) {
            case RESPONDENT: return CallLevel.MANAGER;
            case MANAGER: return CallLevel.DIRECTOR;
            case DIRECTOR: return CallLevel.DIRECTOR;
            default: throw new IllegalStateException();
        }
    }
}
