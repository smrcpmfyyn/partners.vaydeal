/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vaydeal.partner.resp.mod;

import com.vaydeal.partner.message.ResponseMsg;
import com.vaydeal.partner.result.GetAffiliateUsersResult;

/**
 * @company techvay
 * @author rifaie
 */
public class GetAffiliateUsersFailureResponse {

    private final GetAffiliateUsersResult reqR;
    private final String error;

    public GetAffiliateUsersFailureResponse(GetAffiliateUsersResult reqR, String error) {
        this.reqR = reqR;
        this.error = error;
    }

    @Override
    public String toString() {
        String json = "\"status\":\"" + ResponseMsg.RESP_NOT_OK + "\",";
        String[] errors = error.split("#");

        String resp;
        for (int i = 1; i < errors.length; i++) {
            String parameter = errors[i];
            switch (parameter) {
                case "at":
                    String at = reqR.getAt();
                    resp = at.substring(at.lastIndexOf(" ") + 1);
                    json += "\"" + parameter + "\"" + ":" + "\"" + resp + "\" ,";
                    break;
                case "utype":
                    String admType = reqR.getUtype();
                    resp = admType.substring(admType.lastIndexOf(" ") + 1);
                    json += "\"" + parameter + "\"" + ":" + "\"" + resp + "\" ,";
                    break;
            }
        }
        json = json.substring(0, json.length() - 1);
        return "{" + json + "}";
    }
}

