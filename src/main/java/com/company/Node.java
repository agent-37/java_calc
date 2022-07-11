package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public void setName(String newName) {
        name=newName;
    }

    public String getId() {
        return id;
    }

    public void add(Node t) {
        child.add(t);
    }

    public List<Node> getChildren() {
        return child;
    }

    public boolean findChildren(String _name) {
        boolean flag = false;
        for (int i = 0; i < child.size(); i++)
            if (_name.equals(child.get(i).getName()))
                flag = true;
        return flag;
    }

    public void del_all_children() {
        child.clear();
    }

    public void del_child_id(String _id) {
        for (int i = 0; i < child.size(); i++)
            if (_id.equals(child.get(i).getId()))
                child.remove(child.get(i));
    }

    public void change_child(String _id, String newName) {
        for (int i = 0; i < child.size(); i++)
            if (_id.equals(child.get(i).getId())){
                child.get(i).setName(newName);
                System.out.print("zdec");
            }
    }
    public String print(Node node,int n){
        String result=node.getName();
        for(int i=0;i<n;i++)
            result=' '+result ;
        result=result+'\n';
        for(int i=0;i<node.getChildren().size();i++)
           result=result+print(node.getChildren().get(i),n+1);
        return result;
    }
    public void printFile() throws IOException {
        String content = print(this,0);
        String path = "file.txt";
        Files.write(Paths.get(path),content.getBytes());
    }

    public String printToHtml(){
        String  result="<li>"+name+"</li>";
        if(child.size()!=0){
            result+="<vi>";
            for(int i=0;i<child.size();i++)
                result+=child.get(i).printToHtml();
            result+="</vi>";
        }
        //result+="</li>";
        return result;
    }
}
