<#
init-javafx-project.ps1
Create a new JavaFX project scaffold in a given folder. Copies a reusable .vscode/tasks.json and .vscode/launch.json
and creates src, bin, lib folders and a sample Main.java.

Usage:
  .\init-javafx-project.ps1 -ProjectPath C:\path\to\newproject -MainClass MyApp

If you omit -ProjectPath the script will prompt. The script does NOT download JavaFX jars; it expects you to place JavaFX jars in the new project's lib folder or set your own global JavaFX SDK path in the generated launch.json.
#>
param(
    [string]$ProjectPath,
    [string]$MainClass = "Main"
)

if (-not $ProjectPath) {
    $ProjectPath = Read-Host "Enter new project path (absolute). Example: C:\dev\MyJavaFXApp"
}

$proj = (Resolve-Path -Path $ProjectPath -ErrorAction SilentlyContinue)
if (-not $proj) {
    New-Item -ItemType Directory -Path $ProjectPath -Force | Out-Null
}

# Create standard folders
New-Item -ItemType Directory -Path (Join-Path $ProjectPath "src") -Force | Out-Null
New-Item -ItemType Directory -Path (Join-Path $ProjectPath "bin") -Force | Out-Null
New-Item -ItemType Directory -Path (Join-Path $ProjectPath "lib") -Force | Out-Null
New-Item -ItemType Directory -Path (Join-Path $ProjectPath ".vscode") -Force | Out-Null

# Create a sample Main.java in src
$mainJavaPath = Join-Path $ProjectPath "src\$MainClass.java"
if (-not (Test-Path $mainJavaPath)) {
    @"
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class $MainClass extends Application {
    @Override
    public void start(Stage primaryStage) {
        var root = new StackPane(new Label("Hello JavaFX"));
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.setTitle("$MainClass");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
"@ | Set-Content -Path $mainJavaPath -Encoding UTF8
    Write-Host "Created sample $MainClass.java"
} else {
    Write-Host "Main.java already exists at $mainJavaPath, skipping sample creation."
}

# Create .vscode/tasks.json (compiles all java sources)
$tasksJson = @'
{
  "version": "2.0.0",
  "tasks": [
    {
      "label": "javac: compile all",
      "type": "shell",
      "command": "powershell",
      "args": [
        "-NoProfile",
        "-Command",
        "Get-ChildItem -Path src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName | Out-File -FilePath sources.txt -Encoding UTF8; javac -d \"$PWD\\bin\" -cp \"$PWD\\lib\\*\" @sources.txt; Remove-Item sources.txt"
      ],
      "group": { "kind": "build", "isDefault": true },
      "presentation": { "echo": true, "reveal": "always", "panel": "shared" }
    }
  ]
}
'@

Set-Content -Path (Join-Path $ProjectPath ".vscode\tasks.json") -Value $tasksJson -Encoding UTF8
Write-Host "Wrote .vscode/tasks.json"

# Create .vscode/launch.json (uses workspace lib for module-path)
$launchJson = @'
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Run (JavaFX)",
      "request": "launch",
      "mainClass": "${fileBasenameNoExtension}",
      "preLaunchTask": "javac: compile all",
      "vmArgs": "--module-path ${workspaceFolder}/lib --add-modules javafx.controls,javafx.graphics,javafx.fxml,javafx.base"
    }
  ]
}
'@

Set-Content -Path (Join-Path $ProjectPath ".vscode\launch.json") -Value $launchJson -Encoding UTF8
Write-Host "Wrote .vscode/launch.json"

Write-Host "Project scaffold created at: $ProjectPath"
Write-Host "Place JavaFX SDK jars in $ProjectPath\lib or adjust the vmArgs in .vscode\launch.json to point to your global JavaFX SDK."
Write-Host "Open the folder in VS Code and press F5 (Run) to compile+run."
