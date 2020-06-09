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
public enum EnumCriticalZoneCompartments {
    SURFACE_WATER("Surface water"),
    KARSTIC_WATER("Karstic water"),
    GROUNDWATER("Groundwater"),
    LAND_SURFACE("Land surface"),
    BIOSPHERE("Biosphere"),
    ATMOSPHERE("Atmosphere"),
    CRYOSPHERE("Cryosphere"); 
    
    private String enumCriticalZoneCompartments;

    private EnumCriticalZoneCompartments(String enumCriticalZoneCompartments) {
        this.enumCriticalZoneCompartments = enumCriticalZoneCompartments;
    }

    @Override
    public String toString() {
        return this.enumCriticalZoneCompartments;
    }

    public static EnumCriticalZoneCompartments enumValueOf(String test) {
        EnumCriticalZoneCompartments en = null;
        try {
            for (EnumCriticalZoneCompartments e : EnumCriticalZoneCompartments.values()) {
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
