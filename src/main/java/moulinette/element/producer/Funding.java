/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.producer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import moulinette.element.Enum.EnumFundingTypes;

/**
 * Class representing the organisations affiliated to the the provider
 *
 * @author coussotc
 */
@XmlRootElement(name = "funding")
@XmlAccessorType(XmlAccessType.FIELD)
public class Funding {

    /**
     * The organism type according to EnumFundingTypes enumeration
     */
    String type;

    /**
     * Acronym of the organism affiliated
     */
    String acronym;

    /**
     * Complete name of the affiliation
     */
    String name;

    /**
     * idScanR of the affiliation
     */
    String idScanR;

    /**
     * iso3166 of the affiliation
     */
    String iso3166;

    /**
     * Funding constructor
     *
     * @param type EnumFundingTypes for the tyoe of the organism
     * @param acronym acronym of the name of the organisation
     */
    public Funding(EnumFundingTypes type, String acronym) {
        this.type = type.toString();
        this.acronym = acronym;
    }

    /**
     * Funding constructor
     *
     * @param type EnumFundingTypes for the tyoe of the organism
     * @param name the name of the organisation
     */
    public Funding(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     *
     * Funding constructor
     *
     * @param type EnumFundingTypes for the tyoe of the organism
     * @param name the name of the organisation
     * @param acronym acronym of the name of the organisation
     * @param idscanr the idScanR of the organisation
     * @param iso3166 the iso3166 of the organisation
     */
    public Funding(String type, String acronym, String name, String idScanR, String iso3166) {
        this.type = type;
        this.acronym = acronym;
        this.name = name;
        this.idScanR = idScanR;
        this.iso3166 = iso3166;
    }

    /**
     * Funding setter
     *
     * @param acronym the acronym of name of the funder
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * Funding setter
     *
     * @param name the name of the funder
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Funding setter
     *
     * @param idscanr the idscanr of the funder
     */
    public void setIdScanR(String idScanR) {
        this.idScanR = idScanR;
    }

    /**
     * Funding setter
     *
     * @param idscanr the idscanr of the funder
     */
    public void setIso3166(String iso3166) {
        this.iso3166 = iso3166;
    }

}
