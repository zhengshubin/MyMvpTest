package com.gdqt.mymvptest.entity;

import java.util.List;

public class EE {

    /**
     * code : 1000
     * msg : 操作成功！
     * data : {"list":[{"userInfo":{"DEPT_ID":1,"CREATE_DATE":1501495037000,"USER_PASSWORD":"e10adc3949ba59abbe56e057f20f883e","CREATE_NAME":"admin","USER_NICKNAME":"超级管理员","ID":1,"USER_NAME":"admin","USER_REMARK":"超级管理员"},"dmaData":[],"largeMeter":{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.32,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.46539,22.74831","TEXTURE":null,"CREATE_DATE":1522748371000,"FFM_NAME":"西区-响水北路(启懋)","ADDRESS":null,"ID":1000002,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},"userCompany":{"COMPANY_NAME":"大亚湾溢源净水有限公司","CREATE_DATE":1515137703000,"WATER_CHARGES":5,"COMPANY_ID":1},"ffmData":[{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.32,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.46539,22.74831","TEXTURE":null,"CREATE_DATE":1522748371000,"FFM_NAME":"西区-响水北路(启懋)","ADDRESS":null,"ID":1000002,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.2,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.46766,22.72564","TEXTURE":null,"CREATE_DATE":1522748435000,"FFM_NAME":"西区-茶山村","ADDRESS":null,"ID":1000003,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.05,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.45104,22.76138","TEXTURE":null,"CREATE_DATE":1522748628000,"FFM_NAME":"西区-上田新厂村","ADDRESS":null,"ID":1000005,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.15,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.45612,22.74471","TEXTURE":null,"CREATE_DATE":1522748694000,"FFM_NAME":"西区-石化大道南侧（新华科技园）","ADDRESS":null,"ID":1000006,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.05,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.2,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.49059,22.75689","TEXTURE":null,"CREATE_DATE":1522748757000,"FFM_NAME":"西区-新畲（下一村总表）","ADDRESS":null,"ID":1000007,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.05,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.18,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.44469,22.72439","TEXTURE":null,"CREATE_DATE":1522748803000,"FFM_NAME":"西区-龙山四路南（东风本田）","ADDRESS":null,"ID":1000008,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.08,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.3,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.44647,22.77552","TEXTURE":null,"CREATE_DATE":1522748849000,"FFM_NAME":"西区-新寮（新寮村委会）","ADDRESS":"","ID":1000009,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.3,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.42904,22.76236","TEXTURE":null,"CREATE_DATE":1522748828000,"FFM_NAME":"西区-新寮老测压点","ADDRESS":"龙山二路与龙盛二路交界","ID":1000010,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.17,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.43072,22.73827","TEXTURE":null,"CREATE_DATE":1522748761000,"FFM_NAME":"西区-龙盛五路（中工合成）","ADDRESS":"","ID":1000011,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.47562,22.76531","TEXTURE":null,"CREATE_DATE":1515484452000,"FFM_NAME":"西区-原西区办事处","ADDRESS":"","ID":1000012,"PHONE_NUMBER":null,"REMARK":null,"TYPE":"null","PRESSURE_LOWERLIMIT":0.1,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.54899,22.75147","TEXTURE":null,"CREATE_DATE":1522748708000,"FFM_NAME":"中心区-DaDa草地","ADDRESS":null,"ID":1000014,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.3,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.54572,22.74417","TEXTURE":null,"CREATE_DATE":1522748223000,"FFM_NAME":"中心区-石化大道南侧（花样年）","ADDRESS":null,"ID":1000015,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.5257,22.73048","TEXTURE":null,"CREATE_DATE":1515546948000,"FFM_NAME":"澳头区-怡园路（中萃1892）","ADDRESS":"","ID":1000016,"PHONE_NUMBER":null,"REMARK":null,"TYPE":"null","PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.48,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.52938,22.72461","TEXTURE":null,"CREATE_DATE":1522748292000,"FFM_NAME":"澳头区-大温坝市场（中行宿舍）","ADDRESS":"","ID":1000017,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.46,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.53494,22.71616","TEXTURE":null,"CREATE_DATE":1522748337000,"FFM_NAME":"澳头区-坳南路","ADDRESS":null,"ID":1000018,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.25,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.45,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.53618,22.71938","TEXTURE":null,"CREATE_DATE":1522748427000,"FFM_NAME":"澳头区-澳头心心幼儿园","ADDRESS":"","ID":1000019,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.25,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.47,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.55045,22.72928","TEXTURE":null,"CREATE_DATE":1522748441000,"FFM_NAME":"惠州港区-疏港大道（白寿湾桥）","ADDRESS":null,"ID":1000020,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.25,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.48,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.57303,22.69625","TEXTURE":null,"CREATE_DATE":1522748501000,"FFM_NAME":"惠州港区-兴盛化工","ADDRESS":null,"ID":1000021,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.64186,22.76615","TEXTURE":null,"CREATE_DATE":1522748521000,"FFM_NAME":"石化区-滨海大道与东段（派出所）","ADDRESS":"","ID":1000022,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.62431,22.75043","TEXTURE":null,"CREATE_DATE":1522748580000,"FFM_NAME":"石化区-滨海大道与滨海十二路交界","ADDRESS":"","ID":1000023,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":null,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.41178,22.72737","TEXTURE":null,"CREATE_DATE":1522748619000,"FFM_NAME":"深圳流量计","ADDRESS":null,"ID":1000025,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":null,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":null,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.53994,22.71288","TEXTURE":null,"CREATE_DATE":1522748632000,"FFM_NAME":"前进村","ADDRESS":null,"ID":1000026,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":null,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.45649,22.76688","TEXTURE":null,"CREATE_DATE":1522748567000,"FFM_NAME":"西区-富口村(高铁桥旁)","ADDRESS":null,"ID":1000030,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1}]}],"total":""}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"userInfo":{"DEPT_ID":1,"CREATE_DATE":1501495037000,"USER_PASSWORD":"e10adc3949ba59abbe56e057f20f883e","CREATE_NAME":"admin","USER_NICKNAME":"超级管理员","ID":1,"USER_NAME":"admin","USER_REMARK":"超级管理员"},"dmaData":[],"largeMeter":{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.32,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.46539,22.74831","TEXTURE":null,"CREATE_DATE":1522748371000,"FFM_NAME":"西区-响水北路(启懋)","ADDRESS":null,"ID":1000002,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},"userCompany":{"COMPANY_NAME":"大亚湾溢源净水有限公司","CREATE_DATE":1515137703000,"WATER_CHARGES":5,"COMPANY_ID":1},"ffmData":[{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.32,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.46539,22.74831","TEXTURE":null,"CREATE_DATE":1522748371000,"FFM_NAME":"西区-响水北路(启懋)","ADDRESS":null,"ID":1000002,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.2,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.46766,22.72564","TEXTURE":null,"CREATE_DATE":1522748435000,"FFM_NAME":"西区-茶山村","ADDRESS":null,"ID":1000003,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.05,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.45104,22.76138","TEXTURE":null,"CREATE_DATE":1522748628000,"FFM_NAME":"西区-上田新厂村","ADDRESS":null,"ID":1000005,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.15,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.45612,22.74471","TEXTURE":null,"CREATE_DATE":1522748694000,"FFM_NAME":"西区-石化大道南侧（新华科技园）","ADDRESS":null,"ID":1000006,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.05,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.2,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.49059,22.75689","TEXTURE":null,"CREATE_DATE":1522748757000,"FFM_NAME":"西区-新畲（下一村总表）","ADDRESS":null,"ID":1000007,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.05,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.18,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.44469,22.72439","TEXTURE":null,"CREATE_DATE":1522748803000,"FFM_NAME":"西区-龙山四路南（东风本田）","ADDRESS":null,"ID":1000008,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.08,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.3,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.44647,22.77552","TEXTURE":null,"CREATE_DATE":1522748849000,"FFM_NAME":"西区-新寮（新寮村委会）","ADDRESS":"","ID":1000009,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.3,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.42904,22.76236","TEXTURE":null,"CREATE_DATE":1522748828000,"FFM_NAME":"西区-新寮老测压点","ADDRESS":"龙山二路与龙盛二路交界","ID":1000010,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.17,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.43072,22.73827","TEXTURE":null,"CREATE_DATE":1522748761000,"FFM_NAME":"西区-龙盛五路（中工合成）","ADDRESS":"","ID":1000011,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.47562,22.76531","TEXTURE":null,"CREATE_DATE":1515484452000,"FFM_NAME":"西区-原西区办事处","ADDRESS":"","ID":1000012,"PHONE_NUMBER":null,"REMARK":null,"TYPE":"null","PRESSURE_LOWERLIMIT":0.1,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.54899,22.75147","TEXTURE":null,"CREATE_DATE":1522748708000,"FFM_NAME":"中心区-DaDa草地","ADDRESS":null,"ID":1000014,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.3,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.54572,22.74417","TEXTURE":null,"CREATE_DATE":1522748223000,"FFM_NAME":"中心区-石化大道南侧（花样年）","ADDRESS":null,"ID":1000015,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.5257,22.73048","TEXTURE":null,"CREATE_DATE":1515546948000,"FFM_NAME":"澳头区-怡园路（中萃1892）","ADDRESS":"","ID":1000016,"PHONE_NUMBER":null,"REMARK":null,"TYPE":"null","PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.48,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.52938,22.72461","TEXTURE":null,"CREATE_DATE":1522748292000,"FFM_NAME":"澳头区-大温坝市场（中行宿舍）","ADDRESS":"","ID":1000017,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.46,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.53494,22.71616","TEXTURE":null,"CREATE_DATE":1522748337000,"FFM_NAME":"澳头区-坳南路","ADDRESS":null,"ID":1000018,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.25,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.45,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.53618,22.71938","TEXTURE":null,"CREATE_DATE":1522748427000,"FFM_NAME":"澳头区-澳头心心幼儿园","ADDRESS":"","ID":1000019,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.25,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.47,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.55045,22.72928","TEXTURE":null,"CREATE_DATE":1522748441000,"FFM_NAME":"惠州港区-疏港大道（白寿湾桥）","ADDRESS":null,"ID":1000020,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.25,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.48,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.57303,22.69625","TEXTURE":null,"CREATE_DATE":1522748501000,"FFM_NAME":"惠州港区-兴盛化工","ADDRESS":null,"ID":1000021,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.64186,22.76615","TEXTURE":null,"CREATE_DATE":1522748521000,"FFM_NAME":"石化区-滨海大道与东段（派出所）","ADDRESS":"","ID":1000022,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.62431,22.75043","TEXTURE":null,"CREATE_DATE":1522748580000,"FFM_NAME":"石化区-滨海大道与滨海十二路交界","ADDRESS":"","ID":1000023,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":null,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.41178,22.72737","TEXTURE":null,"CREATE_DATE":1522748619000,"FFM_NAME":"深圳流量计","ADDRESS":null,"ID":1000025,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":null,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":null,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.53994,22.71288","TEXTURE":null,"CREATE_DATE":1522748632000,"FFM_NAME":"前进村","ADDRESS":null,"ID":1000026,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":null,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.45649,22.76688","TEXTURE":null,"CREATE_DATE":1522748567000,"FFM_NAME":"西区-富口村(高铁桥旁)","ADDRESS":null,"ID":1000030,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1}]}]
         * total :
         */

