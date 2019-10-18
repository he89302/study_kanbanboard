package tw.teddysoft.clean.usecase.workitem;

import tw.teddysoft.clean.domain.model.FlowEvent;

import java.util.ArrayList;
import java.util.List;

public class FlowMeasurement {

    // key = work item id
    private List<FlowEntryPair> flowEntryPairs;

    public FlowMeasurement(){
        flowEntryPairs = new ArrayList<>();
    }

    public void add(FlowEntryPair flowEntryPair) {
        flowEntryPairs.add(flowEntryPair);
    }
}
