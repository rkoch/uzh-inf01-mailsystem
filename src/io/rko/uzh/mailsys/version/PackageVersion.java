package io.rko.uzh.mailsys.version;


/**
 * Contains version information for the package GCH Galaxy Client Hub.
 *
 * @author auto-generated
 * @version 0.1.0
 */
public final class PackageVersion {

    /** The name of the package (Mailsystem). */
    private static final String mPackageName = "Mailsystem";

    /** The version of the package (0.1.0). */
    private static final String mVersion     = "0.1.0";

    /** The build date of the package (23.11.2012 14:12:26). */
    private static final String mBuildDate   = "23.11.2012 14:12:26";


    /**
     * Gets the package name.
     *
     * @return String The package name.
     */
    public static String getPackageName() {
        return mPackageName;
    }

    /**
     * Gets the package version.
     *
     * @return String The package version.
     */
    public static String getPackageVersion() {
        return mPackageName + " V" + mVersion + " [" + mBuildDate + "]";
    }

    /**
     * Gets the version.
     *
     * @return String The version.
     */
    public static String getVersion() {
        return mVersion;
    }

    /**
     * Gets the build date.
     *
     * @return String The build date.
     */
    public static String getBuildDate() {
        return mBuildDate;
    }

}