        private String total;
        private List<ListBean> list;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * userInfo : {"DEPT_ID":1,"CREATE_DATE":1501495037000,"USER_PASSWORD":"e10adc3949ba59abbe56e057f20f883e","CREATE_NAME":"admin","USER_NICKNAME":"超级管理员","ID":1,"USER_NAME":"admin","USER_REMARK":"超级管理员"}
             * dmaData : []
             * largeMeter : {"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.32,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.46539,22.74831","TEXTURE":null,"CREATE_DATE":1522748371000,"FFM_NAME":"西区-响水北路(启懋)","ADDRESS":null,"ID":1000002,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1}
             * userCompany : {"COMPANY_NAME":"大亚湾溢源净水有限公司","CREATE_DATE":1515137703000,"WATER_CHARGES":5,"COMPANY_ID":1}
             * ffmData : [{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.32,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.46539,22.74831","TEXTURE":null,"CREATE_DATE":1522748371000,"FFM_NAME":"西区-响水北路(启懋)","ADDRESS":null,"ID":1000002,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.2,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.46766,22.72564","TEXTURE":null,"CREATE_DATE":1522748435000,"FFM_NAME":"西区-茶山村","ADDRESS":null,"ID":1000003,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.05,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.45104,22.76138","TEXTURE":null,"CREATE_DATE":1522748628000,"FFM_NAME":"西区-上田新厂村","ADDRESS":null,"ID":1000005,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.15,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.45612,22.74471","TEXTURE":null,"CREATE_DATE":1522748694000,"FFM_NAME":"西区-石化大道南侧（新华科技园）","ADDRESS":null,"ID":1000006,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.05,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.2,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.49059,22.75689","TEXTURE":null,"CREATE_DATE":1522748757000,"FFM_NAME":"西区-新畲（下一村总表）","ADDRESS":null,"ID":1000007,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.05,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.18,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.44469,22.72439","TEXTURE":null,"CREATE_DATE":1522748803000,"FFM_NAME":"西区-龙山四路南（东风本田）","ADDRESS":null,"ID":1000008,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.08,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.3,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.44647,22.77552","TEXTURE":null,"CREATE_DATE":1522748849000,"FFM_NAME":"西区-新寮（新寮村委会）","ADDRESS":"","ID":1000009,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.3,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.42904,22.76236","TEXTURE":null,"CREATE_DATE":1522748828000,"FFM_NAME":"西区-新寮老测压点","ADDRESS":"龙山二路与龙盛二路交界","ID":1000010,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.17,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.43072,22.73827","TEXTURE":null,"CREATE_DATE":1522748761000,"FFM_NAME":"西区-龙盛五路（中工合成）","ADDRESS":"","ID":1000011,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.47562,22.76531","TEXTURE":null,"CREATE_DATE":1515484452000,"FFM_NAME":"西区-原西区办事处","ADDRESS":"","ID":1000012,"PHONE_NUMBER":null,"REMARK":null,"TYPE":"null","PRESSURE_LOWERLIMIT":0.1,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.54899,22.75147","TEXTURE":null,"CREATE_DATE":1522748708000,"FFM_NAME":"中心区-DaDa草地","ADDRESS":null,"ID":1000014,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.3,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.54572,22.74417","TEXTURE":null,"CREATE_DATE":1522748223000,"FFM_NAME":"中心区-石化大道南侧（花样年）","ADDRESS":null,"ID":1000015,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.5257,22.73048","TEXTURE":null,"CREATE_DATE":1515546948000,"FFM_NAME":"澳头区-怡园路（中萃1892）","ADDRESS":"","ID":1000016,"PHONE_NUMBER":null,"REMARK":null,"TYPE":"null","PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.48,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.52938,22.72461","TEXTURE":null,"CREATE_DATE":1522748292000,"FFM_NAME":"澳头区-大温坝市场（中行宿舍）","ADDRESS":"","ID":1000017,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.46,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.53494,22.71616","TEXTURE":null,"CREATE_DATE":1522748337000,"FFM_NAME":"澳头区-坳南路","ADDRESS":null,"ID":1000018,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.25,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.45,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.53618,22.71938","TEXTURE":null,"CREATE_DATE":1522748427000,"FFM_NAME":"澳头区-澳头心心幼儿园","ADDRESS":"","ID":1000019,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.25,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.47,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.55045,22.72928","TEXTURE":null,"CREATE_DATE":1522748441000,"FFM_NAME":"惠州港区-疏港大道（白寿湾桥）","ADDRESS":null,"ID":1000020,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.25,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.48,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.57303,22.69625","TEXTURE":null,"CREATE_DATE":1522748501000,"FFM_NAME":"惠州港区-兴盛化工","ADDRESS":null,"ID":1000021,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.2,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.64186,22.76615","TEXTURE":null,"CREATE_DATE":1522748521000,"FFM_NAME":"石化区-滨海大道与东段（派出所）","ADDRESS":"","ID":1000022,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.35,"IP":null,"IMEI":null,"DN":"","LNG_LAT":"114.62431,22.75043","TEXTURE":null,"CREATE_DATE":1522748580000,"FFM_NAME":"石化区-滨海大道与滨海十二路交界","ADDRESS":"","ID":1000023,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":null,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.41178,22.72737","TEXTURE":null,"CREATE_DATE":1522748619000,"FFM_NAME":"深圳流量计","ADDRESS":null,"ID":1000025,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":null,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":null,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.53994,22.71288","TEXTURE":null,"CREATE_DATE":1522748632000,"FFM_NAME":"前进村","ADDRESS":null,"ID":1000026,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":null,"COMPANY_ID":1},{"COMMUNICATION_TYPE":null,"PORT":null,"ZONE_ID":1,"PRESSURE_TOPLIMIT":0.25,"IP":null,"IMEI":null,"DN":null,"LNG_LAT":"114.45649,22.76688","TEXTURE":null,"CREATE_DATE":1522748567000,"FFM_NAME":"西区-富口村(高铁桥旁)","ADDRESS":null,"ID":1000030,"PHONE_NUMBER":null,"REMARK":null,"TYPE":null,"PRESSURE_LOWERLIMIT":0.15,"COMPANY_ID":1}]
             */

