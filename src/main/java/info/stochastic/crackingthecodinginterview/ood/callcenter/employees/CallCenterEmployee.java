package main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.employees;

import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.Dispatcher;
import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls.Call;
import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls.CallLevel;

import java.util.Random;

public abstract class CallCenterEmployee extends Thread {
    CallLevel callsLevel;
    Call currentCall;
    Dispatcher dispatcher;

    Random r = new Random(System.currentTimeMillis());
    double competency;
    boolean isFree = true;


    public void handleCall(Call call) {
        System.out.println(getClass().getSimpleName() + ": has received a call " + call.getId());

        // Cant handle the call in (1 - competency) * 100%
        if (r.nextDouble() > competency) {
            System.out.println(getClass().getSimpleName() + ": cant handle a call :(");
            cantHandle(call);
            return;
        }
        processCall(call);
    }

    void processCall(Call call)  {
        currentCall = call;
        isFree = false;
    }

    void cantHandle(Call call) {
        call.increaseLevel();
        dispatcher.dispatchACall(call);
    }

    @Override
    public void run() {
        while (true) {
            if (!isFree) {
                System.out.println(this.getClass().getSimpleName()
                        + " call with id = " + currentCall.getId() + ": DONE!");
                currentCall = null;
                isFree = true;
            }

            Thread.yield();
            try {Thread.sleep(500 + r.nextInt(3000));} catch(Exception ignored) {}
        }
    }
}
