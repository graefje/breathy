# breathy

### Android Studio Project

###Projekt App und Projekt Spiel miteinander verbinden
<ol>
<li>Import Gradle Projekt</li>   
  File -> Project Structure -> grün "Plus" Button oben link -> Import Gradle Project   
<li><ul>Configuration   
  <li> in build.gradle von Unterprojekt    
	- ändern:  apply plugin: 'com.android.application' -> apply plugin: 'com.android.library'   
	- löschen: applicationId "<package>"   
  </li>
  <li> in AndroidManifest.xml von Unterprojekt   
	- löschen: <category android:name="android.intent.category.LAUNCHER" />   
  </li>
  <li> add Unterprojekt als dependencies von Oberprojekt   
	File -> Project Structure -> Dependencies Tab -> add Unterprojekt als Library   
  </li>	
</ul>
</li>
	</ol>