            private UserInfoBean userInfo;
            private LargeMeterBean largeMeter;
            private UserCompanyBean userCompany;
            private List<?> dmaData;
            private List<FfmDataBean> ffmData;

            public UserInfoBean getUserInfo() {
                return userInfo;
            }

            public void setUserInfo(UserInfoBean userInfo) {
                this.userInfo = userInfo;
            }

            public LargeMeterBean getLargeMeter() {
                return largeMeter;
            }

            public void setLargeMeter(LargeMeterBean largeMeter) {
                this.largeMeter = largeMeter;
            }

            public UserCompanyBean getUserCompany() {
                return userCompany;
            }

            public void setUserCompany(UserCompanyBean userCompany) {
                this.userCompany = userCompany;
            }

            public List<?> getDmaData() {
                return dmaData;
            }

            public void setDmaData(List<?> dmaData) {
                this.dmaData = dmaData;
            }

            public List<FfmDataBean> getFfmData() {
                return ffmData;
            }

            public void setFfmData(List<FfmDataBean> ffmData) {
                this.ffmData = ffmData;
            }

            public static class UserInfoBean {
                /**
                 * DEPT_ID : 1
                 * CREATE_DATE : 1501495037000
                 * USER_PASSWORD : e10adc3949ba59abbe56e057f20f883e
                 * CREATE_NAME : admin
                 * USER_NICKNAME : 超级管理员
                 * ID : 1
                 * USER_NAME : admin
                 * USER_REMARK : 超级管理员
                 */

