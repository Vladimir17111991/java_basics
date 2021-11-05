import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            Hibernate hibernateForCourse = new Hibernate();
            System.out.println("Введите id курса");
            String idCourse = scanner.nextLine();
            if (idCourse.equals("0")) {
                break;
            }
            Course course = hibernateForCourse.getSession().get(Course.class, Integer.parseInt(idCourse));
            System.out.println(course.getName() + ". Колличество студентов на курсе -  "
                    + course.getStudentsCount());
            //доп.задание
            Hibernate hibernateForStudent = new Hibernate();
            System.out.println("Введите id студента");
            String idStudent = scanner.nextLine();
            if (idStudent.equals("0")) {
                break;
            }
            Student student = hibernateForStudent.getSession().get(Student.class, Integer.parseInt(idStudent));
            System.out.println("Студент с таким id это : "
                    + student.getName() + ", который зарегестрировался - " + student.getRegistrationDate());

            hibernateForCourse.getSessionFactory().close();
            hibernateForStudent.getSessionFactory().close();
        }
    }
}
