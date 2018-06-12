package main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.employees;

import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.Dispatcher;
import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls.CallLevel;

public class Respondent extends CallCenterEmployee {
    Respondent(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.callsLevel = CallLevel.RESPONDENT;
        this.competency = 0.70;
    }
}
