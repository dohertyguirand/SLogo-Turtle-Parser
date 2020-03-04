package execution.all_commands;

import execution.Command;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Tell implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel) {
        List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));
        List<TurtleModel> newActiveTurtles = new ArrayList<>();
        boolean hasBeenChanged = turtleModelContainer.getHasBeenChanged();
        if(!hasBeenChanged){
            for(int i = 2; i < symbolList.size(); i ++){
                int id = Integer.parseInt(symbolList.get(i));
                int difference = id - turtleModelContainer.getTurtleIds().size();
                if(difference > 0){
                    for(int k = 0; k < difference; k ++ ){
                        int newId = turtleModelContainer.getTurtleIds().get(turtleModelContainer.getTurtleIds().size()-1) + 1;
                        TurtleModel turtleModel = turtleModelContainer.addTurtle(id);
                        newActiveTurtles.add(turtleModel);
                    }
                }
                else{
                    TurtleModel turtleModel = turtleModelContainer.getTurleModel(id);
                    newActiveTurtles.add(turtleModel);
                }
            }
            turtleModelContainer.setActiveTurtles(newActiveTurtles);
        }
        turtleModelContainer.setHasBeenChangedTrue();
        return Integer.parseInt(symbolList.get(symbolList.size()-1));
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