                private int DEPT_ID;
                private long CREATE_DATE;
                private String USER_PASSWORD;
                private String CREATE_NAME;
                private String USER_NICKNAME;
                private int ID;
                private String USER_NAME;
                private String USER_REMARK;

                public int getDEPT_ID() {
                    return DEPT_ID;
                }

                public void setDEPT_ID(int DEPT_ID) {
                    this.DEPT_ID = DEPT_ID;
                }

                public long getCREATE_DATE() {
                    return CREATE_DATE;
                }

                public void setCREATE_DATE(long CREATE_DATE) {
                    this.CREATE_DATE = CREATE_DATE;
                }

                public String getUSER_PASSWORD() {
                    return USER_PASSWORD;
                }

                public void setUSER_PASSWORD(String USER_PASSWORD) {
                    this.USER_PASSWORD = USER_PASSWORD;
                }

                public String getCREATE_NAME() {
                    return CREATE_NAME;
                }

                public void setCREATE_NAME(String CREATE_NAME) {
                    this.CREATE_NAME = CREATE_NAME;
                }

                public String getUSER_NICKNAME() {
                    return USER_NICKNAME;
                }

                public void setUSER_NICKNAME(String USER_NICKNAME) {
                    this.USER_NICKNAME = USER_NICKNAME;
                }

