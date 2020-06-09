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
public enum EnumPublicAccessConstraints {
    NO_RESTRICTION("No restriction on public access"),
    L124_4_I_1A("L124-4-I-1 du code de l’environnement (Directive 2007/2/CE (INSPIRE), Article 13.1.a)"),
    L124_5_II_1B("L124-5-II-1 du code de l’environnement (Directive 2007/2/CE (INSPIRE), Article 13.1.b)"),
    L124_5_II_2C("L124-5-II-2 du code de l’environnement (Directive 2007/2/CE (INSPIRE), Article 13.1.c)"),
    L124_4_I_1D("L124_4_I-1 du code de l’environnement (Directive 2007/2/CE (INSPIRE), Article 13.1.d)"),
    L124_5_II_3E("L124-5-II-3 du code de l’environnement (Directive 2007/2/CE (INSPIRE), Article 13.1.e)"),
    L124_4_I_1F("L124-4-I-1 du code de l’environnement (Directive 2007/2/CE (INSPIRE), Article 13.1.f)"),
    L124_4_I_3G("L124-4-I-3 du code de l’environnement (Directive 2007/2/CE (INSPIRE), Article 13.1.g)"),
    L124_4_I_2H("L124-4-I-2 du code de l’environnement (Directive 2007/2/CE (INSPIRE), Article 13.1.h)");

    private String enumPublicAccessConstraints;

    private EnumPublicAccessConstraints(String enumPublicAccessConstraints) {
        this.enumPublicAccessConstraints = enumPublicAccessConstraints;
    }

    @Override
    public String toString() {
        return this.enumPublicAccessConstraints;
    }

    public static EnumPublicAccessConstraints enumValueOf(String test) {
        EnumPublicAccessConstraints en = null;
        try {
            for (EnumPublicAccessConstraints e : EnumPublicAccessConstraints.values()) {
                if (e.name().equals(test)) {
                    en = e;
                }
            }
        }
        catch (EnumConstantNotPresentException e) {
            e.getMessage();
        }
        return en;
    }
}
