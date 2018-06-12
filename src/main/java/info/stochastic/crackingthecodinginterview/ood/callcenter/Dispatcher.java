package main.java.info.stochastic.crackingthecodinginterview.ood.callcenter;

import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls.Call;
import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.employees.Staff;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

public class Dispatcher extends Thread {

    private Queue<Call> callsForRespondents = new ConcurrentLinkedQueue<>();
    private Queue<Call> callsForManagers = new ConcurrentLinkedQueue<>();
    private Queue<Call> callsForDirectors = new ConcurrentLinkedQueue<>();

    private Staff staff;

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void dispatchACall(Call call) {
        System.out.println(getClass().getSimpleName() + " has received a call " + call.getId());
        switch (call.getCallLevel()) {
            case RESPONDENT: callsForRespondents.add(call); return;
            case MANAGER: callsForManagers.add(call); return;
            case DIRECTOR: callsForDirectors.add(call); return;
            default: throw new IllegalStateException();
        }
    }

    @Override
    public synchronized void run() {
        while (true) {

            if (!callsForRespondents.isEmpty()) {
                Call call = callsForRespondents.poll();
                staff.sendToRespondent(call);
            }

            if (!callsForManagers.isEmpty()) {
                Call call = callsForManagers.poll();
                staff.sendToManager(call);
            }

            if (!callsForDirectors.isEmpty()) {
                Call call = callsForDirectors.poll();
                staff.sendToDirector(call);
            }

            Thread.yield();
            try {Thread.sleep(1000);} catch(Exception ignored) {}
        }
    }
}
