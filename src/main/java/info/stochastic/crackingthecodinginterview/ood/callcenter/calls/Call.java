package main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls;

public class Call {
    private CallLevel callLevel;
    private final int id;

    public Call(CallLevel level, int id) {
        this.callLevel = level;
        this.id = id;
    }

    public void increaseLevel() {
        callLevel = callLevel.nextLevel();
    }

    public CallLevel getCallLevel() {
        return callLevel;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return callLevel.name();
    }
}
