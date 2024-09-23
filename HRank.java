package vishalP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HRank {
	

			public static void main(String[] args) {
				 List<String> l = new ArrayList<>();
			        List<String> l1 = new ArrayList<>(List.of("Byte", "Short", "Int", "Long"));

			        Scanner sc = new Scanner(System.in);
			        int t = sc.nextInt();
			        sc.nextLine(); // Consume the newline character after the integer input

			        for (int i = 0; i < t; i++) {
			            String user = sc.nextLine();
			            l.add(user);
			        }

			        for (String value : l) {
			            try {
			                long num = Long.parseLong(value); // Parse once
			                List<String> fittingTypes = new ArrayList<>();

			                // Check if value fits in Byte
			                if (num >= Byte.MIN_VALUE && num <= Byte.MAX_VALUE) {
			                    fittingTypes.add("Byte");
			                }

			                // Check if value fits in Short
			                if (num >= Short.MIN_VALUE && num <= Short.MAX_VALUE) {
			                    fittingTypes.add("Short");
			                }

			                // Check if value fits in Integer
			                if (num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE) {
			                    fittingTypes.add("Int");
			                }

			                // Check if value fits in Long
			                if (num >= Long.MIN_VALUE && num <= Long.MAX_VALUE) {
			                    fittingTypes.add("Long");
			                }

			                // Print results
			                if (!fittingTypes.isEmpty()) {
			                    System.out.print(num + " can be fitted in:\n");
			                    for (String type : fittingTypes) {
			                        System.out.println("* " + type);
			                    }
			                } else {
			                    System.out.println(num + " can't be fitted anywhere.");
			                }
			            } catch (NumberFormatException e) {
			                System.out.println(value + " can't be fitted anywhere.");
			            }
			        }

			        sc.close();
			    }
			}