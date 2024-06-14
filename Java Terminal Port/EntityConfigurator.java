import java.util.Scanner;

public class EntityConfigurator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter NearSoundID (rbxassetid://...): ");
        String nearSoundID = scanner.nextLine().trim();

        boolean spawnNextRoom = getBooleanInput(scanner, "Should SpawnNextRoom be true? (1 for yes, 0 for no): ");
        
        System.out.print("Enter EntityName: ");
        String entityName = scanner.nextLine().trim();

        System.out.print("Enter PointLightColor (R, G, B): ");
        String pointLightColor = scanner.nextLine().trim();

        boolean chasePlayers = getBooleanInput(scanner, "Should ChasePlayers be true? (1 for yes, 0 for no): ");
        
        System.out.print("Enter MinRebounds: ");
        int minRebounds = getIntInput(scanner, "Enter MinRebounds: ");

        System.out.print("Enter ImageID (rbxassetid://...): ");
        String imageID = scanner.nextLine().trim();

        System.out.print("Enter FarSoundID (rbxassetid://...): ");
        String farSoundID = scanner.nextLine().trim();

        System.out.print("Enter WaitTime: ");
        int waitTime = getIntInput(scanner, "Enter WaitTime: ");

        System.out.print("Enter Speed: ");
        int speed = getIntInput(scanner, "Enter Speed: ");

        System.out.print("Enter MaxRebounds: ");
        int maxRebounds = getIntInput(scanner, "Enter MaxRebounds: ");

        System.out.print("Enter DeathMessage: ");
        String deathMessage = scanner.nextLine().trim();

        System.out.print("Enter Roughness: ");
        int roughness = getIntInput(scanner, "Enter Roughness: ");

        System.out.println("\nGenerated Lua Code:");
        System.out.println("local args = {");
        System.out.println("    [1] = {");
        System.out.println("        [\"NearSoundID\"] = \"" + nearSoundID + "\",");
        System.out.println("        [\"SpawnNextRoom\"] = " + spawnNextRoom + ",");
        System.out.println("        [\"EntityName\"] = \"" + entityName + "\",");
        System.out.println("        [\"PointLightColor\"] = Color3.new(" + pointLightColor + "),");
        System.out.println("        [\"ChasePlayers\"] = " + chasePlayers + ",");
        System.out.println("        [\"MinRebounds\"] = " + minRebounds + ",");
        System.out.println("        [\"ImageID\"] = \"" + imageID + "\",");
        System.out.println("        [\"FarSoundID\"] = \"" + farSoundID + "\",");
        System.out.println("        [\"WaitTime\"] = " + waitTime + ",");
        System.out.println("        [\"Speed\"] = " + speed + ",");
        System.out.println("        [\"MaxRebounds\"] = " + maxRebounds + ",");
        System.out.println("        [\"DeathMessage\"] = \"" + deathMessage + "\",");
        System.out.println("        [\"Roughness\"] = " + roughness);
        System.out.println("    }");
        System.out.println("}");
        System.out.println("\ngame:GetService(\"ReplicatedStorage\"):WaitForChild(\"Bricks\"):WaitForChild(\"CreateEntityNew\"):FireServer(unpack(args))");
    }

    private static boolean getBooleanInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.equals("1")) {
                return true;
            } else if (input.equals("0")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 1 for yes or 0 for no.");
            }
        }
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}