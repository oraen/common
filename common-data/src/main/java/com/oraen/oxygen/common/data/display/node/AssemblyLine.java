package com.oraen.oxygen.common.data.display.node;

import com.oraen.oxygen.common.data.display.WorkNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssemblyLine<T, S> implements WorkNode<T>{

    private S context;

    private List<WorkNode<? super T>> nodeList = new ArrayList<>();

    public AssemblyLine(){}

    public AssemblyLine(S context){
        this.context = context;
    }

    @SafeVarargs
    public AssemblyLine(WorkNode<? super T>... nodes){
        nodeList.addAll(Arrays.asList(nodes));
    }

    @SafeVarargs
    public AssemblyLine(S context, WorkNode<? super T>... nodes){
        this.context = context;
        nodeList.addAll(Arrays.asList(nodes));
    }

    @Override
    public void work(T t) {
        for(WorkNode<? super T> node : nodeList){
            node.work(t);
        }
    }

    public AssemblyLine<T, S> add(WorkNode<T> workNode){
        nodeList.add(workNode);
        return this;
    }

    public AssemblyLine<T, S> pop(){
        nodeList.remove(size() - 1);
        return this;
    }

    public AssemblyLine<T, S> remove(WorkNode<T> workNode){
        nodeList.remove(workNode);
        return this;
    }

    public AssemblyLine<T, S> remove(int index){
        nodeList.remove(index);
        return this;
    }

    public int size(){
        return nodeList.size();
    }

    public AssemblyLine<T, S> clear(){
        nodeList = new ArrayList<>();
        return this;
    }


    public S getContext() {
        return context;
    }

    public void setContext(S context) {
        this.context = context;
    }

    abstract class OneNode implements WorkNode<T> {
    }
}
