package com.lazerycode.selenium.repository;

import com.lazerycode.selenium.download.HashType;

import java.net.MalformedURLException;
import java.net.URL;

public class FileDetails {

    private URL fileLocation;
    private HashType hashType;
    private String hash;

    public FileDetails(String fileLocation, String hashType, String hash) throws MalformedURLException, IllegalArgumentException {
        this.fileLocation = new URL(fileLocation);
        setHash(hash, hashType);
    }

    private void setHash(String hash, String hashType) {
        this.hashType = HashType.valueOf(hashType.toUpperCase());
        if (this.hashType.matchesStructureOf(hash)) {
            this.hash = hash;
        } else {
            throw new IllegalArgumentException(hash + " is not a valid " + this.hashType.toString() + " hash!");
        }
    }

    public URL getFileLocation() {
        return this.fileLocation;
    }

    public String getHash() {
        return this.hash;
    }

    public HashType getHashType() {
        return this.hashType;
    }
}
