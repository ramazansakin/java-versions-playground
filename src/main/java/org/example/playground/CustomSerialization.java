package org.example.playground;

import java.io.*;
import java.util.concurrent.*;

public class CustomSerialization {

    private CustomSerialization() {
        // Do nothing to prevent warnings
    }

    public static class CustomSerializableClass implements Serializable {
        private static final long serialVersionUID = 1L;

        private int id;
        private String name;
        private transient String password;  // transient fields are not serialized

        public CustomSerializableClass(int id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
        }

        // Custom serialization logic
        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.defaultWriteObject(); // default serialization for non-transient fields
            oos.writeObject(encrypt(password)); // encrypt password before serialization
        }

        // Custom deserialization logic
        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ois.defaultReadObject(); // default deserialization for non-transient fields
            this.password = decrypt((String) ois.readObject()); // decrypt password after deserialization
        }

        // Example encryption method (placeholder logic)
        private String encrypt(String input) {
            return new StringBuilder(input).reverse().toString();
        }

        // Example decryption method (placeholder logic)
        private String decrypt(String input) {
            return new StringBuilder(input).reverse().toString();
        }

        @Override
        public String toString() {
            return "CustomSerializableClass{id=" + id + ", name='" + name + "', password='" + password + "'}";
        }

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            CustomSerializableClass original = new CustomSerializableClass(1, "John Doe", "secret123");

            // Serialize the object
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(original);

            // Deserialize the object
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            CustomSerializableClass deserialized = (CustomSerializableClass) in.readObject();

            System.out.println("Deserialized Object: " + deserialized);
        }

    }

    public void testExecutorService(String[] args) {

        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            Runnable task1 = () -> System.out.println("Task 1 executed by " + Thread.currentThread().getName());

            Callable<Integer> task2 = () -> {
                System.out.println("Task 2 executed by " + Thread.currentThread().getName());
                return 42;
            };

            executor.execute(task1);
            Future<Integer> future = executor.submit(task2);

            try {
                Integer result = future.get();
                System.out.println("Result from task 2: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }

            executor.shutdown();
        }
    }

}