package main.java.info.stochastic.crackingthecodinginterview.ood.callcenter;

import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls.Call;
import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls.CallLevel;
import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.employees.Staff;

public class CallCenter extends Thread {

    static final int MAX_CALLS = 100;
    private int callsCounter = 0;
    Staff staff = new Staff();
    Dispatcher dispatcher = new Dispatcher();

    public CallCenter() {
        staff.setDispatcher(dispatcher);
        dispatcher.setStaff(staff);
        dispatcher.start();
    }

    public void receiveACall(Call call) {
        dispatcher.dispatchACall(call);
    }

    @Override
    public void run() {
        while (true) {
            Call call = new Call(CallLevel.RESPONDENT, callsCounter);
            receiveACall(call);
            callsCounter++;

            if (callsCounter > MAX_CALLS) {
                break;
            }

            Thread.yield();
            try {Thread.sleep(700);} catch(Exception ignored) {}
        }
    }

    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        callCenter.run();
    }
}
