#include <iostream>
#include <sstream>

// Function declarations
std::string getUserInput(const std::string& prompt);
bool getBooleanInput(const std::string& prompt);
int getIntInput(const std::string& prompt);

// Function to get user input
std::string getUserInput(const std::string& prompt) {
    std::string input;
    std::cout << prompt;
    std::getline(std::cin, input);
    return input;
}

// Function to get boolean input (1 for true, 0 for false)
bool getBooleanInput(const std::string& prompt) {
    int choice;
    while (true) {
        std::cout << prompt;
        std::string input;
        std::getline(std::cin, input);
        std::stringstream ss(input);
        if (ss >> choice && (choice == 0 || choice == 1)) {
            return choice == 1;
        } else {
            std::cout << "Invalid input. Please enter 1 for yes or 0 for no." << std::endl;
        }
    }
}

// Function to get integer input
int getIntInput(const std::string& prompt) {
    int value;
    while (true) {
        std::cout << prompt;
        std::string input;
        std::getline(std::cin, input);
        std::stringstream ss(input);
        if (ss >> value) {
            return value;
        } else {
            std::cout << "Invalid input. Please enter a valid integer." << std::endl;
        }
    }
}

int main() {
    std::string nearSoundID, entityName, pointLightColor, imageID, farSoundID, deathMessage;
    bool spawnNextRoom, chasePlayers;
    int minRebounds, waitTime, speed, maxRebounds, roughness;

    nearSoundID = getUserInput("Enter NearSoundID (rbxassetid://...): ");
    spawnNextRoom = getBooleanInput("Should SpawnNextRoom be true? (1 for yes, 0 for no): ");
    entityName = getUserInput("Enter EntityName: ");
    pointLightColor = getUserInput("Enter PointLightColor (R, G, B): ");
    chasePlayers = getBooleanInput("Should ChasePlayers be true? (1 for yes, 0 for no): ");
    minRebounds = getIntInput("Enter MinRebounds: ");
    imageID = getUserInput("Enter ImageID (rbxassetid://...): ");
    farSoundID = getUserInput("Enter FarSoundID (rbxassetid://...): ");
    waitTime = getIntInput("Enter WaitTime: ");
    speed = getIntInput("Enter Speed: ");
    maxRebounds = getIntInput("Enter MaxRebounds: ");
    deathMessage = getUserInput("Enter DeathMessage: ");
    roughness = getIntInput("Enter Roughness: ");

    std::cout << "\nGenerated Lua Code:" << std::endl;
    std::cout << "local args = {" << std::endl;
    std::cout << "    [1] = {" << std::endl;
    std::cout << "        [\"NearSoundID\"] = \"" << nearSoundID << "\"," << std::endl;
    std::cout << "        [\"SpawnNextRoom\"] = " << (spawnNextRoom ? "true" : "false") << "," << std::endl;
    std::cout << "        [\"EntityName\"] = \"" << entityName << "\"," << std::endl;
    std::cout << "        [\"PointLightColor\"] = Color3.new(" << pointLightColor << ")," << std::endl;
    std::cout << "        [\"ChasePlayers\"] = " << (chasePlayers ? "true" : "false") << "," << std::endl;
    std::cout << "        [\"MinRebounds\"] = " << minRebounds << "," << std::endl;
    std::cout << "        [\"ImageID\"] = \"" << imageID << "\"," << std::endl;
    std::cout << "        [\"FarSoundID\"] = \"" << farSoundID << "\"," << std::endl;
    std::cout << "        [\"WaitTime\"] = " << waitTime << "," << std::endl;
    std::cout << "        [\"Speed\"] = " << speed << "," << std::endl;
    std::cout << "        [\"MaxRebounds\"] = " << maxRebounds << "," << std::endl;
    std::cout << "        [\"DeathMessage\"] = \"" << deathMessage << "\"," << std::endl;
    std::cout << "        [\"Roughness\"] = " << roughness << std::endl;
    std::cout << "    }" << std::endl;
    std::cout << "}" << std::endl;
    std::cout << "\ngame:GetService(\"ReplicatedStorage\"):WaitForChild(\"Bricks\"):WaitForChild(\"CreateEntityNew\"):FireServer(unpack(args))" << std::endl;

    return 0;
}