package com.company;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Контроллер отвечающий за представление списка.
 */
@Path("/")
public class ListPresentationController {
    private final List<String> list;
    private Node root = new Node("Корень");
    private Node node = new Node("Лист");
    private Node node0 = new Node("Лист0");
    private Node node1 = new Node("Лист1");
    private Node node3 = new Node("Лист2");
    private Node node4 = new Node("Лист3");
    private Node current = new Node("Лист");
    private int t = 7;
    private int pos = 0;

    /**
     * Запоминает список, с которым будет работать.
     *
     * @param list список, с которым будет работать контроллер.
     */
    public ListPresentationController(List<String> list) {
        this.list = list;

        root.add(node);
        node.add(node0);
        node0.add(node1);
        root.add(node4);
        node4.add(node3);
        current = root;
    }

    /**
     * Пример вывода простого текста.
     */
    @GET
    @Path("example")
    @Produces("text/plain")
    public String getSimpleText() {
        return "hello world";
    }

    /**
     * Выводит HTML-страницу со списком, ссылками на страницы редактирования и копкой добавления записи.
     *
     * @return HTML-страница со списком.
     */
    @GET
    @Path("/")
    @Produces("text/html")
    public String getList() {
        String result =
                "<html>" +
                        "  <head>" +
                        "    <title>Вывод списка</title>" +
                        "  </head>" +
                        "  <body>" +
                        "    <h1>Список</h1>" +
                        "    <ul>";
        for (int i = 0; i < list.size(); i++) {
            String listItem = list.get(i);
            result += "<li>" + listItem + " <a href=\"edit/" + i + "\">Редактировать</a> </li>";
        }
        result += "    </ul>" +
                "      <br/>" +
                "      <form method=\"post\" action=\"add_random_item\">" +
                "        <input type=\"submit\" value=\"Add random item\"/>" +
                "      </form>" +
                "  </body>" +
                "</html>";
        return result;
    }

    /**
     * Пример обработки POST запроса.
     * Добавляет одну случайную запись в список и перенаправляет пользователя на основную страницу со списком.
     *
     * @return перенаправление на основную страницу со списком.
     */
    @POST
    @Path("add_random_item")
    @Produces("text/html")
    public Response addRandomItem() {
        list.add("zzz");
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }

    @POST
    @Path("up")
    @Produces("text/html")
    public Response up() {
        pos++;
        try {
            return Response.seeOther(new URI("/test_tree")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }

    @POST
    @Path("down")
    @Produces("text/html")
    public Response down() {
        pos--;
        try {
            return Response.seeOther(new URI("/test_tree")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }
    @POST
    @Path("choose")
    @Produces("text/html")
    public Response choose() {
        if(current.getChildren().size()!=0) {
            if (pos < 0)
                current = current.getChildren().get(0);
            else if (pos >= current.getChildren().size())
                current = current.getChildren().get(current.getChildren().size() - 1);
            else
                current = current.getChildren().get(pos);
            pos=0;
        }
        try {
            return Response.seeOther(new URI("/test_tree")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }

    }
    @POST
    @Path("build")
    @Produces("text/html")
    public Response build() {
        Node n =new Node("Лист"+String.valueOf(t));
        t++;
        pos=0;
        current.add(n);
        current=root;
        try {
            return Response.seeOther(new URI("/test_tree")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }
    @POST
    @Path("ret")
    @Produces("text/html")
    public Response ret() {
        pos=0;
        current=root;
        try {
            return Response.seeOther(new URI("/test_tree")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }
    @POST
    @Path("delete")
    @Produces("text/html")
    public Response delete() {
        String s;
        if(current.getChildren().size()!=0) {
            if (pos < 0)
                s=current.getChildren().get(0).getName();
            else if (pos >= current.getChildren().size())
                s=current.getChildren().get(current.getChildren().size() - 1).getName();
            else
                s=current.getChildren().get(pos).getId();
            current.del_child_id(s);
        }
        pos=0;
        current=root;
        try {
            return Response.seeOther(new URI("/test_tree")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }
    /**
     * Выводит страничку для редактирования одного элемента.
     *
     * @param itemId индекс элемента списка.
     * @return страничка для редактирования одного элемента.
     */
    @GET
    @Path("/edit/{id}")
    @Produces("text/html")
    public String getEditPage(@PathParam("id") int itemId) {
        String listItem = list.get(itemId);
        String result =
                "<html>" +
                        "  <head>" +
                        "    <title>Редактирование элемента списка</title>" +
                        "  </head>" +
                        "  <body>" +
                        "    <h1>Редактирование элемента списка</h1>" +
                        "    <form method=\"post\" action=\"/edit/" + itemId + "\">" +
                        "      <p>Значение</p>" +
                        "      <input type=\"text\" name=\"value\" value=\"" + listItem + "\"/>" +
                        "      <input type=\"submit\"/>";
        result +=
                "            </form>" +
                        "  </body>" +
                        "</html>";
        return result;
    }

    /**
     * Редактирует элемент списка на основе полученных данных.
     *
     * @param itemId индекс элемента списка.
     * @return перенаправление на основную страницу со списком.
     */
    @POST
    @Path("/edit/{id}")
    @Produces("text/html")
    public Response editItem(@PathParam("id") int itemId, @FormParam("value") String itemValue) {
        list.set(itemId, itemValue);
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }

    /**
     * Пример вывода вложенного списка.
     */
    @GET
    @Path("nested_list")
    @Produces("text/html")
    public String getNestedListExample() {
        return "<html>" +
                "  <head>" +
                "    <title>Hello world</title>" +
                "  </head>" +
                "  <body>" +
                "    <h1>Hello world</h1>" +
                "    <ul>" +
                "      <li>1</li>" +
                "      <li>2</li>" +
                "      <li>3" +
                "        <ul>" +
                "          <li>3.1</li>" +
                "        </ul>" +
                "      </li>" +
                "    </ul>" +
                "  </body>" +
                "</html>";
    }

    @GET
    @Path("test_tree")
    @Produces("text/html")
    public String getTree() {
        return "<html>" +
                "  <head>" +
                "    <title>Print Tree</title>" +
                "  </head>" +
                "  <body>" +
                "    <h1>Print Tree</h1>" +
                root.printToHtml() +
                "      <form method=\"post\" action=\"down\">" +
                "        <input type=\"submit\" value=\"up\"/>" +
                "      </form>" +
                "      <form method=\"post\" action=\"up\">" +
                "        <input type=\"submit\" value=\"down\"/>" +
                "      </form>" +
                "      <form method=\"post\" action=\"choose\">" +
                "        <input type=\"submit\" value=\"choose\"/>" +
                "      </form>" +
                "      <form method=\"post\" action=\"build\">" +
                "        <input type=\"submit\" value=\"build\"/>" +
                "      </form>" +
                "      <form method=\"post\" action=\"delete\">" +
                "        <input type=\"submit\" value=\"delete\"/>" +
                "      </form>" +
                "      <form method=\"post\" action=\"ret\">" +
                "        <input type=\"submit\" value=\"return\"/>" +
                "      </form>" +
                "  </body>" +
                "</html>";
    }
}
