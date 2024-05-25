# Template to build KMP apps with a CLEAN architecture
This template tries to push the following concepts to the maximum extent:
- Separation of concerns and layering following a CLEAN-like architecture
- Gradle convention over configuration (custom plugins reducing duplicated logic)
- Easy scalability
- Type-safe dependency + plugin access centralised in the `libs.versions.toml` file


### Architecture
The project uses a tree-like structure for Gradle projects, grouping them in the following categories:
- `app`
- `data`
- `di`
- `domain`
- `testing`
- `ui`

As a result, `./gradlew projects` shows the following structure:
```
+--- Project ':app'
+--- Project ':data'
|    +--- Project ':data:database'
|    +--- Project ':data:datasource'
|    \--- Project ':data:repositories'
+--- Project ':di'
+--- Project ':domain'
+--- Project ':testing'
|    +--- Project ':testing:core'
|    \--- Project ':testing:test-app'
\--- Project ':ui'
     +--- Project ':ui:core'
     +--- Project ':ui:feature-main'
     \--- Project ':ui:navigation'
```

### Build
The build configuration is provided as part of the `gradle-plugins` included build. The convention plugins are developed with the convention over configuration mindset that Gradle tries to enforce