                public int getID() {
                    return ID;
                }

                public void setID(int ID) {
                    this.ID = ID;
                }

                public String getUSER_NAME() {
                    return USER_NAME;
                }

                public void setUSER_NAME(String USER_NAME) {
                    this.USER_NAME = USER_NAME;
                }

                public String getUSER_REMARK() {
                    return USER_REMARK;
                }

                public void setUSER_REMARK(String USER_REMARK) {
                    this.USER_REMARK = USER_REMARK;
                }
            }

            public static class LargeMeterBean {
                /**
                 * COMMUNICATION_TYPE : null
                 * PORT : null
                 * ZONE_ID : 1
                 * PRESSURE_TOPLIMIT : 0.32
                 * IP : null
                 * IMEI : null
                 * DN : null
                 * LNG_LAT : 114.46539,22.74831
                 * TEXTURE : null
                 * CREATE_DATE : 1522748371000
                 * FFM_NAME : 西区-响水北路(启懋)
                 * ADDRESS : null
                 * ID : 1000002
                 * PHONE_NUMBER : null
                 * REMARK : null
                 * TYPE : null
                 * PRESSURE_LOWERLIMIT : 0.2
                 * COMPANY_ID : 1
                 */

                private Object COMMUNICATION_TYPE;
                private Object PORT;
                private int ZONE_ID;
                private double PRESSURE_TOPLIMIT;
                private Object IP;
                private Object IMEI;
                private Object DN;
                private String LNG_LAT;
                private Object TEXTURE;
                private long CREATE_DATE;
                private String FFM_NAME;
                private Object ADDRESS;
                private int ID;
                private Object PHONE_NUMBER;
                private Object REMARK;
                private Object TYPE;
                private double PRESSURE_LOWERLIMIT;
                private int COMPANY_ID;

