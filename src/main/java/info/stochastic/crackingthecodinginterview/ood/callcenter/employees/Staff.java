package main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.employees;

import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.Dispatcher;
import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls.Call;

import java.util.ArrayList;
import java.util.List;

public class Staff {
    static final int NUMBER_OF_RESPONDENTS = 20;
    static final int NUMBER_OF_MANAGERS = 7;
    static final int NUMBER_OF_DIRECTORS = 2;

    List<CallCenterEmployee> respondents = new ArrayList<>();
    List<CallCenterEmployee> managers = new ArrayList<>();
    List<CallCenterEmployee> directors = new ArrayList<>();
    Dispatcher dispatcher;

    private void initStaff() {
        for (int i = 0; i < NUMBER_OF_RESPONDENTS; i++) {
            Respondent respondent = new Respondent(dispatcher);
            respondent.start();
            respondents.add(respondent);
        }

        for (int i = 0; i < NUMBER_OF_MANAGERS; i++) {
            Manager manager = new Manager(dispatcher);
            manager.start();
            managers.add(manager);
        }

        for (int i = 0; i < NUMBER_OF_DIRECTORS; i++) {
            Director director = new Director(dispatcher);
            director.start();
            directors.add(director);
        }
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        initStaff();
    }

    public void sendToRespondent(Call call) {
        sendACallTo(call, respondents);
    }

    public void sendToManager(Call call) {
        sendACallTo(call, managers);
    }

    public void sendToDirector(Call call) {
        sendACallTo(call, directors);
    }

    private void sendACallTo(Call call, List<CallCenterEmployee> employees) {
        for (CallCenterEmployee employee: employees) {
            if (employee.isFree) {
                employee.handleCall(call);
                return;
            }
        }

        // Return the call back to a dispatcher
        dispatcher.dispatchACall(call);
    }
}
