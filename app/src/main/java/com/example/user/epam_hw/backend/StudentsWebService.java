package com.example.user.epam_hw.backend;

import android.os.Handler;
import android.os.Looper;

import com.example.user.epam_hw.backend.entities.Student;
import com.example.user.epam_hw.util.ICallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StudentsWebService implements IWebService<Student> {

    private static final int MAX_HOMEWORK_COUNT = 6;
    private static List<String> epamStudents = Arrays.asList(
            "Комар Андрей",
            "Aliaksei Shvants",
            "Maryia Senkevich",
            "Pavel Klimovich",
            "yahor shymanchyk",
            "Anton Liaskevich",
            "Pavel Klimovich",
            "VASILI ZAICEV",
            "Yahor Berdnikau",
            "MAKSIM ZHANHIALIOU",
            "ULADZISLAU SITSKO",
            "Aliaksandr Marozik",
            "Aliaksei Aleksiaichuk",
            "Goncharov Alexander",
            "MAKSIM NASALEVICH",
            "Vitali Kullikouski",
            "ALIAKSANDR LITSKEVICH",
            "Dzmitry Fedarovich",
            "Kiryl Shreyter",
            "Konopeshko Aleksei",
            "NATALLIA BONDARAVA",
            "ALIEKSANDR ZAKHARCHANKA",
            "ALIAKSEI HALAVACH",
            "Dzmitry Siarhei",
            "Maksim Siamashka",
            "Vladyslav Vsemirnov"
    );

    private long idCount;
    private List<Student> students = new ArrayList<>();
    private Random random = new Random();
    private Handler handler = new Handler(Looper.getMainLooper());

    {
        for (int i = 0; i < epamStudents.size(); i++) {
            idCount = (long) i;
            Student student = new Student();
            student.setId(idCount);
            student.setHomeworkCount(1 + random.nextInt(MAX_HOMEWORK_COUNT));
            student.setName(epamStudents.get(i));

            students.add(student);
        }
    }

    @Override
    public void getEntities(final ICallback<List<Student>> callback) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onResult(students);
            }
        });
    }

    @Override
    public void getEntities(final int startRange,
                            final int endRange,
                            final ICallback<List<Student>> callback) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onResult(students);
            }
        });
    }

    @Override
    public void removeEntity(final Long id) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()){
            if (iterator.next().getId().equals(id)){
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void addEntity(final String name, final int homeworkCount) {
        Student student = new Student();

        student.setId(idCount++);
        student.setHomeworkCount(homeworkCount);
        student.setName(name);

        students.add(student);
    }

    @Override
    public void editEntity(final long id, final String name, final int hwCount) {

        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setHomeworkCount(hwCount);
                break;
            }
        }

    }


}
