package com.damg.agreementsapiendpoints.agreementsapiendpoints.models.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.Query;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

@Component
public class PartnerQueryBuilder  {

    private PartnerQueryFilter filter;


    private String sql_select_partner_description = "";
    private String sql_where_agreement_type_id = "";
    private String sql_where_country = "";

    private String sql_where_keyword = "";
    private String sql_where_agreement_id = "";
    private String sql_where_is_published = "";
    private String sql_where_year_established = "";
    private String sql_where_date_last_updated = "";
    private String sql_where_partner_id = "";


    private void checkForPublicView()  {
        if (this.filter.isPublic_view())
        {
           this.sql_select_partner_description = ", ptr.partner_description";
        }
    }

    private void checkForAgreemenTypeId()  {
        if(this.filter.getAgreement_type_id() > 0) {
           this.sql_where_agreement_type_id = "AND agr_xref.agreement_type_id IN(" + this.filter.getAgreement_type_id() + ")";
        }
    }

    private void checkForCountry() {
        if(!StringUtils.isEmpty(filter.getCountry()) ) {
         this.sql_where_country = "AND LOWER(addr.country) IN(" + this.filter.getCountry()+ ")";
        }
    }

    private void checkForKeywords() {

        if (!StringUtils.isEmpty(this.filter.getKeywords())) {

            String[] list_keywords =  this.filter.getKeywords().split("(\\+)+|(\\s+)");
            List<String> search_fields = Arrays.asList("institution_name","partner_website_url","addr.city","addr.state","addr.country");

            if (list_keywords.length > 0){
                this.sql_where_keyword += " AND ( 1 = 0 ";

                for (String keyword: list_keywords ) {

                    for (String search_field:search_fields ) {

                        this.sql_where_keyword += " OR LOWER("+ search_field +") LIKE " + keyword;
                    }

                }
            }

/*
            ;
            if( list_keywords.length > 0) {
                 this.sql_where_keyword += " AND ( 1 = 0 ";

                 String list_searchFields = "institution_name,partner_website_url,addr.city,addr.state,addr.country";

                for (String keyword : list_keywords) {
                }

                 sql_where_keyword += ")";
            } */

        }
    }

    private void checkForAgreementId()     {
        if(!StringUtils.isEmpty(filter.getAgreement_id())) {
           sql_where_agreement_id = "AND agr.id = " + this.filter.getAgreement_id();
        }
    }

    private void checkForIsPublished()     {
        if( filter.isIs_published() ) {
            sql_where_is_published = "AND is_published = 'True'";
        }
    }

    private void checkForDates()     {

        if( filter.getDate_start() != null  && filter.getDate_end()	!= null) {
           sql_where_date_last_updated = "AND ptr.date_last_updated >=" + this.filter.getDate_start() +" AND ptr.date_last_updated <=" +  this.filter.getDate_end();
         }
    }

    private void checkForEstablished()    {
        if(!StringUtils.isEmpty(filter.getEstablished()) ) {
            sql_where_year_established = " AND agr.agreement_id IN ( SELECT agreement_id from (" +
           " SELECT sub_agr.agreement_id , MIN( agr.agreement_start_date ) OVER(PARTITION BY xref.partner_id ) AS year_established" +
           " FROM agr_agreements sub_agr " +
           " JOIN agr_rel_agreements_partner_addresses sub_xref" +
           " ON sub_agr.account_id = sub_xref.account_id " +
           " AND sub_agr.agreement_id = sub_xref.agreement_id " +
           " WHERE sub_xref.partner_id = ptr.partner_id ) min_year " +
           " WHERE CONVERT(varchar, YEAR(year_established) ) = " + this.filter.getEstablished()+" ) ";

        }
    }

    private void checkForPartnerId()     {
        if( filter.getPartner_id() > 0 ) {
            sql_where_partner_id = " AND ptr.partner_id =" + filter.getPartner_id();

        }
    }

    private void buildQuery(PartnerQueryFilter pFilter) {

        this.filter = pFilter;

        checkForPublicView();
        checkForAgreemenTypeId();
        checkForCountry();
        checkForKeywords();
        checkForAgreementId();
        checkForIsPublished();
        checkForDates();
        checkForEstablished();
        checkForPartnerId();

    }

