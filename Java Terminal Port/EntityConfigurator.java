import java.util.Scanner;

public class EntityConfigurator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for inputs
        String nearSoundID = getStringInput(scanner, "Enter NearSoundID (rbxassetid://...): ");
        boolean spawnNextRoom = getBooleanInput(scanner, "Should SpawnNextRoom be true? (1 for yes, 0 for no): ");
        String entityName = getStringInput(scanner, "Enter EntityName: ");
        int[] pointLightColor = getIntArrayInput(scanner, "Enter PointLightColor (R, G, B): ");
        boolean chasePlayers = getBooleanInput(scanner, "Should ChasePlayers be true? (1 for yes, 0 for no): ");
        int minRebounds = getIntInput(scanner, "Enter MinRebounds: ");
        String imageID = getStringInput(scanner, "Enter ImageID (rbxassetid://...): ");
        String farSoundID = getStringInput(scanner, "Enter FarSoundID (rbxassetid://...): ");
        int waitTime = getIntInput(scanner, "Enter WaitTime: ");
        int speed = getIntInput(scanner, "Enter Speed: ");
        int maxRebounds = getIntInput(scanner, "Enter MaxRebounds: ");
        String deathMessage = getStringInput(scanner, "Enter DeathMessage: ");
        int roughness = getIntInput(scanner, "Enter Roughness: ");

        // New parameters from the update
        int fadeOut = getIntInput(scanner, "Enter FadeOut: ");
        int fadeIn = getIntInput(scanner, "Enter FadeIn: ");
        int lightBrightness = getIntInput(scanner, "Enter LightBrightness: ");
        int nearSoundSpeed = getIntInput(scanner, "Enter NearSoundSpeed: ");
        int nearSoundVol = getIntInput(scanner, "Enter NearSoundVol: ");
        int farSoundVol = getIntInput(scanner, "Enter FarSoundVol: ");
        int farSoundSpeed = getIntInput(scanner, "Enter FarSoundSpeed: ");
        int magnitude = getIntInput(scanner, "Enter Magnitude: ");
        int lightRange = getIntInput(scanner, "Enter LightRange: ");
        int killRange = getIntInput(scanner, "Enter KillRange: ");
        int reboundTime = getIntInput(scanner, "Enter ReboundTime: ");

        // Generate Lua code
        String luaCode = generateLuaCode(nearSoundID, spawnNextRoom, entityName, pointLightColor,
                                         chasePlayers, minRebounds, imageID, farSoundID,
                                         waitTime, speed, maxRebounds, deathMessage, roughness,
                                         fadeOut, fadeIn, lightBrightness, nearSoundSpeed,
                                         nearSoundVol, farSoundVol, farSoundSpeed, magnitude,
                                         lightRange, killRange, reboundTime);

        // Display generated Lua code
        System.out.println("\nGenerated Lua Code:");
        System.out.println(luaCode);
    }

    // Helper methods for input
    private static String getStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static boolean getBooleanInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        int input = getIntInput(scanner, "");
        return input == 1;
    }

    private static int[] getIntArrayInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String[] inputs = scanner.nextLine().split(",");
        int[] values = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            values[i] = Integer.parseInt(inputs[i].trim());
        }
        return values;
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Method to generate Lua code based on inputs
    private static String generateLuaCode(String nearSoundID, boolean spawnNextRoom, String entityName,
                                          int[] pointLightColor, boolean chasePlayers, int minRebounds,
                                          String imageID, String farSoundID, int waitTime, int speed,
                                          int maxRebounds, String deathMessage, int roughness,
                                          int fadeOut, int fadeIn, int lightBrightness, int nearSoundSpeed,
                                          int nearSoundVol, int farSoundVol, int farSoundSpeed, int magnitude,
                                          int lightRange, int killRange, int reboundTime) {
        return String.format(
            "local args = {\n" +
            "    [1] = {\n" +
            "        [\"NearSoundID\"] = \"%s\",\n" +
            "        [\"SpawnNextRoom\"] = %b,\n" +
            "        [\"EntityName\"] = \"%s\",\n" +
            "        [\"PointLightColor\"] = Color3.new(%d, %d, %d),\n" +
            "        [\"ChasePlayers\"] = %b,\n" +
            "        [\"MinRebounds\"] = %d,\n" +
            "        [\"ImageID\"] = \"%s\",\n" +
            "        [\"FarSoundID\"] = \"%s\",\n" +
            "        [\"WaitTime\"] = %d,\n" +
            "        [\"Speed\"] = %d,\n" +
            "        [\"MaxRebounds\"] = %d,\n" +
            "        [\"DeathMessage\"] = \"%s\",\n" +
            "        [\"Roughness\"] = %d,\n" +
            "        [\"FadeOut\"] = %d,\n" +
            "        [\"FadeIn\"] = %d,\n" +
            "        [\"LightBrightness\"] = %d,\n" +
            "        [\"NearSoundSpeed\"] = %d,\n" +
            "        [\"NearSoundVol\"] = %d,\n" +
            "        [\"FarSoundVol\"] = %d,\n" +
            "        [\"FarSoundSpeed\"] = %d,\n" +
            "        [\"Magnitude\"] = %d,\n" +
            "        [\"LightRange\"] = %d,\n" +
            "        [\"KillRange\"] = %d,\n" +
            "        [\"ReboundTime\"] = %d\n" +
            "    }\n" +
            "}\n\n" +
            "game:GetService(\"ReplicatedStorage\"):WaitForChild(\"Bricks\"):WaitForChild(\"CreateEntityNew\"):FireServer(unpack(args));",
            nearSoundID, spawnNextRoom, entityName,
            pointLightColor[0], pointLightColor[1], pointLightColor[2],
            chasePlayers, minRebounds, imageID, farSoundID,
            waitTime, speed, maxRebounds, deathMessage, roughness,
            fadeOut, fadeIn, lightBrightness, nearSoundSpeed,
            nearSoundVol, farSoundVol, farSoundSpeed, magnitude,
            lightRange, killRange, reboundTime);
    }
}
