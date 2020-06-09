/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.Enum;

/**
 *
 * @author coussotc
 */
public enum EnumTopicCategories {

    FARMING("Farming"),
    BIOTA("Biota"),
    BOUNDARIES("Boundaries"),
    CLIMATOLOGY_METEOROLOGY_ATMOSPHERE("Climatology / Meteorology / Atmosphere"),
    ECONOMY("Economy"),
    ELEVATION("Elevation"),
    ENVIRONMENT("Environment"),
    GEOSCIENTIFIC_INFORMATION("Geoscientific Information"),
    HEALTH("Health"),
    IMAGE_BASE_MAPS_EARTH_COVER("Imagery / Base Maps / Earth Cover"),
    INTELLIGENCE_MILITARY("Intelligence / Military"),
    INLAND_WATER("Inland Waters"),
    LOCATION("Location"),
    OCEANS("Oceans"),
    PLANNING_CADASTRE("Planning / Cadastre"),
    SOCIETY("Society"),
    STRUCTURE("Structure"),
    TRANSPORTATION("Transportation"),
    UTILITIES_COMMUNICATION("Utilities / Communication");

    private final String enumInspireTheme;

    private EnumTopicCategories(String EnumInspireTheme) {
        this.enumInspireTheme = EnumInspireTheme;
    }
    
  
    @Override
    public String toString() {
        return this.enumInspireTheme;
    }
     /**
     * Check if a String is a value of the Enumeration and return the value of the enumration if true
     * @param test String to test
     * @return value of the enumeration
     */
    public static EnumTopicCategories enumValueOf(String test) {
        EnumTopicCategories en = null;
        try {
            for (EnumTopicCategories e : EnumTopicCategories.values()) {
                if (e.name().equals(test)) {
                    en = e;
                }
            }
        } catch (EnumConstantNotPresentException e) {
            e.getMessage();
        }
        return en;
    }
}