    public String  buildSqlCommand(PartnerQueryFilter pFilter) {

        buildQuery(pFilter);

        String sqlDataCommand = "WITH\n" +
                "\t\t\t\t\tpartner_list (\n" +
                "\t\t\t\t\t\taccount_id,\n" +
                "\t\t\t\t\t\tpartner_id,\n" +
                "\t\t\t\t\t\tinstitution_name,\n" +
                "\t\t\t\t\t\tpartner_description,\n" +
                "\t\t\t\t\t\tpartner_website_url,\n" +
                "\t\t\t\t\t\tdate_last_updated,\n" +
                "\t\t\t\t\t\tyear_established\n" +
                "\t\t\t\t\t)\n" +
                "\t\t\t\t\tAS (\n" +
                "\t\t\t\t\t\tSELECT DISTINCT\n" +
                "\t\t\t\t\t\t\tptr.account_id,\n" +
                "\t\t\t\t\t\t\tptr.id,\n" +
                "\t\t\t\t\t\t\tptr.institution_name,\n" +
                "\t\t\t\t\t\t\tptr.partner_description,\n" +
                "\t\t\t\t\t\t\tptr.partner_website_url,\n" +
                "\t\t\t\t\t\t\tptr.date_last_updated,\n" +
                "\t\t\t\t\t\t\tMIN( agr.agreement_start_date ) OVER(PARTITION BY xref.partner_id ) AS year_established\n" +
                "\t\t\t\t\t\tFROM partners ptr\n" +
                "\t\t\t\t\t\tJOIN partners_agreements_addresses xref\n" +
                "\t\t\t\t\t\tON       ptr.account_id = xref.account_id\n" +
                "\t\t\t\t\t\t\tAND ptr.id = xref.partner_id\n" +
                "\t\t\t\t\t\tJOIN agreemnents agr\n" +
                "\t\t\t\t\t\tON      agr.account_id = xref.account_id\n" +
                "\t\t\t\t\t\t\tAND agr.id = xref.agreement_id\n" +
                "\t\t\t\t\t\tJOIN agreements_agreementstypes agr_xref\n" +
                "\t\t\t\t\t\tON  agr_xref.agreement_id = agr.id\n" +
                "\t\t\t\t\t\tJOIN     addreses addr\n" +
                "\t\t\t\t\t\tON      xref.account_id = addr.account_id\n" +
                "\t\t\t\t\t\t\tAND xref.address_id = addr.id\n" +
                "\t\t\t\t\t\tWHERE\n" +
                "\t\t\t\t\t\t\tptr.account_id =" +  this.filter.getAccount_id() + "\n" +
                "\t\t\t\t\t\t\tAND agr_xref.agreement_type_id IS NOT NULL\n" +
                "\t\t\t\t\t\t\t" + this.sql_where_year_established + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_agreement_type_id + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_country + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_keyword + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_date_last_updated + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_partner_id + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_agreement_id + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_is_published + "\n" +
                "\t\t\t\t\t\t  ORDER BY institution_name ASC\n" +
                "\t\t\t\t\t\tOFFSET 1 ROWS FETCH NEXT 10 ROWS ONLY\n" +
                "\t\t\t\t\t),\n" +
                "\t\t\t\t\tpartnerData(\n" +
                "\t\t\t\t\t\taccount_id,\n" +
                "\t\t\t\t\t\tpartner_id,\n" +
                "\t\t\t\t\t\tinstitution_name,\n" +
                "\t\t\t\t\t\tpartner_description,\n" +
                "\t\t\t\t\t\tpartner_website_url,\n" +
                "\t\t\t\t\t\tdate_last_updated,\n" +
                "\t\t\t\t\t\tyear_established,\n" +
                "\t\t\t\t\t\tagreement_type_id,\n" +
                "\t\t\t\t\t\tagreement_type_name\n" +
                "\t\t\t\t\t) AS (\n" +
                "\t\t\t\t\t\tSELECT DISTINCT\n" +
                "\t\t\t\t\t\t\tptr.account_id,\n" +
                "\t\t\t\t\t\t\tptr.partner_id,\n" +
                "\t\t\t\t\t\t\tptr.institution_name,\n" +
                "\t\t\t\t\t\t\tptr.partner_description,\n" +
                "\t\t\t\t\t\t\tptr.partner_website_url,\n" +
                "\t\t\t\t\t\t\tptr.date_last_updated,\n" +
                "\t\t\t\t\t\t\tptr.year_established,\n" +
                "\t\t\t\t\t\t\tagr_type.id,\n" +
                "\t\t\t\t\t\t\tagr_type.name\n" +
                "\t\t\t\t\t\tFROM partner_list ptr\n" +
                "\t\t\t\t\t\tJOIN partners_agreements_addresses xref\n" +
                "\t\t\t\t\t\tON       ptr.account_id = xref.account_id\n" +
                "\t\t\t\t\t\t\tAND ptr.partner_id = xref.partner_id\n" +
                "\t\t\t\t\t\tJOIN agreemnents agr\n" +
                "\t\t\t\t\t\tON      agr.account_id = xref.account_id\n" +
                "\t\t\t\t\t\t\tAND agr.id = xref.agreement_id\n" +
                "\t\t\t\t\t\tJOIN agreements_agreementstypes agr_xref\n" +
                "\t\t\t\t\t\tON            agr_xref.agreement_id = agr.id\n" +
                "\t\t\t\t\t\tJOIN agreemntes_types agr_type\n" +
                "\t\t\t\t\t\tON      agr_xref.agreement_type_id = agr_type.id\n" +
                "\t\t\t\t\t\tWHERE\n" +
                "\t\t\t\t\t\t\tptr.account_id =" +  this.filter.getAccount_id() + "\n" +
                "\t\t\t\t\t)\n" +
                "\t\t\t\tSELECT DISTINCT\n" +
                "\t\t\t\t\tpd.*,\n" +
                "\t\t\t\t\taddr.city,\n" +
                "\t\t\t\t\taddr.state,\n" +
                "\t\t\t\t\taddr.country,\n" +
                "\t\t\t\t\taddr.latitude,\n" +
                "\t\t\t\t\taddr.longitude\n" +
                "\t\t\t\tFROM partnerData pd\n" +
                "\t\t\t\tLEFT JOIN partners_addresses addr_xref\n" +
                "\t\t\t\tON      pd.account_id = addr_xref.account_id\n" +
                "\t\t\t\t\tAND pd.partner_id = addr_xref.partner_id\n" +
                "\t\t\t\tLEFT JOIN    addreses addr\n" +
                "\t\t\t\tON      addr_xref.account_id = addr.account_id\n" +
                "\t\t\t\t\tAND addr_xref.address_id = addr.id\n" +
                "\t\t\t\tWHERE\n" +

                "\t\t\t\t\taddr.primary_address = 1\n" +
                "\t\t\t\t\t ORDER BY institution_name ASC";


       return sqlDataCommand;

    }

