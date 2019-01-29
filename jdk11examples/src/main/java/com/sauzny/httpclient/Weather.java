package com.sauzny.httpclient;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/***************************************************************************
 *
 * ███████╗ █████╗ ██╗   ██╗███████╗███╗   ██╗██╗   ██╗
 * ██╔════╝██╔══██╗██║   ██║╚══███╔╝████╗  ██║╚██╗ ██╔╝
 * ███████╗███████║██║   ██║  ███╔╝ ██╔██╗ ██║ ╚████╔╝ 
 * ╚════██║██╔══██║██║   ██║ ███╔╝  ██║╚██╗██║  ╚██╔╝  
 * ███████║██║  ██║╚██████╔╝███████╗██║ ╚████║   ██║   
 * ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝   
 *
 * @时间: 2018/12/5 - 16:33
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class Weather {

    /**
     * city : 天津
     * maxWendu : 21（2018-11-03）
     * minWendu : 0（2018-11-16）
     * avgbWendu : 13
     * avgyWendu : 3
     * maxAqi : 261
     * minAqi : 43
     * avgAqi : 109
     * maxAqiInfo : 重度污染
     * maxAqiDate : 11月26日
     * maxAqiLevel : 5
     * minAqiInfo : 空气优
     * minAqiDate : 11月05日
     * minAqiLevel : 1
     */

    private String city;
    private String maxWendu;
    private String minWendu;
    private String avgbWendu;
    private String avgyWendu;
    private String maxAqi;
    private String minAqi;
    private String avgAqi;
    private String maxAqiInfo;
    private String maxAqiDate;
    private String maxAqiLevel;
    private String minAqiInfo;
    private String minAqiDate;
    private String minAqiLevel;

    @Getter
    @Setter
    private List<TqInfo> tqInfo;



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMaxWendu() {
        return maxWendu;
    }

    public void setMaxWendu(String maxWendu) {
        this.maxWendu = maxWendu;
    }

    public String getMinWendu() {
        return minWendu;
    }

    public void setMinWendu(String minWendu) {
        this.minWendu = minWendu;
    }

    public String getAvgbWendu() {
        return avgbWendu;
    }

    public void setAvgbWendu(String avgbWendu) {
        this.avgbWendu = avgbWendu;
    }

    public String getAvgyWendu() {
        return avgyWendu;
    }

    public void setAvgyWendu(String avgyWendu) {
        this.avgyWendu = avgyWendu;
    }

    public String getMaxAqi() {
        return maxAqi;
    }

    public void setMaxAqi(String maxAqi) {
        this.maxAqi = maxAqi;
    }

    public String getMinAqi() {
        return minAqi;
    }

    public void setMinAqi(String minAqi) {
        this.minAqi = minAqi;
    }

    public String getAvgAqi() {
        return avgAqi;
    }

    public void setAvgAqi(String avgAqi) {
        this.avgAqi = avgAqi;
    }

    public String getMaxAqiInfo() {
        return maxAqiInfo;
    }

    public void setMaxAqiInfo(String maxAqiInfo) {
        this.maxAqiInfo = maxAqiInfo;
    }

    public String getMaxAqiDate() {
        return maxAqiDate;
    }

    public void setMaxAqiDate(String maxAqiDate) {
        this.maxAqiDate = maxAqiDate;
    }

    public String getMaxAqiLevel() {
        return maxAqiLevel;
    }

    public void setMaxAqiLevel(String maxAqiLevel) {
        this.maxAqiLevel = maxAqiLevel;
    }

    public String getMinAqiInfo() {
        return minAqiInfo;
    }

    public void setMinAqiInfo(String minAqiInfo) {
        this.minAqiInfo = minAqiInfo;
    }

    public String getMinAqiDate() {
        return minAqiDate;
    }

    public void setMinAqiDate(String minAqiDate) {
        this.minAqiDate = minAqiDate;
    }

    public String getMinAqiLevel() {
        return minAqiLevel;
    }

    public void setMinAqiLevel(String minAqiLevel) {
        this.minAqiLevel = minAqiLevel;
    }
}
