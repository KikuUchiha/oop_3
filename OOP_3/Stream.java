import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stream implements Iterable<Student> {

    private List<Student> students;

    public Stream(StudentGroup studentGroup) {
        this.students = new ArrayList<>(studentGroup.getStudentList());
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

}

