package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoryGame {
    private List<String> historyActions;
    public HistoryGame() {
        historyActions = new ArrayList<>();
    }
    public void addHistoryActions (String playerAction) {
        historyActions.add(playerAction);
    }
     public List<String> getHistoryActions() {
        return Collections.unmodifiableList(historyActions);
     }

}
