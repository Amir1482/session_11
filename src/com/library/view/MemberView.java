package com.library.view;

import com.library.controller.MemberController;

import java.util.Scanner;

public class MemberView {
    private static final Scanner scanner = new Scanner(System.in);

    private static int showMenu() {
        System.out.println("1)Add");
        System.out.println("2)Edit");
        System.out.println("3)Remove");
        System.out.println("4)FindAll");
        System.out.println("0)Exit");
        return Integer.parseInt(getText("Enter Option : "));
    }

    private static String getText(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public static void show() {
        while (true) {
            int opt = showMenu();

            if (opt == 0) {
                break;
            }

            switch (opt) {
                case 1:
                    String name = getText("Enter Name : ");
                    String family = getText("Enter Family : ");
                    String gender = getText("Enter Gender(Male/Female) : ");
                    String date = getText("Enter Birth Date : ");
                    System.out.println(MemberController.save(name, family, gender, date));
                    break;

                case 4:
                    System.out.println(MemberController.findAll());

                default:
                    System.out.println("Invalid Option");
            }
            System.out.println("---------------------------------------------------------------------");
        }
    }
}
