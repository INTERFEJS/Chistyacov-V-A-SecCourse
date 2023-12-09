package interfaceLine;

import domain.Archive;
import manager.ArchiveDAO;

import java.util.Scanner;

public class CommandLineInterface {
    private ArchiveDAO archiveDAO;
    private Scanner scanner;

    public CommandLineInterface() {
        archiveDAO = new ArchiveDAO();
        scanner = new Scanner(System.in);
    }

    public void start() {

        while (true) {
            System.out.println();
            System.out.print("Введите команду(ДобавитьАрхив, ОбновитьАрхив, УдалитьАрхив, ПоказатьАрхивы): ");
            String command = scanner.nextLine();

            if (command.equals("ПоказатьАрхивы")) {
                System.out.println(archiveDAO.getAllArchives());
            } else if (command.equals("ДобавитьАрхив")) {
                System.out.print("Введите название архива: ");
                String title = scanner.nextLine();
                System.out.print("Введите дату создания архива: ");
                String dateOfCreate = scanner.nextLine();
                System.out.print("Введите данные для хранения: ");
                String data = scanner.nextLine();

                Archive archive = new Archive(title, dateOfCreate, data);
                archiveDAO.addArchives(archive);
                System.out.println("Архив добавлен");
            } else if (command.equals("ОбновитьАрхив")) {
                System.out.print("Введите id архива для обновления: ");
                int id = Integer.parseInt(scanner.nextLine());


                System.out.print("Введите название архива: ");
                String title = scanner.nextLine();
                System.out.print("Введите дату создания архива: ");
                String dateOfCreate = scanner.nextLine();
                System.out.print("Введите данные для хранения: ");
                String data = scanner.nextLine();

                Archive updatedArchive = new Archive(title, dateOfCreate, data);
                updatedArchive.setId(id);
                archiveDAO.updateArchives(updatedArchive);
                System.out.println("Архив обновлен");


            } else if (command.equals("УдалитьАрхив")) {
                System.out.print("Введите ID архива который хотите удалить: ");
                int id = Integer.parseInt(scanner.nextLine());


                archiveDAO.deleteArchives(id);
                System.out.println("Удаление архива выполнено успешно!");
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Неизвестная команда. Попробуйте еще раз.");
            }
        }
    }
}