package com.oraen.oxygen.common.design.workstation;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class AssemblyLine<T> implements WorkNode<T>{

    private List<WorkNode<? super T>> assemblyLine = new ArrayList<WorkNode<? super T>> (8);

    public AssemblyLine<T> addNode(WorkNode<? super T> workNode){
        this.assemblyLine.add(workNode);
        return this;
    }

    @Override
    public void execute(T target) {
        for(WorkNode<? super T> w : assemblyLine){
            w.execute(target);
        }
    }
}
