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
public enum EnumDocumentTypes {
    PUBLICATION("Publication"),
    MANUAL("Manual");
    
    private final String EnumDocumentType;

    private EnumDocumentTypes(String EnumDocumentType) {
        this.EnumDocumentType = EnumDocumentType;
    }
    
    @Override
    public String toString() {
        return this.EnumDocumentType;
    }
}
