rootProject.name = "gradle-template-example"
include("kotlin", "java", "spring")

for (project in rootProject.children) {
    project.projectDir = file("modules/${project.name}")
}
