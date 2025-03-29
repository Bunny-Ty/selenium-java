package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //bài 1
        System.out.println(checkEvenOrOdd(10));
        //bài 2
        System.out.println(isLeapYear(2025));
        //bài 3
        System.out.println(getSum(1));
        System.out.println(getSum(9));
        System.out.println(getSum(30));
        System.out.println(getSum(0));
        //bài 4
        inBangCuuChuong();
        //bài 5
        System.out.println(getMax(1, 2, 3));
        System.out.println(getMax(3, 3, 3));
        System.out.println(getMax(2, 1, 0));
        System.out.println(getMax(1, 1, 2));
        //bài 6
        System.out.println(capitalize("trường em xinh đẹp"));

        /** bài tập 7
         * given an array = [34, 1, 23, 44, 3, 12, 45, 33, 6, 22]
         * find max item, out put: 45
         */
        Integer[] arr = {34, 1, 23, 44, 3, 12, 45, 33, 6, 22};
        int max = Arrays.stream(arr)
                .max(Comparator.naturalOrder())
                .get();
        System.out.println(max);

        /** bài tập 8
         * Viết 1 chương trình tính tổng của 1 mãng số nguyên cho trước {34, 1, 23, 44, 3, 12, 45, 33, 6, 22}
         */
        int sum = Arrays.stream(arr)
                .reduce(0, Integer::sum);
        System.out.println(sum);

        /** bài tập 9
         * Viết 1 chương trình tìm ra những số <=30 trong mãng số nguyên cho trước {34, 1, 23, 44, 3, 12, 45, 33, 6, 22}
         * mapping array to List
         * int vs Integer
         */
        List<Integer> subList = Arrays.stream(arr)
                .filter(i->i<=30)
                .toList();
        Arrays.stream(arr)
                .map(i->i.toString())
                .toList();

        //bài tập 10
        List<HocSinh> classrom = new ArrayList<HocSinh>();
        //random score from 1 to 10 in double
        for (int i = 0; i < 10; i++) {
            classrom.add(new HocSinh(randomName(), randomAge(), randomScore()));
        }
        classrom.stream().forEach(HocSinh::info);
        //in ra thông tin của các học sinh xuất sắc
//        classrom.stream()
//                .filter(hocSinh -> hocSinh.rate() == Rating.XUAT_SAC)
//                .forEach(HocSinh::info);
//        //in ra tên của các học sinh có tuổi >=20
//        classrom.stream()
//                .filter(hocSinh -> hocSinh.getAge() >= 20)
//                .map(HocSinh::getName)
//                .forEach(System.out::println);
        classrom.stream()
                .max(Comparator.comparing(HocSinh::getScore))
                .get()
                .info();

    }

    /**
     * bài tập 1
     * write method to  get the interger and return the number is even or odd
     */
    public static String checkEvenOrOdd(int number) {
        return (number % 2 == 0) ? "Even" : "Odd";
    }

    /**
     * bài tập 2
     * viết 1 method kiểm tra nhập vào 1 số nguyên là năm, kiểm tra năm đó là năm nhuận hay không?
     * Năm nhuận là năm chia hết cho 4 nhưng không chia hết cho 100 hoặc chia hết cho 400
     */
    public static boolean isLeapYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year must be greater than 0"); //trong trường hợp năm âm sẽ báo lỗi
        }
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * bài tập 3
     * Viết 1 chương trình tính tiền taxi từ số km nhập vào
     * km đầu tiên 13000
     * từ km th 2 cho tới km 10: 10000/km
     * từ km th 11 trở đi: 8000/km
     */
    public static Float getSum(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Iinvalid km");
        }
        float toal = 0;
        int firstKm = 13000;
        int between2kmto10km = 10000;
        int after10km = 8000;
        if (km == 1) {
            toal += firstKm;
        } else if (km <= 10) {
            toal += firstKm + (km - 1) * between2kmto10km;
        } else {
            toal += firstKm + 9 * between2kmto10km + (km - 10) * after10km;
        }
        return toal;
    }

    /**
     * bài tập 4
     * In ra màn hình bảng cửu chương từ 1 đến 10
     *
     * @param //args
     */
    public static void inBangCuuChuong() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Bảng cửu chương %d:\n", i); // In tiêu đề bảng cửu chương
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d x %d = %d\n", i, j, i * j); // Sử dụng printf để định dạng
            }
            System.out.println("===================================="); // Dòng phân cách
        }
    }

    /**
     * bài tập 5
     * viết một chương trình tìm số lớn nhất từ 3 số nguyên a, b, c
     */
    public static int getMax(int a, int b, int c) {
        int assumeMax = a;
        if (b > assumeMax) {
            assumeMax = b;
        }
        if (c > assumeMax) {
            assumeMax = c;
        }
        return assumeMax;
    }
    /** bài tập 6
     * Viết 1 chương trình viết hoa các ký tự đầu tiên của mỗi từ trong chuỗi
     * Ví dụ: trường em xinh đẹp --> Trường Em Xinh Đẹp
     */
    public static String capitalize(String input) {
        if (input==null || input.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result
                    .append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1))
                    .append(" ");
        }
        return result.toString().trim();
    }

    /** bài tập 10
     * Viết chương trình để tạo một lớp học sinh
     * Giải thích đề bài
     * Bài tập yêu cầu bạn viết 1 chương trình để tạo một lớp học sinh
     * Lớp này chứa các thuộc tính và phương thức để mô tả và thao tác với các đối tượng học sinh
     * Các thuộc tính cơ bản của học sinh bao gồm: tên, tuổi, giới tính, điểm trung bình
     * Và các phương thức để hiển thị thông tin học sinh hoặc tính toán các giá trị đó:
     - Điểm trung bình >= 9.0: Xuất sắc
     - Điểm trung bình >= 8.0: Giỏi
     - Điểm trung bình >= 6.5: Khá
     - Điểm trung bình >= 5.0: Trung bình
     - Điểm trung bình < 5.0: Yếu

     Steps:
     Tạo 1 danh sách học sinh với 10 bạn
     */

    public static String randomName() {
        String[] names = {"Huong", "Anh", "Mai", "Doti", "Hoa", "Nhu", "Hong", "Khanh", "Tien", "Phuong"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    public static int randomAge() {
        Random random = new Random();
        return random.nextInt(25 - 18 + 1) + 18;
    }

    public static double randomScore() {
        Random random = new Random();
        double score = 1.0 + 9.0 * random.nextDouble();
        return Math.round(score * 10) / 10.0;
    }




}