    public String buildCountCommand(PartnerQueryFilter pFilter) {

        buildQuery(pFilter);

        String sqlCountCommand ="SELECT COUNT(DISTINCT ptr.id) AS total_partners_count\n" +
                "\t\t\t\tFROM partners ptr\n" +
                "\t\t\t\tJOIN partners_agreements xref\n" +
                "\t\t\t\tON       ptr.account_id = xref.account_id\n" +
                "\t\t\t\t\tAND ptr.id = xref.partner_id\n" +
                "\t\t\t\tJOIN agreemnents agr\n" +
                "\t\t\t\tON      agr.account_id = xref.account_id\n" +
                "\t\t\t\t\tAND agr.id = xref.agreement_id\n" +
                "\t\t\t\tJOIN agreements_agreementstypes agr_xref\n" +
                "\t\t\t\tON  agr_xref.agreement_id = agr.id\n" +
                "\t\t\t\tJOIN addreses  addr\n" +
                "\t\t\t\tON      xref.account_id = addr.account_id\n" +
                "\t\t\t\t\tAND xref.address_id = addr.id\n" +
                "\t\t\t\tWHERE\n" +
                "\t\t\t\t\t\t\tptr.account_id =" +  this.filter.getAccount_id() + "\n" +
                "\t\t\t\t\t\t\tAND agr_xref.agreement_type_id IS NOT NULL\n" +
                "\t\t\t\t\t\t\t" + this.sql_where_year_established + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_agreement_type_id + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_country + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_keyword + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_date_last_updated + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_partner_id + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_agreement_id + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_is_published + "\n";


       return sqlCountCommand;

    }

    public String builDebugCommand(PartnerQueryFilter pFilter) {

        buildQuery(pFilter);

        String sqlDebugCommand ="SELECT DISTINCT\n" +
                "\t\t\t\t\tptr.account_id,\n" +
                "\t\t\t\t\tptr.id,\n" +
                "\t\t\t\t\tptr.institution_name,\n" +
                "\t\t\t\t\tptr.partner_description,\n" +
                "\t\t\t\t\tptr.partner_website_url,\n" +
                "\t\t\t\t\tptr.date_last_updated,\n" +
                "\t\t\t\t\tMIN( agr.agreement_start_date ) OVER(PARTITION BY xref.partner_id ) AS year_established\n" +
                "\t\t\t\tFROM partners ptr\n" +
                "\t\t\t\tJOIN partners_agreements_addresses xref\n" +
                "\t\t\t\tON       ptr.account_id = xref.account_id\n" +
                "\t\t\t\t\tAND ptr.id = xref.partner_id\n" +
                "\t\t\t\tJOIN agreemnents agr\n" +
                "\t\t\t\tON      agr.account_id = xref.account_id\n" +
                "\t\t\t\t\tAND agr.id = xref.agreement_id\n" +
                "\t\t\t\tJOIN agreements_agreementstypes agr_xref\n" +
                "\t\t\t\tON  agr_xref.agreement_id = agr.id\n" +
                "\t\t\t\tJOIN    addreses addr\n" +
                "\t\t\t\tON      xref.account_id = addr.account_id\n" +
                "\t\t\t\t\tAND xref.address_id = addr.id\n" +
                "\t\t\t\tWHERE" +
                "\t\t\t\t\t\t\tptr.account_id =" +  this.filter.getAccount_id() + "\n" +
                "\t\t\t\t\t\t\tAND agr_xref.agreement_type_id IS NOT NULL\n" +
                "\t\t\t\t\t\t\t" + this.sql_where_year_established + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_agreement_type_id + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_country + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_keyword + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_date_last_updated + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_partner_id + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_agreement_id + "\n" +
                "\t\t\t\t\t\t" + this.sql_where_is_published + "\n";


        return sqlDebugCommand;

    }

}
