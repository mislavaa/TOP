package ru.top.controller;

import ru.top.service.TeacherService;

import java.util.Scanner;

public class TeacherController {

    public TeacherService teacherService;
    Scanner scanner = new Scanner(System.in);

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public void startTeacher() {
        System.out.println("1 - Создать таблицу");
        System.out.println("2 - Внести данные");
        System.out.println("3 - Вывести данные");
        System.out.println("4 - Обновить данные");
        System.out.println("5 - Удалить данные");
        System.out.println("0 - Назад в главное меню");

        while (true) {
            switch (scanner.nextInt()) {
                case 1:
                    create();
                    break;
                case 2:
                    insert();
                    break;
                case 3:
                    select();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный символ");
                    break;
            }
        }
    }

    public void create() {
        teacherService.createTeacher();
    }

    public void insert() {
        teacherService.insertInTeacher();
    }

    public void select() {
        teacherService.selectFromTeacher();
    }

    public void update() {
        teacherService.updateTeacher();
    }

    public void delete() {
        teacherService.deleteFromTeacher();
    }
}
