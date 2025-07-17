package ru.top.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MathClient {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        client.connect(new InetSocketAddress("localhost", 5000)).get();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите операцию (например, ADD 10 5): ");
        String input = scanner.nextLine();

        ByteBuffer buffer = ByteBuffer.wrap(input.getBytes(StandardCharsets.UTF_8));
        client.write(buffer).get();

        ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
        client.read(responseBuffer).get();
        responseBuffer.flip();

        String response = StandardCharsets.UTF_8.decode(responseBuffer).toString();
        System.out.println("Результат от сервера: " + response);

        client.close();
    }
}

