package ru.top;

import ru.top.controller.GroupController;
import ru.top.controller.SubjectController;
import ru.top.controller.TeacherController;
import ru.top.service.GroupService;
import ru.top.service.SubjectService;
import ru.top.service.TeacherService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GroupService groupService = new GroupService();
        SubjectService subjectService = new SubjectService();
        TeacherService teacherService = new TeacherService();

        GroupController groupController = new GroupController(groupService);
        SubjectController subjectController = new SubjectController(subjectService);
        TeacherController teacherController = new TeacherController(teacherService);
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("===Меню===");
            System.out.println("1 - Преподаватели");
            System.out.println("2 - Дисциплины");
            System.out.println("3 - Группы");
            System.out.println("0 - Выйти");
            switch (sc.nextInt()) {
                case 1:
                    teacherController.startTeacher();
                    break;
                case 2:
                    subjectController.startSubject();
                    break;
                case 3:
                    groupController.startGroup();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный символ");
                    break;
            }
        }
    }
}