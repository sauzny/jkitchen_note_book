package com.sauzny.httpclient;

/*************************************************************************** 
 *
 * ███████╗ █████╗ ██╗   ██╗███████╗███╗   ██╗██╗   ██╗
 * ██╔════╝██╔══██╗██║   ██║╚══███╔╝████╗  ██║╚██╗ ██╔╝
 * ███████╗███████║██║   ██║  ███╔╝ ██╔██╗ ██║ ╚████╔╝ 
 * ╚════██║██╔══██║██║   ██║ ███╔╝  ██║╚██╗██║  ╚██╔╝  
 * ███████║██║  ██║╚██████╔╝███████╗██║ ╚████║   ██║   
 * ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝   
 *
 * @时间: 2018/12/5 - 16:23
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class TqInfo {

    /**
     * ymd : 2018-11-01
     * bWendu : 18℃
     * yWendu : 6℃
     * tianqi : 晴
     * fengxiang : 西北风
     * fengli : 1-2级
     * aqi : 95
     * aqiInfo : 良
     * aqiLevel : 2
     */

    private String ymd;
    private String bWendu;
    private String yWendu;
    private String tianqi;
    private String fengxiang;
    private String fengli;
    private String aqi;
    private String aqiInfo;
    private String aqiLevel;

    public String getYmd() {
        return ymd;
    }

    public void setYmd(String ymd) {
        this.ymd = ymd;
    }

    public String getBWendu() {
        return bWendu;
    }

    public void setBWendu(String bWendu) {
        this.bWendu = bWendu;
    }

    public String getYWendu() {
        return yWendu;
    }

    public void setYWendu(String yWendu) {
        this.yWendu = yWendu;
    }

    public String getTianqi() {
        return tianqi;
    }

    public void setTianqi(String tianqi) {
        this.tianqi = tianqi;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getAqiInfo() {
        return aqiInfo;
    }

    public void setAqiInfo(String aqiInfo) {
        this.aqiInfo = aqiInfo;
    }

    public String getAqiLevel() {
        return aqiLevel;
    }

    public void setAqiLevel(String aqiLevel) {
        this.aqiLevel = aqiLevel;
    }
}
