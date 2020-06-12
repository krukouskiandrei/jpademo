package by.krukouski.jpademo.service;

import by.krukouski.jpademo.dao.CourseDao;
import by.krukouski.jpademo.dao.TeacherDao;
import by.krukouski.jpademo.entity.Course;
import by.krukouski.jpademo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class DataFillerService {

    private final CourseDao courseDao;
    private final TeacherDao teacherDao;

    @Autowired
    public DataFillerService(CourseDao courseDao, TeacherDao teacherDao) {
        this.courseDao = courseDao;
        this.teacherDao = teacherDao;
    }

    @PostConstruct
    @Transactional
    public void fillData() {
        Teacher pj = new Teacher("Profesor Jirafales",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg",
                "jirafales@example.com");
        Teacher px = new Teacher("Professor X",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4",
                "director@xproject_.com");
        teacherDao.save(pj);
        teacherDao.save(px);
        courseDao.save(new Course("Mathematics", 20, 10, pj));
        courseDao.save(new Course("Spanish", 20, 10, pj));
        courseDao.save(new Course("Dealing with unknown", 10, 100, pj));
        courseDao.save(new Course("Handling your mental power", 50, 100, pj));
        courseDao.save(new Course("Introduction to psychology", 90, 100, pj));
    }
}
