package ru.top.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

public class MathServer {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
        server.bind(new InetSocketAddress("localhost", 5000));
        System.out.println("Сервер запущен на порту 5000...");

        while (true) {
            AsynchronousSocketChannel client = server.accept().get();
            System.out.println("Клиент подключен");

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            client.read(buffer).get();
            buffer.flip();

            String request = StandardCharsets.UTF_8.decode(buffer).toString().trim();
            System.out.println("Получен запрос: " + request);
            String response = calculate(request);

            ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes(StandardCharsets.UTF_8));
            client.write(responseBuffer).get();

            client.close();
        }
    }

    private static String calculate(String input) {
        try {
            String[] parts = input.split(" ");
            String op = parts[0].toUpperCase();
            double a = Double.parseDouble(parts[1]);
            double b = Double.parseDouble(parts[2]);
            return switch (op) {
                case "ADD" -> String.valueOf(a + b);
                case "SUB" -> String.valueOf(a - b);
                case "MUL" -> String.valueOf(a * b);
                case "DIV" -> (b != 0) ? String.valueOf(a / b) : "Ошибка: деление на ноль";
                default -> "Ошибка: неизвестная операция";
            };
        } catch (Exception e) {
            return "Ошибка: неверный формат";
        }
    }
}
