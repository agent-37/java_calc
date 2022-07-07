package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Node {
    private String id;
    private String name;
    private List<Node> child;

    public Node(String str) {
        id = UUID.randomUUID().toString();
        name = str;
        child = new ArrayList<Node>();
    }

    public String getName() {
        return name;
    }

    public void add(Node t) {
        child.add(t);
    }

    public List<Node> getChildren() {
        return child;
    }
    public boolean findChildren(String _name){
     boolean flag=false;
     for(int i=0;i<child.size();i++){
         if(_name.equals(child.get(i).getName())){
             flag=true;
         }
     }
     return flag;
    }
    public void del_all_children() {
        child.clear();
    }

}
