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

Usage
-----
```java  

BadgeBroadcastManager badgeManager = new BadgeBroadcastManager(context);  
// create/update badge  
badgeManager.notifyUpdate(1)  
// remove badge  
badgeManager.notifyRemove();  

```  

LICENSE
-------
See file [__LICENSE__](../master/LICENSE) for details.  