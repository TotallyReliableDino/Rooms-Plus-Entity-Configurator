#include <iostream>
#include <string>
#include <limits> // Include for numeric_limits

using namespace std;

string getUserInput(const string& prompt) {
    string input;
    cout << prompt;
    getline(cin, input);
    return input;
}

bool getBooleanInput(const string& prompt) {
    while (true) {
        int value;
        cout << prompt << " (1 for true, 0 for false): ";
        cin >> value;
        if (value == 0 || value == 1) {
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Clear the input buffer
            return static_cast<bool>(value);
        } else {
            cout << "Invalid input. Please enter 1 for true or 0 for false." << endl;
            cin.clear(); // Clear error flags
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Discard incorrect input
        }
    }
}

int getIntInput(const string& prompt) {
    while (true) {
        int value;
        cout << prompt;
        cin >> value;
        if (cin.fail()) {
            cout << "Invalid input. Please enter an integer." << endl;
            cin.clear(); // Clear error flags
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Discard incorrect input
        } else {
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Clear the input buffer
            return value;
        }
    }
}

void generateLuaCode() {
    string nearSoundID = getUserInput("Enter NearSoundID (rbxassetid://...): ");
    bool spawnNextRoom = getBooleanInput("Should SpawnNextRoom be true?");
    string entityName = getUserInput("Enter EntityName: ");
    string pointLightColor = getUserInput("Enter PointLightColor (R, G, B): ");
    bool chasePlayers = getBooleanInput("Should ChasePlayers be true?");
    int minRebounds = getIntInput("Enter MinRebounds: ");
    string imageID = getUserInput("Enter ImageID (rbxassetid://...): ");
    string farSoundID = getUserInput("Enter FarSoundID (rbxassetid://...): ");
    int waitTime = getIntInput("Enter WaitTime: ");
    int speed = getIntInput("Enter Speed: ");
    int maxRebounds = getIntInput("Enter MaxRebounds: ");
    string deathMessage = getUserInput("Enter DeathMessage: ");
    int roughness = getIntInput("Enter Roughness: ");
    int fadeOut = getIntInput("Enter FadeOut: ");
    int farSoundVol = getIntInput("Enter FarSoundVol: ");
    int farSoundSpeed = getIntInput("Enter FarSoundSpeed: ");
    int magnitude = getIntInput("Enter Magnitude: ");
    int fadeIn = getIntInput("Enter FadeIn: ");
    int lightBrightness = getIntInput("Enter LightBrightness: ");
    int nearSoundSpeed = getIntInput("Enter NearSoundSpeed: ");
    int nearSoundVol = getIntInput("Enter NearSoundVol: ");
    int killRange = getIntInput("Enter KillRange: ");
    int lightRange = getIntInput("Enter LightRange: ");
    int reboundTime = getIntInput("Enter ReboundTime: ");

    // Generate Lua code
    cout << "\nGenerated Lua Code:" << endl;
    cout << "local args = {" << endl;
    cout << "    [1] = {" << endl;
    cout << "        [\"FadeOut\"] = " << fadeOut << "," << endl;
    cout << "        [\"MinRebounds\"] = " << minRebounds << "," << endl;
    cout << "        [\"FarSoundVol\"] = " << farSoundVol << "," << endl;
    cout << "        [\"EntityName\"] = \"" << entityName << "\"," << endl;
    cout << "        [\"FarSoundSpeed\"] = " << farSoundSpeed << "," << endl;
    cout << "        [\"Magnitude\"] = " << magnitude << "," << endl;
    cout << "        [\"Speed\"] = " << speed << "," << endl;
    cout << "        [\"Roughness\"] = " << roughness << "," << endl;
    cout << "        [\"NearSoundID\"] = \"" << nearSoundID << "\"," << endl;
    cout << "        [\"PointLightColor\"] = Color3.new(" << pointLightColor << ")," << endl;
    cout << "        [\"MaxRebounds\"] = " << maxRebounds << "," << endl;
    cout << "        [\"FadeIn\"] = " << fadeIn << "," << endl;
    cout << "        [\"LightBrightness\"] = " << lightBrightness << "," << endl;
    cout << "        [\"NearSoundSpeed\"] = " << nearSoundSpeed << "," << endl;
    cout << "        [\"NearSoundVol\"] = " << nearSoundVol << "," << endl;
    cout << "        [\"ChasePlayers\"] = " << (chasePlayers ? "true" : "false") << "," << endl;
    cout << "        [\"KillRange\"] = " << killRange << "," << endl;
    cout << "        [\"ImageID\"] = \"" << imageID << "\"," << endl;
    cout << "        [\"FarSoundID\"] = \"" << farSoundID << "\"," << endl;
    cout << "        [\"SpawnNextRoom\"] = " << (spawnNextRoom ? "true" : "false") << "," << endl;
    cout << "        [\"WaitTime\"] = " << waitTime << "," << endl;
    cout << "        [\"LightRange\"] = " << lightRange << "," << endl;
    cout << "        [\"DeathMessage\"] = \"" << deathMessage << "\"," << endl;
    cout << "        [\"ReboundTime\"] = " << reboundTime << endl;
    cout << "    }" << endl;
    cout << "};" << endl;
    cout << "game:GetService(\"ReplicatedStorage\"):WaitForChild(\"Bricks\"):WaitForChild(\"CreateEntityNew\"):FireServer(unpack(args));" << endl;
}

int main() {
    generateLuaCode();
    return 0;
}
