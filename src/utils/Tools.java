package utils;

import java.util.Scanner;

public class Tools {

    private static Scanner sc = new Scanner(System.in);

    public static String getCDName(boolean mayEmpty) {
        String cdName = "";

        while (true) {
            System.out.print("Enter the Collection name [game, movie, music]: ");
            cdName = sc.nextLine();
            if (cdName.isEmpty()) {
                if (!mayEmpty) {
                    System.out.println("Can't empty!");
                } else {
                    return cdName;
                }
            } else {
                if (!cdName.equalsIgnoreCase("game")
                        && !cdName.equalsIgnoreCase("movie")
                        && !cdName.equalsIgnoreCase("music")) {
                    System.out.println("Please enter right Coolection name [game, movie, music]!");
                } else {
                    break;
                }
            }
        }

        return cdName;
    }

    public static String getCDType(boolean mayEmpty) {
        String cdType = "";

        while (true) {
            System.out.print("Enter the CD type [audio, video]: ");
            cdType = sc.nextLine();
            if (cdType.isEmpty()) {
                if (!mayEmpty) {
                    System.out.println("Can't empty!");
                } else {
                    return cdType;
                }
            } else {
                if (!cdType.equalsIgnoreCase("audio")
                        && !cdType.equalsIgnoreCase("video")) {
                    System.out.println("Please enter right CD type [audio, video]!");
                } else {
                    break;
                }
            }
        }

        return cdType;
    }

    public static String getString(String msg, boolean mayEmpty) {
        String result = null;
        while (true) {
            try {
                System.out.print(msg);
                result = sc.nextLine();
                if (result.isEmpty()) {
                    if (!mayEmpty) {
                        System.out.println("Can't empty.");
                    } else {
                        return result;
                    }
                } else {
                    break;
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again!");
            }
        }
        return result;
    }

    public static int getInt(String msg, int min, int max) {
        int result = Integer.MIN_VALUE;
        while (result < min || result > max) {
            try {
                System.out.print(msg + "(from " + min + " to " + max + "): ");
                result = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again!");
            }
        }
        return result;
    }

    public static int getInt(String msg) {
        int result = Integer.MIN_VALUE;
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Try again!");
            }
        }
    }

    public static int getYear() {
        int result = Integer.MIN_VALUE;
        while (result < 1000 || result > 2022) {
            try {
                System.out.print("Enter CD's Publish year: ");
                result = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Try again!");
            }
        }
        return result;
    }
}
