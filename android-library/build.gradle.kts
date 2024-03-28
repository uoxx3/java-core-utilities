import publish.createFromSpec
import publish.getProjectInfo
import kotlin.jvm.optionals.getOrNull

plugins {
  alias(libs.plugins.com.android.library)
}

/* -----------------------------------------------------
 * Project configuration
 * ----------------------------------------------------- */

val projectSpec = getProjectInfo()
group = projectSpec.group
version = projectSpec.version

/* -----------------------------------------------------
 * Android configuration
 * ----------------------------------------------------- */

android {
  namespace = projectSpec.group
  compileSdk = 34
  
  defaultConfig {
    minSdk = 24
    
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }
  
  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }
  
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  
  publishing {
    singleVariant("release") {
      withJavadocJar()
      withSourcesJar()
    }
  }
}

/* -----------------------------------------------------
 * Maven publications
 * ----------------------------------------------------- */

afterEvaluate {
  publishing.publications {
    // Generate maven publications
    createFromSpec(projectSpec, project)
  }
  
  signing {
    // Sign all publications
    useInMemoryPgpKeys(
      projectEnv["SIGNING_USER_ID"].getOrNull(),
      projectEnv["SIGNING_USER_PGP_KEY"].getOrNull(),
      projectEnv["SIGNING_USER_PASSWORD"].getOrNull())
    
    sign(publishing.publications)
  }
}

/* -----------------------------------------------------
 * Project dependencies
 * ----------------------------------------------------- */

dependencies {
  implementation(libs.android.com.android.annotation)
  implementation(libs.android.com.android.compat)
  implementation(libs.android.com.android.material)
  
  // Java resting
  testImplementation(platform(libs.java.org.junit.jupiter.bom))
  testImplementation(libs.java.org.junit.jupiter.jupiter)
  
  // Android testing
  androidTestImplementation(libs.android.com.android.test.junit)
  androidTestImplementation(libs.android.com.android.test.espresso)
}