def main():
    near_sound_id = input("Enter NearSoundID (rbxassetid://...): ").strip()
    spawn_next_room = get_boolean_input("Should SpawnNextRoom be true? (1 for yes, 0 for no): ")
    entity_name = input("Enter EntityName: ").strip()
    point_light_color = input("Enter PointLightColor (R, G, B): ").strip()
    chase_players = get_boolean_input("Should ChasePlayers be true? (1 for yes, 0 for no): ")
    min_rebounds = get_int_input("Enter MinRebounds: ")
    image_id = input("Enter ImageID (rbxassetid://...): ").strip()
    far_sound_id = input("Enter FarSoundID (rbxassetid://...): ").strip()
    wait_time = get_int_input("Enter WaitTime: ")
    speed = get_int_input("Enter Speed: ")
    max_rebounds = get_int_input("Enter MaxRebounds: ")
    death_message = input("Enter DeathMessage: ").strip()
    roughness = get_int_input("Enter Roughness: ")

    print("\nGenerated Lua Code:")
    print(f'local args = {{')
    print(f'    [1] = {{')
    print(f'        ["NearSoundID"] = "{near_sound_id}",')
    print(f'        ["SpawnNextRoom"] = {spawn_next_room},')
    print(f'        ["EntityName"] = "{entity_name}",')
    print(f'        ["PointLightColor"] = Color3.new({point_light_color}),')
    print(f'        ["ChasePlayers"] = {chase_players},')
    print(f'        ["MinRebounds"] = {min_rebounds},')
    print(f'        ["ImageID"] = "{image_id}",')
    print(f'        ["FarSoundID"] = "{far_sound_id}",')
    print(f'        ["WaitTime"] = {wait_time},')
    print(f'        ["Speed"] = {speed},')
    print(f'        ["MaxRebounds"] = {max_rebounds},')
    print(f'        ["DeathMessage"] = "{death_message}",')
    print(f'        ["Roughness"] = {roughness}')
    print(f'    }}')
    print(f'}}')
    print("\ngame:GetService(\"ReplicatedStorage\"):WaitForChild(\"Bricks\"):WaitForChild(\"CreateEntityNew\"):FireServer(unpack(args))")


def get_boolean_input(prompt):
    while True:
        try:
            choice = int(input(prompt).strip())
            if choice == 1:
                return True
            elif choice == 0:
                return False
            else:
                print("Invalid input. Please enter 1 for yes or 0 for no.")
        except ValueError:
            print("Invalid input. Please enter a valid integer (1 or 0).")


def get_int_input(prompt):
    while True:
        try:
            return int(input(prompt).strip())
        except ValueError:
            print("Invalid input. Please enter a valid integer.")


if __name__ == "__main__":
    main()