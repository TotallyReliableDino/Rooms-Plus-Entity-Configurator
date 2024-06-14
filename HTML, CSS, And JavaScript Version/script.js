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

            // New inputs
            var fadeOut = parseInt(document.getElementById('FadeOut').value.trim());
            var farSoundVol = parseInt(document.getElementById('FarSoundVol').value.trim());
            var farSoundSpeed = parseInt(document.getElementById('FarSoundSpeed').value.trim());
            var magnitude = parseInt(document.getElementById('Magnitude').value.trim());
            var fadeIn = parseInt(document.getElementById('FadeIn').value.trim());
            var lightBrightness = parseInt(document.getElementById('LightBrightness').value.trim());
            var nearSoundSpeed = parseInt(document.getElementById('NearSoundSpeed').value.trim());
            var nearSoundVol = parseInt(document.getElementById('NearSoundVol').value.trim());
            var killRange = parseInt(document.getElementById('KillRange').value.trim());
            var lightRange = parseInt(document.getElementById('LightRange').value.trim());
            var reboundTime = parseInt(document.getElementById('ReboundTime').value.trim());

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
        ["Roughness"] = ${roughness},
        ["FadeOut"] = ${fadeOut},
        ["FarSoundVol"] = ${farSoundVol},
        ["FarSoundSpeed"] = ${farSoundSpeed},
        ["Magnitude"] = ${magnitude},
        ["FadeIn"] = ${fadeIn},
        ["LightBrightness"] = ${lightBrightness},
        ["NearSoundSpeed"] = ${nearSoundSpeed},
        ["NearSoundVol"] = ${nearSoundVol},
        ["KillRange"] = ${killRange},
        ["LightRange"] = ${lightRange},
        ["ReboundTime"] = ${reboundTime}
    }
}

game:GetService("ReplicatedStorage"):WaitForChild("Bricks"):WaitForChild("CreateEntityNew"):FireServer(unpack(args))
            `;

            document.getElementById('generatedCode').innerText = luaCode;
}
