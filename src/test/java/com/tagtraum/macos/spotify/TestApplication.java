/*
 * =================================================
 * Copyright 2021 tagtraum industries incorporated
 * All rights reserved.
 * =================================================
 */
package com.tagtraum.macos.spotify;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * TestApplication.
 *
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 */
public class TestApplication {

    @Test
    @Disabled("Does not work without Spotify and account")
    public void testVersion() {
        final Application application = Application.getInstance();
        final String version = application.getVersion();
        assertNotNull(version);
        assertFalse(version.trim().isEmpty());
    }

    @Test
    @Disabled("Does not work without Spotify and account")
    public void testGetCurrentTrack() {
        final Application application = Application.getInstance();
        final Track currentTrack = application.getCurrentTrack();
        if (currentTrack == null) {
            System.out.println("No current track");
        } else {
            System.out.println("Current track: " + currentTrack.getName() + " by " + currentTrack.getArtist());
        }
    }

    @Test
    @Disabled("Does not work without Spotify and account")
    public void testPlayTrack() {
        final Application application = Application.getInstance();
        application.playTrack("spotify:track:5Up9Lj7QWudEfMc0ve5qWW", null);
    }

}
