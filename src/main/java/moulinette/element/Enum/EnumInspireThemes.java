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
public enum EnumInspireThemes {
    ADRESSES("Adresses"),
    ADMINISTRATIVE_UNITS("Administratives units"),
    CADASTRAL_PARCELS("Cadastral parcels"),
    COORDINATE_REFERENCE_SYSTEMS("Coordinate reference systems"),
    GEOGRAPHICAL_GRID_SYSTEMS("Geographical grid systems"),
    GEOGRAPHICAL_NAMES("Geographical names"),
    TRANSPORT_NETWORKS("Transport networks"),
    ELEVATION("Elevation"),
    ORTHOIMAGERY("Orthoimagery"),
    HYDROGRAPHY("Hydrography"),
    PROTECTED_SITES("Protected sites"),
    LAND_COVER("Land cover"),
    GEOLOGY("Geology"),
    SOIL("Soil"),
    LAND_USE("Land use"),
    ENVIRONMENTAL_MONITORING("Environmental monitoring facilities"),
    INDUSTRIAL_SITES("Production and industrial facilities"),
    AGRICULTURAL_SITES("Agriculture and aquaculture facilities"),
    HABITATS_AND_BIOTOPES("Habitats and biotopes"),
    NATURAL_RISK_ZONES("Natural risk zones"),
    ATMOSPHERIC_CONDITIONS("Atmospheric conditions"),
    METEOROLOGICAL_GEOGRAPHICAL_FEATURES("Meteorological geographical features"),
    AREA_MANAGEMENT("Area management / restriction / regulation zones & reporting units"),
    BIOGEOGRAPHICAL_REGIONS("Bio-geographical regions"),
    BUILDING("Buildings"),
    ENERGY_RESOURCES("Energy resources"),
    HEALTH("Human health and safety"),
    MINERAL_RESOURCES("Mineral resources"),
    OCEANOGRAPHIC_GEOGRAPHICAL_FEATURES("Oceanographic geographical features"),
    POPULATION_DISTRIBUTION("Population distribution and demography"),
    SEA_REGIONS("Sea regions"),
    SPECIES_DISTRIBUTIONS("Species distribution"),
    STATISTICAL_UNITS("Statistical units"),
    UTILITY_AND_GOVERNMENTAL_SERVICES("Utility and governmental services")
    ;
    
    private String enumInspireTheme;

    private EnumInspireThemes(String EnumThematicCategories) {
        this.enumInspireTheme = EnumThematicCategories;
    }

    @Override
    public String toString() {
        return this.enumInspireTheme;
    }

    /**
     * Check if a String is a value of the Enumeration and return the value of the enumration if true
     *
     * @param test String to test
     * @return value of the enumeration
     */
    public static EnumInspireThemes enumValueOf(String test) {
        EnumInspireThemes en = null;
        try {
            for (EnumInspireThemes e : EnumInspireThemes.values()) {
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
