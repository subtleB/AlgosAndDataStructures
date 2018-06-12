package main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.employees;

import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.Dispatcher;
import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls.CallLevel;

public class Manager extends CallCenterEmployee {
    Manager(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.callsLevel = CallLevel.MANAGER;
        this.competency = 0.90;
    }
}
