package execution.all_commands;

import execution.Command;
import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

import java.util.List;

public class Product implements Command {

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        System.out.println("Product of " + parameters.get(0) + "and " + parameters.get(1));
        consoleModel.setReturnVal(Double.parseDouble(parameters.get(0))*Double.parseDouble(parameters.get(1)));
        return Double.parseDouble(parameters.get(0))*Double.parseDouble(parameters.get(1));
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}