                public Object getCOMMUNICATION_TYPE() {
                    return COMMUNICATION_TYPE;
                }

                public void setCOMMUNICATION_TYPE(Object COMMUNICATION_TYPE) {
                    this.COMMUNICATION_TYPE = COMMUNICATION_TYPE;
                }

                public Object getPORT() {
                    return PORT;
                }

                public void setPORT(Object PORT) {
                    this.PORT = PORT;
                }

                public int getZONE_ID() {
                    return ZONE_ID;
                }

                public void setZONE_ID(int ZONE_ID) {
                    this.ZONE_ID = ZONE_ID;
                }

                public double getPRESSURE_TOPLIMIT() {
                    return PRESSURE_TOPLIMIT;
                }

                public void setPRESSURE_TOPLIMIT(double PRESSURE_TOPLIMIT) {
                    this.PRESSURE_TOPLIMIT = PRESSURE_TOPLIMIT;
                }

                public Object getIP() {
                    return IP;
                }

                public void setIP(Object IP) {
                    this.IP = IP;
                }

                public Object getIMEI() {
                    return IMEI;
                }

                public void setIMEI(Object IMEI) {
                    this.IMEI = IMEI;
                }

                public Object getDN() {
                    return DN;
                }

                public void setDN(Object DN) {
                    this.DN = DN;
                }

                public String getLNG_LAT() {
                    return LNG_LAT;
                }

                public void setLNG_LAT(String LNG_LAT) {
                    this.LNG_LAT = LNG_LAT;
                }

