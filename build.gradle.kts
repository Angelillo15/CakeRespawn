plugins {
  id("java")
  id("net.minecrell.plugin-yml.paper") version "0.6.0"
  id("xyz.jpenilla.run-paper") version "2.3.0"
}

group = "com.nookure.cakerespawn"
version = "1.0.0"

repositories {
  mavenCentral()
  maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
  compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}

paper {
  name = "CakeRespawn"
  version = project.version as String
  author = "Angelillo15"
  apiVersion = "1.19"
  main = "com.nookure.cakerespawn.CakeRespawn"
}

tasks {
  runServer {
    minecraftVersion("1.20.4")
  }
}