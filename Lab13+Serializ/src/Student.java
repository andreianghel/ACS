import java.io.*;
import java.util.*;

public class Student implements Serializable {
       
        private String name;
       
        public Student(String name) {
                System.out.println(name);
                this.name = name;
        }
       
        @Override
        public String toString() {
                return name;
        }
}

class Group implements Serializable {
       
        private Student[] students;
       
        /**
         * Construieste o grupa pe baza unor studenti.
         *
         * @param students
         *                      parametri cu numar variabil. Acestia pot fi pasati in 2 moduri:
         *                      * separandu-i prin virgula:     new Group(s1, s2, s3);
         *                      * sub forma unui vector:        new Group(new Student[] {s1, s2, s3});
         *                      In cadrul constructorului, parametrul este vazut ca un vector.
         */
        public Group(Student... students) {
                /* Realizam o copie a vectorului, pentru ca modificarile externe
                 * asupra acestuia sa nu se reflecte in interiorul clasei.
                 */
                this.students = Arrays.copyOf(students, students.length);
        }
       
        @Override
        public String toString() {
                // Necesar pentru a accesa reprezentarile elementelor vectorului.
                return Arrays.deepToString(students);
        }

}

