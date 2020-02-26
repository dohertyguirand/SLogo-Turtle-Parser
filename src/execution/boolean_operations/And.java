package execution.boolean_operations;

import execution.Command;
import model.TurtleModel;

import java.util.List;

public class And implements Command {
    @Override
    public double execute(List<Double> parameters, TurtleModel turtleModel) {
        if(parameters.get(0) != 0 && parameters.get(1) != 0){
            System.out.println(1);
            return 1;
        }
        System.out.println(0);
        return 0;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}