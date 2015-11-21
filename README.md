Android Badge Module
====================

Disclaimer
----------
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;  
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  

Feature
-------
* Unread number appears on the app icon/shortcut  
* Sounds and vibrate the device
* Supported launcher(s)
  * SAMSUNG Touchwiz Launcher
  * ASUS ZenUI Launcher
  * SONY Xperia Launcher
  * HTC Blink Launcher

Build (AAR Format)
------------------
:exclamation: Configure **ANDROID_HOME** environment variable first before execute below command line.  

**Gradle Command line**  
```  
gradlew assembleRelease  
```  

This will generate an AAR file in `build/outputs/aar` folder.  

Import `android-badge-module-release.aar` file as a module into your project and update build.gradle file dependencies section.  

**build.gradle**  

```  
dependencies {  
    .....  
    .....  
    compile project(':android-badge-module-release')  
}
```  

Usage
-----
```java  

BadgeBroadcastManager badgeManager = new BadgeBroadcastManager(context);  
// create/update badge  
badgeManager.notifyUpdate(1);  
// create/update badge without sounds and vibrate the device  
badgeManager.notifyUpdate(1, false);  
// remove badge  
badgeManager.notifyRemove();  

```  

LICENSE
-------
See file [__LICENSE__](../master/LICENSE) for details.  