                public Object getTEXTURE() {
                    return TEXTURE;
                }

                public void setTEXTURE(Object TEXTURE) {
                    this.TEXTURE = TEXTURE;
                }

                public long getCREATE_DATE() {
                    return CREATE_DATE;
                }

                public void setCREATE_DATE(long CREATE_DATE) {
                    this.CREATE_DATE = CREATE_DATE;
                }

                public String getFFM_NAME() {
                    return FFM_NAME;
                }

                public void setFFM_NAME(String FFM_NAME) {
                    this.FFM_NAME = FFM_NAME;
                }

                public Object getADDRESS() {
                    return ADDRESS;
                }

                public void setADDRESS(Object ADDRESS) {
                    this.ADDRESS = ADDRESS;
                }

                public int getID() {
                    return ID;
                }

                public void setID(int ID) {
                    this.ID = ID;
                }

                public Object getPHONE_NUMBER() {
                    return PHONE_NUMBER;
                }

                public void setPHONE_NUMBER(Object PHONE_NUMBER) {
                    this.PHONE_NUMBER = PHONE_NUMBER;
                }

                public Object getREMARK() {
                    return REMARK;
                }

                public void setREMARK(Object REMARK) {
                    this.REMARK = REMARK;
                }

                public Object getTYPE() {
                    return TYPE;
                }

                public void setTYPE(Object TYPE) {
                    this.TYPE = TYPE;
                }

                public double getPRESSURE_LOWERLIMIT() {
                    return PRESSURE_LOWERLIMIT;
                }

                public void setPRESSURE_LOWERLIMIT(double PRESSURE_LOWERLIMIT) {
                    this.PRESSURE_LOWERLIMIT = PRESSURE_LOWERLIMIT;
                }

                public int getCOMPANY_ID() {
                    return COMPANY_ID;
                }

                public void setCOMPANY_ID(int COMPANY_ID) {
                    this.COMPANY_ID = COMPANY_ID;
                }
            }

            public static class UserCompanyBean {
                /**
                 * COMPANY_NAME : 大亚湾溢源净水有限公司
                 * CREATE_DATE : 1515137703000
                 * WATER_CHARGES : 5
                 * COMPANY_ID : 1
                 */

                private String COMPANY_NAME;
                private long CREATE_DATE;
                private int WATER_CHARGES;
                private int COMPANY_ID;

                public String getCOMPANY_NAME() {
                    return COMPANY_NAME;
                }

                public void setCOMPANY_NAME(String COMPANY_NAME) {
                    this.COMPANY_NAME = COMPANY_NAME;
                }

                public long getCREATE_DATE() {
                    return CREATE_DATE;
                }

                public void setCREATE_DATE(long CREATE_DATE) {
                    this.CREATE_DATE = CREATE_DATE;
                }

                public int getWATER_CHARGES() {
                    return WATER_CHARGES;
                }

                public void setWATER_CHARGES(int WATER_CHARGES) {
                    this.WATER_CHARGES = WATER_CHARGES;
                }

                public int getCOMPANY_ID() {
                    return COMPANY_ID;
                }

                public void setCOMPANY_ID(int COMPANY_ID) {
                    this.COMPANY_ID = COMPANY_ID;
                }
            }

            public static class FfmDataBean {
                /**
                 * COMMUNICATION_TYPE : null
                 * PORT : null
                 * ZONE_ID : 1
                 * PRESSURE_TOPLIMIT : 0.32
                 * IP : null
                 * IMEI : null
                 * DN : null
                 * LNG_LAT : 114.46539,22.74831
                 * TEXTURE : null
                 * CREATE_DATE : 1522748371000
                 * FFM_NAME : 西区-响水北路(启懋)
                 * ADDRESS : null
                 * ID : 1000002
                 * PHONE_NUMBER : null
                 * REMARK : null
                 * TYPE : null
                 * PRESSURE_LOWERLIMIT : 0.2
                 * COMPANY_ID : 1
                 */

