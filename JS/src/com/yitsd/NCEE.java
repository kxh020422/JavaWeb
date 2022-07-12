package com.yitsd;

/**
 * @ClassName NCEE
 * @Date 2022/6/29 20:31
 */
public class NCEE {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String school;
    private String profession;
    private Integer scale;

    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public NCEE() {
    }

    @Override
    public String toString() {
        return "NCEE{" +
                "code='" + code + '\'' +
                ", school='" + school + '\'' +
                ", profession='" + profession + '\'' +
                ", scale=" + scale +
                ", score=" + score +
                '}';
    }

    public NCEE(String school, String profession, Integer scale) {
        this.school = school;
        this.profession = profession;
        this.scale = scale;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }
}
