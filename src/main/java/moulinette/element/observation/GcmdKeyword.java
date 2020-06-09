/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

/**
 * Class representing the hierchical concepts of the GCMD keywords that can be
 * associated to a variable
 *
 * @author coussotc
 */
public class GcmdKeyword {

    private String category;
    private String topic;
    private String term;
    private String variableLevel1;
    private String variableLevel2;
    private String variableLevel3;
    private String uuid;

    /**
     * GcmdKeyword constructor
     */
    public GcmdKeyword() {
    }

    /**
     * Category setter
     *
     * @param category gcmd category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Topic setter
     *
     * @param topic gcmd setter
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Term setter
     *
     * @param term gcmd setter
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * variableLevel1 setter
     *
     * @param variableLevel1 gdmc variableLevel1
     */
    public void setVariableLevel1(String variableLevel1) {
        this.variableLevel1 = variableLevel1;
    }

    /**
     * variableLevel2 setter
     *
     * @param variableLevel2 gdmc variableLevel2
     */
    public void setVariableLevel2(String variableLevel2) {
        this.variableLevel2 = variableLevel2;
    }

    /**
     * variableLevel3 setter
     *
     * @param variableLevel3 gdmc variableLevel3
     */
    public void setVariableLevel3(String variableLevel3) {
        this.variableLevel3 = variableLevel3;
    }

    /**
     * uuid setter
     *
     * @param uuid gcmd uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