                private Object COMMUNICATION_TYPE;
                private Object PORT;
                private int ZONE_ID;
                private double PRESSURE_TOPLIMIT;
                private Object IP;
                private Object IMEI;
                private Object DN;
                private String LNG_LAT;
                private Object TEXTURE;
                private long CREATE_DATE;
                private String FFM_NAME;
                private Object ADDRESS;
                private int ID;
                private Object PHONE_NUMBER;
                private Object REMARK;
                private Object TYPE;
                private double PRESSURE_LOWERLIMIT;
                private int COMPANY_ID;

                public Object getCOMMUNICATION_TYPE() {
                    return COMMUNICATION_TYPE;
                }

                public void setCOMMUNICATION_TYPE(Object COMMUNICATION_TYPE) {
                    this.COMMUNICATION_TYPE = COMMUNICATION_TYPE;
                }

                public Object getPORT() {
                    return PORT;
                }

                public void setPORT(Object PORT) {
                    this.PORT = PORT;
                }

                public int getZONE_ID() {
                    return ZONE_ID;
                }

                public void setZONE_ID(int ZONE_ID) {
                    this.ZONE_ID = ZONE_ID;
                }

                public double getPRESSURE_TOPLIMIT() {
                    return PRESSURE_TOPLIMIT;
                }

                public void setPRESSURE_TOPLIMIT(double PRESSURE_TOPLIMIT) {
                    this.PRESSURE_TOPLIMIT = PRESSURE_TOPLIMIT;
                }

                public Object getIP() {
                    return IP;
                }

                public void setIP(Object IP) {
                    this.IP = IP;
                }

                public Object getIMEI() {
                    return IMEI;
                }

                public void setIMEI(Object IMEI) {
                    this.IMEI = IMEI;
                }

                public Object getDN() {
                    return DN;
                }

                public void setDN(Object DN) {
                    this.DN = DN;
                }

                public String getLNG_LAT() {
                    return LNG_LAT;
                }

                public void setLNG_LAT(String LNG_LAT) {
                    this.LNG_LAT = LNG_LAT;
                }

                public Object getTEXTURE() {
                    return TEXTURE;
                }

                public void setTEXTURE(Object TEXTURE) {
                    this.TEXTURE = TEXTURE;
                }

                public long getCREATE_DATE() {
                    return CREATE_DATE;
                }

                public void setCREATE_DATE(long CREATE_DATE) {
                    this.CREATE_DATE = CREATE_DATE;
                }

                public String getFFM_NAME() {
                    return FFM_NAME;
                }

                public void setFFM_NAME(String FFM_NAME) {
                    this.FFM_NAME = FFM_NAME;
                }

                public Object getADDRESS() {
                    return ADDRESS;
                }

                public void setADDRESS(Object ADDRESS) {
                    this.ADDRESS = ADDRESS;
                }

                public int getID() {
                    return ID;
                }

                public void setID(int ID) {
                    this.ID = ID;
                }

                public Object getPHONE_NUMBER() {
                    return PHONE_NUMBER;
                }

                public void setPHONE_NUMBER(Object PHONE_NUMBER) {
                    this.PHONE_NUMBER = PHONE_NUMBER;
                }

                public Object getREMARK() {
                    return REMARK;
                }

                public void setREMARK(Object REMARK) {
                    this.REMARK = REMARK;
                }

                public Object getTYPE() {
                    return TYPE;
                }

                public void setTYPE(Object TYPE) {
                    this.TYPE = TYPE;
                }

                public double getPRESSURE_LOWERLIMIT() {
                    return PRESSURE_LOWERLIMIT;
                }

                public void setPRESSURE_LOWERLIMIT(double PRESSURE_LOWERLIMIT) {
                    this.PRESSURE_LOWERLIMIT = PRESSURE_LOWERLIMIT;
                }

                public int getCOMPANY_ID() {
                    return COMPANY_ID;
                }

                public void setCOMPANY_ID(int COMPANY_ID) {
                    this.COMPANY_ID = COMPANY_ID;
                }
            }
        }
    }
}
