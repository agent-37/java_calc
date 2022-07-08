import com.company.Node;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {
    @Test
    void createNode(){
        Node node = new Node("Корень");
        assertEquals("Корень",node.getName());
    }
    @Test
    void addNode(){
        Node root=new Node("Корень");
        Node child = new Node("Лист");
        root.add(child);
        assertEquals(1,root.getChildren().size());
        assertEquals("Лист",root.getChildren().get(0).getName());
    }
    @Test
    void findChild(){
        Node root=new Node("Корень");
        Node child = new Node("Лист");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        root.add(child);
        root.add(child1);
        root.add(child2);
        assertEquals(true,root.findChildren("Лист"));
    }
    @Test
    void delChild(){
        Node root=new Node("Корень");
        Node child = new Node("Лист");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        root.add(child);
        root.add(child1);
        root.add(child2);
        root.del_child_id(child1.getId());
        assertEquals(false,root.findChildren("Лист1"));
    }
    @Test
    void rezny(){
        Node root=new Node("Корень");
        Node child = new Node("Лист");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        root.add(child);
        root.add(child1);
        root.add(child2);
        root.del_all_children();
        assertEquals(0,root.getChildren().size());
    }
    @Test
    void renameChild(){
        Node root=new Node("Корень");
        Node child = new Node("Лист");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        root.add(child);
        root.add(child1);
        root.add(child2);
        root.change_child(child.getId(),"123");
        assertEquals(true,root.findChildren(("123")));
    }
    @Test
    void checkPrint(){
        Node root=new Node("Корень");
        Node child = new Node("Лист1");
        Node child1 = new Node("Лист2");
        Node child2 = new Node("Лист3");
        Node child3 = new Node("Лист4");
        root.add(child);
        root.add(child1);
        root.add(child2);
        child1.add(child3);
        String s=root.print(root,0);
        assertEquals("Корень\n Лист1\n Лист2\n  Лист4\n Лист3\n",s);
    }
    @Test
    void printFile() throws IOException {
        Node root=new Node("Корень");
        Node child = new Node("Лист1");
        Node child1 = new Node("Лист2");
        Node child2 = new Node("Лист3");
        Node child3 = new Node("Лист4");
        root.add(child);
        root.add(child1);
        root.add(child2);
        child1.add(child3);
        root.printFile();
        String s=root.print(root,0);
        String path = "file.txt";
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        String content = new String (bytes);
        assertEquals(content,s);
    }
}
