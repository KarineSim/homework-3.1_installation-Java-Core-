import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File[] newDirs = {
                new File("C:/Games/src"),
                new File("C:/Games/res"),
                new File("C:/Games/savegames"),
                new File("C:/Games/temp"),
                new File("C:/Games/src/main"),
                new File("C:/Games/src/test"),
                new File("C:/Games/res/drawables"),
                new File("C:/Games/res/vectors"),
                new File("C:/Games/res/icons"),

        };

        File[] newFiles = {
                new File("C:/Games/src/main/Main.java"),
                new File("C:/Games/src/main/Utils.java"),
                new File("C:/Games/temp/temp.txt"),
        };

        StringBuilder sb = new StringBuilder();

        for (File newDir : newDirs) {
            sb.append(createNewDirs(newDir));
        }

        for (File newFile : newFiles) {
            sb.append(createNewFiles(newFile));
        }

        try (FileWriter writer = new FileWriter("C:/Games/temp/temp.txt")) {
            writer.append("В папке Games" + "\n\n");
            writer.write(String.valueOf(sb));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String createNewDirs(File newDirs) {
        if (newDirs.mkdir()) {
            return "Создан каталог " + newDirs.getName() + "\n";
        } else {
            return "Не удалось создать каталог " + newDirs.getName() + "\n";
        }
    }

    public static String createNewFiles(File newFiles) {
        try {
            if (newFiles.createNewFile()) {
                return "Создан файл " + newFiles.getName() + "\n";
            } else {
                return "Не удалось создать файл " + newFiles.getName() + "\n";
            }
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}