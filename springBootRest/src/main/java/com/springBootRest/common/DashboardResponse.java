package com.springBootRest.common;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DashboardResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("status_code")
    private String statusCode;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("error_msg")
    private String errorMsg;

    public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public ResponseData getResponseData() {
		return responseData;
	}

	public void setResponseData(ResponseData responseData) {
		this.responseData = responseData;
	}

	@JsonProperty("response_data")
    private ResponseData responseData;

    public void setResponseData(String name, Object value) {
        if(responseData == null)
            responseData = new ResponseData();
        this.responseData.setValue(name, value);
    }

    public Map<String, Object> getResponseData(String name) {
        return this.responseData.getValue();
    }

    class ResponseData {

        @JsonIgnore
        private Map<String, Object> value = new LinkedHashMap<>();

        @JsonAnyGetter
        public Map<String, Object> getValue() {
            return this.value;
        }

        @JsonAnyGetter
        public void setValue(String name, Object value) {
            this.value.put(name, value);
        }
    }
}
