[![LGPL 2.1](https://img.shields.io/badge/License-LGPL_2.1-blue.svg)](https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.tagtraum/obstspot/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.tagtraum/obstspot)
[![Build and Test](https://github.com/hendriks73/obstspot/workflows/Build%20and%20Test/badge.svg)](https://github.com/hendriks73/obstspot/actions)


# Obstspot

*Obstspot* is a Java API for the Spotify app (macOS) based on
[JaplScript](https://github.com/hendriks73/japlscript).


## Installation

Obstspot is released via [Maven](https://maven.apache.org).
You can install it via the following dependency:

```xml
<dependency>
    <groupId>com.tagtraum</groupId>
    <artifactId>obstspot</artifactId>
</dependency>
```

The Maven artifacts also contain sources and javadocs. 

If you are using [modules](https://en.wikipedia.org/wiki/Java_Platform_Module_System),
its name is `tagtraum.obstspot`.


## Usage
                           
To use the generated code, do something like this:

```java
import com.tagtraum.macos.spotify.Application;

public class GetCurrentTrack {

    public static void main(final String[] args) {
        final Application application = Application.getInstance();
        final Track currentTrack = application.getCurrentTrack();
        if (currentTrack == null) {
            System.out.println("No current track");
        } else {
            System.out.println("Current track: " + currentTrack.getName()
                + " by " + currentTrack.getArtist());
        }
    }
}
```
              
Or this:

```java
import com.tagtraum.macos.spotify.Application;

public class PlayTrack {

    public static void main(final String[] args) {
        // provide URI, like "spotify:track:5Up9Lj7QWudEfMc0ve5qWW"
        // as parameter
        final String trackURI = args[0];
        final Application application = Application.getInstance();
        // arguments to playTrack are: trackURI and contextURI
        // contextURI (this is the album or playlist URI) is optional,
        // just leave it "null", if unknown.
        application.playTrack(trackURI, null);
    }
}
```
## API

You can find the complete [API here](https://hendriks73.github.io/obstspot/com/tagtraum/macos/spotify/package-summary.html). 


## AppleScript Sandbox

Since macOS 10.14 (Mojave), Apple imposed a sandbox on AppleScript. Therefore
you may see dialog boxes requesting authorization to perform certain actions.
After a while, these boxes simply disappear and there does not seem to be an easy
way to authorize your app. In this case, you need to open the system preferences,
navigate to *Security & Privacy*, *Privacy*, and then *Automation*, and make
sure your app is allowed to remote control whatever app you are trying to remote
control (see also [this article](https://blog.beatunes.com/2018/10/beatunes-on-mojave-and-windows-10-dark.html)).

If you are shipping a real app with a UI and not just a command line tool, you
need to customize the sandbox permission dialog. You can do so by adding
the key `NSAppleEventsUsageDescription` to your app bundle's `/Contents/Info.plist`
file. For example:

    [...]
    <key>NSAppleEventsUsageDescription</key>
    <string>SuperMusic uses AppleEvents to access your Music.app library,
            e.g., to set BPM values or create playlists.</string>
    [...]

Apple's documentation for the keyword is [here](https://developer.apple.com/documentation/bundleresources/information_property_list/nsappleeventsusagedescription).
