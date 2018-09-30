package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils;

import java.util.Date;

public class PartnerQueryFilter extends QueryFilter {

    private int account_id;
    private int startRow = 0;
    private final int maxRows = 10;
    private boolean includeTotalCount = true;
    private final String order_by = "institution_name ASC";
    private String status;
    private String keyword_search;
    private int agreement_type_id;
    private String country;
    boolean public_view = true;
    private String keywords;
    private int agreement_id;
    boolean is_published;
    private String established;
    private Date date_start;
    private Date date_end;
    private int partner_id;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getMaxRows() {
        return maxRows;
    }


    public boolean isIncludeTotalCount() {
        return includeTotalCount;
    }

    public void setIncludeTotalCount(boolean includeTotalCount) {
        this.includeTotalCount = includeTotalCount;
    }

    public String getOrder_by() {
        return order_by;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeyword_search() {
        return keyword_search;
    }

    public void setKeyword_search(String keyword_search) {
        this.keyword_search = keyword_search;
    }

    public int getAgreement_type_id() {
        return agreement_type_id;
    }

    public void setAgreement_type_id(int agreement_type_id) {
        this.agreement_type_id = agreement_type_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isPublic_view() {
        return public_view;
    }

    public void setPublic_view(boolean public_view) {
        this.public_view = public_view;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getAgreement_id() {
        return agreement_id;
    }

    public void setAgreement_id(int agreement_id) {
        this.agreement_id = agreement_id;
    }

    public boolean isIs_published() {
        return is_published;
    }

    public void setIs_published(boolean is_published) {
        this.is_published = is_published;
    }

    public String getEstablished() {
        return established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public int getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }
}
