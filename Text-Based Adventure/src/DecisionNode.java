import java.util.HashMap;
import java.util.Map;

public class DecisionNode {
    private String prompt;
    private String decision;
    private Map<String, DecisionNode> choices;

    public DecisionNode(String decision, String prompt)
    {
        this.decision = decision;
        this.prompt = prompt;
        choices = new HashMap<>();
    }

    //Adds a choice to the node's choices map
    public void addChoice(String intKey, DecisionNode result)
    {
        choices.put(intKey, result);
    }

    //Displays the prompt of the current node
    public void displayPrompt()
    {
        System.out.println(prompt);
    }

    //Displays the decision the user takes to get to the node
    public String displayDecision()
    {
        return decision;
    }

    //Display all possible choices at the current node by printing out the choices from the Map's keyset
    public void displayChoices()
    {
        for(String choice : choices.keySet())
        {
            System.out.println(choice + ": " + choices.get(choice).displayDecision());
        }
    }

    //Gets the next node based on input
    public DecisionNode nextAction(int decision)
    {
        String key = String.valueOf(decision);
        return choices.get(key);
    }

    //Accessor methods
    public int getNumOfChoices()
    {
        return choices.size();
    }

    public String getPrompt()
    {
        return this.prompt;
    }

    public Map<String, DecisionNode> getGraph()
    {
        return choices;
    }

    

}
