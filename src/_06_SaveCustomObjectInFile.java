import java.io.*;

/**
 * Created by galeto on 22.03.16.
 */
public class _06_SaveCustomObjectInFile {
    public static void main(String[] args) {
        Course course = new Course() {{
            name = "IT";
            numberOfStudents = 56;
        }};
        saveObject(course);
        printCourse(loadObject(course));
    }

    public static void printCourse(Course course) {
        System.out.println(course);
    }

    public static Course loadObject(Course course) {
        Course crs = new Course();
        try(ObjectInputStream source = new ObjectInputStream(new FileInputStream("files/course.save"))){
            crs = (Course) source.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return crs;
    }

    public static void saveObject(Course course) {
        try(ObjectOutputStream destination = new ObjectOutputStream(new FileOutputStream("files/course.save"))){
            destination.writeObject(course);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
class Course implements Serializable {
    String name;
    int numberOfStudents;
    public String toString() {
        return this.name + " course has " + this.numberOfStudents + " students.";
    }
}
