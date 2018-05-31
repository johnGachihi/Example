package client;

import compute.Task;

import java.io.Serializable;

public class HelloTask implements Task<String>, Serializable {
    @Override
    public String execute() {
        return "Hello" + " World" ;
    }
}
