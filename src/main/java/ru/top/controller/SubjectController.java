package ru.top.controller;

import ru.top.service.SubjectService;

import java.util.Scanner;

public class SubjectController {

    public SubjectService subjectService;
    Scanner scanner = new Scanner(System.in);

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public void startSubject() {
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
        subjectService.createSubject();
    }

    public void insert() {
        subjectService.insertInSubject();
    }

    public void select() {
        subjectService.selectFromSubject();
    }

    public void update() {
        subjectService.updateSubject();
    }

    public void delete() {
        subjectService.deleteFromSubject();
    }
}
