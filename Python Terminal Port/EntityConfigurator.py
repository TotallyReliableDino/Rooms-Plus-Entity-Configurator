def get_user_input(prompt):
    return input(prompt).strip()

def get_boolean_input(prompt):
    while True:
        try:
            value = int(input(prompt + " (1 for true, 0 for false): ").strip())
            if value in [0, 1]:
                return bool(value)
            else:
                print("Invalid input. Please enter 1 for true or 0 for false.")
        except ValueError:
            print("Invalid input. Please enter 1 for true or 0 for false.")

def get_int_input(prompt):
    while True:
        try:
            return int(input(prompt).strip())
        except ValueError:
            print("Invalid input. Please enter an integer.")

def main():
    nearSoundID = get_user_input("Enter NearSoundID (rbxassetid://...): ")
    spawnNextRoom = get_boolean_input("Should SpawnNextRoom be true?")
    entityName = get_user_input("Enter EntityName: ")
    pointLightColor = get_user_input("Enter PointLightColor (R, G, B): ")
    chasePlayers = get_boolean_input("Should ChasePlayers be true?")
    minRebounds = get_int_input("Enter MinRebounds: ")
    imageID = get_user_input("Enter ImageID (rbxassetid://...): ")
    farSoundID = get_user_input("Enter FarSoundID (rbxassetid://...): ")
    waitTime = get_int_input("Enter WaitTime: ")
    speed = get_int_input("Enter Speed: ")
    maxRebounds = get_int_input("Enter MaxRebounds: ")
    deathMessage = get_user_input("Enter DeathMessage: ")
    roughness = get_int_input("Enter Roughness: ")
    fadeOut = get_int_input("Enter FadeOut: ")
    farSoundVol = get_int_input("Enter FarSoundVol: ")
    farSoundSpeed = get_int_input("Enter FarSoundSpeed: ")
    magnitude = get_int_input("Enter Magnitude: ")
    fadeIn = get_int_input("Enter FadeIn: ")
    lightBrightness = get_int_input("Enter LightBrightness: ")
    nearSoundSpeed = get_int_input("Enter NearSoundSpeed: ")
    nearSoundVol = get_int_input("Enter NearSoundVol: ")
    killRange = get_int_input("Enter KillRange: ")
    lightRange = get_int_input("Enter LightRange: ")
    reboundTime = get_int_input("Enter ReboundTime: ")

    lua_code = f'''
local args = {{
    [1] = {{
        ["FadeOut"] = {fadeOut},
        ["MinRebounds"] = {minRebounds},
        ["FarSoundVol"] = {farSoundVol},
        ["EntityName"] = "{entityName}",
        ["FarSoundSpeed"] = {farSoundSpeed},
        ["Magnitude"] = {magnitude},
        ["Speed"] = {speed},
        ["Roughness"] = {roughness},
        ["NearSoundID"] = "{nearSoundID}",
        ["PointLightColor"] = Color3.new({pointLightColor}),
        ["MaxRebounds"] = {maxRebounds},
        ["FadeIn"] = {fadeIn},
        ["LightBrightness"] = {lightBrightness},
        ["NearSoundSpeed"] = {nearSoundSpeed},
        ["NearSoundVol"] = {nearSoundVol},
        ["ChasePlayers"] = {str(chasePlayers).lower()},
        ["KillRange"] = {killRange},
        ["ImageID"] = "{imageID}",
        ["FarSoundID"] = "{farSoundID}",
        ["SpawnNextRoom"] = {str(spawnNextRoom).lower()},
        ["WaitTime"] = {waitTime},
        ["LightRange"] = {lightRange},
        ["DeathMessage"] = "{deathMessage}",
        ["ReboundTime"] = {reboundTime}
    }}
}}

game:GetService("ReplicatedStorage"):WaitForChild("Bricks"):WaitForChild("CreateEntityNew"):FireServer(unpack(args))
    '''

    print("\nGenerated Lua Code:")
    print(lua_code)

if __name__ == "__main__":
    main()
