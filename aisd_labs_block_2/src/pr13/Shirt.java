package pr13;

public class Shirt {
    String id;
    String name;
    String color;
    String size;

    public Shirt(String data) {
        String[] parts = data.split(",");
        this.id = parts[0].trim();
        this.name = parts[1].trim();
        this.color = parts[2].trim();
        this.size = parts[3].trim();
    }

    public String toString() {
        return "ID: " + id + "\n" +
                "Название: " + name + "\n" +
                "Цвет: " + color + "\n" +
                "Размер: " + size + "\n" +
                "----------------------";
    }

    public static void main(String[] args) {
        String[] shirtsData = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };

        Shirt[] shirts = new Shirt[shirtsData.length];
        for (int i = 0; i < shirtsData.length; i++) {
            shirts[i] = new Shirt(shirtsData[i]);
        }

        for (Shirt s : shirts) {
            System.out.println(s);
        }
    }
}