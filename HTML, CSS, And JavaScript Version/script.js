function generateLuaCode() {
    var nearSoundID = document.getElementById('NearSoundID').value.trim();
    var spawnNextRoom = document.getElementById('SpawnNextRoom').checked;
    var entityName = document.getElementById('EntityName').value.trim();
    var pointLightColor = document.getElementById('PointLightColor').value.trim();
    var chasePlayers = document.getElementById('ChasePlayers').checked;
    var minRebounds = parseInt(document.getElementById('MinRebounds').value.trim());
    var imageID = document.getElementById('ImageID').value.trim();
    var farSoundID = document.getElementById('FarSoundID').value.trim();
    var waitTime = parseInt(document.getElementById('WaitTime').value.trim());
    var speed = parseInt(document.getElementById('Speed').value.trim());
    var maxRebounds = parseInt(document.getElementById('MaxRebounds').value.trim());
    var deathMessage = document.getElementById('DeathMessage').value.trim();
    var roughness = parseInt(document.getElementById('Roughness').value.trim());

    var luaCode = `
local args = {
    [1] = {
        ["NearSoundID"] = "${nearSoundID}",
        ["SpawnNextRoom"] = ${spawnNextRoom},
        ["EntityName"] = "${entityName}",
        ["PointLightColor"] = Color3.new(${pointLightColor}),
        ["ChasePlayers"] = ${chasePlayers},
        ["MinRebounds"] = ${minRebounds},
        ["ImageID"] = "${imageID}",
        ["FarSoundID"] = "${farSoundID}",
        ["WaitTime"] = ${waitTime},
        ["Speed"] = ${speed},
        ["MaxRebounds"] = ${maxRebounds},
        ["DeathMessage"] = "${deathMessage}",
        ["Roughness"] = ${roughness}
    }
}

game:GetService("ReplicatedStorage"):WaitForChild("Bricks"):WaitForChild("CreateEntityNew"):FireServer(unpack(args))
    `;

    document.getElementById('generatedCode').innerText = luaCode;
}