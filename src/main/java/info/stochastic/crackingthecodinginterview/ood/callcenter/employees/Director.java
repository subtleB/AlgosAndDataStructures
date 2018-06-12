package main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.employees;

import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.Dispatcher;
import main.java.info.stochastic.crackingthecodinginterview.ood.callcenter.calls.CallLevel;

public class Director extends CallCenterEmployee {
    Director(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.callsLevel = CallLevel.DIRECTOR;
        this.competency = 0.95;
    }
}
